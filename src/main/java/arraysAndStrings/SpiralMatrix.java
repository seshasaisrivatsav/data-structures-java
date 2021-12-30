package arraysAndStrings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix, return/print it in spiral form
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int [][] matrix = {
		                   { 1, 2, 3, 4 },
		                   { 5, 6, 7, 8},
		                   { 9, 10, 11, 12}
		};

		System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> spiralOrder = new LinkedList<>();
		if (matrix.length == 0) {
			return spiralOrder;
		}
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {

			// Left to Right
			for (int i = colStart; i <= colEnd; i++) {
				spiralOrder.add(matrix[rowStart][i]);
			}
			rowStart++;

			// Right to Bottom
			for (int i = rowStart; i <= rowEnd; i++) {
				spiralOrder.add(matrix[i][colEnd]);
			}
			colEnd--;

			// Right to Left
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					spiralOrder.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}

			// Bottom to top
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					spiralOrder.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}

		return spiralOrder;

	}
}
