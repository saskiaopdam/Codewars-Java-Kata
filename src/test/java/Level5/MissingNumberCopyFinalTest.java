package Level5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MissingNumberCopyFinalTest {
    @Test
    public void basicTests(){
        assertEquals(4,MissingNumberCopyFinal.missing("123567"));
//        assertEquals(92,MissingNumberCopyFinal.missing("899091939495"));
//        assertEquals(100,MissingNumberCopyFinal.missing("9899101102"));
//        assertEquals(-1,MissingNumberCopyFinal.missing("599600601602"));
//        assertEquals(-1,MissingNumberCopyFinal.missing("8990919395")); // 92 list [92] moet zijn [92, 94]
//        assertEquals(1002,MissingNumberCopyFinal.missing("998999100010011003")); // -1 empty list []
//        assertEquals(10000,MissingNumberCopyFinal.missing("99991000110002")); // -1 empty list []
//        assertEquals(-1,MissingNumberCopyFinal.missing("979899100101102"));
//        assertEquals(900003,MissingNumberCopyFinal.missing("900001900002900004900005900006"));
    }
}