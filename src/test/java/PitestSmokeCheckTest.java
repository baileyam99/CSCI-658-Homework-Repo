import Homework_8.PitestSmokeCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PitestSmokeCheckTest {

    private final PitestSmokeCheck smokeCheck = new PitestSmokeCheck();

    @Test
    void isPositiveShouldReturnTrueOnlyForPositiveNumbers() {
        assertTrue(smokeCheck.isPositive(1));
        assertFalse(smokeCheck.isPositive(0));
        assertFalse(smokeCheck.isPositive(-1));
    }

    @Test
    void addOneShouldReturnInputPlusOne() {
        assertEquals(2, smokeCheck.addOne(1));
        assertEquals(1, smokeCheck.addOne(0));
    }
}
