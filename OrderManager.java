import java.util.Scanner;
import java.util.ArrayList;

public class OrderManager {

	private ArrayList<Order> orderList;
	//private Customer customer; do we need this?

	public OrderManager(){ 
		orderList = new ArrayList<Order>();
	}

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
	 * 
	 * @param s
	 */
	public void createOrder() { //either we take in a Staff argument or ask for user input here to indicate staff eid and check from globalStaffManager
		Order temp = new Order();
		temp.makeNewOrder(); //order obj calls makeNewOrder that adds orderItems to the arrayList
		this.orderList.add(temp);
		System.out.println("Order created. printing new order...");
		temp.printOrder();
		// TODO - implement OrderManager.createOrder
		//throw new UnsupportedOperationException();
	}

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
			System.out.println("Order ipdated. printing updated order...");
			temp.printOrder();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
		
	}

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

	public Order getOrderListItem(int index) {
		Order order = this.orderList.get(index);
		return order;
		// TODO - implement MenuManager.getMenuItem
	}

	public int getSizeOfOrderList() {
		return this.orderList.size();
		// TODO - implement MenuManager.getSizeOfMenu
	}

}