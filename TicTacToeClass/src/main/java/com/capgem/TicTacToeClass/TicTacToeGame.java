package com.capgemini;

import java.util.Scanner;

public class TicTacToeGame {
	private static final char EMPTY = ' ';
	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_O = 'O';
	private static void showBoard(char[] ticTacToeBoard) {
		for(int rowHead = 1; rowHead <= 7; rowHead += 3) {
			for(int cellHead = rowHead; cellHead < rowHead + 3; cellHead++) {
				System.out.print(ticTacToeBoard[cellHead]);
				if(cellHead % 3 != 0)
					System.out.print(" | ");
			}
			System.out.print("\n");
		}
	}

