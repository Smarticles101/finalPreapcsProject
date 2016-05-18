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
	private File f = null;
	private final String SAVE_FILE = "./saves/save.txt";

	public int[][] board;

	public Board(int w, int h, int np) {
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
	}

	public Board() {
		this(7,6,1);
	}

	public Board(int np) {
		this(7,6,np);
	}

	public void dropPiece(int x, int p) {
		int column = x-1;
		int row = height-1;
		while (board[row][column] != 0) {
			row--;
		}
		board[row][column] = p;
		//System.out.println("Player placed piece at: " + xwidth + "," + xheight);
		saveGame();								// game is always saved after a player moves
	}
	
	public int checkWin() {						// return 1 for win, 2 for draw
	    if(isDraw()) {
	    	deleteSave();
	    	return 2;
	    }
		
		for (int column = 0; column < width; column++) {
	        for (int row = 0; row < height; row++) {
	            if (board[row][column] != player) {
	            	continue; 
	            }
	                
	            if (column + 3 < width && player == board[row][column+1] && board[row][column] == board[row][column+2] && board[row][column] == board[row][column+3]) {
	                //System.out.println("Won horozontal");
	                deleteSave();
	                return 1; // won horozontal
	            }
	            
	            if (row + 3 < height) {
	                if (board[row][column] == board[row+1][column] && board[row][column] == board[row+2][column] && board[row][column] == board[row+3][column]) {
	                    //System.out.println("Won vertical");
	                    deleteSave();
	                    return 1; // won vertical
	                }
	                if (column + 3 < width && board[row][column] == board[row+1][column+1] && board[row][column] == board[row+2][column+2] && board[row][column] == board[row+3][column+3]) {
	                    //System.out.println("Won diag 1\nboard[row][column]=="+board[row][column]);
	                    deleteSave();
	                    return 1; // won diag 
	                }
	                if (column - 3 >= 0 && board[row][column] == board[row+1][column-1] && board[row][column] == board[row+2][column-2] && board[row][column] == board[row+3][column-3]) {
	                	//System.out.println("Won diag 2");   
	                	deleteSave();
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

	public int getPlayer() {														//////////////////////////////////
		return player;																//	Getter methods				//
	}																				//	aren't used that much now	//
																					//	might get used more later	//
	public int getWidth() {															//////////////////////////////////
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isAiGame() {
		return isAiGame;
	}

	public void resetGame() {									//////////////////////////////
		for(int column = 0; column < width; column++) {			//	Obsolete method			//
			for(int row = 0; row < height; row++) {				//	Left here as refrence	// 
				board[row][column] = 0;							//////////////////////////////
			}
		}
		player = 1;
	}

	public void aiMove() {
		try{
			int decision = Expo.random(1,width);									// get random column
			dropPiece(decision,2);													// put piece in random column
		} catch(ArrayIndexOutOfBoundsException e) {
			aiMove();																// catch the exception and recursively call the method again
		}
	}

	public void saveGame() {
		try {
			f = new File(SAVE_FILE);
			if(!f.exists()) {
				f.createNewFile();													// if save file does not exist, create it
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {																		// save game data here
            FileWriter fileWriter = new FileWriter(SAVE_FILE);						// Assume the default encoding

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);			// wrap FileWriter inside BufferedWriter 
            		//////////////////////////////////////
            		// write() does not automatically	//
            		// append a newline character.		//
            		//////////////////////////////////////
            bufferedWriter.write(player+"");										// write who's turn it is!
            bufferedWriter.newLine();
            bufferedWriter.write(isAiGame+"");										// write isAiGame boolean
            bufferedWriter.newLine();
            bufferedWriter.write(numPlayer+"");										// write the number of players
            bufferedWriter.newLine();
            bufferedWriter.write(height+"");     									// write rows
            bufferedWriter.newLine();
            bufferedWriter.write(width+"");  										// write columns
            bufferedWriter.newLine();

            for(int row = 0; row < height; row++) {
                for(int column = 0; column < width; column++) {
                    bufferedWriter.write(board[row][column]+",");
                }
                bufferedWriter.newLine();
            }

            // Always close files.
            bufferedWriter.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public void loadGame() {
        String line = null;
        int columns;
        int rows;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(SAVE_FILE);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            player = Integer.parseInt(bufferedReader.readLine());					// load who's turn it is!
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
                    c++;															// next column
                }
                c = 0;																// reset column number
                r++;																// next row
            }

            bufferedReader.close();         										// close the file!
        } catch(FileNotFoundException ex) {											//////////////////////////
            ex.printStackTrace();													//	Handle file			//
        } catch(IOException ex) {													//	exceptions			//
            ex.printStackTrace();													//////////////////////////
        }
	}
	
	public File[] getSaveFileList() {												//////////////////////////
		File folder = new File("./saves/");											//	Could be used to 	//
		File[] listOfFiles = folder.listFiles();									//	make a load game 	//
																					//	selection menu		//
		return listOfFiles;															//////////////////////////
	}

	public boolean saveExists() {
		try {
			f = new File(SAVE_FILE);
			if(f.exists()) {														// Does our save file exist?
				return true;														// if yes, return true
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}

		return false;																// otherwise.. return false
	}

	private void deleteSave() {
		try {
			f = new File(SAVE_FILE);
			f.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
