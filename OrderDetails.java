import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class OrderDetails {

	private int tableID;
	private Order order;
	private LocalTime time;
	private LocalDate date;

	/**
	 * 
	 * @param order
	 */
	public OrderDetails(Order order) {
		// TODO - implement OrderDetails.OrderDetails
		this.date = LocalDate.now(); //stores the date of the object creation
		this.time = LocalTime.now(); // stores the time of the object creation, can also specify the fields manually
		this.order = order;
		Scanner sc = new Scanner(System.in);
		System.out.println("What table is this order for? (1 - 10)");
		this.tableID = sc.nextInt(); //maybe need to minus 1, not sure what this tableId is for
		sc.close();
		throw new UnsupportedOperationException();
	}

	public int getTableID() {
		return this.tableID;
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public Order getOrder() {
		// TODO - implement OrderDetails.getOrder
		return this.order;
	}

	public void setOrder(Order o) {
		// TODO - implement OrderDetails.setOrder
		this.order = o;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 * @param date
	 * @param time
	 * @param order
	 */
	// public OrderDetails(int tableID, Date date, Time time, Order order) {
	// 	// TODO - implement OrderDetails.OrderDetails
	// 	throw new UnsupportedOperationException();
	// } since orderDetails objects are only created in Order class, i don't think we need this

	public LocalTime getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void printOrderDetails() {
		System.out.println("Date of Order: "+this.date);
		System.out.println("Time of Order: "+this.time);
		System.out.println("Order for Table Number: "+this.tableID);//depending on how we store tableID, this may need to +1
		System.out.println("Order details: ");
		this.order.printOrder();
		// TODO - implement OrderDetails.printOrderDetails
		throw new UnsupportedOperationException();
	}

	public double calculatePrice() {
		return this.order.calculateBasePrice(); // return the basePrice of a particular order
		// TODO - implement OrderDetails.calculatePrice
	}

}