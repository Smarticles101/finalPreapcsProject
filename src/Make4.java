import java.util.Arrays;
import java.awt.*;
import java.applet.Applet;

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
 *			multiplayer over network
 */

/**
 * @since 0.1.0
 */
public class Make4 extends Applet {
	Board gb;

	public void start() {
		gb = new Board();
		startGame(4);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("Paint called");

		Expo.setColor(g,Expo.black);
		for(int y = 0; y<gb.HEIGHT*100; y+=100) {
			Expo.drawLine(g,0,y,gb.WIDTH*100,y);
		}
		for(int x = 0; x<gb.WIDTH*100; x+=100) {
			Expo.drawLine(g,x,0,x,gb.HEIGHT*100);
		}

		for(int y = 0; y<gb.HEIGHT; y++) {
			for(int x = 0; x<gb.WIDTH; x++) {
				if(gb.board[x][y] != 0) {
					switch(gb.board[x][y]) {
						case 1:
							Expo.setColor(g, Expo.red);
						break;
						case 2:
							Expo.setColor(g,Expo.black);
						break;
						case 3:
							Expo.setColor(g,Expo.green);
						break;
						case 4:
							Expo.setColor(g,Expo.purple);
						break;
					}
					Expo.fillCircle(g,x+50,y+50,50);
				}
			}
		}
	}
	
	public void startGame(int np) {
		System.out.println("Game started");
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
			
			repaint();  // repaint
			getPlayerInput(player);
			wonType = gb.checkWin(player);
		}

		repaint();
		// repaint

		switch(wonType) {
			case 1:
				System.out.println("Player "+player+" won!");
			break;

			case 2:
				System.out.println("There was a draw!");
			break;

			default:
				System.out.println("There was an error with the win type...\nPlease contact the developer.");
			break;
		}
	}

	/*********************************************************************************
	**********************************************************************************
	*********************************************************************************/

	public void getPlayerInput(int p) {  // diffrent class
		System.out.println("User input");
		int player = p;
		try {
			String tempString = JOptionPane.showInputDialog("Player " + player + "\'s turn: ");
			int playerColumn = Integer.parseInt(tempString);

			if(playerColumn>gb.WIDTH) {
				System.out.println("I threw an Exception");
				throw new Exception();
			} 
			
			gb.dropPiece(playerColumn, player);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("That collum appears to be full. please try a diffrent one");
			getPlayerInput(player);
		} catch(Exception e) {
			System.out.println("Please input a valid collum between 1 and "+gb.WIDTH);
			getPlayerInput(player);
		}
	}
}