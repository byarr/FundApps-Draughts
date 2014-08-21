package com.brianyarr.fundapps.draughts;

public class MoveResult {

	private final boolean success;
	private final String errorMessage;
	
	public MoveResult(boolean success, String errorMessage) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public static MoveResult success() {
		return new MoveResult(true, null);
	}
	
	public static MoveResult error(String message) {
		return new MoveResult(false, message);
	}
	
}
