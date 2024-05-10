package Level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagpiesTest {

    private final String m1 = "BWBWBW";
    private final String m2 = "BWBWBB";
    private final String m3 = "WWWWBB";

    @Test
    public void child() {
        assertEquals(true, Magpies.child(m1, m2));
        assertEquals(true, Magpies.child(m2, m3));
    }

    @Test
    public void grandchild() {

        assertEquals(true, Magpies.grandchild(m1, m3));

        // Codewars random test failed:
        // Expected true but was false:
        assertEquals(true, Magpies.grandchild("WB", "WB"));
    }

    @Test
    public void notChild() {
        assertEquals(false, Magpies.child(m1, m3));
    }

}