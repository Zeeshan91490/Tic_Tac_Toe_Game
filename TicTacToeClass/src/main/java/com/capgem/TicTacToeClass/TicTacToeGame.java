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
	 * uc8
	 * @param ticTacToeBoard
	 * @param chosenLetter
	 * @return
	 */
	private static int computerPlay(char[] ticTacToeBoard, char chosenLetter){
		String computerWinPossibility;
		int cellNoForComputerWin = 0;
		char[] ticTacToeBoardCopy = new char[10];
		for(int i = 0; i < ticTacToeBoardCopy.length; i++) {
			ticTacToeBoardCopy[i] = ticTacToeBoard[i];
		}
		for(int i = 1; i <=9; i++) {
			if(ticTacToeBoardCopy[i] == EMPTY) {
				ticTacToeBoardCopy[i] = chosenLetter; 
				computerWinPossibility = gameManager(ticTacToeBoardCopy, chosenLetter); 
				if(computerWinPossibility.contains("win")) {
					cellNoForComputerWin = i;
				}
				ticTacToeBoardCopy[i] = EMPTY;
			}
		}
		//System.out.println(cellNoForComputerWin);
		return cellNoForComputerWin; 
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
		int computerPlayReturn = 0, moveIndex;
		String lastPlayer = firstChance;
		do {
			if(lastPlayer.contains(PlayerNames.COMPUTER.name())) {
				computerPlayReturn = computerPlay(ticTacToeBoard, chosenLetter);
			}
			if(computerPlayReturn != 0) {
				moveIndex = computerPlayReturn;
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

