package kingsley.aoc2023.day2.domain;

import lombok.Data;

import java.util.function.Predicate;

@Data
public class ValidGamePredicate implements Predicate<Game> {
    private final Bag bag;

    @Override
    public boolean test(Game game) {
        return game.getDraws()
                .stream()
                .noneMatch(new BadDrawPredicate(bag));
    }
}
