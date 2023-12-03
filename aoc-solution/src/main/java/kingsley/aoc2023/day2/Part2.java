package kingsley.aoc2023.day2;

import kingsley.aoc2023.day2.domain.Game;
import kingsley.aoc2023.day2.infrastructure.FileParser;

import java.util.List;
import java.util.Optional;

/**
 * Cube Conundrum Part2
 */
public class Part2 {
    public static void main(String[] args) {
        List<Game> games = new FileParser().parseFile();
        Optional<Long> sumOfPower = games.stream()
                .map(game -> game.findMinimumBag().calculatePower())
                .reduce(Long::sum);
        System.out.format("The sum of the IDs of those games is: %d", sumOfPower.get());
    }
}
