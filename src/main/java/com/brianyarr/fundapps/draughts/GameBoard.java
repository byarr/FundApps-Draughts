package com.brianyarr.fundapps.draughts;

class GameBoard {

	private final Piece[][] board;
	
	
	GameBoard() {
		board = new Piece[8][8];
	}
	
	void setPieceAt(Piece piece, Position pos) {
		board[pos.rowIdx][pos.colIdx] = piece;
	}
	
	Piece getPieceAt(Position pos) {
		return board[pos.rowIdx][pos.colIdx];
	}
	
	void init() {
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
	
	MoveResult doMove(Move m) {
		Piece movingPiece = getPieceAt(m.from);
		if (movingPiece == null) {
			return MoveResult.error(m.player + " tried to move a piece that doesn't exist at " + m.from);
		}
		else if (!movingPiece.owner.equals(m.player)) {
			return MoveResult.error(m.player + " tried to move a piece owned by " + movingPiece.owner);
		}
		
		if(getPieceAt(m.to) != null) {
			return MoveResult.error("Trying to move to an occupied position " + m.to);
		}
		
		//moves can either be one square, or two if they are over an opposing piece
		int colMoves = Math.abs(m.from.colIdx - m.to.colIdx);
		int rowMoves = m.from.rowIdx - m.to.rowIdx;
		//moving diagonally means row and col moves by same amount
		if (colMoves != Math.abs(rowMoves)) {
			return MoveResult.error("Invalid move.");
		}
		
		if (!movingPiece.isKing) {
			//normal pieces can move in specific directions
			int rowMoveDir = movingPiece.owner.equals(Player.BLACK) ? -1 : +1;
			if (Math.signum(rowMoves) != rowMoveDir) {
				return MoveResult.error("Invalid move.");
			}
		}
		
		if (colMoves == 1) {
			//already checked everything?
		}
		else if (colMoves == 2) {
			//check row moves is 2 in valid dir and that we have jumped over opposing player
			Position jumpedPos = new Position((m.from.rowIdx + m.to.rowIdx)/2, (m.from.colIdx + m.to.colIdx) / 2);
			Piece jumpedPiece = getPieceAt(jumpedPos);
			if (jumpedPiece == null) {
				return MoveResult.error("Can't jump and empty square.");
			}
			else if (jumpedPiece.owner.equals(movingPiece.owner)) {
				return MoveResult.error("Can't jump your own peices.");
			}
			else {
				setPieceAt(null, jumpedPos);
			}
		}
		else {
			return MoveResult.error("Tried to move invalid number of columns.");
		}
		
		setPieceAt(null, m.from);
		setPieceAt(movingPiece, m.to);
		
		return MoveResult.success();
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
