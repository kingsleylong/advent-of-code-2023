package kingsley.aoc2023.day2.domain;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    private static Game game;

    @Test
    public void shouldReturnTheMinimumBag() {
        System.out.println(game);
        Assert.assertEquals(
                Draw.builder().blues(6).greens(2).reds(4).build(),
                game.findMinimumBag());
        Assert.assertEquals(48, game.findMinimumBag().calculatePower());
    }

    @BeforeClass
    public static void setUp() {
        List<Draw> draw1 = Arrays.asList(
                Draw.builder().blues(3).reds(4).build(),
                Draw.builder().blues(6).greens(2).reds(1).build(),
                Draw.builder().greens(2).build()
        );
        game = Game.builder()
                .id(123)
                .draws(draw1)
                .build();
    }
}