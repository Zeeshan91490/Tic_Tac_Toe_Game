package com.capgemini;

import java.util.Scanner;

enum PlayerNames{
	PLAYER, COMPUTER
}

public class TicTacToeGame {
	private static final char EMPTY = ' ';
	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_O = 'O';
	private static final int HEADS = 0;

	
	/**
	 * uc13
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner takeInput = new Scanner(System.in);
		char responseForAnotherGame;
		do {
			playGame();
			System.out.println("Do you want to play again? (Y/N)");
			responseForAnotherGame = takeInput.next().charAt(0);
		} while(responseForAnotherGame == 'Y');
	}	
}
