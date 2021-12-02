package treesAndGraphs;

import java.util.Arrays;

/**
 * Given a sorted array with integer elements
 * write algorithm to create binary search tree with minimal height
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) = height of tree
 *
 *
 * Time Complexity: T(n) = 2T(n/2) + C
 *  Where T(n) = time take for array of size n
 *         C = time take to find middle
 *
 */
public class MinimalTree {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        createBinarySearchTree(arr);
    }

    public static Node createBinarySearchTree(int[] arr) {
        return createBinarySearchTreeHelper(arr, 0, arr.length-1);
    }
    public static Node createBinarySearchTreeHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        Node head = new Node(arr[mid]);
        head.leftChild = createBinarySearchTreeHelper(arr, start, mid-1);
        head.rightChild = createBinarySearchTreeHelper(arr, mid-1, end);
        return head;
    }
}
