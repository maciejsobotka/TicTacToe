package tictactoe.game;

import java.util.Random;

import tictactoe.model.Field;
import tictactoe.model.Symbols;

public class CpuPlayer {
	Symbols cpuSymbol;
	
	public CpuPlayer(){
		this.cpuSymbol = Symbols.Knot;
	}

	public Field makeMove(Symbols[][] board)
	{
		Random generator = new Random();
		while(true){
			int i = generator.nextInt(board.length);
			int j = generator.nextInt(board.length);
			if (board[i][j] == null)
			{
				board[i][j] = cpuSymbol;
				return new Field(i, j);
			}
		}
	}
		
	public Symbols getCpuSymbol() {
		return cpuSymbol;
	}
}
