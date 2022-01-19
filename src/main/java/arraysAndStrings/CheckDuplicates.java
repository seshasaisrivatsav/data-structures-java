package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * ContainsDuplicate | contains duplicate
 *
 *  Method A: Use hashSet and return if value already exists TC: O(n) SC: O(n)
 *
 *  Method B: Sort the array + find dupes TC: O(n log n) + O(n) SC = O(1)
 */
public class CheckDuplicates {
    
    public static void main(String[] args){
        int[] arr = {9, 1, 2, 3, 9, 3, 3, 3};
        System.out.println("Using Bubble sort : Expected: true Actual: " + checkDupsUsingBubbleSort(arr));
        System.out.println("Using set : Expected: true Actual: " + checkDupsUsingSet(arr));
        System.out.println("Using inbuilt sort : Expected: true Actual: " + checkDupsInbuiltSort(arr));
        System.out.println("Using hashmap: Expected: true Actual: " + checkDupsHashMap(arr));

    }
    // Method 1: Use hashSet and return if value already exists
    // TC: O(n) SC: O(n)
    // Run time: 6ms (61% faster)
    // Memory: 52MB, less than 21%
    public static boolean checkDupsUsingSet(int[] nums) {
        Set<Integer> myset = new HashSet<>();
        for (int num: nums) {
            if(myset.contains(num)) {
                return true;
            }
            myset.add(num);
        }
        return false;
    }

    // Method 3: Sort the array + find dupe =
    // TC = O(n log n) + O(n) | SC = O(1)
    // Run time: 16 ms (9% faster)
    // Memory: 51.3 MB less than 26%
    public static boolean checkDupsInbuiltSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDupsUsingBubbleSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) { // swap j, j+1
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return checkDupsSortedArray(arr);
    }

    public static boolean checkDupsHashMap(int[] arr) {
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        int count=0;
        for (int value : arr) {
            if (myHashMap.containsKey(value)) {
                return true;
            } else {
                myHashMap.put(value, count + 1);
            }
        }
        return false;
    }

    public static boolean checkDupsSortedArray(int[] arr) {
         for (int i=0; i< arr.length-1; i++){
            if (arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
    

}
