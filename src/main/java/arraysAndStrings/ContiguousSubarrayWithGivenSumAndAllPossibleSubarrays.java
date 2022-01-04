package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
https://youtu.be/HbbYPQc-Oo4
https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
https://leetcode.com/problems/subarray-sum-equals-k/
    Given an unsorted array of integers, find a subarray that adds to a given number.
    If there is more than one subarray with the sum of the given number, print any of them.

    Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Output: Sum found between indexes 2 and 4
    Explanation: Sum of elements between indices
    2 and 4 is 20 + 3 + 10 = 33

    Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
    Output: Sum found between indexes 0 to 3
    Explanation: Sum of elements between indices
    0 and 3 is 10 + 2 - 2 - 20 = -10

    Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
    Output: No subarray with given sum exists
    Explanation: There is no subarray with the given sum
 */
public class ContiguousSubarrayWithGivenSumAndAllPossibleSubarrays {

    public static void main(String[] args) {
       //  /*

        int[] arr1 = {1, 4, 20, 3, 10, 5}; int sum1 = 33;
        int[] arr2 = {10, 2, -2, -20, 10}; int sum2 = -10;
        int[] arr3 = {-10, 0, 2, -2, -20, 10}; int sum3 = 20;
        System.out.println("Expected: [2, 4] Actual: " + Arrays.toString(getSubarrayWithGivenSum_hashmap(arr1, sum1)));
        System.out.println("Expected: [0, 3] Actual: " + Arrays.toString(getSubarrayWithGivenSum_hashmap(arr2, sum2)));
        System.out.println("Expected: [-1, -1] Actual: " + Arrays.toString(getSubarrayWithGivenSum_hashmap(arr3, sum3)));
        System.out.println("Expected: [2, 4] Actual: " + Arrays.toString(getSubarrayWithGivenSum_n2(arr1, sum1)));
        System.out.println("Expected: [0, 3] Actual: " + Arrays.toString(getSubarrayWithGivenSum_n2(arr2, sum2)));
        System.out.println("Expected: [-1, -1] Actual: " + Arrays.toString(getSubarrayWithGivenSum_n2(arr3, sum3)));

        System.out.println("========================================");

        int[] arr4 = {3, 4, 7, 2, -3, 1, 4, 3};
        // TOD0: FIX this
        System.out.println("Given Array: " + Arrays.toString(arr4));
        System.out.println("all possible sub arrays that add to 7");
        List<List<Integer>> res = getAllPossibleArraysWithGivenSum(arr4, 7);
        for (List<Integer> range: res) {
            System.out.println(Arrays.toString(range.toArray()));
        }

        System.out.println("========================================");
        int[] arr5 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println("Given Array: " + Arrays.toString(arr5));
        System.out.println("all possible sub arrays that add to 7");
        List<List<Integer>> res1 = getAllPossibleArraysWithGivenSum(arr5, 7);
        for (List<Integer> range: res1) {
            System.out.println(Arrays.toString(range.toArray()));
        }

        // */
        System.out.println("========================================");
        int[] arr6 = {-4, 6, 7, 0, 2, 3, 4};
        System.out.println("Given Array: " + Arrays.toString(arr6));
        System.out.println("all possible sub arrays that add to 9");
        List<List<Integer>> res2 = getAllPossibleArraysWithGivenSum(arr6, 9);
        for (List<Integer> range: res2) {
            System.out.println(Arrays.toString(range.toArray()));
        }
    }

    /**
     * Idea:
     * Sub-arrays with given sum K may start at any point and end at any point BUT startIndex <= endIndex
     *  - We will maintain a currSum = Which is the prefix value
     *  - as we iterate right, we update currSum
     *  - at each iteration we compare currSum with K, if they're equal it means a sub-array exists
     *  - we also keep a hashMap to store (currSum-SumK), index
     *      IMP: Where ever we find currSum-SumK in our map, there is a sub array from next index till the current Index's point
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @param sumK
     * @return
     */
    public static int[] getSubarrayWithGivenSum_hashmap(int[] nums, int sumK) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currSum = 0;
        for (int i=0; i<nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum == sumK) {
                return new int[] {0, i}; // start to current iteration
            }
            if (hashMap.containsKey(currSum-sumK)) {
                int start = hashMap.get(currSum-sumK) + 1;
                return new int[] {start, i};
            }
            hashMap.put(currSum, i);
        }
        return new int[]{-1, -1}; // if not found
    }

    // TODO: FIX IT
    public static List<List<Integer>> getAllPossibleArraysWithGivenSum(int[] nums, int sumK) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int currSum = 0;
        for (int i=0; i<nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum == sumK) {
                List<Integer> range = new ArrayList<>();
                range.add(0);
                range.add(i);
                res.add(range);
            }
            if (hm.containsKey(currSum-sumK)) {
                List<Integer> ranges = hm.get(currSum - sumK);
                for (int range : ranges) {
                    int start = range + 1;
                    List<Integer> range1 = new ArrayList<>();
                    range1.add(start);
                    range1.add(i);
                    res.add(range1);
                }
                ranges.add(i);
                hm.put(currSum, ranges);
            }


            if (hm.containsKey(currSum)) {
                List<Integer> currRange = hm.get(currSum);
                currRange.add(i);
                hm.put(currSum, currRange);
            } else {
                List<Integer> firstRange = new ArrayList<>();
                firstRange.add(i);
                hm.put(currSum, firstRange);
            }
        }
        return res;
    }
    // TC: O(n^2) SC = O(1)
    public static int[] getSubarrayWithGivenSum_n2(int[] nums, int sum) {
        int currSum = 0;
        for (int i=0; i<nums.length; i++) {
            currSum = nums[i];
            for (int j=i+1; j < nums.length; j++) {
                currSum = currSum + nums[j];
                if (currSum == sum) {
                    return new int[] {i, j}; // starting and ending index
                }
            }
        }
        return new int[]{-1, -1}; // if not found
    }
}
