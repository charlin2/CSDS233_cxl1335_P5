import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    Sort sort = new Sort();

    @Test
    public void testInsertionSort() {
        // general sorting
        int[] sortArray = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
        sort.insertionSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));

        // sort on array of size one
        sortArray = new int[1];
        sortArray[0] = 1;
        sort.insertionSort(sortArray);
        Assert.assertEquals("[1]", Arrays.toString(sortArray));

        // sort on empty array
        sortArray = new int[0];
        sort.insertionSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));

        // sort on null input
        sortArray = null;
        try {
            sort.insertionSort(sortArray);
        }
        catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
        
    }

    @Test
    public void testQuickSort() {
        // general sorting
        int[] sortArray = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
        sort.quickSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));

        // sort on array of size one
        sortArray = new int[1];
        sortArray[0] = 1;
        sort.quickSort(sortArray);
        Assert.assertEquals("[1]", Arrays.toString(sortArray));

        // sort on empty array
        sortArray = new int[0];
        sort.quickSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));

        // sort on null input
        sortArray = null;
        try {
            sort.quickSort(sortArray);
        }
        catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testMergeSort() {
        // general sorting
        int[] sortArray = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
        sort.mergeSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));

        // sort on array of size one
        sortArray = new int[1];
        sortArray[0] = 1;
        sort.mergeSort(sortArray);
        Assert.assertEquals("[1]", Arrays.toString(sortArray));

        // sort on empty array
        sortArray = new int[0];
        sort.mergeSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
        
        // sort on null input
        sortArray = null;
        try {
            sort.mergeSort(sortArray);
        }
        catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testBubbleSort() {
        // general sorting
        int[] sortArray = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
        sort.bubbleSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));

        // sort on array of size one
        sortArray = new int[1];
        sortArray[0] = 1;
        sort.bubbleSort(sortArray);
        Assert.assertEquals("[1]", Arrays.toString(sortArray));

        // sort on empty array
        sortArray = new int[0];
        sort.bubbleSort(sortArray);
        Assert.assertEquals("[]", Arrays.toString(sortArray));
        
        // sort on null input
        sortArray = null;
        try {
            sort.bubbleSort(sortArray);
        }
        catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }
}