import java.util.Arrays;

/**
 * @since 0.1.0
 */
class Board {
	public final int WIDTH;
	public final int HEIGHT;
	private int player = 1; 					// Always start at player 1
	public final int NUM_PLAYER;

	public int[][] board;

	public Board() {
		board = new int[7][6];
		WIDTH = board.length;
		HEIGHT = board[0].length;
		NUM_PLAYER = 2;
	}

	public Board(int w, int h, int np) {
		board = new int[w][h];
		WIDTH = board.length;
		HEIGHT = board[0].length;
		NUM_PLAYER = np;
	}

	public void dropPiece(int x) {
		int xwidth = x-1;
		int xheight = HEIGHT-1;
		while (board[xwidth][xheight] != 0) {
			xheight--;
		}
		board[xwidth][xheight] = player;
		//System.out.println("Player placed piece at: " + xwidth + "," + xheight);
	}
	
	public int checkWin() {						// return 1 for win, 2 for draw
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
	
	private boolean isDraw() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				if(board[x][y] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void changePlayer() {
		if(player<NUM_PLAYER) {
			player++;
		} else {
			player = 1;
		}
	}

	public int getPlayer() {
		return player;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void resetGame() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				board[x][y] = 0;
			}
		}
		player = 0;							// start at 0, gamepanel file will iterate it to 1
	}
}
