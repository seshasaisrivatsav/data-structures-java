package sortingAndSearching;

import java.util.*;

/**
 * Given k sorted arrays of size n each, merge them and print the sorted output.
 * Algorithm with pictures: https://www.algorithmsandme.com/merge-k-sorted-arrays/
 *
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        // Change n at the top to change number of elements
        // in an array
        int[][] arr =  {{2, 6, 12, 34},
                        {1, 9, 20, 1000},
                        {23, 34, 90, 2000}};
        System.out.println("Expected: [1, 2, 6, 9, 12, 20, 23, 34, 90, 1000, 2000] Actual " + Arrays.toString(mergeKArrays_minHeap(arr)));

        int[][] arr2 = {{1, 4, 7, 11, 15},
                        {2, 5, 10, 14, 9},
                        {-5, 3, 8}};
        System.out.println("Expected: [-5, 1, 2, 3, 4, 5, 7, 9, 10, 11, 14, 15] Actual " + Arrays.toString(mergeKArrays_minHeap(arr2)));
    }
    // ----------------- vvv Approach 1: Merge 2 at a time vvvv ---------------- //

    /**
     *  Given K arrays, return a sorted merged array
     *
     * Approach
     * ========
     *  - Add the first K items in all arrays into a min heap
     *  - N = total number of items
     *  - min heap gives smallest of K items
     *  - then grab next element from the array
     *  - in min heap we annotate the items, we remember the array that comes from
     *         - If this was array list of linked list, we'd have access to next item
     *  - no we pull smallest item again, add next item in array, repeat
     *  - if min heap is empty, we're good
     *
     * Time Complexity: O(N Log K) = Since depth of min heap = (1+floor (log K)) - for insert and fetch we do this twice for N elements
     * Space Complexity: O(K) = We store K elements
     *
     * Priority Queue is implemented with min-heap
     *
     * Time Complexity Analysis
     * ======================
     *  Assume - we have binary heap
     *         - binary heap has 1 + floor(log k) levels
     *  - Time Complexity:
     *      - Time taken for insertion = N (1 + floor(log k)) for insertion for n elements = O(n log k)
     *      - Time for removal N (1 + floor(log k))
     *      Total = 2N + 2Floor (log k) = O(N log K)
     *  - Space Complexity: O(k) => at max we hold k items
     * @param arrays int[][] 2d array
     * @return int[] sorted and merged array
     */
    public static int[] mergeKArrays_minHeap(int[][] arrays) {
        if (arrays.length == 0) { return null; }

        // In Java, min heap is implemented by priority queue
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
//        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(arrays.length, (HeapNode a, HeapNode b) -> a.value - b.value);

        // n = Total elements in all arrays
        int n = 0;
        for (int[] array : arrays) {
            n += array.length;
        }

        // initialize res
        int[] res = new int[n];

        // Initialize the minHeap - we add the first elements from all the arrays
        for (int i=0; i<arrays.length; i++) {
            minHeap.add(new HeapNode(arrays[i][0], 0, i));
        }

        // Iterate as many times as the elements and poll the lowest element from the min heap
        // and add a number from the same array back to min heap
        for (int i=0; i<n; i++) {
            // Poll the lowest element from min heap and add it to result
            HeapNode node = minHeap.poll();
            if (node != null) {
                res[i] = node.value;

                // if the corresponding array of the minheap poll still has values, add it to min heap
                if (node.index + 1 < arrays[node.arrNum].length) {
                    minHeap.add(new HeapNode(arrays[node.arrNum][node.index+1], node.index + 1, node.arrNum));
                }
            }

        }
        return res;
    }

    private static class HeapNode implements Comparable<HeapNode> {
        public int value;
        public int index;
        public int arrNum;

        HeapNode(int arrVal, int index, int arrNum) {
            this.value = arrVal;
            this.index = index;
            this.arrNum = arrNum;
        }

        @Override
        public int compareTo(HeapNode o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
