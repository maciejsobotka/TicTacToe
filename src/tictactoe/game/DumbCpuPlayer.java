package tictactoe.game;

import java.util.Random;

import tictactoe.model.Field;
import tictactoe.model.Symbols;

/**
 * Implementation of CPU player. Field to play next is chosen randomly.
 * 
 * @author Maciej Sobótka
 */
public class DumbCpuPlayer extends CpuPlayer{
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>This implementation choses next field randomly.</p>
	 */
	@Override
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

}
