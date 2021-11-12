public class SaleItem {

	private MenuItem menuItem;
	private int quantity;

	/**
	 * 
	 * @param menuItem
	 */
	public SaleItem(MenuItem menuItem , int quantity) {
		menuItem = menuItem;
		quantity = quantity;
		// TODO - implement SaleItem.SaleItem
		//throw new UnsupportedOperationException();
	}

	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	/**
	 * 
	 * @param menuItem
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
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