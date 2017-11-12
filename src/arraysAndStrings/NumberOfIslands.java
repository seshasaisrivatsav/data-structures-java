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
