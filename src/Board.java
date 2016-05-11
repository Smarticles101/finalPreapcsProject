import java.util.Arrays;

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

	public void printBoard() {  						// Needs to be put in a diffrent class
		System.out.print("| ");
		for(int y = 0; y<HEIGHT; y++) {
			for(int x = 0; x<WIDTH; x++) {
				System.out.print(board[x][y] + " | ");
			}

			if(y==HEIGHT-1) {
				System.out.print("\n");  // thi
			} else {
				System.out.print("\n| ");
			}
		}
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
	                return 1;
	            }
	            
	            if (y + 3 < HEIGHT) {
	                if (board[x][y] == board[x][y+1] && board[x][y] == board[x][y+2] && board[x][y] == board[x][y+3]) {
	                    return 1;
	                }
	                if (x + 3 < WIDTH && board[x][y] == board[x+1][y+1] && board[x][y] == board[y+2][y+2] && board[x][y] == board[y+3][y+3]) {
	                    return 1;
	                }
	                if (x - 3 >= 0 && board[x][y] == board[x-1][y+1] && board[x][y] == board[x-2][y+2] && board[x][y] == board[x-3][y+3]) {
	                    return 1;
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
	
	// The below code is depreciated and has been replaced by a better algorithm THAT ACTUALLY WORKS CORRECTLY
	/*public boolean checkWins(int player) {
		System.out.println("Player: "+player);
		int count = 0;

		vertical: for(int y = 0; y<HEIGHT; y++) {
			System.out.println("Vertical test "+y+" of "+HEIGHT+"-1");
			for(int x=0; x<WIDTH; x++) {
				if(board[x][y] == player) {
					count++;
					
					if(count>=4) {
						System.out.println("Player "+player+" won!");
						return true;
					}
				} else {
					count = 0;
				}
			}
		}

		count = 0;

		horizontal: for(int x = 0; x<WIDTH; x++) {
			System.out.println("Horizontal test "+x+" of "+WIDTH+"-1");
			for(int y = 0; y<HEIGHT; y++) {
				if(board[x][y] == player) {
					count++;	// If there is a break in this code, count will be reset

					if(count>=4) {
						System.out.println("Player "+player+" won!");
						return true;
					}	
				} else {
					count = 0;
				}
			}
		}

		
		count = 0;

		int y = HEIGHT-1;
		int x;
		diagonalDownRightA: for(int loop = 0; y>=0; loop++) {
			
			System.out.println("diagonalDownRightA test "+loop);
			x = 0;
			int otherY = y;
			
			while(x<=WIDTH-1 && otherY<=HEIGHT-1) {	// Go diagonally right downwards
				System.out.println("dDRA testing at "+x+","+otherY);
				if (board[x][otherY] == player) {
					count++;
					System.out.println("Found a result, count++");
					if(count>=4) {
						System.out.println("Player "+player+" won!");
						break diagonalDownRightA;
					}
				} else {
					count = 0;
				}
				x++; 
				otherY++;
				y = HEIGHT-1; // fixes skipping rows bug
			}
			count = 0;
			y-=loop;
			// start at (0,HEIGHT-1)
			// go up one row, x++ y++ until reached (WIDTH-1||HEIGHT-1)
			// go up one row, add one to x and y until reached a point of no return
			// repeat above until reached the top
			// when done checking for diagonals starting at (0,0)
			// go to the next collumn add one to x and y until reached a point of no return
			// go to the next collumn add one to x and y until reached a point of no return
			// same thing until done
		}

		count = 0;

		x = WIDTH-1;
		diagonalDownRightB: for(int loop = 0; x>=0; loop++) {
			System.out.println("diagonalDownRightB test "+loop);
			y = 0;
			int otherX = x; // =x

			while(y<=HEIGHT-1 && otherX<=WIDTH-1) {	// Go diagonally right downwards for other half of the board
				System.out.println("dDRB testing at "+otherX+","+y);
				if (board[otherX][y] == player) {
					count++;
					
					if(count>=4) {
						System.out.println("Player "+player+" won!");
						return true;
					}
				} else {
					count = 0;
				}
				y++; 
				otherX++;
				x = WIDTH-1;
			}
		count = 0;
		x-=loop;
		}
		
		y = HEIGHT-1;
		
		diagonalDownLeftA: for(int loop = 0; y>=0; loop++) {
			System.out.println("diagonalDownLeftA test "+loop);
			x = WIDTH-1;
			
			int otherY = y;
			
			while(x>=0 && otherY<=HEIGHT-1) {
				System.out.println("dDLA testing at "+x+","+otherY);
				if (board[x][otherY] == player) {
					count++;
					System.out.println("Found a result, count++");
					if(count>=4) {
						System.out.println("Player "+player+" won!");
						return true;
					}
				} else {
					count = 0;
				}
				x--; 
				otherY++;
				y = HEIGHT-1; // fixes skipping rows bug
			}
			count = 0;
			y-=loop;
			// start at (WIDTH-1,0)
			// go to the previous collumn. x-- y++ until reached (WIDTH-1||HEIGHT-1)
			// go up one row, subtract one from x but add one to y until reached a point of no return
			// go up one row, subtract one from x but add one to y until reached a point of no return
			// same thing until done
		}
		
		count = 0;

		x = WIDTH-1;
		diagonalDownLeftB: for(int loop = 0; x>=0; loop++) {
			System.out.println("diagonalDownLeftB test "+loop);
			y = 0;
			int otherX = x;

			while(y<=HEIGHT-1 && otherX>=0) {
				System.out.println("dDLB testing at "+otherX+","+y);
				if (board[otherX][y] == player) {
					count++;

					if(count>=4) {
						System.out.println("Player "+player+" won!");
						return true;
					}
				} else {
					count = 0;
				}
				y++; 
				otherX--;
				x = WIDTH-1;
			}
			count = 0;
			x-=loop;
		}
		return false;
	}*/
}
