import java.util.Random;

/**
* The game manager for the WhackaMole Game.
* @author Ryan Blazer
* @version 11/20/22
*/
public class WhackaMole {
    /** Integer variable representing the number of rows */
    public static final int ROWS = 5;

    /** Integer variable representing the number of columns */
    public static final int COLS = 5;
    
    /** String array variable representing the names of all symbols in the game */
    public static final String[][] SYMBOL_NAMES = {{"cat", "dog", "tiger", "frog", "cat"}, 
                                                   {"tiger", "lion", "dog", "tiger", "frog"},
                                                   {"lion", "frog", "mole",  "dog", "cat"},
                                                   {"frog", "dog", "tiger", "cat", "lion"},
                                                   {"cat", "frog", "lion", "dog", "tiger"}};
                                                    
    /** Integer array variable representing the point values of all symbols */
    public static final int[][] SYMBOL_POINTS = {{10, 15, 30, 20, 10},
                                                 {30, 40, 15, 30, 20},
                                                 {40, 20, 50, 15, 10},
                                                 {20, 15, 30, 10, 40},
                                                 {10, 20, 40, 15, 30}};
    
    /** Boolean variable representing the testing state */    
    private boolean testing;
    
    /** Integer variable representing the total game score*/
    private int totalScore;
    
    /** Integer variable representing the number of total misses */
    private int numberOfMisses;
    
    /** Grid object variable representing the grid object and the grid in game */
    private Grid grid;
    
    /** Rand object variable representing the random number generator */
    private Random rand;
    
    /** Integer variable representing the next row to be displayed */
    private int nextRow;
    
    /** Integer variable representing the next column to be displayed */
    private int nextCol;
    
