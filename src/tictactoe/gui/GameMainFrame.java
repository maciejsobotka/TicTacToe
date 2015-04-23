package tictactoe.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tictactoe.game.Game;
import tictactoe.model.Field;
import tictactoe.model.Symbols;

/**
 * Main frame of tic-tac-toe game. This is the place where interactions
 * with player are handled.
 * 
 * @author Maciej Sobótka
 */
public class GameMainFrame implements ActionListener{
	
	private JFrame frame;
	private Game game;
	private BoardGUI buttons;
	private int size;
	private boolean end;
	
	//==========================================================================
	// Constructors
	/**
	 * Non-parameterized constructor. Creates main frame and initializes the game.
	 */
	public GameMainFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tic-Tac-Toe");
		
		size = 3;
		game = new Game();
		buttons = new BoardGUI();
		frame.getContentPane().add(BorderLayout.CENTER, buttons);
		frame.setVisible(true);
		
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
				buttons.getButtonBoard()[i][j].addActionListener(this);
	}

	/**
	 * Parametrized constructor. Creates main frame and initializes the game.
	 * 
	 * @param size	dimension of game board
	 */
	public GameMainFrame(int size) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tic-Tac-Toe");
		
		this.size = size;
		game = new Game(size);
		buttons = new BoardGUI(size);
		frame.getContentPane().add(BorderLayout.CENTER, buttons);
		frame.setVisible(true);
		
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
				buttons.getButtonBoard()[i][j].addActionListener(this);
	}
	
	//=========================================================================
	// Methods
	/**
	 * This is the place where program starts.
	 * @param args
	 */
	public static void main(String[] args){
		GameMainFrame tttGui = new GameMainFrame();
		Random generator = new Random();
		int starter = generator.nextInt(2);
		if(starter == 1)
			tttGui.playGame();
	}
	
	/**
	 * Method to initialize new game. Resets main frame and game state.
	 */
	private void gameInit(int size)
	{
		frame.getContentPane().remove(buttons);
		game = new Game(size);
		buttons = new BoardGUI(size);
		frame.getContentPane().add(BorderLayout.CENTER, buttons);
		frame.revalidate();
		frame.repaint();
		
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
				buttons.getButtonBoard()[i][j].addActionListener(this);
		end = false;
		Random generator = new Random();
		int starter = generator.nextInt(2);
		if(starter == 1)
			playGame();
	}
	
	/**
	 * Makes CPU player move, shows it on board and checks if the game has ended.
	 */
	private void playGame() {
		Field f = game.cpuMove();
		buttons.getButtonBoard()[f.getCol()][f.getRow()].setText(Symbols.NOUGHT.toString());
		buttons.getButtonBoard()[f.getCol()][f.getRow()].removeActionListener(this);
		if(checkWin(f, Symbols.NOUGHT) == 0)
			gameInit(size);
			
	}
	
	/**
	 * Checks if the game has ended. If ended, states whether player wants to play next game.
	 * 
	 * @param col	last used column
	 * @param row	last used row
	 * @param s		last used player symbol
	 * @return	<ul><li> 0: game has ended and player wants to play again
	 * 			<li> 1: game has ended and player had enough
	 * 			<li> 2: game has not ended yet </ul>
	 */
	private int checkWin(int col, int row, Symbols s){
		int win = game.checkIfWin(col, row, s);
		if(win == 1){
			end = true;
			if(s == Symbols.NOUGHT)
				return JOptionPane.showConfirmDialog(null, "Rozpocząć nową grę?", "Przegrałeś!",
					JOptionPane.YES_NO_OPTION);
			if(s == Symbols.CROSS)
				return JOptionPane.showConfirmDialog(null, "Rozpocząć nową grę?", "Wygrałeś!",
					JOptionPane.YES_NO_OPTION);
		}
		if(win == -1){
			end = true;
			return JOptionPane.showConfirmDialog(null, "Rozpocząć nową grę?", "Remis!",
					JOptionPane.YES_NO_OPTION);
		}
		return 2;
	}

	/**
	 * Checks if the game has ended. If ended, states whether player wants to play next game.
	 * 
	 * @param f		last used field
	 * @param s		last used player symbol
	 * @return	<ul><li> 0: game has ended and player wants to play again
	 * 			<li> 1: game has ended and player had enough
	 * 			<li> 2: game has not ended yet </ul>
	 */
	private int checkWin(Field f, Symbols s){
		return checkWin(f.getCol(), f.getRow(), s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!end){
			JButton space = (JButton) e.getSource();
			space.setText(Symbols.CROSS.toString());
			space.removeActionListener(this);
			for(int i = 0; i < game.getSize(); ++i)
				for(int j = 0; j < game.getSize(); ++j)
				if(space == buttons.getButtonBoard()[i][j])
				{
					game.playerMove(i, j);
					if(checkWin(i, j, Symbols.CROSS) == 0){
						gameInit(size);
						return;
					}
					break;
				}
		}
		if (!end) playGame();
	}
}
