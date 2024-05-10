package Level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesTest {
    @Test
    public void test() {
        assertEquals(23, new Multiples().solution(10));
        assertEquals(78, new Multiples().solution(20));
        assertEquals(9168, new Multiples().solution(200));
    }
}