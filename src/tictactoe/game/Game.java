package tictactoe.game;

import tictactoe.model.Field;
import tictactoe.model.Symbols;

/**
 * Class that handles logic of tic-tac-toe game.
 * 
 * @author Maciej Sobótka
 */
public class Game {

	private int size;
	private Symbols[][] board;
	private CpuPlayer cpuPlayer;
	private int moveCount=0;
		
	//==========================================================================
	// Constructors
	/**
	 * Non-parameterized constructor. Default board size is 3x3.
	 */
	public Game(){
		this.size = 3;
		this.board = new Symbols[size][size];
		this.cpuPlayer = new DumbCpuPlayer();
	}

	/**
	 * Parameterized constructor. Allows to change board size.
	 * 
	 * @param size	board size (size x size)
	 */
	public Game(int size) {
		this.size = size;
		this.board = new Symbols[size][size];
		this.cpuPlayer = new DumbCpuPlayer();
	}
	
	//=========================================================================
	// Methods
	/**
	 * Returns a field that Cpu uses in it's move.
	 * 
	 * @return field on game board
	 */
	public Field cpuMove() {
		Field f = cpuPlayer.makeMove(board);
		moveCount++;
		
		return f;
	}
	
	/**
	 * Marks player move on board.
	 * 
	 * @param i	column
	 * @param j row
	 */
	public void playerMove(int i, int j) {
		board[i][j] = Symbols.CROSS;
		moveCount++;
	}
	
	/**
	 * Checks if the game has ended.
	 * @param col	last used column
	 * @param row	last used row
	 * @param s		last used player symbol
	 * @return	<ul><li> 0: still playing
	 * 			<li> 1: it's a win
	 * 			<li> -1: it's a draw </ul>
	 */
	public int checkIfWin(int col, int row, Symbols s) {		
    	for(int i = 0; i < size; ++i){	//check column
    		if(board[col][i] != s)
    			break;
    		if(i == size-1){
    			return 1;
    		}
    	}

    	for(int i = 0; i < size; ++i){	// check row
    		if(board[i][row] != s)
    			break;
    		if(i == size-1){
    			return 1;
    		}
    	}

    	if(col == row){	    //check diagonal if possible
    		for(int i = 0; i < size; ++i){
    			if(board[i][i] != s)
    				break;
    			if(i == size-1){
        			return 1;
    			}
    		}
    	}
    						//check anti diagonal
    	for(int i = 0; i < size; ++i){
    		if(board[i][(size-1)-i] != s)
    			break;
    		if(i == size-1){
    			return 1;
    		}
    	}
    						//check draw
    	if(moveCount == (size * size - 1)){
    		return -1;
    	}
    	return 0;
	}
	
	/**
	 * Checks if the game has ended.
	 * @param f		last used field
	 * @param s		last used player symbol
	 * @return	<ul><li> 0: still playing
	 * 			<li> 1: it's a win
	 * 			<li> -1: it's a draw </ul>
	 */
	public int checkIfWin(Field f, Symbols s) {
		return checkIfWin(f.getCol(), f.getRow(), s);
	}
		
	//=========================================================================
	// Getters and Setters
	/**
	 * Gets dimension of board.
	 * 
	 * @return board dimension
	 */
	public int getSize() {
		return size;
	}
	
	public CpuPlayer getCpuPlayer() {
		return cpuPlayer;
	}
}
