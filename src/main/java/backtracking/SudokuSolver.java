/*
https://leetcode.com/problems/sudoku-solver/
*/

package backtracking;
class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    /*
        Time Complexity: O(9^m) here m = number of blanks
        
        Idea: Backtracking
          1. Choice - Place a number in an empty cell
          2. Constraints - A distinct number in 1. Row 2. Column 3. 3x3 cell
          3. Goal place numbers in all empty cells
          
        isSafe function
          - Checks that a given value is eligible to be inserted in a given row and column - returns boolean
          
        Chice - When making an assignment, check if an element is safe to be assigned in a location
        - Once the element is added, check if that leads to a solution, if no return false
    */
    
    public boolean solve(char[][] board) {
        for (int row=0; row < board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                // if a element is empty
                if (board[row][col] == '.') {
                    // check if each number is isSafe for insertion there
                    for (char c='1'; c <= '9'; c++) {
                        if (isSafe(board, row, col, c)) {
                            board[row][col] = c;
                            // Insert it and solve and check if result
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; //  if that solution is valid
    }
    
    public boolean isSafe(char[][] board, int row, int col, char c) {
        for (int i=0; i<9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; 
        }
        return true;
    }
  
  
  private void generateThreeByThree(int row, int col) {
    /* Eg: where row=0, col = 0
      (0,0), (0,1), (0,2)
      (1,0), (1,1), (1,2)
      (2,0), (2,1), (2,2)
     */
    for (int i=0; i<9; i++) {
      // Here row/3 is evaluated first 
      System.out.println(3 * (row / 3) + i / 3 + " , " + 3 * (col / 3) + i % 3);
    }
  }
  
  
}
