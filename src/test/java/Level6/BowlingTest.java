package Level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest
{
    @Test
    public void exampleTests()
    {
        Bowling bowling = new Bowling();
        int[] testArray = new int[]{1,2,3};
        assertEquals("I I I I\n I I I \n       \n       ", bowling.bowlingPins(testArray));

        testArray = new int[]{3,5,9};
        assertEquals("I I   I\n I   I \n  I    \n   I   ", bowling.bowlingPins(testArray));
    }
}
