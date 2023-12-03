package kingsley.aoc2023.day2.infrastructure;

import kingsley.aoc2023.day2.domain.Draw;
import kingsley.aoc2023.day2.domain.Game;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * <a href="https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/">
 *     Scanner vs BufferedReader</a>
 */
@Data
public class FileParser {

    public static final String DAY2_INPUT_FILE_NAME = "input 2.txt";

    public List<Game> parseFile() {
        List<Game> games = new ArrayList<>();
        URL fileUrl = Objects.requireNonNull(getClass().getClassLoader().getResource(DAY2_INPUT_FILE_NAME));
        try (InputStream inputStream = fileUrl.openStream();
             Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // skip empty lines
                if (line.trim().isEmpty()) continue;
                Game game = parseGame(line);
                games.add(game);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return games;
    }

    private Game parseGame(String line) {
        String[] split = line.split(":");
        String gameString = split[0].trim();
        String gameIdStr = gameString.split(" ")[1].trim();

        return Game.builder()
                .id(Integer.parseInt(gameIdStr))
                .draws(parseDraws(split[1].trim()))
                .build();
    }

    // Example: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    private List<Draw> parseDraws(String drawsString) {
        List<Draw> draws = new ArrayList<>();
        String[] drawSplit = drawsString.split(";");
        for (String drawString : drawSplit) {
            draws.add(parseDraw(drawString));
        }
        return draws;
    }

    // Example: 3 blue, 4 red
    private Draw parseDraw(String drawString) {
        Draw draw = Draw.builder().build();
        String[] cubeSplit = drawString.trim().split(",");
        for (String cubeString : cubeSplit) {
            String[] cubeNumberString = cubeString.trim().split(" ");
            int num = Integer.parseInt(cubeNumberString[0].trim());
            String color = cubeNumberString[1].trim();

            switch (color) {
                case "blue":
                    draw.setBlues(num);
                    break;
                case "green":
                    draw.setGreens(num);
                    break;
                case "red":
                    draw.setReds(num);
                    break;
            }
        }
        return draw;
    }

}
