package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {


    public static void main(String[] args) {
        List<List<Integer>> res = printPascalTriangle(5);
        res.forEach((n) -> System.out.println(Arrays.toString(n.toArray())));
    }

    /**
     * With Dynamic programming
     *  1. Base case; the value at the beginning or end of row is always 1
     *  2. Recurrence: each number = sum of 2 numbers directly above it
     *
     *  triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col]
     *  1
     *  1 1
     *  1 2 1
     *  1 3 3 1
     *  1 4 6 4 1
     * @param numOfRows int number of rows
     * @return List<List<Integer>> List of list where ith list represents ith row in pascal's triangle
     */
    public static List<List<Integer>> printPascalTriangle(int numOfRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> startingElement = new ArrayList<>();
        startingElement.add(1);
        triangle.add(startingElement);

        for (int row=1; row<numOfRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row-1);
            // first element = 1
            currentRow.add(1);

            // recurrence
            for (int col=1; col<prevRow.size(); col++) {
                currentRow.add(prevRow.get(col-1) + prevRow.get(col));
            }
            // last element =1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}
