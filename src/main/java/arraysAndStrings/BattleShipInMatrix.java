package arraysAndStrings;

/*
 * Goal = Find number of battleships in matrix
 * Battleship = "* * * * * " (horizontal or vertical)
 * Two battleships won't intersect
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
