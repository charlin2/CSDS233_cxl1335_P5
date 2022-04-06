import java.util.Arrays;

/**
 * CSDS233 Project 5: Sorting algorithms and benchmarking performance
 * @author <i>Charlie Lin</i>
 */
public class Sort {
    /**
     * Sorts an array in ascending order using insertion sort
     * @param arr the array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                int toInsert = arr[i];
                int j = i;
                // iterate backwards, stopping when reaching the front of the list or when the current value is no longer less than the preceeding value
                while (j > 0 && toInsert < arr[j-1]) {
                    arr[j] = arr[--j];
                }
                arr[j] = toInsert;
            }
        }
    }

    /**
     * Sorts an array in ascending order using quick sort
     * @param arr the array to be sorted
     */
    public static void quickSort(int[] arr) {
        // TODO
    }

    /**
     * Sorts an array in ascending order using merge sort
     * @param arr the array to be sorted
     */
    public static void mergeSort(int[] arr) {
        // TODO
    }

    /**
     * Generates a random array of <i>n</i> integers with values between <i>a</i> and <i>b</i>
     * @param n the size of the array
     * @param a the lower bound for the potential values
     * @param b the upper bound for the potential values
     * @return a random array of size <i>n</i>
     */
    public static int[] randomArray(int n, int a, int b) {
        if (b < a || n <= 0) return new int[0];
        int[] randArr = new int[n];
        for (int i = 0; i < n; i++) {
            randArr[i] = (int)(Math.random()*(b-a+1) + a);
        }
        return randArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Sort.randomArray(0, 5, 23)));
        System.out.println(Arrays.toString(Sort.randomArray(10, 7, 4)));
        System.out.println(Arrays.toString(Sort.randomArray(10, 5, 23)));
        System.out.println(Arrays.toString(Sort.randomArray(10, 5, 23)));
        System.out.println(Arrays.toString(Sort.randomArray(10, 5, 5)));
        System.out.println(Arrays.toString(Sort.randomArray(10, 5, 6)));
    }
}
