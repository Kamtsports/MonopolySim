package de.kamtsports.helper;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import de.kamtsports.game.board.fields.*;
import de.kamtsports.game.board.fields.fieldStatus.CardType;
import de.kamtsports.game.players.Actions.Action;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVHelper {

    public static List<Field> generateFieldsFromFile(String path) throws IllegalStateException {
        List<Field> fields = new ArrayList<>();
        try {
            final CSVReader reader = new CSVReader(new FileReader(path));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                final int id = Integer.parseInt(nextLine[0]);
                final String type = nextLine[1];
                final String color = nextLine[2];
                final int buyPrice = Integer.parseInt(nextLine[3]);
                final List<Integer> rents = new ArrayList<>();
                for (int i = 4; i < 10; i++) {
                    rents.add(Integer.valueOf(nextLine[i]));
                }
                final int housePrice = Integer.parseInt(nextLine[10]);
                final int mortgage = Integer.parseInt(nextLine[11]);
                final String action = nextLine[12];

                switch (type) {
                    case "corner" -> fields.add(new Corner(id));
                    case "street" -> fields.add(new Street(id, color, buyPrice, rents, housePrice, mortgage));
                    case "COMMUNITY", "EVENT" -> fields.add(new CardField(id, CardType.valueOf(type)));
                    case "action" -> fields.add(new ActionField(id, action));
                    case "trainStation" -> fields.add(new TrainStation(id, buyPrice, rents, mortgage));
                    case "specialStation" -> fields.add(new SpecialStation(id, buyPrice, mortgage));
                    default -> throw new IllegalStateException("Unexpected value: " + nextLine[1]);
                }
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return fields;
    }


}
