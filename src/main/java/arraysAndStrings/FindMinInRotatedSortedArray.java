package arraysAndStrings;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
Note:  rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
      You must write an algorithm that runs in O(log n) time.
Problem: Given the sorted rotated array nums of unique elements, return the minimum element of this array.

My Comprehensive solution: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/1721991/Simple-Java-Solution-with-Modified-Binary-Search-Iterative-and-Recursive-with-examples

Constraints:
    - Nums rotated between 1 and n times
    - each number is under 5000
    - array has unique numbers

Companies asked
    -  Facebook, Amazon, Microsoft, Bloomberg, Uber, Adobe

Examples:
    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

 */
public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        System.out.println("expected: 1 actual: " + findMinInRotatedSortedArray.findMin_Iterative(new int[]{3,4,5,1,2}));
        System.out.println("expected: 0 actual: " + findMinInRotatedSortedArray.findMin_Iterative(new int[]{4,5,6,7,0,1,2}));
        System.out.println("expected: 11 actual: " + findMinInRotatedSortedArray.findMin_Iterative(new int[]{11,13,15,17}));


        System.out.println("expected: 1 actual: " + findMinInRotatedSortedArray.findMinRecursive(new int[]{3,4,5,1,2}));
        System.out.println("expected: 0 actual: " + findMinInRotatedSortedArray.findMinRecursive(new int[]{4,5,6,7,0,1,2}));
        System.out.println("expected: 11 actual: " + findMinInRotatedSortedArray.findMinRecursive(new int[]{11,13,15,17}));
    }

    /**
     * Approach: We modify binary search to find the inflection point
     *
     *                   decrease  => Inflection point 1<7
     *                   ---->
     *  Eg:     4, 5, 6, 7,  1, 2, 3
     *          --------->   --------->
     *           increase    increasing
     * All the elements to left of inflection point > first element of array
     * All the elements to the right of inflection point < first element of array
     *
     *    Algorithm:
     *      1. find the mid of array
     *      2. if mid element > first element of array => we need to look for inflection point to the right
     *              eg: 4, 5, 6, 7, 1, 2, 3 => 7 > 4 => Look for element to right
     *      3. if mid element < first element of array => we need to look for inflection point to the left
     *              eg: .... 7, 1, 2 ... 1 < 7
     *      4. stop our search when we find the inflection point
     *          when this happens, either of these two conditions are satisfied
     *          a. nums[mid+1] < nums[mid] OR   ===> mid+1 is smallest
     *          b. nums[mid] < nums[mid-1]      ===> mid is smallest
     * @param nums int[] array where we've to find the min
     * @return int the minimum element in the array
     */
    public int findMin_Iterative(int[] nums) {
        if (nums.length==1) { return nums[0]; }
        int start = 0;
        int end = nums.length-1;
        int mid;

        // CASE 1: when array is not rotated
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        // When array is rotated
        while (start < end) {
            mid = (start+end)/2;

            // There are two possibilities for choosing the min
            //     |
            // eg: 7, 1, 2
            if (mid<end && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            //        |
            // eg: 7, 1, 2
            if (mid>start && nums[mid-1] > nums[mid]) {
                return nums[mid];
            }

            // 1. if the mid element is less than first element, then look towards left
            // eg: 6, 5, 1, 2, 3, 4   ===> here 2 < 6   => look left
            if (nums[mid] < nums[start]) {
                //  Move left
                end = mid - 1;
            } else {
                // 1. If the mid element of array is greater than first element, then look towards right
                // eg: 4, 5, 6, 7, 1, 2, 3  => here 7 > 4 ==> look right
                // move right
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * @param nums int[] sorted and rotated array
     * @return int min value in the array
     */
    public int findMinRecursive(int[] nums) {
        return findMinHelper(nums, 0, nums.length-1);
    }

    public int findMinHelper(int[] nums, int start, int end) {
        if (start > end) { return -1; }
        int mid = (start + end)/2;
        if (nums[mid] > nums[end]) {
            return findMinHelper(nums, mid+1, end);
        } else if (nums[mid] < nums[end]) {
            return findMinHelper(nums, start, mid);
        } else {
            return nums[mid];
        }
    }

    public int findMinHelper_alt(int[] nums, int start, int end) {
        if (start > end) { return -1; }
        if (start == end) { return nums[start]; }
        int mid = (start + end)/2;

        // For the case where (mid+1) is the minimum element
        // Eg: 3, 4, 5, 1, 2   5 > 1
        if (mid < end &&  nums[mid] > nums[mid+1]) {
            return nums[mid+1];
        }

        // For the case where mid is the minimum element
        // Eg: 4, 5, 1, 2, 3   1 < 5
        if (mid > start && nums[mid-1] > nums[mid]) {
            return nums[mid];
        }
        if (nums[end] > nums[mid]) {
            return findMinHelper(nums, start, mid-1);
        } else {
            return findMinHelper(nums, mid+1, end);
        }
    }
}
