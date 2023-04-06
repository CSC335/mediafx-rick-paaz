package PlaySongDemo;

public class LineItem {

  // Adding a comment
  private int howMany;
  private double howMuch;

  public LineItem(int quantity, double price) {
    howMuch = price;
    howMany = quantity;
  }

  double lineItemTotal() {
    return Math.round(100 * howMany * howMuch) / 100.0;
  }

  public String toString() {
    return howMany + "@" + howMuch + " = $" + lineItemTotal();
  }
}