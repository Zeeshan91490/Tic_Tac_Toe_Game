package TicTacToeClass;

import java.util.Scanner;

//UC2

public class TicTacToeGame {
	public static void main(String[] args) {
		TicTacToeGame obj = new TicTacToeGame();
		
		
}
	public static void createBoard() {
		char[] board=new char[10];
		for(int i=0;i<10;i++) {
			board[i]=' ';
			
		}
	}
	
public static void chooseLetter() {
	System.out.println("Enter X or O");
	Scanner sc = new Scanner(System.in);
	char c= sc.next().charAt(0);
	if (c=='X') {
		System.out.println("User has chosen O");
	}
	else
		System.out.println("Computer has chosen X");
		
}


}
