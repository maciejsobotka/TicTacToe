package tictactoe.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import tictactoe.model.Symbols;

public class TicTacToeGUI implements ActionListener{
	
	private Board board;
	
	public void createGui() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Tic-Tac-Toe");
		
		board = new Board();
		frame.getContentPane().add(BorderLayout.CENTER, board);
		frame.setVisible(true);
		
		for(JButton b : board.getSpaces())
			b.addActionListener(this);
	}

	public void showCpuMove(int space)
	{
		board.getSpaces()[space].setText(Symbols.Knot.toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton space = (JButton) e.getSource();
		space.setText(Symbols.Cross.toString());
		space.removeActionListener(this);	
	}
}
