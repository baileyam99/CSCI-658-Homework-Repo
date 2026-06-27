import Homework_8.Change;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeHw8Test {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStandardStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void changeCalcAlwaysReturnsFiveDenominationSlots() {
        int[] change = Change.changeCalc(2.00, 1.00);

        assertNotNull(change);
        assertEquals(5, change.length);
    }

    @Test
    void exactPaymentReturnsNoChange() {
        assertChange(new int[]{0, 0, 0, 0, 0}, 15.75, 15.75);
    }

    @Test
    void underPaymentReturnsNoChange() {
        assertChange(new int[]{0, 0, 0, 0, 0}, 10.00, 12.25);
    }

    @Test
    void oneDollarChangeUsesDollarsOnly() {
        assertChange(new int[]{1, 0, 0, 0, 0}, 2.25, 1.25);
    }

    @Test
    void quarterBoundaryUsesQuarterInsteadOfSmallerCoins() {
        assertChange(new int[]{0, 1, 0, 0, 0}, 1.25, 1.00);
    }

    @Test
    void dimeBoundaryUsesDimeInsteadOfNickelsOrPennies() {
        assertChange(new int[]{0, 0, 1, 0, 0}, 1.10, 1.00);
    }

    @Test
    void nickelBoundaryUsesNickelInsteadOfPennies() {
        assertChange(new int[]{0, 0, 0, 1, 0}, 1.05, 1.00);
    }

    @Test
    void penniesAreReturnedAfterLargerDenominationsAreRemoved() {
        assertChange(new int[]{0, 0, 0, 0, 4}, 1.04, 1.00);
    }

    @Test
    void oneCentChangeReturnsOnePenny() {
        assertChange(new int[]{0, 0, 0, 0, 1}, 1.01, 1.00);
    }

    @Test
    void mixedChangeUsesLargestDenominationsFirst() {
        assertChange(new int[]{5, 3, 1, 1, 4}, 15.94, 10.00);
    }

    @Test
    void changeJustBelowQuarterUsesDimesAndPennies() {
        assertChange(new int[]{0, 0, 2, 0, 4}, 1.24, 1.00);
    }

    @Test
    void mainReadsCostThenPaidAmountAndPrintsChangeLines() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("1.25\n2.00\n".getBytes(StandardCharsets.UTF_8)));
        System.setOut(new PrintStream(output));

        Change.main(new String[]{});

        String normalizedOutput = output.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
        assertEquals("""
                Please enter the cost:
                Please enter the paid amount:
                0
                3
                0
                0
                0
                """, normalizedOutput);
    }

    private static void assertChange(int[] expectedChange, double paid, double cost) {
        assertArrayEquals(expectedChange, Change.changeCalc(paid, cost));
    }
}
