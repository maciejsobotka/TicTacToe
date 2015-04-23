package tictactoe.model;

/**
 * Enum representing symbols used by players in the game of tic-tac-toe.
 * 
 * @author Maciej Sobótka
 */
public enum Symbols {
	
	/**
	 * Symbol for player O.
	 */
	NOUGHT("O"),
	
	/**
	 * Symbol for player X.
	 */
	CROSS("X");
	
    private final String text;

    /**
     * Parametrized constructor.
     * 
     * @param text	player symbol
     */
    private Symbols(String text) {
        this.text = text;
    }

    /**
     * Returns one of the symbols used in tic-tac-toe.
     * 
     * @return	player symbol
     */
	@Override
	public String toString(){
		return text;
	}
}
