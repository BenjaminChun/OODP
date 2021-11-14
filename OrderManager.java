import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents an order manager in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class OrderManager {

	/**
	 * The list of orders of this order manager.
	 */
	private ArrayList<Order> orderList;
	//private Customer customer; do we need this?

	/**
	 * Creates a new order manager.
	 */
	public OrderManager(){ 
		orderList = new ArrayList<Order>();
	}

	/**
	 * Removes an order from the list of orders of this order manager.
	 */
	public void cancelOrder() {
		Scanner sc = new Scanner(System.in);
		this.printOrderList();
		try {
			System.out.println("Which order would you like to cancel?");
			int orderIndex = sc.nextInt();
			sc.nextLine();
			if (orderIndex <= 0 || orderIndex > this.orderList.size()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.orderList.size());
			}
			this.orderList.remove(orderIndex - 1); //remove the index - 1 order from orderList
			System.out.println("Order #" + orderIndex +" cancelled");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Creates an order and adds it into the order list.
	 */
	public void createOrder() {
		Order temp = new Order();
		//order obj calls makeNewOrder that adds orderItems to the arrayList
		temp.makeNewOrder(); 
		this.orderList.add(temp);
		System.out.println("Order created. printing new order...");
		temp.printOrder();
	}

	/**
	 * Change the order in the list of orders of this order manager.
	 */
	public void changeOrder() {
		Scanner sc = new Scanner(System.in);
		this.printOrderList();
		try {
			System.out.println("Which order would you like to change?");
			int changeChoice = sc.nextInt();
			sc.nextLine();
			if (changeChoice <= 0 || changeChoice > this.orderList.size()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.orderList.size());
			}
			Order temp = this.orderList.get(changeChoice-1);
			temp.updateOrder();
			System.out.println("Order Updated. printing updated order...");
			temp.printOrder();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
		
	}

	/**
	 * Prints out the order list in this order manager.
	 */
	public void printOrderList() {
		int orderListSize = this.orderList.size();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		for(int i = 0; i<orderListSize; i++){
			System.out.println("Order Number "+ (i+1) + ": ");
			this.orderList.get(i).printOrder();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++"); //separator between orders
		}
		System.out.println();
		//throw new UnsupportedOperationException();
		// TODO - implement OrderManager.viewOrderList
	}

	/**
	 * Gets an order item from the order list of this Order Manager with a given index.
	 * @param index The index of the order in the order list.
	 * @return the order of the given index.
	 */
	public Order getOrderListItem(int index) {
		Order order = this.orderList.get(index);
		return order;
		// TODO - implement MenuManager.getMenuItem
	}

	/**
	 * Gets the size of the orderlist of this order manager.
	 * @return the size of the order list.
	 */
	public int getSizeOfOrderList() {
		return this.orderList.size();
		// TODO - implement MenuManager.getSizeOfMenu
	}

}