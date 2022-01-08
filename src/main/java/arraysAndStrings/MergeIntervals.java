package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
Given an array of intervals where intervals[i] = [starti, endi]
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeIntervals {
    public static void twodprint(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int[] row: arr) {
            sb.append(Arrays.toString(row) + ", ");
        }
        System.out.println(sb.substring(0, sb.length()-2).toString());
    }
    public static void main(String[] args) {
        int[][] intervalOne = {{8, 10}, {15, 18}, {1,3}, {2, 6},  {18, 25}};
        twodprint(merge(intervalOne)); // outputs: {{1, 6}, {8,10}, {15,18}}

        int[][] intervalTwo = {{1,4}, {4,5}};
        twodprint(merge(intervalTwo)); // {1, 5}

        int[][] intervalThree = {{1, 7}, {4, 6}, {6, 7}}; // output: {{1, 7}}
        twodprint(merge(intervalThree)); //{1, 7}

        twodprint(merge(new int[][] {{1,4}, {5, 6}})); // expected {{1, 4}, {5, 6}}
    }

    /**
     * Approach: We sort the intervals based on start time
     *
     *  Time Complexity: O(n log n) + ) (n) = O(n log n)
     *  Space Complexity: o(n) = O(no of intervals)
     *  If we can sort intervals in place, we do not need more than constant additional space,
     *  although the sorting itself takes O(log n) space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
     * @param intervals int[][]
     * @return int[][] merged intervals
     */
    public static int[][] merge(int[][] intervals) {
        // sort the arrays based on start by passing custom comparator
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // have a data structure to add all intervals as we don't know how many
        LinkedList<int[]> res = new LinkedList<>(); // using linked list as it's easy to add to last

        // for every interval, we look at previous interval and if we can extend it
        // other wise we add it
        for (int[] interval: intervals) {
            // if the last item in the linked list (ending) is before where we start at
            // Eg {1, 4}  {5, 6}   here 4 < 5
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                // there is overlap eg: (1, 5) (4, 6) => (1 , Max(5, 6)) => (1, 6)
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
