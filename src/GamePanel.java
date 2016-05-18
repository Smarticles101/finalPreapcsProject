import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

/**
 * @author Logan Stucki
 * @version 0.1.0
 * TODO:
 *      Main menu
 *      changing colors and board size
 *      
 *      Trivial stuff:
 *          done
 *      
 *      Impossible stuff that will probably never happen (ever):
 *          multiplayer over network
 */
class GamePanel extends JPanel {
	private Board gb = new Board();
	private int panelX;
	private int panelY;
	private boolean hasWon;

	public GamePanel() {
		int userChoice = 0;

		setBorder(BorderFactory.createLineBorder(Color.black));

		if(gb.saveExists()) {
			userChoice = JOptionPane.showConfirmDialog(null,
								"Would you like to load your most recent save?", 
								"", 
								JOptionPane.YES_NO_OPTION);
					
			if(userChoice==0) {
				gb.loadGame();
			}
		}

		if(userChoice==1 || !gb.saveExists()) {
			newGameDiag();
		}

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				hasWon = false;
				int column = (e.getX()/100)+1;
				boolean error = false;
				try {
					//System.out.println("column="+column+"player="+gb.getPlayer());
					gb.dropPiece(column, gb.getPlayer());
				} catch(ArrayIndexOutOfBoundsException aioobe) {
					JOptionPane.showMessageDialog(null, 
								"That collum appears to be full. please try a diffrent one");
					error = true;
				}

				winDialogue();
				if(!hasWon) {
					if(!error) {
						gb.changePlayer();
						if(gb.isAiGame()) {
							gb.aiMove();
							winDialogue();
							if(!hasWon) {
								gb.changePlayer();
							}
						}
					}
				}
				repaint();
				error = false;
			}
		});
	}

	public void winDialogue() {
		switch(gb.checkWin()) {
			case 1:
				hasWon = true;
				repaint();
				int userChoice = JOptionPane.showConfirmDialog(null,
								"Play again?", 
								"Player "+gb.getPlayer()+" won!", 
								JOptionPane.YES_NO_OPTION);
			
				if(userChoice==0) {
					newGameDiag();
				} else {
					System.exit(0);
				}
			break;

			case 2:
			hasWon = true;
				repaint();
				userChoice = JOptionPane.showConfirmDialog(null,
								"Play again?", 
								"There was a draw!", 
								JOptionPane.YES_NO_OPTION);
					
				if(userChoice==0) {
					newGameDiag();
				} else {
					System.exit(0);
				}
			break;
		}
	}
	

	public Dimension getPreferredSize() {
		return new Dimension(700,600);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);       
		g.drawString("Player "+gb.getPlayer()+"'s turn",10,20);

		paintBoard(g);
	}

	public void paintBoard(Graphics g) {
		Expo.setColor(g,Expo.black);
		for(int y = 0; y<gb.getHeight()*100; y+=100) {
			Expo.drawLine(g,0,y,gb.getWidth()*100,y);
		}
		for(int x = 0; x<gb.getWidth()*100; x+=100) {
			Expo.drawLine(g,x,0,x,gb.getHeight()*100);
		}

		for(int column = gb.getWidth()-1; column >= 0; column--) {
			for(int row = 0; row < gb.getHeight(); row++) {
				if(gb.board[row][column] != 0) {
					switch(gb.board[row][column]) {
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
					Expo.fillCircle(g,column*100+50,row*100+50,45);
				}
			}
		}
	}

	public void newGameDiag() {
		Object[] options = {"Friend","Computer"};
		int userChoice = JOptionPane.showOptionDialog(null,
            			"Play against a friend, or the computer?",
			            "",
			            JOptionPane.YES_NO_CANCEL_OPTION,
			            JOptionPane.DEFAULT_OPTION,
			            null,
 			        	options,
 			        	options[1]);
		if(userChoice==0) {
			gb = new Board(2);
		} else {
			gb = new Board();
		}
	}
}