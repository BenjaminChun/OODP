import java.util.Scanner;

public class OrderItem {

	private MenuItem menuItem;
	private int quantity;

	public OrderItem() {
	}

	public OrderItem(MenuItem item, int qty){
		this.menuItem = item;
		this.quantity = qty;
	}

	public MenuItem getMenuItem() {
		return menuItem;
		// TODO - implement OrderItem.getMenuItem
	}

	/**
	 * 
	 * @param menuItem
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		// TODO - implement OrderItem.getQuantity
		return this.quantity;
	}

	/**
	 * 
	 * @param qty
	 */
	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	public void createOrderItem() {
		Scanner sc = new Scanner(System.in);
		RestaurantApp.globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		System.out.println("Which item would you like to order?");
		int menuIndex = sc.nextInt();
		this.menuItem = RestaurantApp.globalMenuManager.getMenuItem(menuIndex-1);
		System.out.println("How many of this are you ordering?");
		int qty = sc.nextInt();
		this.quantity = sc.nextInt();
		System.out.println("Order item added. printing details...");
		this.printOrderItem();
		sc.close();
	}

	public double calculatePrice() {
		return menuItem.getPrice() * quantity;	
	}

	public void printOrderItem(){
		System.out.println(this.menuItem.getName()+" - "+this.calculatePrice());
	}
}