package tictactoe.model;

public class Field {
	
	private int col;
	private int row;
	
	public Field(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
}
