import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * TODO:
 *      reset player to 1 upon game reset
 */

public class Make4Runner {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Connect four by Logan Stucki");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new GamePanel());
        f.pack();
        f.setVisible(true);
    } 
}