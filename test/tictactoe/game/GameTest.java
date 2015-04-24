package tictactoe.game;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tictactoe.model.Symbols;

public class GameTest {

	private Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void shouldReturnWinValue() {
		game.playerMove(0, 2);
		game.playerMove(1, 1);
		game.playerMove(2, 0);
		int result = game.checkIfWin(2, 0, Symbols.CROSS);
		assertEquals("Not equal", result, 1);
	}
	
	@Test
	public void shouldReturnNoEndValue() {
		game.playerMove(0, 2);
		game.playerMove(2, 1);
		game.playerMove(2, 0);
		int result = game.checkIfWin(2, 0, Symbols.CROSS);
		assertEquals("Not equal", result, 0);
	}
}
