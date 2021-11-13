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
	 * @param tableID ID of the Table
	 * @param seatingCapacity seatingCapacity of the Table
	 * @param status status of the Table
	 */
	public Table(int tableID, int seatingCapacity, Status status) {
		this.tableID = tableID;
		this.seatingCapacity = seatingCapacity;
		this.status = status;
	}
	
	/**
	 * Get the seating capacity of the Table.
	 * @return the seating capacity of the Table.
	 */
	public int getSeatingCapacity() {
		return this.seatingCapacity;
	}

	/**
	 * Set the Table status.
	 * @param status the new status of the Table.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Get the Table status.
	 * @return the Table status.
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Get the tableID.
	 * @return tableID.
	 */
	public int getId(){
		return tableID;
	}
	
}