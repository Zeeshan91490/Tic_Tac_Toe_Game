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
	 * uc7
	 * @param ticTacToeBoard
	 * @param chosenLetter
	 * @param lastPlayer
	 * @return
	 */
	private static String gameManager(char[] ticTacToeBoard, char chosenLetter, String lastPlayer) {
		int counter = 0;
		for(int i = 1; i <=9; i++) 
			if(ticTacToeBoard[i] == EMPTY)
				counter++;
		if(counter == 0) {
			System.out.println("The game is a TIE!");
			return "tie";
		}
		else if((ticTacToeBoard[1] == chosenLetter && ticTacToeBoard[2] == chosenLetter && ticTacToeBoard[3] == chosenLetter) || 
				(ticTacToeBoard[4] == chosenLetter && ticTacToeBoard[5] == chosenLetter && ticTacToeBoard[6] == chosenLetter) || 
				(ticTacToeBoard[7] == chosenLetter && ticTacToeBoard[8] == chosenLetter && ticTacToeBoard[9] == chosenLetter) || 
				(ticTacToeBoard[1] == chosenLetter && ticTacToeBoard[4] == chosenLetter && ticTacToeBoard[7] == chosenLetter) ||
				(ticTacToeBoard[2] == chosenLetter && ticTacToeBoard[5] == chosenLetter && ticTacToeBoard[8] == chosenLetter) ||
				(ticTacToeBoard[3] == chosenLetter && ticTacToeBoard[6] == chosenLetter && ticTacToeBoard[9] == chosenLetter) ||
				(ticTacToeBoard[1] == chosenLetter && ticTacToeBoard[5] == chosenLetter && ticTacToeBoard[9] == chosenLetter) ||
				(ticTacToeBoard[3] == chosenLetter && ticTacToeBoard[5] == chosenLetter && ticTacToeBoard[7] == chosenLetter)) {
			System.out.println(lastPlayer + " WON!");
			return "win";
		}
		else 
			return "change";
	}
	
	private static char swapPlayerLetter(char chosenLetter) {
		if(chosenLetter == CHARACTER_X)
			chosenLetter = CHARACTER_O;
		else
			chosenLetter = CHARACTER_X;
		return chosenLetter;
	}
	
	private static String swapPlayerTurn(String lastPlayer) {
		if(lastPlayer.contains(PlayerNames.PLAYER.name()))
			lastPlayer = PlayerNames.COMPUTER.name();
		else
			lastPlayer = PlayerNames.PLAYER.name();
		return lastPlayer;
	}
	
	public static void main (String[] args) {
		Scanner takeInput = new Scanner(System.in);
		char[] ticTacToeBoard = createBoard();
		System.out.println("Player letter: ");
		char playerLetter = takeInput.next().charAt(0);
		char computerLetter = selectLetter(playerLetter);
		System.out.println("Computer Letter: " + computerLetter);
		String firstChance = getWhoPlaysFirst();
		char chosenLetter;
		if(firstChance.contains("PLAYER"))
			chosenLetter = playerLetter;
		else
			chosenLetter = computerLetter;
		System.out.println("First Chance for " + firstChance);
		System.out.println("\n--Initial status of board--");
		showBoard(ticTacToeBoard);
		String gameStatus;
		String lastPlayer = firstChance;
		do {
			int moveIndex = checkFree(ticTacToeBoard, chosenLetter, lastPlayer);
			makeMove(ticTacToeBoard, chosenLetter, moveIndex);
			System.out.println("\n--Updated board after the move--");
			showBoard(ticTacToeBoard);
			gameStatus = gameManager(ticTacToeBoard, chosenLetter, lastPlayer);
			chosenLetter = swapPlayerLetter(chosenLetter);
			lastPlayer = swapPlayerTurn(lastPlayer);
		}while(gameStatus.contains("change"));

	}	
}
