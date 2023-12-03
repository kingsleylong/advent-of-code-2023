package kingsley.aoc2023.day2.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Game {
    int id;
    List<Draw> draws;

    public Bag findMinimumBag() {
        Optional<Draw> minimumBag = draws.stream()
                .reduce((draw1, draw2) -> Draw.builder()
                        .blues(Math.max(draw1.blues, draw2.blues))
                        .greens(Math.max(draw1.greens, draw2.greens))
                        .reds(Math.max(draw1.reds, draw2.reds))
                        .build());
        return minimumBag.get();
    }
}