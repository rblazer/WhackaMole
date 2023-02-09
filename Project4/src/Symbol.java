/**
* Class repsenting a symbol with a point value.
* Also checks if the symbol has been clicked on.
* @author Ryan Blazer
* @version 11/09/2022
*/ 
public class Symbol {
    /** String variable representing the name of the Symbol */
    private String name;
    
    /** Integer variable representing the point value of the Symbol */
    private int points;
    
    /** Boolean variable representing the state of whether the symbol has
        been clicked on or not */
    private boolean hasBeenClickedOn;
    
    /**
    * Class constructor that builds a symbol using two parameters.
    * @param name the name of the symbol as a string
    * @param points the point value of the symbol representing as an int
    * @throws IllegalArgumentException if the name is null or point value is less than
    * one.
    */
    public Symbol(String name, int points) {
        if (name == null) {
            throw new IllegalArgumentException("Null name");
        }
        
        if (points < 1) {
            throw new IllegalArgumentException("Invalid points");
        }
        // Intializing our class fields using this keyword.
        this.name = name;
        this.points = points;
        this.hasBeenClickedOn = false;
    }
    
    /**
    * Getter method for the name.
    * @return name the name of the symbol as a string
    */
    public String getName() {
        // Retrieving the name field.
        return this.name;
    }
    
    /**
    * Getter method for the points.
    * @return the point value of the symbol representing as an int
    */
    public int getPoints() {
        // Retrieving the points field.
        return this.points;
    }
    
    /**
    * Getter method for the checker boolean
    * @return either true or false depending on if it has been clicked on.
    */
    public boolean hasBeenClickedOn() {
        // Retreiving the hasBeenClickedOn field.
        return this.hasBeenClickedOn;
    }
    
    /**
    * setter method for the checker boolean
    * @param hasBeenClickedOn value true or false, whatever the user wants.
    */
    public void setHasBeenClickedOn(boolean hasBeenClickedOn) {
        // Setting our hasBeenClickedOn field to our parameter.
        this.hasBeenClickedOn = hasBeenClickedOn;
    }
    
    /**
    * Checks if a Symbol is equal to another symbol
    * @param o any object we are comparing our symbol object against.
    * @return boolean either true or false is the symbol is exactly equal.
    */
    public boolean equals(Object o) {
        // if O is an instance of this Symbol class
        if (o instanceof Symbol) {
            // Make a new symbol to compare against.
            Symbol other = (Symbol) o;
            // If their name, point value, and boolean value are the same, set  true.
            if (this.name == other.getName() && this.points == other.getPoints()
                && this.hasBeenClickedOn == other.hasBeenClickedOn()) {
                return true;
            } else { // return false if values are not the same.
                return false;
            }
        } else { // return false if it is a different object.
            return false;
        }
    }
    
    /**
    * the creator for a string representation of a Symbol
    * @return a string displaying the name, points, and clickedOn boolean value.
    */
    public String toString() {
        // Line outline for a string representation.
        String line = "%s %d %s";
        // Formatting line with our desired field elements.
        return String.format(line, this.name, this.points, this.hasBeenClickedOn);
    }
} 