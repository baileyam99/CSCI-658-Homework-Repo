import Homework_2.FunWithNumbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunWithNumbersTest {
    private static int[] a1;
    private static int[] a2;
    private static int[] a3;
    private static int[] a4;

    @BeforeAll
    public static void setUp() {
        a1 = new int[]{ 1, 2, 3, 4, 5 };
        a2 = new int[]{ -1, -2, -3, -4, -5 };
        a3 = new int[]{ -2, -1, 0, 1, 2 };
        a4 = new int[]{};
    }

    @Test
    public void testPositiveSum() {
        assertEquals(15, FunWithNumbers.sum(a1));
    }

    @Test
    public void testNegativeSum() {
        assertEquals(-15, FunWithNumbers.sum(a2));
    }

    @Test
    public void testSumZero() {
        assertEquals(0, FunWithNumbers.sum(a3));
        assertEquals(0, FunWithNumbers.sum(a4));
    }

    @Test
    public void testSumNull() {
        try {
            FunWithNumbers.sum(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("should throw NPE with null array");
    }

    @Test
    public void testSumToNPositive() {
        assertTrue(FunWithNumbers.sumToN(a1, 9));
    }

    @Test
    public void testSumToNNegative() {
        assertTrue(FunWithNumbers.sumToN(a2, -9));
    }

    @Test
    public void testSumToNFalse() {
        assertFalse(FunWithNumbers.sumToN(a1, -9));
    }

    @Test
    public void testSumToNEmpty() {
        assertFalse(FunWithNumbers.sumToN(a4, 9));
    }

    @Test
    public void testSumToNNull() {
        try {
            FunWithNumbers.sumToN(null, 5);
        } catch (NullPointerException e) {
            return;
        }
        fail("should throw NPE with null array");
    }
}
