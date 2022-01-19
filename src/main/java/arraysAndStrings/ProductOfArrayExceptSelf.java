package arraysAndStrings;

import java.util.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]


Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 2, 3, 4, 5};
        int[] nums1 = {-1,1,0,-3,3};
        int[] nums2 = {4, 5, 1, 8, 2};
        System.out.println("expected: [120, 60, 40, 30, 24] actual:" + Arrays.toString(productOfArrayExceptSelf_oneArray(nums0)));
        System.out.println("expected: [0, 0, 9, 0, 0]  actual:" + Arrays.toString(productOfArrayExceptSelf_oneArray(nums1)));
        System.out.println("expected: [80, 64, 320, 40, 160]  actual:" + Arrays.toString(productOfArrayExceptSelf_oneArray(nums2)));

        System.out.println("expected: [120, 60, 40, 30, 24] actual:" + Arrays.toString(productOfArrayExceptSelf_twoArrays(nums0)));
        System.out.println("expected: [0, 0, 9, 0, 0]  actual:" + Arrays.toString(productOfArrayExceptSelf_twoArrays(nums1)));
        System.out.println("expected: [80, 64, 320, 40, 160]  actual:" + Arrays.toString(productOfArrayExceptSelf_twoArrays(nums2)));
    }

    public static int[] productOfArrayExceptSelf_oneArray(int[] nums) {
        if (nums.length==1) {return nums;}
        // Uses one array
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++) {
            res[i] = nums[i-1] * res[i-1];
        }

        int rightProd = 1;
        for (int i=nums.length-1; i>=0; i--) {
            res[i] = rightProd * res[i];
            rightProd  = rightProd * nums[i];
        }
        return res;
    }
    /*
        Approach: Take 2 arrays, one for left prefix, one for right prefix
                  multiply both
        Time Complexity: O(N)
        Space Complexity: O(N+N) = O(N) (note that result isn't taken into consideration)


        a0, a1, a2, a3 ....... an-4, an-3, an-2, an-1

        eg: res[a3] = (a1* a2)   * (an-4, an-3, an-2, an-1)

        product at element i = prefix left * suffix right

        We can use two arrays to left , right
        left =   a, b, c, d, e
        right =  f, g, h, i, j

        res = (a*f), (b*g), (c*h), (d*i), (e*j)

        Step 1: Traverse left to right to build prefix product
        Arr:      4, 5, 1,  8,  2,   10,  6
        left:     1, 4, 20, 20, 160, 320, 3200

        Step 2: Traverse from right of the input array and build suffix product

        Arr:      4,      5,    1,    8,     2,   10,  6
        right    4800,   960,  960,   120,   60    6    1
        left:     1,      4,   20,    20,    160, 320, 3200

        Step 3: traverse and multiply prefix and suffix array



     */
    public static int[] productOfArrayExceptSelf_twoArrays(int[] nums) {
        if (nums.length==1) {return nums;}
        // Uses two
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        leftProd[0] = 1;
        for (int i=1; i<nums.length; i++) {
            leftProd[i] = nums[i-1] * leftProd[i-1];
        }

        rightProd[nums.length-1] = 1;
        for (int j=nums.length-2; j>=0; j--) {
            rightProd[j]  = rightProd[j+1] * nums[j+1];
        }

        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }

    public static int[] productOfArrayExceptSelf_constantSpace(int[] nums) {
        return null;
    }

    public static int[] productOfArray_withDivision(int[] nums) {
        if (nums.length==1) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++) {
            res[0] = res[0] * nums[i];
        }
        // TODO: fix the case if the result is 0
        if (res[0]==0) {

        }
        for (int i=1; i<nums.length; i++) {
            res[i] = res[0]/nums[i];
        }
        return res;
    }

    // Approach: Brute force
    // Fails in leet code
    public static int[] productOfArray_nSquare(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int loopProd = 1;
            for (int j=0; j<nums.length; j++) {
                if (i!=j){
                    loopProd = loopProd * nums[j];
                }
            }
            res[i] = loopProd;
        }
        return res;
    }
}
