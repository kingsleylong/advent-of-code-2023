package kingsley.aoc2023.day2.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * A bag holds some cubes which are either red, green, or blue.
 */
@Data
@SuperBuilder
//@AllArgsConstructor
public class Bag {
    protected int blues;
    protected int greens;
    protected int reds;

    /**
     * The power of a bag is equal to the numbers of red, green, and blue cubes multiplied together.
     *
     * @return the power of the bag
     */
    public long calculatePower() {
        return (long) blues * greens * reds;
    }
}
