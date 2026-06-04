import Homework_5.Roots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RootsTest {
    private static final double TOLERANCE = 0.000001;

    @Test
    public void testQuadraticWithTwoRoots() {
        Roots.calculate_roots(1, 5, 6);
        assertEquals(2, Roots.num_roots(), TOLERANCE);
        assertEquals(-2, Roots.first_root(), TOLERANCE);
        assertEquals(-3, Roots.second_root(), TOLERANCE);
    }

    @Test
    public void testQuadraticWithOneRoot() {
        Roots.calculate_roots(1, 2, 1);
        assertEquals(1, Roots.num_roots(), TOLERANCE);
        assertEquals(-1, Roots.first_root(), TOLERANCE);
        assertEquals(-1, Roots.second_root(), TOLERANCE);
    }

    @Test
    public void testQuadraticWithNoRealRoots() {
        Roots.calculate_roots(1, 0, 1);
        assertEquals(0, Roots.num_roots(), TOLERANCE);
        assertEquals(-1, Roots.first_root(), TOLERANCE);
        assertEquals(-1, Roots.second_root(), TOLERANCE);
    }

    @Test
    public void testNotQuadraticWithPositiveDiscriminant() {
        Roots.calculate_roots(0, 2, -4);
        assertEquals(0, Roots.num_roots(), TOLERANCE);
        assertEquals(-1, Roots.first_root(), TOLERANCE);
        assertEquals(-1, Roots.second_root(), TOLERANCE);
    }

    @Test
    public void testNotQuadraticWithZeroDiscriminant() {
        Roots.calculate_roots(0, 0, 4);
        assertEquals(0, Roots.num_roots(), TOLERANCE);
        assertEquals(-1, Roots.first_root(), TOLERANCE);
        assertEquals(-1, Roots.second_root(), TOLERANCE);
    }
}
