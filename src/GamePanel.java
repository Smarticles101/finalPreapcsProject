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
 *      single player with simple ai
 *      2+ player mode
 *      
 *      Trivial stuff:
 *          save/load game from file
 *      
 *      Impossible stuff:
 *          multiplayer over network
 */
class GamePanel extends JPanel {
    private Board gb;
    private int panelX;
    private int panelY;
    boolean hasWon;

    public GamePanel() {
        gb = new Board(1);

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                hasWon = false;
                int x = (e.getX()/100)+1;
                boolean error = false;
                try {
                    System.out.println("x="+x+"player="+gb.getPlayer());
                    gb.dropPiece(x, gb.getPlayer());
                } catch(ArrayIndexOutOfBoundsException aioobe) {
                    JOptionPane.showMessageDialog(null, "That collum appears to be full. please try a diffrent one");
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
                int userChoice = JOptionPane.showConfirmDialog(null,"Play again?", "Player "+gb.getPlayer()+" won!", JOptionPane.YES_NO_OPTION);
            
                if(userChoice==0) {
                    gb.resetGame();
                } else {
                    System.exit(0);
                }
            break;

            case 2:
            hasWon = true;
                repaint();
                userChoice = JOptionPane.showConfirmDialog(null,"Play again?", "There was a draw!", JOptionPane.YES_NO_OPTION);
                    
                if(userChoice==0) {
                    gb.resetGame();
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

        for(int y = 0; y<gb.getHeight(); y++) {
            for(int x = gb.getWidth()-1; x>=0; x--) {
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
                    Expo.fillCircle(g,x*100+50,y*100+50,45);
                }
            }
        }
    }
}