package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

 Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

 a, b are from arr
 a < b
 b - a equals to the minimum absolute difference of any two elements in arr


 Example 1:

 Input: arr = [4,2,1,3]
 Output: [[1,2],[2,3],[3,4]]
 Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 Example 2:

 Input: arr = [1,3,6,10,15]
 Output: [[1,3]]
 Example 3:

 Input: arr = [3,8,-10,23,19,-4,-14,27]
 Output: [[-14,-10],[19,23],[23,27]]
 */
public class MinimumAbsoluteDifference {

    /**
     * hint: Once you've sorted, you just need to go through adjacent numbers to find minimum abs diff
     * Approach:
     *      Sort
     *      Loop once to add or remove min res
     *  Time Complexity: O(n log n)
     *  Space Complexity: O(n)
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifferenceOneLoop(int[] arr) {
        // STEP 1: Sort the given array and initialize result DS
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // STEP 2: find absMin and update res
        int absMin = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            int currMin = Math.abs(arr[i]-arr[i+1]);
            // If we found a current min that is smaller than absMin, clear the res
            if (currMin<absMin) {
                absMin = currMin;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            } else if (currMin == absMin) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;
    }
    /**
     * hint: Once you've sorted, you just need to go through adjacent numbers to find minimum abs diff
     * Approach:
     *      Sort
     *      iterate to find absMin
     *      iterate to find pairs
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // STEP 1: Sort the given array and initialize result DS
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // STEP 2: find absMin
        int absMin = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            if (Math.abs(arr[i]-arr[i+1])<absMin) {
                absMin = Math.abs(arr[i]-arr[i+1]);
            }
        }

        // STEP 3: loop through and find result
        for(int i=0; i<arr.length; i++) {
            if (Math.abs(arr[i]-arr[i+1])==absMin) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;

    }
}
