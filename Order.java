import java.util.Scanner;
import java.util.ArrayList;

public class Order {

	private ArrayList<OrderItem> orderItemList;
	private Staff s;
	//private Date date; not sure if needed
	private OrderDetails orderDetails;

	/**
	 * 
	 * @param s
	 */
	public Order(Staff s) {
		// TODO - implement Order.Order
		this.orderItemList = new ArrayList<OrderItem>();
		//this.orderItemList.add(globalMenuManager.getMenuItem(0), 5) globalMenuManager needs to be implemented before Order
		this.s = s;
		this.orderDetails = new OrderDetails(this);
		//throw new UnsupportedOperationException();
	}

	public void makeNewOrder(){
		Scanner sc = new Scanner(System.in);
		int createChoice = 0;
		while (createChoice < 2){
			System.out.println("What would you like to do?");
			System.out.println("1. add order items 2. quit");
			createChoice = sc.nextInt();
			if (createChoice == 1){
				this.addToOrder(); 
			}
		}
		sc.close();
	}

	public void updateOrder(){
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1. add order item 2. remove order item");
		int choice = sc.nextInt();
		if (choice == 1) this.addToOrder();
		else this.deleteFromOrder();
		sc.close();
	}

	public void addToOrder() { //calls createOrderItem from OrderItem and adds it to orderItemList
		// TODO - implement Order.addToOrder
		OrderItem temp = new OrderItem();
		temp.createOrderItem();
		this.orderItemList.add(temp);
		//throw new UnsupportedOperationException();
	}

	public void deleteFromOrder() {
		// TODO - implement Order.deleteFromOrder
		Scanner sc = new Scanner(System.in);
		this.printOrder();
		System.out.println("Which order item would you like to delete?");
		int orderItemIndex = sc.nextInt();
		this.orderItemList.remove(orderItemIndex - 1); //delete the index - 1 orderItem from this order
		sc.close();
		//throw new UnsupportedOperationException();
	}

	public double calculateBasePrice() {
		// TODO - implement Order.calculateBasePrice
		int orderSize = this.orderItemList.size();
		double basePrice = 0;
		for(int i = 0; i<orderSize; i++){
			basePrice += this.orderItemList.get(i).calculatePrice(); //iterates list and adds to basePrice the orderItems in order
		}
		return basePrice;
	}

	public void printOrder() {
		// TODO - implement Order.printOrder
		int orderSize = this.orderItemList.size();
		//System.out.println("Staff EID: " + this.s.getEmployeeID());
		System.out.println("Staff Name: " + this.s.getName());//should this be a print function of staff?

		for(int i = 0; i<orderSize; i++){
			System.out.print((i+1) + ". ");
			this.orderItemList.get(i).printOrderItem();
			System.out.println("----------------------------------------------");
		}
		//throw new UnsupportedOperationException();
	}

	// public void updateOrder() { 
	// 	// TODO - implement Order.updateOrder
	// 	this.printOrder();
	// 	Scanner sc = new Scanner(System.in);
	// 	System.out.println("Which Order item would you like to update?");
	// 	int updateChoice = sc.nextInt();
	// 	OrderItem temp = this.orderItemList.get(updateChoice-1);
	// 	temp.update(); //call the correct update method in respective subclasses, not sure if you need to re insert into arraylist. 
	// 	sc.close();
	// 	throw new UnsupportedOperationException();
	// } not specified in question, dunno if need

	// public Date getDate() {
	// 	// TODO - implement Order.getDate
	// 	throw new UnsupportedOperationException();
	// } not sure if date is needed

	// public void setDate() {
	// 	// TODO - implement Order.setDate
	// 	throw new UnsupportedOperationException();
	// }

	public OrderDetails getOrderDetails() {
		return this.orderDetails;
	}

	/**
	 * 
	 * @param orderDetails
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public Staff getStaff(){
		return this.s;
	}

	public void setStaff(Staff staff){
		this.s = staff;
	}

    public ArrayList<OrderItem> getOrderItemList() {
        return this.orderItemList;
    }
}