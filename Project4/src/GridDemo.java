public class GridDemo {
  public static void main(String[] args) {
    // Building a simple 3x3 grid
    Grid grid = new Grid(3, 3);

    // Adding symbols to grid
    grid.setSymbol(0, 0, new Symbol("Start", 1));
    grid.setSymbol(0, 1, new Symbol("Tile", 1));
    grid.setSymbol(0, 2, new Symbol("Tile", 1));

    grid.setSymbol(1, 0, new Symbol("Wall", 1));
    grid.setSymbol(1, 1, new Symbol("Wall", 1));
    grid.setSymbol(1, 2, new Symbol("Key", 100));

    grid.setSymbol(2, 0, new Symbol("Goal", 900));
    grid.setSymbol(2, 1, new Symbol("Door", 1));
    grid.setSymbol(2, 2, new Symbol("Tile", 100));

    // Should print
    /*
      Start Tile Tile
      Wall Wall Key
      Goal Door Tile
    */
    System.out.println(grid);

    // Should print "Start 1 false"
    System.out.println(grid.getSymbol(0,0));

    // Should print "Goal 900 false"
    System.out.println(grid.getSymbol(2,0));
  }  
}