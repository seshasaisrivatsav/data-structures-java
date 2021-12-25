package treesAndGraphs;

public class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] sortedArr = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBSTRecursive(sortedArr));
    }

    /**
     * Time Complexity: O(N) = as we visit each node exactly once
     * Space Complexity: O(log N) - recursion stack
     * @param arr
     * @return
     */
    public static Node sortedArrayToBSTRecursive(int[] arr) {
        return sortedArrayToBSTHelper(arr, 0, arr.length-1);
    }

    public static Node sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node head = new Node(arr[mid]);
        head.leftChild = sortedArrayToBSTHelper(arr, start, mid-1);
        head.rightChild = sortedArrayToBSTHelper(arr, mid+1, start);
        return head;
    }
}
