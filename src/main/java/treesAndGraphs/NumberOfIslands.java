package treesAndGraphs;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] island1 = {
				{ '1', '1', '1', '1' }, 
				{ '1', '0', '0', '1'  }, 
				{ '1', '0', '0', '1'  },
				{ '1', '1', '1', '1'  },
				{ '0', '0', '0', '0'  },
				{ '0', '0', '0', '1'  }};
 
		System.out.println("Expected: 2 Actual: " + numIslands(island1));

		char[][] island2 = {
				{ '1','1','0','0','0' },
				{ '1','1','0','0','0' },
				{ '0','0','1','0','0' },
				{ '0','0','0','1','1' }};
		System.out.println("Expected: 3 Actual: " + numIslands(island2));

		char[][] island3 = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};

		System.out.println("Expected: 1 Actual: " + numIslands(island3));
	}

	/*
	 Two for loops iterate on MxN
	 	if(Mat[i][j]==1)
	 		DFS(Mat, i, j)
	 		count++
	 
	 DFS - Same as dfs - identify corner cases and return. make an element to 0 ofter
	 Call the same function on all 4 directions
	 if(i<0 or i>=Mat.length or j<0 or j>=Mat[0].length or Mat[i][j]!=1) return
	 Mat[i][j]==0
	 call the same fun on 4 sides
	 */
	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					DFS(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void DFS(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFS(grid, i - 1, j);
		DFS(grid, i + 1, j);
		DFS(grid, i, j - 1);
		DFS(grid, i, j + 1);
	}

}
