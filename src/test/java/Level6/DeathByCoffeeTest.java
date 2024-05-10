package Level6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DeathByCoffeeTest {

    // Show returned limits
    private static int[] show(final int y, final int m, final int d, final int[] result) {
        System.out.println(String.format("%4d%02d%02d -> ",y,m,d)+ Arrays.toString(result));
        return result;
    }

    @Test
    public void exJohn() {
        final int y=1950, m=1, d=19;
        assertArrayEquals(new int[]{2645,1162}, show(y,m,d, DeathByCoffee.coffeeLimits(y,m,d)));
    }

    @Test
    public void exSusan() {
        final int y=1965, m=12, d=11;
        assertArrayEquals(new int[]{111,0}, show(y,m,d, DeathByCoffee.coffeeLimits(y,m,d)));
    }

    @Test
    public void exElizabeth() {
        final int y=1964, m=11, d=28;
        assertArrayEquals(new int[]{0,11}, show(y,m,d, DeathByCoffee.coffeeLimits(y,m,d)));
    }

    @Test
    public void exPeter() {
        final int y=1965, m=9, d=4;
        assertArrayEquals(new int[]{0,0}, show(y,m,d, DeathByCoffee.coffeeLimits(y,m,d)));
    }

}