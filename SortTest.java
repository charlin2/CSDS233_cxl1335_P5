import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    int[] array = {3, 1, 4, 12, 24, 23, 12, 30, 10, 12, 11, 5, 25, 25, 21};
    
    @Test
    public void testInsertionSort() {
        int[] sortArray = array;
        Sort.insertionSort(sortArray);
        Assert.assertEquals("[1, 3, 4, 5, 10, 11, 12, 12, 12, 21, 23, 24, 25, 25, 30]", Arrays.toString(sortArray));
    }


}