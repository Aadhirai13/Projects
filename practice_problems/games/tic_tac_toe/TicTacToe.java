package games;

import java.util.Scanner;

public class TicTacToe {
	private Scanner scanner = new Scanner(System.in);

	private static boolean x = true , o = false;
	private static int xCnt = 0, oCnt = 0;
	
	public static void main(String[] args) {
		TicTacToe obj = new TicTacToe();
		obj.startGame();
	}

	private void startGame() {
		char[][] game = new char[3][3];
		printGame(game);
		playGame(game);
	}

	private void playGame(char[][] game) {
		while(xCnt <= 5) {
			char turn = x ? 'X' : 'O';
			System.out.println(turn + " Turn");
			System.out.println("Enter row");
			int row = scanner.nextInt();
			System.out.println("Enter col");
			int col = scanner.nextInt();
			if(!mark(row,col,game))
				return;
		}
		System.out.println("Match draw");
	}

	private boolean mark(int row, int col, char[][] game) {
		if(game[row][col] != '\u0000') {
			System.out.println("Already marked");
			return true;
		}
		if(x && !o) {
			game[row][col] = 'x';
			xCnt++;
			printGame(game);
			if(checkGame(game,row,col))
				return false;
			x = false; o = true;
			return true;
		}
		else if(!x && o){
			game[row][col] = 'o';
			oCnt++;
			printGame(game);
			if(checkGame(game,row,col))
				return false;
			x = true; o = false;
			return true;
		}
		return true;
	}

	private boolean checkGame(char[][] game,int row,int col) {
		boolean result = true;
		if(x && xCnt >= 3) {
			for(int i = 0;i < 3;i++) {
				if(game[row][i] != 'x') {
					result = false;
				}
				result = true;
				if(game[i][col] != 'x') {
					result = false;
					break;
				}
			}
			if(!result && row == col) {
				for(int i = 0;i < 3;i++) {
					for(int j = 0;j < 3;j++) {
						if((i==j) && game[i][j] != 'x') {
							result = false;
							break;
						}
					}
				}
			}
			if(x && result) {
				System.out.println("X WINS");
				return result;
			}
		}
		else if(o && oCnt >= 3) {
			for(int i = 0;i < 3;i++) {
				if(game[row][i] != 'o') {
					result = false;
				}
				result = true;
				if(game[i][col] != 'o') {
					result = false;
					break;
				}
			}
			result = true;
			if(!result && row == col) {
				for(int i = 0;i < 3;i++) {
					for(int j = 0;j < 3;j++) {
						if((i==j) && game[i][j] != 'o') {
							result = false;
							break;
						}
					}
				}
			}
			if(o && result) {
				System.out.println("O WINS");
				return result;
			}
		}
		return false;
	}

	private void printGame(char[][] game) {
		for(int row = 0;row < 3;row++) {
			for(int col = 0;col < 3;col++) {
				if(game[row][col] == ' ') {
					if(col == 2)
						System.out.print("| |");
					else
						System.out.print("| ");
				}
				else {
					if(col == 2)
						System.out.print("|"+game[row][col]+"|");
					else
						System.out.print("|"+game[row][col]);
				}
			}
			System.out.println();
		}
	}

}