    /**
    * Class constructor, setups the grid and intializes game state and starting points.
    * @param testing checks if the game will be in testing mode or not. 
    */ 
    public WhackaMole(boolean testing) {
        // Sets testing mode 
        this.testing = testing;
        // Creating the game board (grid object).
        this.grid = new Grid(ROWS, COLS);
        // Filling grid with new symbols based on class variables.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.grid.setSymbol(i, j, new Symbol(SYMBOL_NAMES[i][j], SYMBOL_POINTS[i][j]));
            }
        }
        // Setting starting point if in testing mode.
        if (testing == true) {
            this.nextRow = 0;
            this.nextCol = 0;
        }
        // Setting starting point if NOT in testing mode.
        if (testing == false) {
            // Creating random number generator.
            this.rand = new Random();
            this.nextRow = this.rand.nextInt(ROWS);
            this.nextCol = this.rand.nextInt(COLS);
        }
        
    }
    
    /**
    * Getter method for the total score.
    * @return the total score at the point of calling.
    */
    public int getTotalScore() {
        return this.totalScore;
    }
    
    /**
    * Getter method for the number of misses.
    * @return numberOfMisses, the number of misses at the point of calling.
    */
    public int getNumberOfMisses() {
        return this.numberOfMisses;
    }
    
    /**
    * Getter method for the next row to be displayed
    * @return nextRow, the next row to be displayed at the point of calling.
    */
    public int getNextRow() {
        return this.nextRow;
    }
    
    /**
    * Getter method for the next column to be displayed
    * @return nextCol, the next column to be displayed at the point of calling.
    */
    public int getNextCol() {
        return this.nextCol;
    }
    
    /**
    * Retrieve a symbols name at a given row and column (square).
    * @param row an integer representing the index for the row on the grid object
    * @param col an integer representing the idnex for the column on the grid object
    * @return the string field representing the symbol's name.
    * @throws IllegalArgumentException if row/col is less than zero or greater than
    * or equal to the rows/col field in the grid object.
    */
    public String getSymbolName(int row, int col) {
        if (row < 0 || row >= grid.getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if (col < 0 || col >= grid.getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Returning symbol name field from the symbol object
        return this.grid.getSymbol(row, col).getName();
    }
    
    /**
    * Retrieve a symbols point value at a given row and column (square).
    * @param row an integer representing the index for the row on the grid object
    * @param col an integer representing hte idnex for the column on the grid object
    * @return the integer field representing the symbol's point value.
    * @throws IllegalArgumentException if row/col is less than zero or greater than
    * or equal to the rows/col field in the grid object.
    */
    public int getSymbolPoints(int row, int col) {
        if (row < 0 || row >= grid.getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if (col < 0 || col >= grid.getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Returning symbol point value from symbol object.
        return this.grid.getSymbol(row, col).getPoints();
    }
    
    /**
    * Retrieve a symbol's clicked on state at a given row and column (square).
    * @param row an integer representing the index for the row on the grid object
    * @param col an integer representing the idnex for the column on the grid object
    * @return the boolean state representing click status
    * @throws IllegalArgumentException if row/col is less than zero or greater than
    * or equal to the rows/col field in the grid object.
    */
    public boolean hasBeenClickedOn(int row, int col) {
        if (row < 0 || row >= grid.getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if (col < 0 || col >= grid.getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Returning boolean state from symbol object.
        return this.grid.getSymbol(row, col).hasBeenClickedOn();
    }
    
    /**
    * Checks if all symbols in the grid have been clicked on
    * @return a boolean value true if all have been clicked on, false otherwise.
    */
    public boolean allSymbolsClickedOn() {
        // Intializing a variable to keep count.
        int count = 0;
        // Traversing the grid checking if each
        // square has been clicked on or not.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (hasBeenClickedOn(i, j)) {
                    count++;
                }
            }
        }
        // if count equals total number of squares
        if (count == ROWS * COLS) {
            return true;
        }
        return false;
    }
    
    /**
    * Updates the next row/col to be displayed on the grid after a user clicks.
    */
    private void updateNextRowAndCol() {
        // IsSymbol checks if a valid symbol has been clicked on.
        boolean isSymbol = false;
        if (allSymbolsClickedOn() == true) {
            // Don't display any more.
            this.nextRow = -1;
            this.nextCol = -1;
            
            
        } else if (this.testing == true) {
            // While we don't have a symbol.
            // Increments rows/cols sequentially
            while (isSymbol == false) {
                this.nextCol += 1;
                if (this.nextCol == COLS) {
                    this.nextCol = 0;
                    this.nextRow += 1; 
                }
                if (this.nextRow == ROWS) {
                    this.nextRow = 0;
                } // Exit loop when we do have a valid symbol.
                if (hasBeenClickedOn(this.nextRow, this.nextCol) == false) {
                    isSymbol = true;
                }
            }
        } else {
            isSymbol = false;
            while (isSymbol == false) {
                // Randomize next position
                this.nextRow = this.rand.nextInt(ROWS);
                this.nextCol = this.rand.nextInt(COLS);
                if (hasBeenClickedOn(this.nextRow, this.nextCol) == false) {
                    isSymbol = true;
                }
            }
        }
    
        
    }
   
   /**
   * Called when a user clicks, setting click status to true, and adds to the total score.
   * @param row an integer representing the index for the row on the grid object
   * @param col an integer representing hte idnex for the column on the grid object
   * @throws IllegalArgumentException if row/col is less than zero or greater than
   * or equal to the rows/col field in the grid object.
   */
    public void clickOnSymbol(int row, int col) {
        if (row < 0 || row >= grid.getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if (col < 0 || col >= grid.getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Setting point value and boolean when a symbol is clicked on.
        if (hasBeenClickedOn(row, col) == false) {
            this.grid.getSymbol(row, col).setHasBeenClickedOn(true);
            this.totalScore += getSymbolPoints(row, col);
            updateNextRowAndCol();
        }
    }
   
   /**
   * Adds to the total misses when called and updates the next row/col.
   */ 
    public void addMiss() {
        this.numberOfMisses += 1;
        updateNextRowAndCol();
    }
   
   /**
   * Getter method for the grid object.
   * @return grid, the grid object representing the game board.
   */
    public Grid getGrid() {
        return this.grid;
    }
   
}