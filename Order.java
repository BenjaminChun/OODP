import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents an Order in a restaurant.
 * @author Tan Zheng Kai
 * @version 2.0
 * @since 2021-11-13
 */
public class Order {

	private ArrayList<OrderItem> orderItemList;
	private Staff s;
	private OrderDetails orderDetails;

	/**
	 * Creates a new order after taking in name of staff. 
	 * @param s This Order's staff.
	 */
	public Order() {
		this.orderItemList = new ArrayList<OrderItem>();
		RestaurantApp.globalStaffManager.displayList();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Who's taking this order?");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice <= 0 || choice > RestaurantApp.globalStaffManager.getSizeOfStaffList()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+RestaurantApp.globalStaffManager.getSizeOfStaffList());
			}
			this.s = RestaurantApp.globalStaffManager.getStaff(choice-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
		this.orderDetails = new OrderDetails(this);
	}
	/**
	 * Creates a new order item into the order list.
	 */
	public void makeNewOrder(){
		Scanner sc = new Scanner(System.in);
		int createChoice = 0;
		while (createChoice < 2){
			System.out.println("What would you like to do?");
			System.out.println("1. add order items 2. quit");
			createChoice = sc.nextInt();
			sc.nextLine();
			if (createChoice == 1){
				this.addToOrder(); 
			}
		}
	}

	/**
	 * Adds or remove an order item into the list.
	 */
	public void updateOrder(){
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1. add order item 2. remove order item");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) this.addToOrder();
		else this.deleteFromOrder();
	}
	/**
	 * Calls creates order item and adds it into the order item list.
	 */
	public void addToOrder() { //calls createOrderItem from OrderItem and adds it to orderItemList
		OrderItem temp = new OrderItem();
		temp.createOrderItem();
		this.orderItemList.add(temp);
	}

	/**
	 * Deletes an order item from order item list.
	 */
	public void deleteFromOrder() {
		Scanner sc = new Scanner(System.in);
		this.printOrder();
		try {
			System.out.println("Which order item would you like to delete?");
			int orderItemIndex = sc.nextInt();
			sc.nextLine();
			if (orderItemIndex <= 0 || orderItemIndex > this.orderItemList.size()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.orderItemList.size());
			}
			this.orderItemList.remove(orderItemIndex - 1); //delete the index - 1 orderItem from this order
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Calculates the base price of all order items.
	 * @return the base price of all order items.
	 */
	public double calculateBasePrice() {
		int orderSize = this.orderItemList.size();
		double basePrice = 0;
		for(int i = 0; i<orderSize; i++){
			basePrice += this.orderItemList.get(i).calculatePrice(); //iterates list and adds to basePrice the orderItems in order
		}
		return basePrice;
	}

	/**
	 * Prints out every order item in this order.
	 */
	public void printOrder() {
		int orderSize = this.orderItemList.size();
		System.out.println("Staff Name: " + this.s.getName());//should this be a print function of staff?
		System.out.println("----------------------------------------------");
		for(int i = 0; i<orderSize; i++){
			System.out.print((i+1) + ". ");
			this.orderItemList.get(i).printOrderItem();
			System.out.println("----------------------------------------------");
		}
		System.out.println();
	}
	
	/**
	 * Gets order details of this order.
	 * @return the order details of this Order.
	 */
	public OrderDetails getOrderDetails() {
		return this.orderDetails;
	}

	/**
	 * Changes order details of this order.
	 * @param orderDetails The order details of this order 
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	/**
	 * Gets the staff of this order.
	 * @return this order's staff.
	 */
	public Staff getStaff(){
		return this.s;
	}

	/**
	 * Changes the staff of this order.
	 * @param staff This order's staff.
	 */
	public void setStaff(Staff staff){
		this.s = staff;
	}

	/**
	 * Gets the order item list of this order.
	 * @return the order item list of this order.
	 */
    public ArrayList<OrderItem> getOrderItemList() {
        return this.orderItemList;
    }
}