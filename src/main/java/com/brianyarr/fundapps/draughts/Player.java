package com.brianyarr.fundapps.draughts;

public enum Player {
	
	BLACK, WHITE;
	
	Player nextPlayer() {
		Player[] players = Player.values();
		return players[(this.ordinal() + 1) % players.length];
	}

}
