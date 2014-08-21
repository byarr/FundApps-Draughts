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
	
	Piece getPieceAt(Position p) {
		return board[p.rowIdx][p.colIdx];
	}
	
	public Player getNextPlayer() {
		return nextPlayer;
	}
	
	public void doMove(Move m) {
		if (!m.player.equals(nextPlayer)) {
			throw new IllegalArgumentException(m.player + " tried to move but it is " + nextPlayer + " turn.");
		}
		
		Piece movingPiece = getPieceAt(m.from);
		if (movingPiece == null) {
			throw new IllegalArgumentException(m.player + " tried to move a piece that doesn't exist at " + m.from);
		}
		else if (!movingPiece.owner.equals(m.player)) {
			throw new IllegalArgumentException(m.player + " tried to move a piece owned by " + movingPiece.owner);
		}
		
		if(getPieceAt(m.to) != null) {
			throw new IllegalArgumentException("Trying to move to an occupied position " + m.to);
		}
		
		//update board state
		
		//check for win condition?
		
		nextPlayer = nextPlayer.nextPlayer();
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
