package Level3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class BooleanOrderTest {

    @Test
    public void sampleTests() {
//        assertEquals(new BigInteger("2"),            new BooleanOrder("tft","^&").solve());
//        assertEquals(new BigInteger("16"),           new BooleanOrder("ttftff","|&^&&").solve());
//        assertEquals(new BigInteger("339"),          new BooleanOrder("ttftfftf","|&^&&||").solve());
//        assertEquals(new BigInteger("851"),          new BooleanOrder("ttftfftft","|&^&&||^").solve());
//        assertEquals(new BigInteger("2434"),         new BooleanOrder("ttftfftftf","|&^&&||^&").solve());
        assertEquals(new BigInteger("945766470799"), new BooleanOrder("ttftfftftffttfftftftfftft","|&^&&||^&&^^|&&||^&&||&^").solve());
    }
}