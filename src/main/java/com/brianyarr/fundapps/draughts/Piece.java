package com.brianyarr.fundapps.draughts;

public enum Piece {

	
	BLACK_MAN(Player.BLACK, false, 0x26C2), BLACK_KING(Player.BLACK, true, 0x26C3), WHITE_MAN(Player.WHITE, false, 0x26C0), WHITE_KING(Player.WHITE, true, 0x26C1);
	
	private final char[] unicodeRep;
	public final Player owner;
	public final boolean isKing;
	
	Piece(Player owner, boolean isKing, int uncodeCharPoint) {
		this.owner = owner;
		this.isKing = isKing;
		this.unicodeRep = Character.toChars(uncodeCharPoint);
	}
	
	char[] getUnicodeRep() {
		return unicodeRep;
	}
	
}
