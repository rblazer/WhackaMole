import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Symbol class
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Ryan Blazer
 */
public class SymbolTest { 

    /** Symbol giraffe for testing */
    private Symbol giraffe;
    
    /** Symbol monkey for testing */
    private Symbol monkey;

    /**
     * Create Symbols for testing
     */
    @BeforeEach
    public void setUp() {
        giraffe = new Symbol("giraffe", 25);
        monkey = new Symbol("monkey", 30);
    }

    /**
    * Testing getName() for Symbol giraffe.
    */ 
    @Test
    public void testGetNameGiraffe() {
        assertEquals("giraffe", giraffe.getName(), "giraffe name");
    }
    
    /**
    * Testing getName() for Symbol monkey.
    */ 
    @Test
    public void testGetNameMonkey() {
        assertEquals("monkey", monkey.getName(), "monkey name");
    }

    /**
    * Testing getPoints() for Symbol giraffe.
    */ 
    @Test
    public void testGetPointsGiraffe() {
        assertEquals(25, giraffe.getPoints(), "giraffe points");
    }     
    
    /**
    * Testing getPoints() for Symbol monkey.
    */ 
    @Test
    public void testGetPointsMonkey() {
        assertEquals(30, monkey.getPoints(), "monkey points");
    }
    
    /**
    * Testing toString() for Symbol giraffe.
    */ 
    @Test
    public void testToStringGiraffe() {
        assertEquals("giraffe 25 false", giraffe.toString(), "giraffe toString");        
    }
    
    /**
    * Testing toString() for Symbol monkey.
    */ 
    @Test
    public void testToStringMonkey() {
        assertEquals("monkey 30 false", monkey.toString(), "monkey toString");
    }
    
    /**
    * Testing hasBeenClickedOn() for Symbol giraffe.
    */ 
    @Test
    public void testHasBeenClickedOnGiraffe() {
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe hasBeenClickedOn");
    }
    
    /**
    * Testing hasBeenClickedOn() for Symbol monkey.
    */ 
    @Test
    public void testHasBeenClickedOnMonkey() {
        assertFalse(monkey.hasBeenClickedOn(), "monkey hasBeenClickedOn");
    }
    
    /**
    * Testing setHasBeenClickedOn() for Symbol giraffe.
    */ 
    @Test
    public void testSetHasBeenClickedOnGiraffe() {
        giraffe.setHasBeenClickedOn(true);
        assertTrue(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn true");
        giraffe.setHasBeenClickedOn(false);
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn false");
    }
    
    /**
    * Testing setHasBeenClickedOn() for Symbol monkey.
    */ 
    @Test
    public void testSetHasBeenClickedOnMonkey() {
        monkey.setHasBeenClickedOn(true);
        assertTrue(monkey.hasBeenClickedOn(), "monkey setHasBeenClickedOn true");
        monkey.setHasBeenClickedOn(false);
        assertFalse(monkey.hasBeenClickedOn(), "monkey setHasBeenClickedOn false"); 
    }

    /**
    * Testing equals(Object o) for Symbol giraffe.
    */ 
    @Test
    public void testEqualsGiraffe() {
        assertTrue(giraffe.equals(giraffe), "giraffe equals with same instance");
        assertTrue(giraffe.equals(new Symbol("giraffe", 25)), 
                   "giraffe equals with different instances");
        assertFalse(giraffe.equals(new Symbol("cow", 25)), "giraffe with different name");
        assertFalse(giraffe.equals(new Symbol("giraffe", 4)), "giraffe with different points");
        assertFalse(giraffe.equals(new Symbol("horse", 5)), 
                    "giraffe with different name and points");
        assertFalse(giraffe.equals(null), "giraffe compared to null object");
        assertFalse(giraffe.equals("giraffe"), "giraffe compared to String");
    }
    
    /**
    * Testing equals(Object o) for Symbol monkey.
    */ 
    @Test
    public void testEqualsMonkey() {
        assertTrue(monkey.equals(monkey), "monkey equals with same instance");
        assertTrue(monkey.equals(new Symbol("monkey", 30)),
                    "monkey equals with different instances");
        assertFalse(monkey.equals(new Symbol("bird", 30)), "monkey with different name");
        assertFalse(monkey.equals(new Symbol("monkey", 3)), "monkey with different points");
        assertFalse(monkey.equals(new Symbol("dog", 2)),
                    "monkey with different name and points");
        assertFalse(monkey.equals(null), "monkey compared to null object");
        assertFalse(monkey.equals("monkey"), "monkey compared to String");
    }
    

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        
        // Testing constructor with null name
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol(null, 1), "Constructor name null");
        assertEquals("Null name", exception.getMessage(),
                "Testing null name message");
                
        // Testing constructor with 0 points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("snake", 0), "Constructor points 0");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing points 0 message");
                
        // Testing constructor with negative points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("frog", -5), "Constructor points -5");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing negative points message");
                
    }

}
