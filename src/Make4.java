import java.util.Arrays;
import java.awt.*;
import java.applet.Applet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Logan Stucki
 * @version 0.1.0
 * TODO:
 * 		gui with swing or applet
 *		single player with simple ai
 *		2+ player mode
 *		
 *		Trivial stuff:
 *			save/load game from file
 *		
 *		Impossible stuff:
 *			multiplayer over network
 */

/**
 * @since 0.1.0
 */
public class Make4 extends Applet {
	Board gb = new Board();
	boolean hasFirstRun = false;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBoard(g);
		if(!hasFirstRun) {
			hasFirstRun = true;
			startGame(2,g);
		}
	}
	
	public void startGame(int np, Graphics g) {
		int player = 0;
		int numPlayer = np;
		int wonType = 0;
		
		//getPlayerInput(player);
		
		while(wonType == 0) {
			
			if(player<numPlayer) {
				player++;
			} else {
				player = 1;
			}
			
			paintBoard(g);  // repaint
			getPlayerInput(player);
			wonType = gb.checkWin(player);
		}

		paintBoard(g);
		// repaint

		switch(wonType) {
			case 1:
				JOptionPane.showMessageDialog(null, "Player "+player+" won!");
			break;

			case 2:
				JOptionPane.showMessageDialog(null, "There was a draw!");
			break;

			default:
				JOptionPane.showMessageDialog(null, "There was an error with the win type...\nPlease contact the developer.");
			break;
		}
	}

	/*********************************************************************************
	**********************************************************************************
	*********************************************************************************/

	public void getPlayerInput(int p) {
		int player = p;
		try {
			String tempString = JOptionPane.showInputDialog("Player " + player + "\'s turn: ");
			int playerColumn = Integer.parseInt(tempString);

			if(playerColumn>gb.WIDTH) {
				throw new Exception();
			} 
			
			gb.dropPiece(playerColumn, player);
		} catch(ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "That collum appears to be full. please try a diffrent one");
			getPlayerInput(player);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please input a valid collum between 1 and "+gb.WIDTH);
			getPlayerInput(player);
		}
	}
}