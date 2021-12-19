package arraysAndStrings;

/**
 * Given a sorted array with duplicates, remove duplicates in the array, return the number of distinct elements
 * Do this In place with O(1) memory
 */
public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {

        System.out.println("Expected: 2. Actual: " + removeDuplicatesSortedArray(new int[]{1,1,2}));
        System.out.println("Expected: 5. Actual: " + removeDuplicatesSortedArray(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    /**
     * Time complexity: O(n)
     * Space Complexity: O(1)
     * https://youtu.be/gf7vdIin0dk?t=718
     * @param nums sorted numbers
     * @return number of distinct elements
     */
    public static int removeDuplicatesSortedArray(int[] nums) {
        int j = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length-1];
        return j+1;
    }

    /*

        Run down
        i
        1 1 1 2 2 3
        j

            i
        1 1 1 2 2 3
        j

                i
        1 2 1 2 2 3
          j

        Final outside loop
                i
        1 2 3 2 2 3
            j


     */
}
