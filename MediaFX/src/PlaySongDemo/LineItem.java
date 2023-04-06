package PlaySongDemo;

public class LineItem {

  // Add another comment
  private int howMany;
  private double howMuch;

  public LineItem(int quantity, double price) {
    howMany = quantity;
    howMuch = price;
  }

  double lineItemTotal() {
    return Math.round(100 * howMany * howMuch) / 100.0;
  }

  public String toString() {
    return howMany + "@" + howMuch + " = $" + lineItemTotal();
  }
}