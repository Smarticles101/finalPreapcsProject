import java.util.Arrays;
import java.io.*;

/**
 * @since 0.1.0
 */
class Board {
	private int width;
	private int height;
	private int player = 1; 					// Always start at player 1
	private int numPlayer;
	private boolean isAiGame;
	private String saveFile;
	private File f = null;

	public int[][] board;

	public Board(int w, int h, int np, String sf) {
		board = new int[h][w];
		width = board[0].length;
		height = board.length;
		if(np == 1) {
			isAiGame = true;
			numPlayer = 2;
		} else {
			isAiGame = false;
			numPlayer = np;
		}
		loadGame(sf);
	}

	public Board() {
		this(7,6,1,"save");
	}

	public Board(int np) {
		this(7,6,np,"save");
	}

	public void dropPiece(int x, int p) {
		int column = x-1;
		int row = height-1;
		while (board[row][column] != 0) {
			row--;
		}
		board[row][column] = p;
		//System.out.println("Player placed piece at: " + xwidth + "," + xheight);
	}
	
	public int checkWin() {						// return 1 for win, 2 for draw
	    if(isDraw()) {
	    	return 2;
	    }
		
		for (int column = 0; column < width; column++) {
	        for (int row = 0; row < height; row++) {
	            if (board[row][column] != player) {
	            	continue; 
	            }
	                
	            if (column + 3 < width && player == board[row][column+1] && board[row][column] == board[row][column+2] && board[row][column] == board[row][column+3]) {
	                //System.out.println("Won horozontal");
	                return 1; // won horozontal
	            }
	            
	            if (row + 3 < height) {
	                if (board[row][column] == board[row+1][column] && board[row][column] == board[row+2][column] && board[row][column] == board[row+3][column]) {
	                    //System.out.println("Won vertical");
	                    return 1; // won vertical
	                }
	                if (column + 3 < width && board[row][column] == board[row+1][column+1] && board[row][column] == board[row+2][column+2] && board[row][column] == board[row+3][column+3]) {
	                    //System.out.println("Won diag 1\nboard[row][column]=="+board[row][column]);
	                    return 1; // won diag 
	                }
	                if (column - 3 >= 0 && board[row][column] == board[row+1][column-1] && board[row][column] == board[row+2][column-2] && board[row][column] == board[row+3][column-3]) {
	                	//System.out.println("Won diag 2");   
	                	return 1; // won diag
	                }
	            }
	        }
	    }
	    return 0;
	}
	
	private boolean isDraw() {
		for(int column = 0; column < width; column++) {
			for(int row = 0; row < height; row++) {
				if(board[row][column] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void changePlayer() {
		if(player<numPlayer) {
			player++;
		} else {
			player = 1;
		}
	}

	public int getPlayer() {
		return player;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isAiGame() {
		return isAiGame;
	}

	public void resetGame() {
		for(int column = 0; column < width; column++) {
			for(int row = 0; row < height; row++) {
				board[row][column] = 0;
			}
		}
		player = 1;
	}

	public void aiMove() {
		try{
			int decision = Expo.random(1,width);
			dropPiece(decision,2);
		} catch(ArrayIndexOutOfBoundsException e) {
			aiMove();
		}
	}
	
	public void saveGame() {
		try {
			f = new File("./saves/"+saveFile);
			if(!f.exists()) {
				f.createNewFile();													// if save file does not exist, create it
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {																		// save game data here
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter("./saves/"+saveFile);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            

            // Note that write() does not automatically
            // append a newline character.

            bufferedWriter.write(isAiGame+"");										// write isAiGame boolean
            bufferedWriter.newLine();
            bufferedWriter.write(numPlayer+"");										// write the number of players
            bufferedWriter.newLine();
            bufferedWriter.write(height+"");     									// write rows
            bufferedWriter.newLine();
            bufferedWriter.write(width+"");  										// write columns
            bufferedWriter.newLine();

            for(int column = 0; column < width; column++) {
                for(int row = 0; row < height; row++) {
                    bufferedWriter.write(board[row][column]+",");
                }
                bufferedWriter.newLine();
            }

            // Always close files.
            bufferedWriter.close();
        } catch(IOException ex) {
            System.out.println("Error writing to file '"+ saveFile + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
	
	public void loadGame(String fileName) {
		saveFile = fileName+".txt";
		
        String line = null;
        int columns;
        int rows;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            isAiGame = Boolean.parseBoolean(bufferedReader.readLine());				// load isAiGame
            numPlayer = Integer.parseInt(bufferedReader.readLine());				// load number of players
            rows = Integer.parseInt(bufferedReader.readLine());						// load rows
            columns = Integer.parseInt(bufferedReader.readLine());					// load columns
            board = new int[rows][columns];											// create board
    		width = board[0].length;												// set width
    		height = board.length;													// set height
            int r = 0;
            int c = 0;

            while((line = bufferedReader.readLine()) != null) {						// iterate lines
                for (String retval: line.split(",")){								// for each value
                    board[r][c] = Integer.parseInt(retval);							// load value into board
                    r++;															// next row
                }
                r = 0;																// reset row number
                c++;																// next column
            }

            bufferedReader.close();         										// close the file!
        } catch(FileNotFoundException ex) {											//////////////////////////
            ex.printStackTrace();													//	Handle file			//
        } catch(IOException ex) {													//	exceptions			//
            ex.printStackTrace();													//////////////////////////
        }
	}
	
	public File[] getSaveFileList() {
		File folder = new File("./saves/");
		File[] listOfFiles = folder.listFiles();
		
		return listOfFiles;
	}
}
