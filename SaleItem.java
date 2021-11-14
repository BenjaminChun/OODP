/**
 * Represents the Invoice Manager in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class SaleItem {

	/**
	 * The order item of this Sale Item.
	 */
	private OrderItem orderItem;
	/**
	 * The quantity of this Sale Item.
	 */
	private int quantity;

	/**
	 * Creates a sale item with a given quantity.
	 * @param orderItem Order Item of this Sale Item.
	 * @param quantity Quantity of this Sale Item.
	 */
	public SaleItem(OrderItem orderItem , int quantity) {
		this.orderItem = orderItem;
		this.quantity = quantity;
	}

	/**
	 * Gets the order item of this sale item.
	 * @return the order item of this sale item.
	 */
	public OrderItem getOrderItem() {
		return this.orderItem;
	}

	/**
	 * Changes the order item of this sale item.
	 * @param orderItem this sale item's order item.
	 */
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	/**
	 * Gets the quantity of this sale item.
	 * @return the quantity of this sale item.
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Changes the quantity of this sale item.
	 * @param quantity The quantity of this sale item.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Increase the quantity by a specified value.
	 * @param addition The specified value to be added.
	 */
    public void incrementQuantity(int addition) {
		this.quantity += addition;
    }

}