package com.brianyarr.fundapps.draughts;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class GameStateTest {

	@Test
	public void testBoardInit() {
		GameState initialState = new GameState();
		assertEquals(Player.BLACK, initialState.getNextPlayer());
		
		System.out.println(initialState.boardToString());
		
		
		//top left is empty, next one along is black
		assertEquals(null, initialState.getPieceAt(0, 0));
		assertEquals(Piece.BLACK_MAN, initialState.getPieceAt(0, 1));
		assertEquals(Piece.BLACK_MAN, initialState.getPieceAt(1, 0));
		
		//rows 0-2 have some back men
		int blackCount = 0;
		for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
			for (int colIdx = 0; colIdx<8; colIdx++) {
				Piece p = initialState.getPieceAt(rowIdx, colIdx);
				if (p != null) {
					if (p.equals(Piece.BLACK_MAN)) {
						blackCount++;
					}
					else {
						fail("Piece should be black");
					}
				}
				
			}
		}
		assertEquals(12, blackCount);
		
		//rows 5-7 have some white men
		int whiteCount = 0;
		for (int rowIdx = 5; rowIdx < 8; rowIdx++) {
			for (int colIdx = 0; colIdx<8; colIdx++) {
				Piece p = initialState.getPieceAt(rowIdx, colIdx);
				if (p != null) {
					if (p.equals(Piece.WHITE_MAN)) {
						whiteCount++;
					}
					else {
						fail("Piece should be White");
					}
				}
				
			}
		}
		assertEquals(12, whiteCount);
		
		//the rest are empty
		for (int rowIdx = 3; rowIdx < 5; rowIdx++) {
			for (int colIdx = 0; colIdx<8; colIdx++) {
				assertEquals(null, initialState.getPieceAt(rowIdx, colIdx));
			}
		}
		
	}

}
