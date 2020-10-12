package com.capgem.TicTacToeClass;


//UC1 Test case
public class TicTacToeGame{
	public static final char NULL=' ';
	private static char[] ticTacBoard;

public TicTacToeGame( ) {
	super();
	ticTacBoard = new char [10];
}

public static void createBoard() {
	for (int i=1; i<ticTacBoard.length;i++) {
		ticTacBoard[i] = NULL;
	}
}

public static void main (String[] args) {
	TicTacToeGame ticTacObject = null;
	ticTacObject.createBoard();
  }
}
