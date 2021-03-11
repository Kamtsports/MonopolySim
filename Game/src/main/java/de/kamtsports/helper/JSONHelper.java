package de.kamtsports.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.kamtsports.game.board.fields.Field;
import de.kamtsports.game.board.gameBoards.BoardLoader;
import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public abstract class JSONHelper {


    public static List<Field> generateFields(String path) {
        String input;
        BoardLoader board = null;
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Color.class, new ColorDeserializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        try (InputStream inputStream = JSONHelper.class.getClassLoader().getResourceAsStream(path)) {
            input = IOUtils.toString(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            board = objectMapper.readValue(input, BoardLoader.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(board).getField();
    }

    private static class ColorDeserializer extends StdDeserializer<Color> {

        public ColorDeserializer() {
            this(null);
        }

        public ColorDeserializer(Class vc) {
            super(vc);
        }

        @Override
        public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String color = p.readValueAs(String.class);
            return ColorHelper.getColor(color);
        }
    }
}

