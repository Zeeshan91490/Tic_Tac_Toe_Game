package com.capgemini;

import java.util.Scanner;

enum FirstTurn{
	PLAYER, COMPUTER
}

public class TicTacToeGame {
	private static final char EMPTY = ' ';
	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_O = 'O';
	private static final int HEADS = 0;

	
	/**
	 * uc6
	 * @return
	 */
	private static String getWhoPlaysFirst() {
		int randomInt = (int)Math.floor((Math.random()*10)%2);
		if(randomInt == HEADS)
			return  FirstTurn.PLAYER.name();
		else
			return FirstTurn.COMPUTER.name();
	}

	public static void main (String[] args) {
		Scanner takeInput = new Scanner(System.in);
		char[] ticTacToeBoard = createBoard();
		System.out.println("Player letter (X or O): ");
		char playerLetter = takeInput.next().charAt(0);
		char computerLetter = selectLetter(playerLetter);
		System.out.println("Computer Letter: " + computerLetter);
		String firstChance = getWhoPlaysFirst();
		System.out.println("First Chance for " + firstChance);
	}	
}

