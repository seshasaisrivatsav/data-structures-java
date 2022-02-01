package arraysAndStrings;

/**
 * There are n houses evenly lined up on the street, and each house is beautifully painted.
 * You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
 *
 * Return the maximum distance between two houses with different colors.
 *
 * The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
 *
 * Example 1:
 *      Input: colors = [1,1,1,6,1,1,1]
 *      Output: 3
 *      Explanation: In the above image, color 1 is blue, and color 6 is red.
 *      The furthest two houses with different colors are house 0 and house 3.
 *      House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
 *      Note that houses 3 and 6 can also produce the optimal answer.
 *
 * Example 2:
 *       Input: colors = [1,8,3,8,3]
 *       Output: 4
 *       Explanation: In the above image, color 1 is blue, color 8 is yellow, and color 3 is green.
 *       The furthest two houses with different colors are house 0 and house 4.
 *       House 0 has color 1, and house 4 has color 3. The distance between them is abs(0 - 4) = 4.
 *
 * Example 3:
 *      Input: colors = [0,1]
 *      Output: 1
 *      Explanation: The furthest two houses with different colors are house 0 and house 1.
 *      House 0 has color 0, and house 1 has color 1. The distance between them is abs(0 - 1) = 1.
 *
 * Companies: Amazon
 */
public class MaxDistHousesDiffColors {
    public static void main(String[] args) {
        int[] colors1 = {1, 1, 1, 6, 1, 1, 1};
        int[] colors2 = {1, 8, 3, 8, 3};
        int[] colors3 = {0, 1};

        System.out.println("Expected: 3 Actual: " + maxDistance_twoPointers(colors1));
        System.out.println("Expected: 4 Actual: " + maxDistance_twoPointers(colors2));
        System.out.println("Expected: 1 Actual: " + maxDistance_twoPointers(colors3));


        System.out.println("Expected: 3 Actual: " + maxDistance(colors1));
        System.out.println("Expected: 4 Actual: " + maxDistance(colors2));
        System.out.println("Expected: 1 Actual: " + maxDistance(colors3));
    }

    /**
     * Approach
     *  - Have two pointers at start and end
     *  - while end is same as start, move it inward
     *  - while start is same as end, move it inward
     *  - return absolute of diff (end, length-1-start)
     *
     *  Eg:
     *    index        0  1  2  3  4
     *    colors       1, 8, 3, 8, 3
     *                 s           e
     *
     *
     * @param colors int[] colors
     * @return int - max diff
     */
    public static int maxDistance_twoPointers(int[] colors) {
        int start=0;
        int end = colors.length-1;

        // Bring end inwards
        while (colors[0] == colors[end]){
            end--;
        }
        // Bring start inwards
        while (colors[colors.length-1] == colors[start]) {
            start++;
        }

        return Math.max(end, colors.length-1-start);
    }
    public static int maxDistance(int[] colors) {
        int maxDistance = 0;
        for (int i=1; i<colors.length; i++) {
            if (colors[i] != colors[0]) {
                maxDistance = Math.max(maxDistance, i);
            }
            if (colors[i] != colors[i-1]) {
                maxDistance = Math.max(maxDistance, colors.length-i-1);
            }
        }
        return maxDistance;
    }
}
