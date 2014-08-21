package com.brianyarr.fundapps.draughts;

public class GameState {

	private Player nextPlayer;
	
	// array of board squares, row by column, 0,0 being top left and a white square next on blacks end 
	private final Piece[][] board;

	public GameState() {
		nextPlayer = Player.BLACK; // black starts the game

		board = new Piece[8][8];
		for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
			for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
				int colType = (colIdx + (rowIdx % 2)) % 2;
				if (colType  == 1) {
					if (rowIdx <= 2) {
						// black square
						board[rowIdx][colIdx] = Piece.BLACK_MAN;
					} else if (rowIdx >= 5) {
						board[rowIdx][colIdx] = Piece.WHITE_MAN;
					}
				}
			}
		}
	}

	Piece getPieceAt(int row, int col) {
		return board[row][col];
	}
	
	public Player getNextPlayer() {
		return nextPlayer;
	}
	
	String boardToString() {
		StringBuilder result = new StringBuilder();
		for (int i=0;i<8;i++) {
			for (int j=0;j<board[i].length;j++) {
				if (board[i][j] == null) {
					result.append("-\t");
				}
				else {
					result.append(board[i][j].getUnicodeRep()).append("\t");
				}
			}
			result.append(String.format("%n"));
		}
		return result.toString();
	}
	
}
