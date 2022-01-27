package general;

import java.util.*;

public class DeleteMe {
    public static void main(String[] args) {
        // String
        String immutableString = "sesha";
        System.out.println(immutableString.concat(" sai")); // outputs: sesha sai
        System.out.println(immutableString); //outputs:  sesha

        // Index of test
        String str = "abbcdef";
        System.out.println("index of a in "+ str + " " + str.indexOf("a"));
        System.out.println("index of z in "+ str + " " + str.indexOf("z"));
        System.out.println("index of char b in "+ str + " " + str.indexOf('b'));

        System.out.println(firstUniqueCharacter("leetcode"));

    }


    public static int firstUniqueCharacter(String s) {
        if (s.length()==0) {return -1;}
        if (s.length()==1) {return 0;}
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c: s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character,Integer> entry: hm.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    /**
     * TO get max profit, we need to buy a stock at min price,
     *                  sell at max profit
     * @param prices
     * @return
     */
    public int computeMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public boolean containsDuplicateUsingSet(int[] nums) {
        // [1,1,1,3,3,4,3,2,4,2] = true
        // [1,2,3,4] = false
        // With additional Data Structure
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }

    // TC: O(N log N) SC: O(1)
    public boolean containsDuplicateUsingHashMap(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {return true;}
        }
        return false;
    }

    public int[] productOfArrayExceptSelf_twoArrays(int[] nums) {
        // Write an algorithm in O(n) time and
        // do not use division
        // nums[i] = (nums[0]*nums[1]..nums[i-1]) * (nums[i+1]*nums[nums.length()-1])
        // Space: O(n)
        // Time Complexity: O(N)
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];

        leftProd[0] = 1;
        rightProd[nums.length-1] = 1;
        for (int i=1; i<nums.length; i++) {
            leftProd[i] = leftProd[i-1] * nums[i-1];
        }

        for (int i=nums.length-2; i>=0; i--) {
            rightProd[i] = rightProd[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }

    public int[] productOfTwoArraysExceptSelf_OneArray(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        // Calculate prefix prod as as before
        for (int i=1; i<nums.length; i++) {
            res[i] = res[i-1] * nums[i];
        }

        // but for right side, keep a variable
        int rightProd = 1;
        for(int i=nums.length-1; i>=0; i--) {
            res[i] = res[i] * rightProd;
            rightProd = nums[i] * rightProd;
        }
        return res;
    }

    /**
     * returns index of the searchNum in sorted array
     * @param nums int[] sorted array
     * @param searchNum int number that we've to look for in the array
     * @param start int start index
     * @param end int end index
     * @return int index of the search element
     */
    public int binarySearchHelper(int[] nums, int searchNum, int start, int end) {
        if (start > end) { return -1; }
        int mid = (start + end)/2;
        if (searchNum < nums[mid]) {
            return binarySearchHelper(nums, searchNum, start, mid-1);
        } else if (searchNum > nums[mid]) {
            return binarySearchHelper(nums, searchNum, mid+1, end);
        } else {
            return mid;
        }
    }
}
