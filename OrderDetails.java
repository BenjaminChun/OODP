import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents order details in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class OrderDetails {
	/**
	 * The table id of this order details. 
	 */
	private int tableID;
	/**
	 * The order of this order details.
	 */
	private Order order;
	/**
	 * The local time of this order details.
	 */
	private LocalTime time;
	/**
	 * The local time of this order details.
	 */
	private LocalDate date;

	/**
	 * Creates Order Details through taking in an order.
	 * @param order The order of this order details.
	 */
	public OrderDetails(Order order) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy"); 
		System.out.println("Date of order: (d/MM/yyyy)\n");
		String tempDate = sc.nextLine();
  		//convert String to LocalDate
		try {
			this.date = LocalDate.parse(tempDate, dateFormatter);
		} catch (DateTimeParseException e) {
			System.out.println("Please follow the correct format for inputting of date!");
			System.out.println("program exiting...");
			System.exit(0);
		}
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println("Time of order: HH:mm\n");
		String tempTime = sc.nextLine();
		try {
			this.time = LocalTime.parse(tempTime, timeFormatter);
		} catch (DateTimeParseException e) {
			System.out.println("Please follow the correct format for inputting of time!");
			System.out.println("program exiting...");
			System.exit(0);
		}
		this.order = order;
		Invoice newInvoice = RestaurantApp.globalInvoiceManager.createInvoice(this);
		ArrayList<Table> availTables = RestaurantApp.globalTableManager.getAvailableTables(); //get a list of available table
		ArrayList<Table> reservedTables = RestaurantApp.globalTableManager.getReservedTables(); 
		if (RestaurantApp.globalReservationManager.checkExist(newInvoice.getCustomer().getContact()) == null){
			RestaurantApp.globalTableManager.printTables(availTables);
		}
		else {
			System.out.println("There is a reservation made with this contact...");
			RestaurantApp.globalTableManager.printTables(reservedTables);
		}
		System.out.println("What table ID is this order for?");
		try {
			int id = sc.nextInt();
			sc.nextLine();
			boolean tableFound = false;
			for (int i = 0; i < availTables.size(); i++){
				if(availTables.get(i).getId() == id){
					tableFound = true;
				}
			}
			for (int i = 0; i < reservedTables.size(); i++){
				if(reservedTables.get(i).getId() == id){
					tableFound = true;
				}
			}
			if (!tableFound){
				throw new IncorrectTableIDException("Table ID "+id+" is not found in available/reserved table list!");
			}
			this.tableID = id;
			RestaurantApp.globalTableManager.setTableToOccupied(id);
		} catch (IncorrectTableIDException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Gets the table id of this order details.
	 * @return the table id of this order details.
	 */
	public int getTableID() {
		return this.tableID;
	}

	/**
	 * Changes the table id of this order details.
	 * @param tableID The table id of this order details
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	/**
	 * Gets the order item of this order details.
	 * @return the order of this order details.
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Changes the order of this order details.
	 * @param o returns the order of this order details.
	 */
	public void setOrder(Order o) {
		this.order = o;
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


	/**
	 * Gets the local time of this order details.
	 * @return the local time of this order details.
	 */
	public LocalTime getTime() {
		return this.time;
	}

	/**
	 * Changes the local time of this order details.
	 * @param time the time of this order details.
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}

	/**
	 * Gets the date of this order details.
	 * @return the date of this order details.
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Changes the local time of this order details.
	 * @param date the date of this order details.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Prints the attributes of this order details.
	 */
	public void printOrderDetails() {
		System.out.println("Date of Order: "+this.date);
		System.out.println("Time of Order: "+this.time);
		System.out.println("Order for Table Number: "+this.tableID);
		System.out.println("Order details: ");
		this.order.printOrder();
	}

	/**
	 * Calculates the base price of the order in this order details.
	 * @return the calculated base price of this order details.
	 */
	public double calculatePrice() {
		return this.order.calculateBasePrice(); // return the basePrice of a particular order
	}

}