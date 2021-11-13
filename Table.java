/**
 * Represents a Table in the restaurant.
 * Table can have different number of seats,
 * status and ID.
 * @author Benjamin Chun Wei Jie
 * @version 14
 * @since 2021-11-13
 */
public class Table {

	/**
	 * The seating capacity of the Table
	 */
	private int seatingCapacity;

	/**
	 * The status of the Table (AVAILABLE, 
	 * OCCUPIED, RESERVED).
	 */
	private Status status;

	/**
	 * The ID of the table.
	 */
	private int tableID;
	
	/**
	 * Creates a Table object.
	 * The table can only have 2/4/6/8/10 seats.
	 * Table status can only be chosen from the Status class.
	 * @param tableID 
	 * @param seatingCapacity
	 * @param status
	 */
	public Table(int tableID, int seatingCapacity, Status status) {
		this.tableID = tableID;
		this.seatingCapacity = seatingCapacity;
		this.status = status;
	}
	
	public int getSeatingCapacity() {
		return this.seatingCapacity;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public int getId(){
		return tableID;
	}
	
}