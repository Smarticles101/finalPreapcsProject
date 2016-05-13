import java.util.Arrays;

/**
 * @since 0.1.0
 */
class Board {
	final int WIDTH;
	final int HEIGHT;

	int[][] board;

	public Board() {
		board = new int[7][6];
		WIDTH = board.length;
		HEIGHT = board[0].length;
	}

	public Board(int w, int h) {
		board = new int[w][h];
		WIDTH = board.length;
		HEIGHT = board[0].length;
	}

	public void dropPiece(int x, int player) {
		int xwidth = x-1;
		int xheight = HEIGHT-1;
		while (board[xwidth][xheight] != 0) {
			xheight--;
		}
		board[xwidth][xheight] = player;
		//System.out.println("Player placed piece at: " + xwidth + "," + xheight);
	}
	
	public int checkWin(int player) {
	    if(isDraw()) {
	    	return 2;
	    }
		
		for (int x = 0; x < WIDTH; x++) {
	        for (int y = 0; y < HEIGHT; y++) {
	            if (board[x][y] != player) {
	            	continue; 
	            }
	                
	            if (x + 3 < WIDTH && player == board[x+1][y] && board[x][y] == board[x+2][y] && board[x][y] == board[x+3][y]) {
	                //System.out.println("Won horozontal");
	                return 1; // won horozontal
	            }
	            
	            if (y + 3 < HEIGHT) {
	                if (board[x][y] == board[x][y+1] && board[x][y] == board[x][y+2] && board[x][y] == board[x][y+3]) {
	                    //System.out.println("Won vertical");
	                    return 1; // won vertical
	                }
	                if (x + 3 < WIDTH && board[x][y] == board[x+1][y+1] && board[x][y] == board[x+2][y+2] && board[x][y] == board[x+3][y+3]) {
	                    //System.out.println("Won diag 1\nboard[x][y]=="+board[x][y]);
	                    return 1; // won diag 
	                }
	                if (x - 3 >= 0 && board[x][y] == board[x-1][y+1] && board[x][y] == board[x-2][y+2] && board[x][y] == board[x-3][y+3]) {
	                	//System.out.println("Won diag 2");   
	                	return 1; // won diag
	                }
	            }
	        }
	    }
	    return 0;
	}
	
	public boolean isDraw() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				if(board[x][y] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
