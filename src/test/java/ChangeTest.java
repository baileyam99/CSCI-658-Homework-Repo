import Homework_6.change;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeTest {
    @Test
    public void positiveChangeUsesCalculationPath() {
        assertArrayEquals(new int[]{1, 1, 0, 0, 0}, change.changeCalc(5.00, 3.75));
    }

    @Test
    public void exactPaymentUsesNoChangePath() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, change.changeCalc(4.25, 4.25));
    }

    @Test
    public void underPaymentUsesNoChangePath() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, change.changeCalc(3.00, 4.25));
    }

    @Test
    public void mainReadsInputAndPrintsChangeArray() {
        ByteArrayInputStream testInput = new ByteArrayInputStream(
                "3.75\n5.00\n".getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));

        try {
            change.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        String output = testOutput.toString();
        assertTrue(output.contains("Please enter the cost:"));
        assertTrue(output.contains("Please enter the paid amount:"));
        assertTrue(output.endsWith(("1\n1\n0\n0\n0\n").replace("\n", System.lineSeparator())));
    }
}
