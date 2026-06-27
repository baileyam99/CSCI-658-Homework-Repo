import Homework_6.hotelOccupancy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelOccupancyTest {
    @Test
    public void fullOccupancyCoversNormalLoopPath() {
        String output = runHotel("20\n20\n20\n20\n20\n20\n");

        assertTrue(output.contains("The hotel has a total of 120 suites."));
        assertTrue(output.contains("120 are currently occupied."));
        assertTrue(output.contains("This is an occupancy rate of 100%"));
    }

    @Test
    public void partialOccupancyUsesDecimalRate() {
        String output = runHotel("1\n0\n0\n0\n0\n0\n");

        assertTrue(output.contains("1 are currently occupied."));
        assertTrue(output.contains("This is an occupancy rate of 0.833%"));
    }

    @Test
    public void tooLargeFloorCountIsRejectedAndReentered() {
        String output = runHotel("25\n10\n0\n0\n0\n0\n0\n");

        assertTrue(output.contains("The number of occupied suites must be between 0 and 20"));
        assertTrue(output.contains("10 are currently occupied."));
        assertTrue(output.contains("This is an occupancy rate of 8.333%"));
    }

    @Test
    public void negativeFloorCountIsRejectedAndReentered() {
        String output = runHotel("-1\n0\n0\n0\n0\n0\n0\n");

        assertTrue(output.contains("The number of occupied suites must be between 0 and 20"));
        assertTrue(output.contains("0 are currently occupied."));
        assertTrue(output.contains("This is an occupancy rate of 0%"));
    }

    private String runHotel(String input) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));

        try {
            new hotelOccupancy().calcRate();
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return testOutput.toString();
    }
}
