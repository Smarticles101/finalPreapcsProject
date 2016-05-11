import java.util.Scanner;

public class Player extends Board{

	public Player() {
		super();
	}

	public Player(int w, int h) {
		super(w,h);
	}

	public void dropPiece(int x, int player) { // logic class
		int xwidth = x-1;
		int xheight = super.HEIGHT-1;
		while (super.board[xwidth][xheight] != 0) {
			xheight--;
		}
		super.board[xwidth][xheight] = player;
		//System.out.println("Player placed piece at: " + xwidth + "," + xheight);
	}
		
	public void getPlayerInput(int p) {  // diffrent class
		int player = p;
		try {
			int playerColumn = Expo.enterIntGUI("Player " + player + "\'s turn: ");
			
			if(playerColumn>super.WIDTH) {
				throw new Exception();
			} 
			
			dropPiece(playerColumn, player);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("That collum appears to be full. please try a diffrent one");
			getPlayerInput(player);
		} catch(Exception e) {
			System.out.println("Please input a valid collum between 1 and "+super.WIDTH);
			getPlayerInput(player);
		}
	}
}
