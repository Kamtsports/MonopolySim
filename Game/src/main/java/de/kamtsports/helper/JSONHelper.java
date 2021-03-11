package de.kamtsports.helper;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.kamtsports.game.board.fields.DefaultField;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.gameBoards.BoardLoader;
import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class JSONHelper {


    public static List<Field> generateFields(String path) {
        String input;
        BoardLoader board = null;
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeyDeserializer(Color.class, new ColorDeserializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        try (InputStream inputStream = JSONHelper.class.getClassLoader().getResourceAsStream(path)) {
            input = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            board = objectMapper.readValue(input, BoardLoader.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board.getField();
        //return board.getFields().stream().map(f -> mapToActualField(f)).collect(Collectors.toList());
    }

    private static Field mapToActualField(DefaultField f) {
        switch (f.getType()) {


        }

        return null;
    }


    private static class ColorDeserializer extends KeyDeserializer {
        @Override
        public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
            return ColorHelper.getColor(key);
        }
    }
}

