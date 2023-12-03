package kingsley.aoc2023.day2.domain;

import lombok.Data;

import java.util.function.Predicate;

@Data
public class DrawPredicate implements Predicate<Draw> {
    private final Bag bag;

    @Override
    public boolean test(Draw draw) {
        return draw.getBlues() > bag.getBlues()
                || draw.getGreens() > bag.getGreens()
                || draw.getReds() > bag.getReds();
    }
}
