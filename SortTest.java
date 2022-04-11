import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    int[] array = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
    Sort sort = new Sort();

    @Test
    public void testInsertionSort() {
        int[] sortArray = array;
        sort.insertionSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));
        sortArray = new int[0];
        sort.insertionSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
    }

    @Test
    public void testQuickSort() {
        int[] sortArray = array;
        sort.quickSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));
        sortArray = new int[0];
        sort.quickSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
    }

    @Test
    public void testMergeSort() {
        int[] sortArray = array;
        sort.mergeSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));
        sortArray = new int[0];
        sort.mergeSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
    }

    @Test
    public void testBubbleSort() {
        int[] sortArray = array;
        sort.bubbleSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));
        sortArray = new int[0];
        sort.bubbleSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
    }
}