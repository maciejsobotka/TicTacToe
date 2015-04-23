package tictactoe.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardGUI extends JPanel{

	private static final long serialVersionUID = 1892317335019511521L;
	private JButton buttonBoard[][];
	
	public BoardGUI(){
		this.buttonBoard = new JButton[3][3];
		createBoard(3);
	}
	
	public BoardGUI(int size){
		this.buttonBoard = new JButton[size][size];
		createBoard(size);
	}

	public void createBoard(int size){
		this.setLayout(new GridLayout(4, 4));
		//this.setPreferredSize(new Dimension(100, 100));
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j){
				JButton space = new JButton();
				space.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				//space.setBounds(x, y, width, height);(new Dimension(100,100));
				buttonBoard[i][j] = space;
				this.add(space);
		}
	}
	
	public JButton[][] getButtonBoard(){
		return buttonBoard;
	}
}
