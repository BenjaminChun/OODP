import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
		RestaurantApp.globalInvoiceManager.createInvoice(this);
		ArrayList<Table> availTables = RestaurantApp.globalTableManager.getAvailableTables(); //get a list of available table
		RestaurantApp.globalTableManager.printTables(availTables);
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
			if (!tableFound){
				throw new IncorrectTableIDException("Table ID "+id+" is not found in available table list!");
			}
			this.tableID = id;
			RestaurantApp.globalTableManager.setTableToOccupied(id);
		} catch (IncorrectTableIDException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
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
		return this.order;
	}

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
		System.out.println("Order for Table Number: "+this.tableID);
		System.out.println("Order details: ");
		this.order.printOrder();
	}

	public double calculatePrice() {
		return this.order.calculateBasePrice(); // return the basePrice of a particular order
	}

}