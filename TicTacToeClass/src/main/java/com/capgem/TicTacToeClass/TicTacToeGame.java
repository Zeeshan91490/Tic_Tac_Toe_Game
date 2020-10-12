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
	 * uc9
	 * @param ticTacToeBoard
	 * @param chosenLetter
	 * @return
	 */
	private static int computerPlayToBlock(char[] ticTacToeBoard, char chosenLetter) {
		char swappedLetter = swapPlayerLetter(chosenLetter);
		String playerWinPossibility;
		int cellNoForPlayerWin = 0;
		char [] ticTacToeBoardCopy = ticTacToeBoard.clone();
		for(int i = 1; i <=9; i++) {
			if(ticTacToeBoardCopy[i] == EMPTY) {
				ticTacToeBoardCopy[i] = swappedLetter; 
				playerWinPossibility = gameManager(ticTacToeBoardCopy, swappedLetter); 
				if(playerWinPossibility.contains("win")) {
					cellNoForPlayerWin = i;
				}
				ticTacToeBoardCopy[i] = EMPTY;
			}
		}
		System.out.println("cell for computer block: " + cellNoForPlayerWin);
		return cellNoForPlayerWin; 
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
		int computerPlayReturnWin = 0, computerPlayReturnBlock = 0, moveIndex;
		String lastPlayer = firstChance;
		do {
			if(lastPlayer.contains(PlayerNames.COMPUTER.name())) {
				computerPlayReturnWin = computerPlayToWin(ticTacToeBoard, chosenLetter);
				computerPlayReturnBlock = computerPlayToBlock(ticTacToeBoard, chosenLetter);
			}
			if(computerPlayReturnWin != 0) {
				moveIndex = computerPlayReturnWin;
				System.out.println("[COMPUTER AUTO-PLAYS]");
			}
			else if(computerPlayReturnBlock != 0) {
				moveIndex = computerPlayReturnBlock;
				computerPlayReturnBlock = 0;
				System.out.println("[COMPUTER AUTO-PLAYS]");
			}
			else {
				moveIndex = checkFree(ticTacToeBoard, chosenLetter, lastPlayer);
			}
			makeMove(ticTacToeBoard, chosenLetter, moveIndex);
			System.out.println("\n--Updated board after the move--");
			showBoard(ticTacToeBoard);
			gameStatus = gameManager(ticTacToeBoard, chosenLetter);
			chosenLetter = swapPlayerLetter(chosenLetter);
			lastPlayer = swapPlayerTurn(lastPlayer);
		}while(gameStatus.contains("change"));
	}	
}
