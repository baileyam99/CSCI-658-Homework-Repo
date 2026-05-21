import Homework_2.FunWithNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunWithNumbersAIGeneratedTest {
    @Test
    void canCreateFunWithNumbersInstance() {
        assertNotNull(new FunWithNumbers());
    }

    @Test
    void sumReturnsZeroForEmptyArray() {
        assertEquals(0, FunWithNumbers.sum(new int[]{}));
    }

    @Test
    void sumAddsPositiveNegativeAndZeroValues() {
        assertEquals(8, FunWithNumbers.sum(new int[]{7, -3, 0, 4}));
    }

    @Test
    void sumToNReturnsFalseWhenArrayHasFewerThanTwoValues() {
        assertFalse(FunWithNumbers.sumToN(new int[]{}, 0));
        assertFalse(FunWithNumbers.sumToN(new int[]{5}, 5));
    }

    @Test
    void sumToNReturnsTrueWhenAdjacentValuesMatchTarget() {
        assertTrue(FunWithNumbers.sumToN(new int[]{1, 4, 2}, 5));
    }

    @Test
    void sumToNReturnsFalseWhenNoAdjacentPairMatchesTarget() {
        assertFalse(FunWithNumbers.sumToN(new int[]{1, 4, 2, 8}, 7));
    }
}
