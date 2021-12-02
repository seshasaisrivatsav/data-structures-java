package arraysAndStrings;

/**
 *  find number of elements needed to give a largest sum of 5 consecutive elements
 * @link Arrays.md
 */
public class MaxSumContiguousArray {

    public static void main(String[] args) {
        int[] arr = { 5, 7, 1, 4, 3, 6, 2, 9, 2 };
        System.out.println("Sliding window max: " + getMaxSum_windowSliding(arr, 5));
        System.out.println("Bruteforce max: " + getMaxSum_bruteForce(arr, 5));

    }

    /**
     * Approach 1: Using sliding window
     * Time Complexity: O(n)
     * @param arr
     * @param windowSize
     * @return
     */
    public static int getMaxSum_windowSliding(int[] arr, int windowSize) {
        int arrayLength = arr.length;
        if (arrayLength < windowSize) {
            return -1; // Unable to process
        }

        int maxSum = 0;

        // Initialize sum of first window
        for (int i=0; i<windowSize; i++) {
            maxSum = maxSum + arr[i];
        }

        int windowSum = maxSum; // use windowSum variable to arrive at solution
        for (int i=windowSize; i<arrayLength; i++) {
            windowSum = windowSum + (arr[i] - arr[i-windowSize]);
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }
    /**
     * Time complexity: O(n*k), where k = total contiguous items
     * @param arr
     * @return
     */
    public static int getMaxSum_bruteForce(int[] arr, int contiguousLength) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<contiguousLength; i++) {
            int loopSum = 0;
            for(int j=i; j<i+contiguousLength; j++) {
                loopSum = loopSum + arr[j];
            }
            if (loopSum > max) {
                max = loopSum;
            }
        }
        return max;
    }
}
