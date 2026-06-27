import Homework_6.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {
    @Test
    public void emptyArrayDoesNotEnterOuterLoop() {
        int[] values = {};

        BubbleSort.bubbleSortEfficient(values, values.length);

        assertArrayEquals(new int[]{}, values);
    }

    @Test
    public void sortedArrayStopsAfterNoExchangePass() {
        int[] values = {1, 2, 3, 4};

        BubbleSort.bubbleSortEfficient(values, values.length);

        assertArrayEquals(new int[]{1, 2, 3, 4}, values);
    }

    @Test
    public void twoElementReverseArrayCoversSwapPath() {
        int[] values = {2, 1};

        BubbleSort.bubbleSortEfficient(values, values.length);

        assertArrayEquals(new int[]{1, 2}, values);
    }

    @Test
    public void mixedArrayCoversSwapAndNoSwapInnerBranches() {
        int[] values = {4, 1, 3, 2};

        BubbleSort.bubbleSortEfficient(values, values.length);

        assertArrayEquals(new int[]{1, 2, 3, 4}, values);
    }
}
