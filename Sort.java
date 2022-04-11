import java.util.Arrays;
import java.util.Scanner;

/**
 * CSDS233 Project 5: Sorting algorithms and benchmarking performance
 * @author <i>Charlie Lin</i>
 */
public class Sort {
    /**
     * Sorts an array in ascending order using insertion sort
     * @param arr the array to be sorted
     */
    public void insertionSort(int[] arr) {
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
     * Sorts an array in ascending order using quick-sort
     * @param arr the array to be sorted
     */
    public void quickSort(int[] arr) {
        qSort(arr, 0, arr.length-1);
    }

    /**
     * Recursive helper method for quickSort
     * @param arr the array to be sorted
     * @param start the start of the range to be sorted
     * @param end the end of the range to be sorted
     */
    private void qSort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);

            qSort(arr, start, partition-1);
            qSort(arr, partition+1, end);
        }
    }

    /**
     * Helper method for qSort/quickSort
     * @param arr the array to be sorted
     * @param start the start of the range to be sorted
     * @param end the end of the range to be sorted
     * @return the index of the partition
     */
    private int partition(int[] arr, int start, int end) {
        // last element is pivot
        int pivot = arr[end];

        // variable used for swapping
        int temp;
        // index of element to swap pivot with
        int pivotPointer = start;
        for (int i = start; i < end; i++) {
            // if element is less than pivot, swap it leftward, increment pivot pointer
            if (arr[i] < pivot) {
                temp = arr[pivotPointer];
                arr[pivotPointer] = arr[i];
                arr[i] = temp;
                pivotPointer++;
            }
        }
        // move pivot into place by swapping into pointer position
        temp = arr[pivotPointer];
        arr[pivotPointer] = pivot;
        arr[end] = temp;
        return pivotPointer;
    }

    /**
     * Sorts an array in ascending order using merge-sort
     * @param arr the array to be sorted
     */
    public void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length);
    }

    /**
     * Recursive helper method for mergeSort, splits array and merges the sorted arrays
     * @param arr the array to be sorted
     * @param start the start index of the array
     * @param end the end index of the array
     */
    private void mSort(int[] arr, int start, int end) {
        // Base case: array length is 1
        if (arr.length > 1) {
            int middle = (end + start)/2;

            // construct left and right subarrays
            int[] leftArr = new int[middle];
            int[] rightArr = new int[end-middle];

            for (int i = 0; i < leftArr.length; i++)
                leftArr[i] = arr[i];

            for (int i = 0; i< rightArr.length; i++)
                rightArr[i] = arr[middle + i];

            // recursively sort the subarrays 
            mSort(leftArr, 0, leftArr.length);
            mSort(rightArr, 0, rightArr.length);

            merge(arr, leftArr, rightArr);
        }
    }

    /**
     * Merges two subarrays in sorted order
     * @param arr the array to be sorted
     * @param leftArr left subarray
     * @param rightArr right subarray
     */
    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int leftCount = 0, rightCount = 0, arrCount = 0;
        // replace values in main array with sorted values from left and right subarrays
		while (leftCount < leftArr.length && rightCount < rightArr.length) {
			if (leftArr[leftCount] < rightArr[rightCount])
				arr[arrCount++] = leftArr[leftCount++];
			else
				arr[arrCount++] = rightArr[rightCount++];
		}
        // finish off the sorting
		while (leftCount < leftArr.length)
			arr[arrCount++] = leftArr[leftCount++];
		while (rightCount < rightArr.length)
			arr[arrCount++] = rightArr[rightCount++];
	}

    /**
     * Generates a random array of <i>n</i> integers with values between <i>a</i> and <i>b</i>
     * @param n the size of the array
     * @param a the lower bound for the potential values
     * @param b the upper bound for the potential values
     * @return a random array of size <i>n</i>
     */
    public int[] randomArray(int n, int a, int b) {
        if (b < a || n <= 0) return new int[0];
        int[] randArr = new int[n];
        for (int i = 0; i < n; i++) {
            randArr[i] = (int)(Math.random()*(b-a+1) + a);
        }
        return randArr;
    }

    /**
     * Sorts an array in ascending order using bubble sort
     * @param arr the array to be sorted
     */
    public void bubbleSort(int[] arr) {
        // outer loop keeps track of how many values are sorted from the back
        for (int i = arr.length; i > 0; i--) {
            int j = 1;
            // swap adjacent elements until largest value is at the end of the array
            while (j < i) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        Scanner scan = new Scanner(System.in);
        System.out.println("Input the array size to test:");
        int arrSize = scan.nextInt();
        scan.close();

        int[] partiallySortedArray = new int[1000]; // partially sorted array will double as sorted array
        for (int i = 0; i < 500; i++)
            partiallySortedArray[i] = i;
        for (int i = 500; i < partiallySortedArray.length; i++)
            partiallySortedArray[i] = (int)(Math.random()*1000);

        /** Insertion Sort */
        double totalTime = 0;
        for (int i = 0; i < 6; i++) {
            int[] random = sort.randomArray(arrSize, 0, 1000);
            double startTime = System.nanoTime();
            sort.insertionSort(random);
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        double start = System.nanoTime();
        sort.insertionSort(partiallySortedArray);
        double end = System.nanoTime();
        System.out.println("InsertionSort for random arrays: " + totalTime/5 + " nanoseconds");
        System.out.println("InsertionSort for partially sorted array: " + (end-start) + " nanoseconds");
        start = System.nanoTime();
        sort.insertionSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("InsertionSort for sorted array: " + (end-start) + " nanoseconds\n");

        /** Quick Sort */
        partiallySortedArray = new int[1000];
        for (int i = 0; i < 500; i++)
            partiallySortedArray[i] = i;
        for (int i = 500; i < partiallySortedArray.length; i++)
            partiallySortedArray[i] = (int)(Math.random()*1000);
        totalTime = 0;
        for (int i = 0; i < 6; i++) {
            int[] random = sort.randomArray(arrSize, 0, 1000);
            double startTime = System.nanoTime();
            sort.quickSort(random);
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        start = System.nanoTime();
        sort.quickSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("QuickSort for random arrays: " + totalTime/5 + " nanoseconds");
        System.out.println("QuickSort for partially sorted array: " + (end-start) + " nanoseconds");
        start = System.nanoTime();
        sort.quickSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("QuickSort for sorted array: " + (end-start) + " nanoseconds\n");
        
        /** Merge Sort */
        partiallySortedArray = new int[1000];
        for (int i = 0; i < 500; i++)
            partiallySortedArray[i] = i;
        for (int i = 500; i < partiallySortedArray.length; i++)
            partiallySortedArray[i] = (int)(Math.random()*1000);
        totalTime = 0;
        for (int i = 0; i < 6; i++) {
            int[] random = sort.randomArray(arrSize, 0, 1000);
            double startTime = System.nanoTime();
            sort.mergeSort(random);
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        start = System.nanoTime();
        sort.mergeSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("MergeSort for random arrays: " + totalTime/5 + " nanoseconds");
        System.out.println("MergeSort for partially sorted array: " + (end-start) + " nanoseconds");
        start = System.nanoTime();
        sort.mergeSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("MergeSort for sorted array: " + (end-start) + " nanoseconds\n");

        /** Arrays Sort */
        partiallySortedArray = new int[1000];
        for (int i = 0; i < 500; i++)
            partiallySortedArray[i] = i;
        for (int i = 500; i < partiallySortedArray.length; i++)
            partiallySortedArray[i] = (int)(Math.random()*1000);
        totalTime = 0;
        for (int i = 0; i < 6; i++) {
            int[] random = sort.randomArray(arrSize, 0, 1000);
            double startTime = System.nanoTime();
            Arrays.sort(random);
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        start = System.nanoTime();
        Arrays.sort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("Arrays Sort for random arrays: " + totalTime/5 + " nanoseconds");
        System.out.println("Arrays Sort for partially sorted array: " + (end-start) + " nanoseconds");
        start = System.nanoTime();
        Arrays.sort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("Arrays Sort for sorted array: " + (end-start) + " nanoseconds\n");

        /** Bubble Sort */
        partiallySortedArray = new int[1000];
        for (int i = 0; i < 500; i++)
            partiallySortedArray[i] = i;
        for (int i = 500; i < partiallySortedArray.length; i++)
            partiallySortedArray[i] = (int)(Math.random()*1000);
        totalTime = 0;
        for (int i = 0; i < 6; i++) {
            int[] random = sort.randomArray(arrSize, 0, 1000);
            double startTime = System.nanoTime();
            sort.bubbleSort(random);
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        start = System.nanoTime();
        sort.bubbleSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("BubbleSort for random arrays: " + totalTime/5 + " nanoseconds");
        System.out.println("BubbleSort for partially sorted array: " + (end-start) + " nanoseconds");
        start = System.nanoTime();
        sort.bubbleSort(partiallySortedArray);
        end = System.nanoTime();
        System.out.println("BubbleSort for sorted array: " + (end-start) + " nanoseconds\n");

    }
}
