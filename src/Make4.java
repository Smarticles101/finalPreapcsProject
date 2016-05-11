import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

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
public class Make4 extends Player {
	public void paint(Graphics g) {
		int w = Expo.enterIntGUI("Enter a board width");
		int h = Expo.enterIntGUI("Enter a board height");
		Make4 m4 = new Make4();
		
		paintBoard(g);
	}

	public void repaint(Graphics g) {
		paintBoard(g);
	}

	public void paintBoard(Graphics g) {
		for(int y = 0; y<HEIGHT; y++) {
			for(int x = 0; x<WIDTH; x++) {
				if(super.board[x][y] != 0) {
					switch(board[x][y]) {
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
				}
			}

			if(y==HEIGHT-1) {
				System.out.print("\n");  // thi
			} else {
				System.out.print("\n| ");
			}
		}
	}
	
	public Make4() {
		super();
	}
	
	public Make4(int w, int h) {
		super(w,h);
	}
	
	public void startGame(int np) {
		int player = 1;
		int numPlayer = np;
		int wonType = 0;
		
		repaint();
		super.getPlayerInput(player);
		
		while(wonType == 0) {
			
			if(player<numPlayer) {
				player++;
			} else {
				player = 1;
			}
			
			repaint();  // repaint
			super.getPlayerInput(player);
			wonType = super.checkWin(player);
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
}