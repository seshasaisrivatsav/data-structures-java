package arraysAndStrings;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Companies:
 *  Facebook, Amazon, LinkedIn, Microsoft, Google, Adobe, Oracle
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        KthLargestElementInArray kth = new KthLargestElementInArray();
        System.out.println("Expected: 5 Actual: " + kth.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("Expected: 4 Actual: " + kth.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        return 1;
    }
}
