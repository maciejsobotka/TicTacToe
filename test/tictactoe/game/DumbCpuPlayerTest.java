package tictactoe.game;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import tictactoe.model.Symbols;


public class DumbCpuPlayerTest {

	private CpuPlayer cpuPlayer;
	
	@Before
	public void setUp() {
		cpuPlayer = new DumbCpuPlayer();
	}
	
	@Test
	public void shouldPutSymbolOn22() {
		Symbols board[][] = new Symbols[3][3];
		for(int i=0; i < 3; ++i)
			for(int j=0; j < 3; ++j)
				board[i][j] = Symbols.CROSS;
		board[2][2] = null;
		cpuPlayer.makeMove(board);
		assertNotNull("Field 22 is null", board[2][2]);
	}
}
