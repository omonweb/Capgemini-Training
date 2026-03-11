package Feb4;

import java.util.Arrays;
import java.util.Scanner;

public class tictactoe {
	
	
	public static void init(char[][] board) {
		for(char[] r : board) {
			Arrays.fill(r, '-');
		}
	}
	
	public static void printBoard(char[][] board) {
		System.out.println("+---+---+---+");
		for(int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();

			System.out.println("+---+---+---+");
		}
	}
	
	public static boolean checkWinner(char[][] board, char player) {
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
		}
		
		for(int j= 0; j < 3; j++) {
			if(board[0][j] == player && board[1][j] == player && board[2][j] == player) return true;
		}
		
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
		
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
	
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[][] board = new char[3][3];
		
		tictactoe.init(board);
		tictactoe.printBoard(board);
		
		sc.close();
	}

}
