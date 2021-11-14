import java.util.Scanner;

/**
 * Represents the Order Item in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class OrderItem {
	/**
	 * The menu item of this order item.
	 */
	private MenuItem menuItem;
	/**
	 * The quantity of this order item.
	 */
	private int quantity;
	
	public OrderItem() {
	}
	/**
	 * Creates an order item with a given quantity.
	 * @param item The menu item of this order item.
	 * @param qty The quantity of this order item.
	 */
	public OrderItem(MenuItem item, int qty){
		this.menuItem = item;
		this.quantity = qty;
	}

	/**
	 * Gets the menu item of this order item
	 * @return the menu item of this order item.
	 */
	public MenuItem getMenuItem() {
		return menuItem;
		// TODO - implement OrderItem.getMenuItem
	}

	/**
	 * Changes the menu item of this order item
	 * @param menuItem The menu item of this order item.
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	/**
	 * Gets the quantity of this order item.
	 * @return the quantity of this order item.
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Changes the quantity of this order item.
	 * @param qty the quantity of this order item.
	 */
	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	/**
	 * Creates an order item by scanning input for each attribute.
	 */
	public void createOrderItem() {
		Scanner sc = new Scanner(System.in);
		RestaurantApp.globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		try {
			System.out.println("Which item would you like to order?");
			int menuIndex = sc.nextInt();
			sc.nextLine();
			if (menuIndex <= 0 || menuIndex > RestaurantApp.globalMenuManager.getSizeOfMenu()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+RestaurantApp.globalMenuManager.getSizeOfMenu());
			}
			this.menuItem = RestaurantApp.globalMenuManager.getMenuItem(menuIndex-1);
			System.out.println("How many of this are you ordering?");
			this.quantity = sc.nextInt();
			sc.nextLine();
			System.out.println("Order item added. printing details...");
			this.printOrderItem();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Calculate the price of one entry of menu items.
	 * @return total price of the menu items in that entry.
	 */
	public double calculatePrice() {
		return menuItem.getPrice() * quantity;	
	}

	/**
	 * Show text of the calculation of one entry of the menu item list.
	 */
	public void printOrderItem(){
		System.out.print(this.quantity+" x "+this.menuItem.getName()+" ---- ");
		System.out.printf("$%.2f\n",this.calculatePrice());
	}
}