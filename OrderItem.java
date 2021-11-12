import java.util.Scanner;

public class OrderItem {

	private MenuItem menuItem;
	private int quantity;
	private MenuManager globalMenuManager;

	public OrderItem() {
		// TODO - implement OrderItem.OrderItem
		//throw new UnsupportedOperationException();
	}

	public OrderItem(MenuItem item, int qty, MenuManager globalMenuManager){
		this.menuItem = item;
		this.quantity = qty;
		this.globalMenuManager = globalMenuManager;
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
		globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		System.out.println("Which item would you like to order?");
		int menuIndex = sc.nextInt();
		this.menuItem = globalMenuManager.getMenuItem(menuIndex-1);
		System.out.println("How many of this are you ordering?");
		int qty = sc.nextInt();
		this.quantity = sc.nextInt();
		System.out.println("Order item added. printing details...");
		this.printOrderItem();
		sc.close();
		// TODO - implement OrderItem.createOrderItem
		throw new UnsupportedOperationException();
	}

	public double calculatePrice() {
		// TODO - implement OrderItem.calculatePrice
		return menuItem.getPrice() * quantity;	
	}

	public void printOrderItem(){
		System.out.println(this.menuItem.getName()+" - "+this.calculatePrice());
	}
}