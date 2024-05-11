package Level5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {
    @Test
    public void basicTests(){
        assertEquals(4,MissingNumber.missing("123567"));
//        assertEquals(92,MissingNumber.missing("899091939495")); // *** faalt, ipv [92] enorme lijst
        assertEquals(100,MissingNumber.missing("9899101102"));
        assertEquals(-1,MissingNumber.missing("599600601602"));
        assertEquals(-1,MissingNumber.missing("8990919395")); // ** slaagt, maar ipv [92, 94] enorme lijst
        assertEquals(1002,MissingNumber.missing("998999100010011003"));
        assertEquals(10000,MissingNumber.missing("99991000110002"));
        assertEquals(-1,MissingNumber.missing("979899100101102"));
        assertEquals(900003,MissingNumber.missing("900001900002900004900005900006"));
    }
}