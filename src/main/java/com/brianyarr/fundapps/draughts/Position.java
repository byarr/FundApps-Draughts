package com.brianyarr.fundapps.draughts;

public class Position {

	public final int rowIdx;
	public final int colIdx;
	
	public Position(int rowIdx, int colIdx) {
		super();
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
	}

	@Override
	public String toString() {
		return "Position [rowIdx=" + rowIdx + ", colIdx=" + colIdx + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colIdx;
		result = prime * result + rowIdx;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (colIdx != other.colIdx)
			return false;
		if (rowIdx != other.rowIdx)
			return false;
		return true;
	}
	
}
