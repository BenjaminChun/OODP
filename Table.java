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
	 * @param tableID This Table's ID
	 * @param seatingCapacity This Table's seating capacity.
	 * @param status This Table's status.
	 */
	public Table(int tableID, int seatingCapacity, Status status) {
		this.tableID = tableID;
		this.seatingCapacity = seatingCapacity;
		this.status = status;
	}
	
	/**
	 * Get the seating capacity of the Table.
	 * @return The seating capacity of the Table.
	 */
	public int getSeatingCapacity() {
		return this.seatingCapacity;
	}

	/**
	 * Set the Table status.
	 * @param status The new status of the Table.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Get the Table status.
	 * @return The Table status.
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Get the tableID.
	 * @return tableID of the Table.
	 */
	public int getId(){
		return tableID;
	}
	
}