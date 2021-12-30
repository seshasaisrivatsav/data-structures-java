package arraysAndStrings;

/*
 * Goal = Find number of battleships in matrix
 * Battleship = "* * * * * " (horizontal or vertical)
 * Two battleships won't intersect
 Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board.
In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size.
At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 */

import java.util.Objects;

public class BattleShipInMatrix {

	public static void main(String[] args) {

		String[][] bsm = { 
				{ "*", ".", ".", "*" }, 
				{ ".", ".", ".", "*" }, 
				{ "*", ".", ".", "." },
				{ ".", ".", ".", "*" } };
 
		System.out.println(findShips(bsm));

	}
	
	/*
	 for a MXN matrix; iterate M, N 
	 	if(Mat[i][j]==".") continue
	 	if(i>0 && Mat[i-1][j]=="*") continue
	 	if(j>0 && Mat[i][j-1]=="*") continue
	 	count++
	 */
	public static int findShips(String[][] bsm) {
		int count = 0;
		int m = bsm.length;
		int n = bsm[0].length;
		
		for (int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				if(bsm[i][j]==".") continue;
				if(i>0 && bsm[i - 1][j].equals("*")) continue;
				if(j>0 && Objects.equals(bsm[i][j - 1], "*")) continue;
				count++;
			}
		}
		return count;
	}

}
