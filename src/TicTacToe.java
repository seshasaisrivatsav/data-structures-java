
public class TicTacToe {

	// 9 boxes
	static String[][] ticTacToeBoard = new String[3][3];

	public static void main(String[] args) {

		// initialize all cells to zero and try to print them in a tic tac toe format
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ticTacToeBoard[i][j] = "";
			}
		}

		int position = 1;

		String[][] addedBoard = add("X", position);
		printBoard(addedBoard);

	}
	
	// Check if board is full
	// ALl boxes must have values
	public static boolean isFull(String[][] ticTacToeBoard) {
		
		for(int i=0; i<3; i++) {
			if(ticTacToeBoard[i][0] != null) {
				return false;
			} else if(ticTacToeBoard[i][1] != null) {
				return false;
			} else if(ticTacToeBoard[i][2] != null) {
				return false;
			}
		}
		
		return true;
		
	}
	
	// AI makes a move - Any legal move . If not, throw exception

	public static String[][] add(String element, int position) {

		if (position == 0) {
			ticTacToeBoard[0][0] = element;
		} else if (position == 1) {

			ticTacToeBoard[0][1] = element;

		} else if (position == 2) {
			ticTacToeBoard[0][2] = element;
		}

		else if (position == 3) {
			ticTacToeBoard[1][0] = element;
		} else if (position == 4) {
			ticTacToeBoard[1][1] = element;
		} else if (position == 5) {
			ticTacToeBoard[1][2] = element;
		}

		else if (position == 6) {
			ticTacToeBoard[2][0] = element;
		} else if (position == 7) {
			ticTacToeBoard[2][1] = element;
		} else if (position == 8) {
			ticTacToeBoard[2][2] = element;
		}

		return ticTacToeBoard;
	}

	/*
	 * This method will just print the board in a text format on screen
	 */
	public static void printBoard(String[][] ticTacToeBoard) {
		
		String printElement1 = "", printElement2="", printElement3="";

		for (int i = 0; i < 3; i++) {

			if (ticTacToeBoard[i][0] == "") {
				printElement1 = "-";
			} else if (ticTacToeBoard[i][0] !="") {

				printElement1 = ticTacToeBoard[i][0];
			}

			if (ticTacToeBoard[i][1] == "") {
				printElement2 = "-";
			} else if (ticTacToeBoard[i][1] != "") {
				printElement2 = ticTacToeBoard[i][1];
			}

			if (ticTacToeBoard[i][2] == "") {
				printElement3 = "-";
			} else if (ticTacToeBoard[i][2] != "") {
				printElement3 = ticTacToeBoard[i][2];
			}

			 System.out.println(printElement1 + " |" + printElement2 + " |"+
			 printElement3);

		}

	}

}
