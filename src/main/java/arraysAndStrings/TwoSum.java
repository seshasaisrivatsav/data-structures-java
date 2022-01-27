package arraysAndStrings;

import java.util.*;


/**
 * Given an `nums` array and a `target`, return array of indices that match the target
 * https://web.stanford.edu/class/cs9/sample_probs/TwoSum.pdf
 * Constraints
 *  - can have any arbitrary integers +ve, -ve or 0
 *  - Can have duplicates
 *  - Can modify the array
 *  - Can be in any order
 */
class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 6;
        System.out.println(Arrays.toString(twoSumsHashMap(nums, target))); // THIS IS THE CORRECT ONE!

        TwoSum twoSum = new TwoSum();
        int[] nums1 = {1, 3, 4, 5, 6, 8};
        System.out.println("Expected: [[1, 2], [0, 4]] actual: " + Arrays.toString(twoSum.twoSumAllPossible(nums1, 7).toArray()));
        System.out.println("Expected: [[5, 0], [2, 3] [1, 4]] actual: " + Arrays.toString(twoSum.twoSumAllPossible(nums1, 9).toArray()));

        int[] nums2 = {4, 1, 3, 7, 7, 2, 2, 6, -2};
        System.out.println("Expected: [[3, 1], [2, 2], [6, -2]] actual: " + Arrays.toString(twoSum.twoSumAllPossibleValues(nums2, 4).toArray()));
	}

    /**
     * Approach 1: With HashMap
     * For each element of give `target` array we store target - nums[i]
     *
     * AS what's happening is we return if we have target-nums[i]+nums[i]
     * Time Complexity: O(n) - n insertions + n lookups = O(2n) = O(n)
     * Space Complexity: O(n)
     * @param nums int[] nums
     * @param target int target number
     * @return int[] with each index representing position of the number, both when added yields target sum
     */
    public static int[] twoSumsHashMap(int[] nums, int target) {
        if (nums == null || nums.length<2) {
            return new int[]{0,0};
        }
        // Hashmap stores target-nums[i], i
        // and in each iteration we look for nums[i]
        HashMap<Integer, Integer> numsHashMap = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            if (numsHashMap.containsKey(nums[i])) {
                return new int[]{numsHashMap.get(nums[i]), i};
            } else {
                numsHashMap.put(target-nums[i], i);
            }
        }
        return new int[]{0, 0};
    }


    /**
     * Approach 1: Sorting and walking inward
     * Steps
     *  = We sort the array
     *  = And use two pointers to walk inward
     * If it's exactly `target` we stop
     * if it exceeds k, we walk pointer inwards
     *
     * Time Complexity: O(n log n) - Due to sorting
     *  If radix sort is used it takes O(n log U) where U is the largest element of the array
     * Space Complexity: O(log n) - quick sort or radix sort
     *                 : O(1) if heapsort is used
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumsPointers(int[] nums, int target) {
        int[] res = new int[2];
        int[] sortedNums = nums.clone(); // Copies an array
        Arrays.sort(sortedNums); // (n log n) or O(1) log 8 = 3

        int leftPointer = 0, rightPointer = sortedNums.length - 1;

        while (leftPointer <= rightPointer) {
            int sum = sortedNums[leftPointer] + sortedNums[rightPointer];
            if (sum == target) {
                res[0] = locateElementIndexInArray(nums, sortedNums[leftPointer]);
                res[1] = locateElementIndexInArray(nums, sortedNums[rightPointer]); // TODO: fix when there are duplicates
                return res;
            } else if (sum < target) {
                leftPointer ++;
            } else {
                rightPointer --;
            }
        }
        return res;
    }


    public static int locateElementIndexInArray(int[] nums, int element){
        for (int i=0; i <nums.length; i++) {
            if (nums[i] == element) {
                return i;
            }
        }
        return 1; // return the second index

    }

    /**
     * Return list of set of 2 indices that return a sum
     * @param nums int[] nums
     * @param k int sum
     * @return List<Integer> representing indices of numbers that add up to l
     */
    public List<List<Integer>> twoSumAllPossible(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // difference, index
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                List<Integer> pointers = new ArrayList<>();
                pointers.add(i);
                pointers.add(hm.get(nums[i]));
                res.add(pointers);
            } else {
                hm.put(k-nums[i], i);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSumAllPossibleValues(int[] nums, int sumK) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                List<Integer> pairFound = new ArrayList<>();
                pairFound.add(nums[i]);
                pairFound.add(sumK-nums[i]);
                res.add(pairFound);
            } else {
                hm.put(sumK-nums[i], i);
            }
        }
        return res;
    }
}
