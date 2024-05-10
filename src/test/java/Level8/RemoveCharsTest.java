package Level8;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveCharsTest {

    @Test
    public void testRemoval() {
        assertEquals("loquen", RemoveChars.remove("eloquent"));
        assertEquals("ountr", RemoveChars.remove("country"));
        assertEquals("erso", RemoveChars.remove("person"));
        assertEquals("lac", RemoveChars.remove("place"));
        assertEquals("oopss", RemoveChars.remove("ooopsss"));
    }


    @Test
    public void testRemovalWithRandomString() {
        for (int i = 0; i < 6; i++) {
            String randStr = randomString(random.nextInt(21) + 10);
            assertEquals(removeChars(randStr), RemoveChars.remove(randStr));
        }
    }

    private static final Random random = new SecureRandom();

    private static String removeChars(String str) {
        return str.substring(1, str.length() - 1);
    }

    private static String randomString(int len) {
        StringBuilder sb = new StringBuilder();

        while (len > 0) {
            // char from '!' to '~'
            sb.append((char) (random.nextInt(94) + 33));
            len--;
        }

        return sb.toString();
    }
}