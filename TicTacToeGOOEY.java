//Tom Harren, Brian Mitchell, & Pazao Vue
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;

public class TicTacToeGOOEY {
	static Gameboard board = new Gameboard();
	static JButton[][] buttons = new JButton[3][3];
	static int win = 0;
	static int human = 0;
	static int computer = 0;
	static int tie = 0;

	public static void updateView() {
		String value = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				value = board.getValue(i, j);
				if (buttons[i][j].getText() != value) {
					buttons[i][j].setText(value);
				}
			}
		}
	}

	public static void main(String[] args) {
		// We need a top-level container, such as a JFrame
		JFrame frame = new JFrame();
		frame.setSize(300, 300);

		// When you click the red cross in the right corner, it exits
		// (without this, the window closes, but the program continues to run)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//make the buttons
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton("");
				//alternate the color in a fun way!
				if ((i + j) % 2 == 0) {
					buttons[i][j].setBackground(Color.orange);
				
				} else {
					buttons[i][j].setBackground(Color.cyan);
				}
				buttons[i][j].setForeground(Color.black);
				// pass to the listener all the needed references:
				buttons[i][j].addActionListener(new ClickListener(board, i, j));
				buttons[i][j].setSize(100, 100);
			}
		}	

		//Pre-game popup
		if (JOptionPane.showConfirmDialog(null, "Welcome!\nWould you like to play?\n\nHarren, Mitchell, Vue - 2013", "Tic Tac Toe", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)		
					System.exit(0);
		
		
		// components are added to a panel, in this 
		// case the contentPane of the JPanel
		JPanel panel = (JPanel) frame.getContentPane();

		// there are many layouts to chose from. 
		// Grid is the best for tables and other grids
		GridLayout grid = new GridLayout(3, 3);
		// setting the layout for the panel:
		panel.setLayout(grid);

		// adding all the components to the next available space 
		// according to the layout:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				panel.add(buttons[i][j]);
			}
		}
		
		// this is important!
		frame.setVisible(true);	
	}
}
