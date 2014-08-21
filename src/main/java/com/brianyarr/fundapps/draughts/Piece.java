package com.brianyarr.fundapps.draughts;

public enum Piece {

	
	BLACK_MAN(0x26C2), BLACK_KING(0x26C3), WHITE_MAN(0x26C0), WHITE_KING(0x26C1);
	
	private char[] unicodeRep;
	
	Piece(int uncodeCharPoint) {
		this.unicodeRep = Character.toChars(uncodeCharPoint);
	}
	
	char[] getUnicodeRep() {
		return unicodeRep;
	}
	
}
