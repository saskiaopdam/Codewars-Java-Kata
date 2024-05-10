package Level5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UmbrellaTest {
    @Test
    @DisplayName("Fixed Tests")
    void testUmbrellas() {
        assertEquals(0, Umbrella.minUmbrellas(Weather.CLOUDY), "wrong answer for no rain");
        assertEquals(1,
                Umbrella.minUmbrellas(Weather.RAINY, Weather.RAINY, Weather.RAINY, Weather.RAINY),
                "wrong answer for always rainy."
        );
        assertEquals(2,
                Umbrella.minUmbrellas(Weather.OVERCAST, Weather.RAINY, Weather.CLEAR, Weather.THUNDERSTORMS),
                "wrong answer for 2 dry mornings and 2 rainy afternoons."
        );
    }
}
