package tictactoe.model;

/**
 * Class representing a field in tic-tac-toe grid (game board).
 * 
 * @author Maciej Sobótka
 */
public class Field {
	
	private int col;
	private int row;
	
	//==========================================================================
	// Constructors
	/**
     * Parametrized constructor.
     * 
	 * @param col	column coordinate of the field
	 * @param row	row coordinate of the field
	 */
	public Field(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	//=========================================================================
	// Getters and Setters
	/** Get column coordinate of the field.
	 *
	 * @return column coordinate
	 */
	public int getCol() {
		return col;
	}
	
	/** Set column coordinate of the field.
	 *
	 *  @param col column coordinate
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/** Get row coordinate of the field.
	 *
	 * @return row coordinate
	 */
	public int getRow() {
		return row;
	}
	
	/** Row column coordinate of the field.
	 *
	 *  @param row row coordinate
	 */
	public void setRow(int row) {
		this.row = row;
	}
}
