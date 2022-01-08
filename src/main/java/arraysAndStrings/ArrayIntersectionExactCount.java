package arraysAndStrings;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

import java.util.*;

public class ArrayIntersectionExactCount {
    /**
     * Approach: Here we use a hash map to store smaller array and counts
     *          Then we iterate along bigger array anf if the number exists, add it to result and decrement the count in HM
     *
     * Time Complexity: O(n+m)
     * Space Complexity: O(min(m,n)) for the hashmap
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[] of common intersection
     */
    public static int[] interesctionUsingHashMap(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return interesctionUsingHashMap(nums2, nums1);
        }
        // nums1 = smaller, nums2=larger
        // use smaller for quick lookups
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n: nums1) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        // iterate larger one anf
        int j=0; // pointer
        for (int n: nums2) {
            int elementCount = hm.getOrDefault(n, 0);
            if (elementCount > 0) {
                nums1[j] = n;
                j++;
                hm.put(n, elementCount-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, j);
    }

    /**
     * Approach: Here, we sort both arrays and use two pointers to find common elements
     *  - sort nums1, nums2
     *  - initialize i, j, k for nums1, nums2 and res
     *  - increment i if nums1[i] is smaller
     *  - increment j if nums2[j] is smaller
     *  - if numbers are equal, then copy into res, increment all three pointers
     *
     *  Time Complexity: O(m log m + n log n) = for sorting and linear scan
     *  Space complexity: O(log n + log m) to O(m_n) depending on implementation of sorting
     *  - we ignore memory required by input and output
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[]
     */
    public static int[] intersectionUsingSortingTwoPointer(int[] nums1, int[] nums2) {
        if (nums1.length==0) {return  nums1;}
        if (nums2.length==0) {return  nums2;}
        int i=0; int j=0; int k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]==nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                k++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        // copy of range returns a new array with selected range
        return Arrays.copyOfRange(nums1, 0, k);
    }
    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};

        System.out.println("Expected: [4, 9] Actual: " + Arrays.toString(intersectionUsingSortingTwoPointer(arr1, arr2)));

        int[] arr3 = {1, 2};
        int[] arr4 = {1, 1};
        System.out.println("Expected: [1] Actual: " + Arrays.toString(intersectionUsingSortingTwoPointer(arr3, arr4)));
        System.out.println("Expected: [1] Actual: " + Arrays.toString(interesctionUsingHashMap(arr3, arr4)));

        int[] arr5 = {1, 2, 2, 1};
        int[] arr6 = {2, 2};
        System.out.println("Expected: [2, 2] Actual: " + Arrays.toString(intersectionUsingSortingTwoPointer(arr6, arr5)));
        System.out.println("Expected: [2, 2] Actual: " + Arrays.toString(interesctionUsingHashMap(arr6, arr5)));

        int[] arr7 = {4, 9, 5};
        int[] arr8 = {9, 4, 9, 8, 4};
        System.out.println("Expected: [4, 9] Actual: " + Arrays.toString(interesctionUsingHashMap(arr7, arr8)));

    }
}
