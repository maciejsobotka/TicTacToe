package tictactoe.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tictactoe.game.Game;
import tictactoe.model.Field;
import tictactoe.model.Symbols;

public class TicTacToeGUI implements ActionListener{
	
	private Game game;
	private BoardGUI buttons;
	
	public TicTacToeGUI() {
		JFrame frame = new JFrame();
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
		tttGui.playGame();
	}
	
	private void playGame() {
		Field f = game.cpuMove();
		showCpuMove(f);
		checkWin(f, game.getCpuPlayer().getCpuSymbol());
	}
	
	private void checkWin(int col, int row, Symbols s){
		int win = game.checkIfWin(col, row, s);
		if(win == 1){
			if(s == Symbols.Knot)
				JOptionPane.showMessageDialog(null, "Komputer wygrywa.", "Przegrałeś!",
					JOptionPane.INFORMATION_MESSAGE);
			if(s == Symbols.Cross)
				JOptionPane.showMessageDialog(null, "Komputer przegrywa.", "Wygrałeś!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if(win == -1)
			JOptionPane.showMessageDialog(null, "Remis.", "Remis!",
					JOptionPane.INFORMATION_MESSAGE);
	}

	private void checkWin(Field f, Symbols s){
		checkWin(f.getCol(), f.getRow(), s);
	}

	public void showCpuMove(Field f)
	{
		buttons.getButtonBoard()[f.getCol()][f.getRow()].setText(Symbols.Knot.toString());
		buttons.getButtonBoard()[f.getCol()][f.getRow()].removeActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton space = (JButton) e.getSource();
		space.setText(Symbols.Cross.toString());
		space.removeActionListener(this);
		for(int i = 0; i < game.getSize(); ++i)
			for(int j = 0; j < game.getSize(); ++j)
			if(space == buttons.getButtonBoard()[i][j])
			{
				game.playerMove(i, j);
				checkWin(i, j, Symbols.Cross);
				break;
			}
		playGame();
	}
}
