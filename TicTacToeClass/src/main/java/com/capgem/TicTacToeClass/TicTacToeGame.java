package com.capgemini;

import java.util.Scanner;

public class TicTacToeGame {
	private static final char EMPTY = ' ';
	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_O = 'O';
	private static boolean checkFree(char[] ticTacToeBoard, char playerLetter, int moveIndex) {
		boolean emptyStatus;
		if(ticTacToeBoard[moveIndex] == EMPTY) {
			emptyStatus = true;
			System.out.println("Index available");
		}
		else {
			emptyStatus = false;
			System.out.println("Index not available");
		}
		return emptyStatus;
	}

	public static void main (String[] args) {
		Scanner takeInput = new Scanner(System.in);
		char[] ticTacToeBoard = createBoard();
		System.out.println("Player letter (X or O): ");
		char playerLetter = takeInput.next().charAt(0);
		char computerLetter = selectLetter(playerLetter);
		System.out.println("Computer Letter: " + computerLetter);
		showBoard(ticTacToeBoard);
		boolean emptyStatus; 
		do {
			System.out.println("Enter index to place letter " + playerLetter);
			int moveIndex = takeInput.nextInt();
			emptyStatus = checkFree(ticTacToeBoard, playerLetter, moveIndex);
		} while(emptyStatus == false);
	}	
}

