public class Table {

	private int seatingCapacity;
	private Status status;
	private int tableID;
	
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