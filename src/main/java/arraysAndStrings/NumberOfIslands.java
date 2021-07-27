package arraysAndStrings;

public class NumberOfIslands {
	
	public static void main(String[] args) {

		char[][] bsm = { 
				{ '1', '1', '1', '1' }, 
				{ '1', '0', '0', '1'  }, 
				{ '1', '0', '0', '1'  },
				{ '1', '1', '1', '1'  },
				{ '0', '0', '0', '0'  },
				{ '0', '0', '0', '1'  }};
 
		System.out.println(numIslands(bsm));
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
