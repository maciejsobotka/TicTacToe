package tictactoe.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class that represents tic-tac-toe grid in graphical form.
 * 
 * @author Maciej Sobótka
 */
public class BoardGUI extends JPanel{

	private static final long serialVersionUID = 1892317335019511521L;
	private JButton buttonBoard[][];
	
	//==========================================================================
	// Constructors
	/**
     * Non-parametrized constructor.
    */
	public BoardGUI(){
		this.buttonBoard = new JButton[3][3];
		createBoard(3);
	}
	
	/**
	 * Parametrized constructor.
	 * 
	 * @param size	dimension of game board
	 */
	public BoardGUI(int size){
		this.buttonBoard = new JButton[size][size];
		createBoard(size);
	}

	//=========================================================================
	// Methods
	/**
	 * Method that creates buttons for game board.
	 * 
	 * @param size	dimension of game board
	 */
	public void createBoard(int size){
		this.setLayout(new GridLayout(size, size));
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j){
				JButton space = new JButton();
				space.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				buttonBoard[i][j] = space;
				this.add(space);
		}
	}
	
	//=========================================================================
	// Getters and Setters
	/**
	 * Gets buttons array representing grid fields.
	 * 
	 * @return array of buttons (fields)
	 */
	public JButton[][] getButtonBoard(){
		return buttonBoard;
	}
}
