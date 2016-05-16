import java.util.Arrays;

/**
 * @since 0.1.0
 */
class Board {
	private final int WIDTH;
	private final int HEIGHT;
	private int player = 1; 					// Always start at player 1
	private final int NUM_PLAYER;
	private boolean isAiGame;

	public int[][] board;

	public Board(int w, int h, int np) {
		board = new int[w][h];
		WIDTH = board.length;
		HEIGHT = board[0].length;
		if(np == 1) {
			isAiGame = true;
			NUM_PLAYER = 2;
		} else {
			isAiGame = false;
			NUM_PLAYER = np;
		}
	}

	public Board() {
		this(7,6,1);
	}

	public Board(int np) {
		this(7,6,np);
	}

	public void dropPiece(int x, int p) {
		int xwidth = x-1;
		int xheight = HEIGHT-1;
		while (board[xwidth][xheight] != 0) {
			xheight--;
		}
		board[xwidth][xheight] = p;
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

	public boolean isAiGame() {
		return isAiGame;
	}

	public void resetGame() {
		for(int x = 0; x < WIDTH; x++) {
			for(int y = 0; y < HEIGHT; y++) {
				board[x][y] = 0;
			}
		}
		player = 1;
	}

	public void aiMove() {
		try{
			int decision = Expo.random(1,WIDTH);
			dropPiece(decision,2);
		} catch(ArrayIndexOutOfBoundsException e) {
			aiMove();
		}
	}
}
