package com.brianyarr.fundapps.draughts;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void testWhiteMoves() {
		GameBoard board = new GameBoard();
		board.setPieceAt(Piece.WHITE_MAN, new Position(4, 4));
		assertFalse(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(5, 3))).isSuccess());
		assertFalse(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(5, 5))).isSuccess());
	
		assertTrue(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(3, 5))).isSuccess());
		assertNull(board.getPieceAt(new Position(4, 4)));
		assertEquals(Piece.WHITE_MAN, board.getPieceAt(new Position(3, 5)));
	}
	
	@Test
	public void testWhiteTakes() {
		GameBoard board = new GameBoard();
		board.setPieceAt(Piece.WHITE_MAN, new Position(4, 4));
		board.setPieceAt(Piece.BLACK_MAN, new Position(3, 5));
		
		assertFalse(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(5, 3))).isSuccess());
		assertFalse(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(5, 5))).isSuccess());
	
		assertTrue(board.doMove(new Move(Player.WHITE, new Position(4, 4), new Position(2, 6))).isSuccess());
		assertNull(board.getPieceAt(new Position(4, 4)));
		assertNull(board.getPieceAt(new Position(3, 5)));
		assertEquals(Piece.WHITE_MAN, board.getPieceAt(new Position(2, 6)));
	}

}
