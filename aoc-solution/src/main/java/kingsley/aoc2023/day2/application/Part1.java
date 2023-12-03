package kingsley.aoc2023.day2.application;

import kingsley.aoc2023.day2.domain.Bag;
import kingsley.aoc2023.day2.domain.Game;
import kingsley.aoc2023.day2.domain.ValidGamePredicate;
import kingsley.aoc2023.day2.infrastructure.FileParser;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Cube Conundrum Part 1
 */
public class Part1 {
    public static void main(String[] args) {
        Bag bag = Bag.builder().blues(14).greens(13).reds(12).build();
        List<Game> games = new FileParser().parseFile();
        Stream<Game> gameStream = games.stream().filter(new ValidGamePredicate(bag));
        Optional<Integer> result = gameStream.map(Game::getId).reduce(Integer::sum);
        System.out.format("The sum of the IDs of those games is: %d", result.orElse(0));
    }
}
