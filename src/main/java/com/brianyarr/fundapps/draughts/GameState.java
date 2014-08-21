package com.brianyarr.fundapps.draughts;

public class GameState {

	private Player nextPlayer;
	
	// array of board squares, row by column, 0,0 being top left and a white square next on blacks end 
	private final GameBoard board;

	public GameState() {
		nextPlayer = Player.BLACK; // black starts the game

		board = new GameBoard();
		board.init();
	}

	Piece getPieceAt(int row, int col) {
		return getPieceAt(new Position(row, col));
	}
	
	Piece getPieceAt(Position p) {
		return board.getPieceAt(p);
	}
	
	public Player getNextPlayer() {
		return nextPlayer;
	}
	
	public MoveResult doMove(Move m) {
		if (!m.player.equals(nextPlayer)) {
			return MoveResult.error(m.player + " tried to move but it is " + nextPlayer + " turn.");
		}
		
		
		MoveResult boardRes = board.doMove(m);
		if (!boardRes.isSuccess()) {
			return boardRes;
		}
		
		//check for win condition?
		nextPlayer = nextPlayer.nextPlayer();
		return boardRes;
	}
	
}
