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

    public GamePanel(int r, int c) {
        panelY = y;
        panelX = x;
        gb = new Board(r,c);

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = (e.getX()/100)+1;
                boolean error = false;
                try {
                    gb.dropPiece(x);
                } catch(ArrayIndexOutOfBoundsException aioobe) {
                    JOptionPane.showMessageDialog(null, "That collum appears to be full. please try a diffrent one");
                    error = true;
                }
                
                switch(gb.checkWin()) {
                    case 1:
                        repaint();
                        int userChoice = JOptionPane.showConfirmDialog(null,"Play again?", "Player "+gb.getPlayer()+" won!", JOptionPane.YES_NO_OPTION);
            
                        if(userChoice==0) {
                            gb.resetGame();
                        } else {
                            System.exit(0);
                        }
                    break;

                    case 2:
                        repaint();
                        userChoice = JOptionPane.showConfirmDialog(null,"Play again?", "There was a draw!", JOptionPane.YES_NO_OPTION);
                    
                        if(userChoice==0) {
                            gb.resetGame();
                        } else {
                            System.exit(0);
                        }
                    break;
                }

                if(!error) {
                    gb.changePlayer();
                }
                
                repaint();
                error = false;
            }
        });

        /*addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });*/
        
    }
    
    /*private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }*/
    

    public Dimension getPreferredSize() {
        return new Dimension(panelX,panelY);
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