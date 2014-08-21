package com.brianyarr.fundapps.draughts;

public class Move {

	public final Player player;
	public final Position from;
	public final Position to;
	
	public Move(Player player, Position from, Position to) {
		super();
		this.player = player;
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Move [player=" + player + ", from=" + from + ", to=" + to + "]";
	}
	
}
