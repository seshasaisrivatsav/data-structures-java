package sortingAndSearching;

import java.util.Arrays;

/*
    Selection sort
        - Sorts the array by repeatedly finding minimum element (for asc order) from unsorted part and puts at beginning
        - Maintains 2 sub arrays
        1. Subarray which is already sorted
        2. Subarray that is unsorted
        - In every iteration of selection sort, the min element from unsorted subarray is picked, moved to sorted part\\\

            5 4 2 3 1
    Step 1: 1 4 2 3 5            (finds min in arr[0..4])
    Step 2: 1 2 4 3 5            (finds min in arr[1..4])
    Step 3: 1 2 3 4 5            (finds min in arr[2..4])
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[] {5, 4, 2, 3, 1})));
        System.out.println(Arrays.toString(selectionSort(new int[] {5, 2, 4, -1, 2, 3, 1})));
    }
    public static int[] selectionSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int currIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                // Find the minimum in arr[i+1.. n]
                if (arr[j] < arr[currIndex]) {
                    currIndex = j;
                }
                // swap the element
                int temp = arr[currIndex];
                arr[currIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
