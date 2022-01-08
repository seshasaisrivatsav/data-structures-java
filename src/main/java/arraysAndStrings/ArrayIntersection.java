package arraysAndStrings;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Questions to be asked
1. Can we modify the array
2. can there be repeated elements in the array or between the arrays

https://afteracademy.com/blog/find-the-intersection-of-two-unsorted-arrays
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2,2};
        System.out.println("Expected: [2] Actual: " + Arrays.toString(getArrayIntersection_hashset(arr1, arr2)));
        System.out.println("Expected: [2] Actual: " + Arrays.toString(getArrayIntersection_SortingTwoPointer(arr1, arr2)));
        System.out.println("Expected: [2] Actual: " + Arrays.toString(getArrayIntersection_binarySearch(arr1, arr2)));

        int[] arr3 = {4, 9, 5};
        int[] arr4 = {9, 4, 9, 8, 4};
        System.out.println("Expected: [4, 9] Actual: " + Arrays.toString(getArrayIntersection_hashset(arr3, arr4)));
        System.out.println("Expected: [4, 9] Actual: " + Arrays.toString(getArrayIntersection_SortingTwoPointer(arr3, arr4)));
        System.out.println("Expected: [4, 9] Actual: " + Arrays.toString(getArrayIntersection_binarySearch(arr3, arr4)));
    }

    /**
     * Approach 1:
     *      We sort both the arrays and at each step, we compare one element of first array with one element of second
     *      if both are equal, we add to the list, else we move forward
     *
     *   Time Complexity: O(m log m) + O(n log n)
     *   Space complexity: O(1)
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[]
     */
    public static int[] getArrayIntersection_SortingTwoPointer(int[] nums1, int[] nums2) {
        Set<Integer> resSet = new HashSet<>();
        Arrays.sort(nums1); // n log n
        Arrays.sort(nums2);

        int i=0; int j=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resSet.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[resSet.size()];
        int k=0;
        for (Integer intRes: resSet) {
            res[k] = (int) intRes;
            k++;
        }
        return res;
    }
    /**
     * Approach 2: Using hash set
     *  Store nums1 in hashset
     *  For each number num2 in nums2, if a number is present in hashset, we add it to result hashset
     *
     *  Here, if you store the smaller array in hash set, we'd have to do less look ups and decrease run time
     *
     * Time Complexity: O(nums2.length + nums1.length)
     * Space Complexity: O(nums1.length)
     *
     *
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[] that is common intersection without duplicates
     */
    public static int[] getArrayIntersection_hashset(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger = nums1.length >= nums2.length ? nums1 : nums2;


        HashSet<Integer> hs = new HashSet<>();
        for (int num: smaller) {
            hs.add(num);
        }


        HashSet<Integer> resHashSet = new HashSet<>();
        for (int num: larger) {
            if (hs.contains(num)) {
                resHashSet.add(num);
            }
        }

        int[] res = new int[resHashSet.size()];
        int i=0;
        Iterator iterator = resHashSet.iterator();
        while(iterator.hasNext()) {
            res[i] = (int) iterator.next();
            i++;
        }
        return res;
    }


    /**
     * Approach 3: sorting and binary search
     *  - sort an array A - O(n log n)
     *  - for each item in B, if element is found in A, add it to the list
     *
     *  Time Complexity: O(n log n) + O(m log n) = Sort of n elements + searching m elements in n sorted array
     *  Space Complexity: O(1)
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[] intersection
     */
    public static int[] getArrayIntersection_binarySearch(int[] nums1, int[] nums2) {
        Set<Integer> resSet = new HashSet<>();
        Arrays.sort(nums1);

        for (int num2: nums2) {
            int bsIndex = binarySearch(nums1, num2);
            if (bsIndex > -1) {
                resSet.add(nums1[bsIndex]);
            }
        }

        int[] res = new int[resSet.size()];
        int pos = 0;
        for (Integer hsInt: resSet) {
            res[pos] = (int) hsInt;
            pos++;
        }
        return res;
    }

    public static int binarySearch(int[] nums, int element) {
        return binarySearchHelper(nums, element, 0, nums.length-1);
    }

    public static int binarySearchHelper(int[] nums, int element, int start, int end) {
        if (start > end) { return -1; }
        int mid = (start + end)/2;

        if (nums[mid] == element) { return mid; }
        if (element < nums[mid]) {
            return binarySearchHelper(nums, element, start, mid-1);
        } else {
            return binarySearchHelper(nums, element, mid+1, end);
        }
    }

    public static int[] getArrayIntesection_bruteForce(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger = nums1.length >= nums2.length ? nums1: nums2;

        List<Integer> res = new ArrayList<>();
        for (int smallerInt : smaller) {
            for (int largerInt : larger) {
                if (smallerInt == largerInt) {
                    // TODO: Only add if res doesn't already have the element
                    res.add(smallerInt);
                }
            }
        }
        int[] arrRes = new int[res.size()];
        Iterator it = res.iterator();
        int i=0;
        while(it.hasNext()) {
            arrRes[i] = (int) it.next();
            i++;
        }
        return arrRes;
    }
}
