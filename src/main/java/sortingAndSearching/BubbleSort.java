package sortingAndSearching;

import java.util.Arrays;

/**
 * In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater than the second.
 * Then, we go to the next pair, and so on, continuously making sweeps of the array until it is sorted.
 * In doing so, the smaller items slowly"bubble" up to the beginning of the list.
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
            Loop 1: goes from 0 to length-1
                Loop 2: goes from 0 to length-loop1-1

                loop1: 0 to 6
                    loop2: 0 to (0to6)

      index 0  1  2  3  4  5  6
            4  5  1  3  5  0  9

      i j
      0 0  4  5  1  3  5  0  9  (j=0 to 6)
      0 1  4  1  5  3  5  0  9
      0 2  4  1  3  5  5  0  9
      0 3  4  1  3  5  5  0  9
      0 4  4  1  3  5  0  5  9
      0 5  4  1  3  5  0  5  9

      1 0  1  4  3  5  0  5  9 (j=0 to 5)
      1 1  1  3  4  5  0  5  9 (j=0 to 5)
      1 2  1  3  4  5  0  5  9 (j=0 to 5)
      1 3  1  3  4  0  5  5  9 (j=0 to 5)
      1 4  1  3  4  0  5  5  9 (j=0 to 5)

      2 0  1  3  4  0  5  5  9 (j=0 to 4)
      2 1  1  3  4  0  5  5  9 (j=0 to 4)
      2 2  1  3  0  4  5  5  9 (j=0 to 4)
      2 3  1  3  0  4  5  5  9 (j=0 to 4)

      3 0  1  3  0  4  5  5  9 (j=0 to 3)
      3 1  1  0  3  4  5  5  9 (j=0 to 3)
      3 2  1  0  3  4  5  5  9 (j=0 to 3)

      4 0  0  1  3  4  5  5  9 (j=0 to 2)


         */
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 5, 1, 3, 5, 0, 9})));
    }

    /**
     * Sort the array
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
