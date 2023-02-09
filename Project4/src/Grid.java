/**
* Class representing a 2D Grid of Symbols.
* @author Ryan Blazer
* @version 11/09/2022
*/ 
public class Grid {
    /** Integer variable representing the number of rows */
    private int rows;
    
    /** Integer variable representing the number of columns */
    private int cols;
    
    /** Symbol variable representing a 2D array of Symbol objects */
    private Symbol[][] symbols;
    
    /**
    * Class constructor that builds grid using our row and col field
    * @param rows an integer greater than or equal to 1 that is the number of rows.
    * @param cols an integer greater than or equal to 1 that is the number of columns.
    * @throws IllegalArgumentException if rows or cols is less than 1.
    */
    public Grid(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Invalid rows/cols");
        }
        // Setting our fields to the passed row and col.
        this.rows = rows;
        this.cols = cols;
        // Intializing our 2D array field with a size of row * col total squares.
        this.symbols = new Symbol[rows][cols];
    }
    
    /**
    * Getter method for the number of rows.
    * @return an integer value representing the number of rows.
    */
    public int getRows() {
        // Getting our row field value.
        return this.rows;
    }
    
    /**
    * Getter method for the number of columns.
    * @return an integer value representing the number of columns.
    */
    public int getCols() {
        // Getting our col field value.
        return this.cols;
    }
    
    /**
    * Sets an index in the 2D array to a particular symbol.
    * @param row an integer representing which row index we want
    * @param col an integer representing which column index we want.
    * @param symbol a symbol object consisting of a name and a point value.
    * @throws IllegalArgumentException if symbol is null, row or col is less than zero or 
    * greater than or equal to the row/col field.
    */
    public void setSymbol(int row, int col, Symbol symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Null symbol");
        }
        if (row < 0 || row >= getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Setting a particular index to the passed symbol.
        this.symbols[row][col] = symbol;
    }
    
    /**
    * A getter method for a symbol at a particular index in the 2D array
    * @param row an integer representing which row index we want
    * @param col an integer representing which column index we want.
    * @return A symbol object at the desired row/col indexes.
    * @throws IllegalArgumentException if row/col is less than zero or 
    * greater than or equal to the row/col field.
    */
    public Symbol getSymbol(int row, int col) {
        if (row < 0 || row >= getRows()) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= getCols()) {
            throw new IllegalArgumentException("Invalid col");
        }
        // Returning a particular symbol at the passed row and col index
        return this.symbols[row][col];
    }
    
    /**
    * A string representation of the grid consisting only of names.
    * @return the string representation of a grid of 2D names.
    */ 
    public String toString() {
        // Our output string
        String output = "";
        // Formatting string for each subsequent name string.
        String line = "%s";
        // Looping through the 2D array and collecting symbol names.
        for (int i = 0; i < this.symbols.length; i++) {
            for (int j = 0; j < this.symbols[i].length; j++) {
                if (j != this.symbols[i].length - 1) {
                    // If we are not on the last column, get the name and add a space.
                    output += String.format(line, symbols[i][j].getName()) + " ";
                } else
                {
                    // If we ARE on the last column, get the name and add a NEW line.
                    output += String.format(line, symbols[i][j].getName()) + "\n";
                }
                
            }
        }
        return output;
    }
    
    
}