package sortingAndSearching;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeThreeSortedArrays2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 6};
        int[] arr2 = {2, 7, 9};
        int[] arr3 = {3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(mergeThreeArraysMinHeap(arr1, arr2, arr3)));

    }



    static class ArrayItem {
        int val;
        int index;
        int arrIndex;
        ArrayItem(int val, int index, int arrIndex) {
            this.val = val;
            this.index = index;
            this.arrIndex = arrIndex;
        }
    }
    /**
     * N = E (a1+a2+a3)
     * Confirm: O(1)
     * Addition: O(log(k)) + removal: O(log K) = N * O(log K)
     * Space Complexity: O(K) (only Heap without result)
     * @param arr1 int[]
     * @param arr2 int[]
     * @param arr3 int[]
     * @return int[] sorted result
     */
    public static int[] mergeThreeArraysMinHeap(int[] arr1, int[] arr2, int[] arr3) {
        int[] res = new int[arr1.length + arr2.length + arr3.length];
        PriorityQueue<ArrayItem> minHeap = new PriorityQueue<>(new Comparator<ArrayItem>() {
            @Override
            public int compare(ArrayItem o1, ArrayItem o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        // Step 1: Initialize the queue
        if (arr1.length > 0) {
            minHeap.add(new ArrayItem(arr1[0], 0, 0));
        }
        if (arr2.length > 0) {
            minHeap.add(new ArrayItem(arr2[0], 0, 1));
        }
        if (arr3.length > 0) {
            minHeap.add(new ArrayItem(arr3[0], 0, 2));
        }

        // Step 2: pluck each item from queue, add to res and add the next item
        //          from the same array
        int k = 0;
        while (!minHeap.isEmpty()) {
            ArrayItem currArrayItem = minHeap.poll();

            res[k] = currArrayItem.val;
            k++;

            switch (currArrayItem.arrIndex) {
                case 0:
                    addToMinHeap(minHeap, currArrayItem, arr1);
                    break;
                case 1:
                    addToMinHeap(minHeap, currArrayItem, arr2);
                    break;
                case 2:
                    addToMinHeap(minHeap, currArrayItem, arr3);
                    break;
            }

        }

        return res;
    }

    static void addToMinHeap(PriorityQueue<ArrayItem> minHeap, ArrayItem arrayItem, int[] sourceArr) {
        if (arrayItem.index + 1  < sourceArr.length) {
            minHeap.add(new ArrayItem(sourceArr[arrayItem.index + 1], arrayItem.index+1, arrayItem.arrIndex));
        }
    }
    /**
     * TC: O(arr1.l + arr2.l + arr3.l)
     * SC: O(1)
     * @param arr1 int[] arr1
     * @param arr2 int[] arr2
     * @param arr3 int[] arr3
     * @return int[] sorted array
     */
    public static int[] mergeThreeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int[] res = new int[arr1.length + arr2.length + arr3.length];

        int i = 0, j = 0, k = 0, p = 0;

        // Case 1- while 3 arrays have values
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // 1 < 2 and 1 < 3
            if ((arr1[i] < arr2[j]) && (arr1[i] < arr3[k])) {
                res[p] = arr1[i];
                i++;
            } else if ((arr2[j] < arr3[k]) && (arr2[j] < arr1[i])) {
                // 2 is smallest
                res[p] = arr2[j];
                j++;
            } else {
                // 3 is smallest
                res[p] = arr3[k];
                k++;
            }
            p++;
        }
        // Case 2 - when only 2 of them have values
        // 1 2
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[p] = arr1[i];
                i++;
            } else {
                res[p] = arr2[j];
                j++;
            }
            p++;
        }

        // 2 and 3
        while (j < arr2.length && k < arr3.length) {
            if (arr2[j] < arr3[k]) {
                res[p] = arr2[j];
                j++;
            } else {
                res[p] = arr3[k];
                k++;
            }
            p++;
        }

        // 1 3
        while (i < arr1.length && k < arr3.length) {
            if (arr1[i] < arr3[k]) {
                res[p] = arr1[i];
                i++;
            } else {
                res[p] = arr3[k];
                k++;
            }
            p++;
        }

        // Case 3 - when only 1 of them has values
        while (i < arr1.length) {
            res[p] = arr1[i]; i++; p++;
        }
        while (j < arr2.length) {
            res[p] = arr2[j]; j++; p++;
        }
        while (k < arr3.length) {
            res[p] = arr3[k]; k++; p++;
        }
        return res;
    }

    /*
    @Test
    public void test_allEqualLength() {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 2, 6, 7};
        int[] arr3 = {9, 10, 11, 12};
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12}, mergeThreeArraysMinHeap(arr1, arr2, arr3));
    }

    @Test
    public void test_inEqualLength() {
        int[] arr1 = {1, 5};
        int[] arr2 = {2, 3, 5, 6, 7, 8, 9};
        int[] arr3 = {4, 10, 11, 12};
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12}, mergeThreeArraysMinHeap(arr1, arr2, arr3));
    }

    @Test
    public void test_empty() {
        int[] arr1 = {};
        int[] arr2 = { 2, 4, 5};
        int[] arr3 = { 3, 4, 4, 6 };
        Assert.assertArrayEquals(new int[] { 2, 3, 4, 4, 4, 5, 6 }, mergeThreeArraysMinHeap(arr1, arr2, arr3));
    }

    @Test
    public void test_all_empty() {
        int[] arr1 = {};
        int[] arr2 = {};
        int[] arr3 = {};
        Assert.assertArrayEquals(new int[] {}, mergeThreeArraysMinHeap(arr1, arr2, arr3));
    }


     */
}
