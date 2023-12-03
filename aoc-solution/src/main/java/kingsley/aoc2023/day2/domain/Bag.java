package kingsley.aoc2023.day2.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * A bag holds
 */
@Data
@SuperBuilder
//@AllArgsConstructor
public class Bag {
    protected int blues;
    protected int greens;
    protected int reds;

    public long calculatePower() {
        return blues * greens * reds;
    }
}
