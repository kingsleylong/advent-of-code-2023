package kingsley.aoc2023.day2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A bag holds
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Bag {
    protected int blues;
    protected int greens;
    protected int reds;
}
