package arraysAndStrings;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class ContiguousSubArrayCountsWithGivenSum {


    public static void main(String[] args) {
        int[] arr0 = {3, 4, 7, 2, -3, 1, 4, 2};
        /*
                3, 4
                7
                7 2 -3 1
                1 4 2
         */
        System.out.println("Expected: 4 Actual: " + countSubarraysThatAddtoGivenSum(arr0, 7));

        int[] arr1 = {3, 4, 7, 2, -3, 1, 4, 3};
        /*
                3, 4
                7
                7 2 -3 1
                2, -3, 1, 4, 3
                4 3
         */
        System.out.println("Expected: 5 Actual: " + countSubarraysThatAddtoGivenSum(arr1, 7));

        int[] arr2 = {1, 1, 1}; int sum2 = 2;
        /*
            1 1
            1 1
         */
        System.out.println("Expected: 2 Actual: " + countSubarraysThatAddtoGivenSum(arr2, sum2));

        int[] arr3 = {-4, 6, 7, 0, 2, 3, 4}; int sum3 = 9;
        /*
                -4, 6, 7, 0
                -4, 6, 7
                0, 2, 3, 4
                2, 3, 4
                7, 0, 2
         */
        System.out.println("Expected: 5 Actual: " + countSubarraysThatAddtoGivenSum(arr3, sum3));

        int[] arr4 = {0, 0, 0, 0, 0, 0}; int sum4 = 0; // all possible combinations
        System.out.println("Expected: 21 Actual: " + countSubarraysThatAddtoGivenSum(arr4, sum4));
    }

    /**
     * Ideology is same as ContiguousSubarrayWithGivenSum with the following modifications
     * Approach: Cummulative sum represented by Sumi upto ith index
     *          Sum i - Sum j = k
     *
     *         In the hashmap, we will store
     *                  Sum i , No. Of occurence of the sum
     *  Space Complexity: O(n)
     *  Time Complexity: O(N)
     * @param nums int[]
     * @param sumK int
     * @return int number of sub arrays that add up to sumK
     */
    public static int countSubarraysThatAddtoGivenSum(int[] nums, int sumK) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            currSum = currSum + num;
            if (currSum == sumK) {
                count++;
            }
            if (hm.containsKey(currSum - sumK)) {
                count = count + hm.get(currSum - sumK);
            }
            hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}
