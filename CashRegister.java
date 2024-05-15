/**
 * Constructs a cash register with cleared item count and total.
 */
public class CashRegister {
    private int itemCount;
    private double totalPrice;


    public CashRegister() {
        itemCount = 0;
        totalPrice = 0; }

    /**
     * Adds an item to this cash register.
     * @param price the price of this item
     */
    public void addItem(double price) {
        itemCount++;
        totalPrice = totalPrice + price;
    }
    /**
     * Gets the price of all items in the current sale.
     * @return the total price
     */
    public double getTotal() {
        return totalPrice;
    }
    /**
     * Gets the number of items in the current sale.
     * @return the item count
     */
    public int getCount() {
        return itemCount;
    }
    /**
     * Clears the item count and the total.
     */
    public void clear() {
        itemCount = 0;
        totalPrice = 0;
    }
}
