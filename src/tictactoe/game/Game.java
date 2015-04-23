package tictactoe.game;

import tictactoe.model.Field;
import tictactoe.model.Symbols;

public class Game {

	private int size;
	private Symbols[][] board;
	private CpuPlayer cpuPlayer;
	private int moveCount=0;
	
	public Game(){
		this.size = 3;
		this.board = new Symbols[size][size];
		this.cpuPlayer = new CpuPlayer();
	}

	public Game(int size){
		this.size = size;
		this.board = new Symbols[size][size];
		this.cpuPlayer = new CpuPlayer();
	}
	
	public Field cpuMove()
	{
		Field f = cpuPlayer.makeMove(board);
		moveCount++;
		
		return f;
	}
	
	public void playerMove(int i, int j)
	{
		board[i][j] = Symbols.Cross;
		moveCount++;
	}
	
	public int checkIfWin(int col, int row, Symbols s)
	{
    	for(int i = 0; i < size; i++){
    		if(board[col][i] != s)
    			break;
    		if(i == size-1){
    			return 1;
    		}
    	}

    	//check row
    	for(int i = 0; i < size; i++){
    		if(board[i][row] != s)
    			break;
    		if(i == size-1){
    			return 1;
    		}
    	}

    	//check diag
    	if(col == row){
    		//we're on a diagonal
    		for(int i = 0; i < size; i++){
    			if(board[i][i] != s)
    				break;
    			if(i == size-1){
        			return 1;
    			}
    		}
    	}

            //check anti diag (thanks rampion)
    	for(int i = 0;i<size;i++){
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
	
	public int checkIfWin(Field f, Symbols s)
	{
		return checkIfWin(f.getCol(), f.getRow(), s);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Symbols[][] getBoard() {
		return board;
	}

	public CpuPlayer getCpuPlayer() {
		return cpuPlayer;
	}

	public void setCpuPlayer(CpuPlayer cpuPlayer) {
		this.cpuPlayer = cpuPlayer;
	}
}
