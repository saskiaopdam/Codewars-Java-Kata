package Level4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MysteryFunctionTest {
    @Test
    public void mystery() throws Exception {
        assertEquals( 5, MysteryFunction.mystery( 6 ), "mystery(6)" );
        assertEquals( 13, MysteryFunction.mystery( 9 ), "mystery(9)" );
        assertEquals( 26, MysteryFunction.mystery( 19 ), "mystery(19)" );
    }

    @Test
    public void mysteryInv() throws Exception {
        assertEquals( 6, MysteryFunction.mysteryInv( 5 ), "mysteryInv(5)" );
//        assertEquals( 9, MysteryFunction.mysteryInv( 13 ), "mysteryInv(13)" );
//        assertEquals( 19, MysteryFunction.mysteryInv( 26 ),"mysteryInv(26)" );
    }

}