public class SaleItem {

	private OrderItem orderItem;
	private int quantity;

	/**
	 * 
	 * @param menuItem
	 */
	public SaleItem(OrderItem orderItem , int quantity) {
		this.orderItem = orderItem;
		this.quantity = quantity;
		// TODO - implement SaleItem.SaleItem
		//throw new UnsupportedOperationException();
	}

	public OrderItem getOrderItem() {
		return this.orderItem;
	}

	/**
	 * 
	 * @param menuItem
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.orderItem = orderItem;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    public void incrementQuantity(int addition) {
		this.quantity += addition;
    }

}