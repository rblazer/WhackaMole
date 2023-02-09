public class SymbolDemo {
  public static void main(String[] args) {
    Symbol square = new Symbol("Square", 10);
    Symbol treasure = new Symbol("Treasure", 1000);
    
    // Should output "Square 10 false"
    System.out.println(square);
    
    // Should output "Square 10 true"
    square.setHasBeenClickedOn(true);
    System.out.println(square);
    
    // Should output "Treasure 1000 false"
    System.out.println(treasure);
    
    // Should output "false"
    System.out.println(treasure.hasBeenClickedOn());
    
    // Should output "true"
    System.out.println(treasure.equals(treasure));
    
    // Should output "false"
    System.out.println(treasure.equals(square));
    
  }
}