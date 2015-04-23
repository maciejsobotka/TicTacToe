package tictactoe.game;

import tictactoe.model.Field;
import tictactoe.model.Symbols;

/**
 * Abstract class representing template for CPU player.
 * 
 * @author Maciej Sobótka
 *
 */
public abstract class CpuPlayer {
	protected Symbols cpuSymbol;
	
	//==========================================================================
	// Constructors
	/**
	 * Non-parameterized constructor. Default CPU player sybol is O.
	 */
	public CpuPlayer(){
		this.cpuSymbol = Symbols.NOUGHT;
	}
	
	//=========================================================================
	// Methods
	/**
	 * Method holding algorithm for choosing next field.
	 * @param 	board	game board
	 * @return	field to play next
	 */
	public abstract Field makeMove(Symbols[][] board);
	
	//=========================================================================
	// Getters and Setters
	/**
	 * Gets CPU player symbol.
	 * @return 	CPU player symbol
	 */
	public Symbols getCpuSymbol() {
		return cpuSymbol;
	}
}
