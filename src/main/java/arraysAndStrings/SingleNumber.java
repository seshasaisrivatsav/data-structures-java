package arraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/solution/
 * Given an array of numbers, where every element occurs twice ecept one, find the one in linear time and use constant space
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 6, 4};
        System.out.println("Expected: 5 Actual: " + singleNumberHashMap(arr)); // O(N) O(N)
        System.out.println("Expected: 5 Actual: " + singleNumberWithMath(arr)); // O(N) O(N)
        System.out.println("Expected: 5 Actual: " + singleNumberBitManipulation(arr)); // time: O(N)  space: O(1)
    }

    /**
     * Logic:
     * - If we take XOR of a zero and some bit, it will return that bit
     * - If we take XOR of two same bits, it will return 0
     *
     *      a xor 0 = a
     *      a xor a = 0
     *
     *      a xor b xor a  =  b
     *  - So we can XOR all the bits together to find unique number
     * @param nums
     * @return
     */
    public static int singleNumberBitManipulation(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res = res ^ num;
        }
        return res;
    }

    /**
     * Logic
     *  2*(a+b+c) - (a+a+b+b+c) = C
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums int[]
     * @return int
     */
    public static int singleNumberWithMath(int[] nums) {
        int sumOfSet = 0;
        int sumOfNums = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet = sumOfSet + num;
            }
            sumOfNums = sumOfNums + num;
        }
        return 2*sumOfSet - sumOfNums;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums int[]
     * @return int - the number that appears only once
     */
    public static int singleNumberHashMap(int[] nums) {
        if (nums.length==1) {return nums[0];}
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num: nums) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
