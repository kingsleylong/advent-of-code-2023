package kingsley.aoc2023.day2;

import kingsley.aoc2023.day2.domain.Bag;
import kingsley.aoc2023.day2.domain.Game;
import kingsley.aoc2023.day2.domain.GamePredicate;
import kingsley.aoc2023.day2.infrastructure.FileParser;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Cube Conundrum
 */
public class App {
    public static void main(String[] args) {
        Bag bag = Bag.of(14, 13, 12);
        List<Game> games = new FileParser().parseFile();
        Stream<Game> gameStream = games.stream().filter(new GamePredicate(bag));
        Optional<Integer> result = gameStream.map(Game::getId).reduce(Integer::sum);
        System.out.format("The sum of the IDs of those games is: %d", result.orElse(0));
    }
}
