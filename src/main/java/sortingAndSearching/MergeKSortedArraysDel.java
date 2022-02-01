package sortingAndSearching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArraysDel {
    public static void main(String[] args) {
        // Change n at the top to change number of elements
        // in an array
        int[][] arr =  {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        System.out.println("Expected: [1, 2, 6, 9, 12, 20, 23, 34, 90, 1000, 2000] Actual " + Arrays.toString(mergeKSortedArrays(arr)));

        int[][] arr2 = {{1, 4, 7, 11, 15},
                {2, 5, 10, 14, 9},
                {3, 8, -5}};
        System.out.println("Expected: [-5, 1, 2, 3, 4, 5, 7, 9, 10, 11, 14, 15] Actual " + Arrays.toString(mergeKSortedArrays(arr2)));
    }
    private static class HeapNode {
        public int arrNum;
        public int index;
        public int value;

        HeapNode(int arrVal, int index, int arrNum) {
            this.value = arrVal;
            this.index = index;
            this.arrNum = arrNum;
        }
    }
    public static int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays.length == 0) { return null; }

        PriorityQueue<HeapNode> minHeap =
                new PriorityQueue<>(arrays.length,
                        (HeapNode a, HeapNode b) -> a.value - b.value);

        int n = 0;
        for (int[] array : arrays) {
            n += array.length;
        }
        int[] result = new int[n]; // k * n

        //add first elements in the array to this heap
        for (int i = 0; i < arrays.length; i++) {
            minHeap.add(new HeapNode(arrays[i][0], 0, i));
        }

        //Complexity O(n * k * log k)
        for (int i = 0; i < n; i++) {
            //Take the minimum value and put into result
            HeapNode node = minHeap.poll();

            if (node != null) {
                result[i] = node.value;
                if (node.index + 1 < arrays[node.arrNum].length) {
                    minHeap.add(new HeapNode( arrays[node.arrNum][node.index + 1], node.index + 1,node.arrNum));
                }
            }
        }
        return result;
    }
}
