package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Given an `nums` array and a `target`, return array of indices that match the target
 * https://web.stanford.edu/class/cs9/sample_probs/TwoSum.pdf
 *
 * Constraints
 *  - can have any arbitrary integers +ve, -ve or 0
 *  - Can have duplicates
 *  - Can modify the array
 *  - Can be in any order
 */
class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 9;
        System.out.println(Arrays.toString(twoSumsPointers(nums, target)));
        System.out.println(Arrays.toString(twoSumsHashSet(nums, target)));
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
	    int sortedNums[] = nums.clone(); // Copies an array
        Arrays.sort(sortedNums);

        int leftPointer = 0, rightPointer = sortedNums.length - 1;

        while (leftPointer < rightPointer) {
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

    /**
     * Approach 2: With HashMap
     * For each element of give `target` array we store target - nums[i]
     *
     * AS what's happening is we return if we have target-nums[i]+nums[i]
     * Time Complexity: O(n) - n insertions + n lookups = O(2n) = O(n)
     * Space Complexity: O(n)
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSumsHashSet(int[] nums, int target) {
        if (nums == null || nums.length<2) {
            return new int[]{0,0};
        }

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
    
    
    public static int locateElementIndexInArray(int[] nums, int element){
        for (int i=0; i <nums.length; i++) {
            if (nums[i] == element) {
                return i;
            }
        }
        return 1; // return the second index

    }

    /**
     * Approach 2: Brute Force
     * Time Complexity: O(n2)
     * Space Complexity: O(1)
     * @param nums integer array
     * @param target target number
     * @return array of indices in nums, the values to which sum up to `target`
     */
    public static int[] twoSumsBruteForce(int[] nums, int target) {
        int[] res = new int[2];

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
