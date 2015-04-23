package tictactoe.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel{

	private static final long serialVersionUID = 1892317335019511521L;
	private JButton spaces[];
	private int size;
	
	public Board()
	{
		this.size = 3;
		spaces = new JButton[ size * size ];
		createBoard();
	}

	public void createBoard()
	{
		this.setLayout(new GridLayout(4, 4));
		//this.setPreferredSize(new Dimension(100, 100));
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		for (int i = 0; i < size * size; i++) {
				JButton space = new JButton();
				space.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				//space.setBounds(x, y, width, height);(new Dimension(100,100));
				spaces[i] = space;
				this.add(space);
		}
	}
	
	public JButton[] getSpaces() {
		return spaces;
	}
}
