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

public class TicTacToeGUI implements ActionListener{
	
	private JFrame frame;
	private Game game;
	private BoardGUI buttons;
	private boolean end;
	
	public TicTacToeGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Tic-Tac-Toe");
		
		game = new Game();
		buttons = new BoardGUI();
		frame.getContentPane().add(BorderLayout.CENTER, buttons);
		frame.setVisible(true);
		
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
				buttons.getButtonBoard()[i][j].addActionListener(this);
	}

	public static void main(String[] args){
		TicTacToeGUI tttGui = new TicTacToeGUI();
		Random generator = new Random();
		int starter = generator.nextInt(2);
		if(starter == 1)
			tttGui.playGame();
	}
	
	private void gameInit()
	{
		frame.getContentPane().remove(buttons);
		game = new Game();
		buttons = new BoardGUI();
		frame.getContentPane().add(BorderLayout.CENTER, buttons);
		frame.revalidate();
		frame.repaint();
		
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
				buttons.getButtonBoard()[i][j].addActionListener(this);
		end = false;
	}
	
	private void playGame() {
		Field f = game.cpuMove();
		showCpuMove(f);
		if(checkWin(f, game.getCpuPlayer().getCpuSymbol()) == 0)
			gameInit();
			
	}
	
	private int checkWin(int col, int row, Symbols s){
		int win = game.checkIfWin(col, row, s);
		if(win == 1){
			end = true;
			if(s == Symbols.Knot)
				return JOptionPane.showConfirmDialog(null, "Rozpocząć nową grę?", "Przegrałeś!",
					JOptionPane.YES_NO_OPTION);
			if(s == Symbols.Cross)
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

	private int checkWin(Field f, Symbols s){
		return checkWin(f.getCol(), f.getRow(), s);
	}

	public void showCpuMove(Field f)
	{
		buttons.getButtonBoard()[f.getCol()][f.getRow()].setText(Symbols.Knot.toString());
		buttons.getButtonBoard()[f.getCol()][f.getRow()].removeActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!end){
			JButton space = (JButton) e.getSource();
			space.setText(Symbols.Cross.toString());
			space.removeActionListener(this);
			for(int i = 0; i < game.getSize(); ++i)
				for(int j = 0; j < game.getSize(); ++j)
				if(space == buttons.getButtonBoard()[i][j])
				{
					game.playerMove(i, j);
					if(checkWin(i, j, Symbols.Cross) == 0)
						gameInit();
					break;
				}
		}
		if (!end) playGame();
	}
}
