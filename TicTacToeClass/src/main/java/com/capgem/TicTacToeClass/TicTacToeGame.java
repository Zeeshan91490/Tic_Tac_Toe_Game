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
		 * uc12
		 */
		private static void playGame() {
			Scanner takeInput = new Scanner(System.in);
			char[] ticTacToeBoard = createBoard();
			System.out.println("Player letter: ");
			char playerLetter = takeInput.next().charAt(0);
			char computerLetter = selectLetter(playerLetter);
			System.out.println("Computer Letter: " + computerLetter);
			String currentPlayer = getWhoPlaysFirst();
			char chosenLetter;
			if(currentPlayer.contains("PLAYER"))
				chosenLetter = playerLetter;
			else
				chosenLetter = computerLetter;
			System.out.println("First Chance for " + currentPlayer);
			System.out.println("\n--Initial status of board--");
			showBoard(ticTacToeBoard);
			String gameStatus;
			int computerPlayReturnWin = 0, computerPlayReturnBlock = 0, computerFreeCornerAvailable = 0, computerFreeCentreOrSideAvailable = 0, moveIndex = 0;
			do {
				if(currentPlayer.contains(PlayerNames.COMPUTER.name())) {
					computerPlayReturnWin = computerPlayToWin(ticTacToeBoard, chosenLetter);
					computerPlayReturnBlock = computerPlayToBlock(ticTacToeBoard, chosenLetter);
					computerFreeCornerAvailable = computerPlayToCorner(ticTacToeBoard);
					computerFreeCentreOrSideAvailable = computerPlayToCentreOrSide(ticTacToeBoard);
					if(computerPlayReturnWin != 0) {
						moveIndex = computerPlayReturnWin;
					}
					else if(computerPlayReturnBlock != 0) {
						moveIndex = computerPlayReturnBlock;
						computerPlayReturnBlock = 0; //this is important to reset
					}
					else if(computerFreeCornerAvailable != 0) {
						moveIndex = computerFreeCornerAvailable;
						computerFreeCornerAvailable = 0; //this is important to reset
					}
					else if(computerFreeCentreOrSideAvailable != 0) {
						moveIndex = computerFreeCentreOrSideAvailable;
						computerFreeCentreOrSideAvailable = 0; //this is important to reset
					}
				}
				else {
					moveIndex = checkFree(ticTacToeBoard, chosenLetter, currentPlayer);
				}
				makeMove(ticTacToeBoard, chosenLetter, moveIndex);
				System.out.println("\n--Updated board after the " + currentPlayer +"'s move--");
				showBoard(ticTacToeBoard);
				gameStatus = gameManager(ticTacToeBoard, chosenLetter);
				chosenLetter = swapPlayerLetter(chosenLetter);
				currentPlayer = swapPlayerTurn(currentPlayer);
			}while(gameStatus.contains("change"));
			if(gameStatus.contains("tie"))
				System.out.println("It's a TIE!");
			else
				System.out.println("The game is WON by " + swapPlayerTurn(currentPlayer));
		}
	
		public static void main (String[] args) {
			playGame();
		}	
	}



