import java.util.ArrayList;
import java.util.Scanner;

public class TableManager {
	
	private ArrayList<Table> tableList;
	private static int maxCapacity = 10;
	public TableManager() {
		
		ArrayList<Table> tableList = new ArrayList<Table>();
		tableList.add(new Table(1, 2, Status.AVAILABLE));
		tableList.add(new Table(2, 4, Status.AVAILABLE));
		tableList.add(new Table(3, 6, Status.AVAILABLE));
		tableList.add(new Table(4, 6, Status.AVAILABLE));
		tableList.add(new Table(5, 8, Status.AVAILABLE));
		tableList.add(new Table(6, 8, Status.AVAILABLE));
		tableList.add(new Table(7, 10, Status.AVAILABLE));
		tableList.add(new Table(8, 10, Status.AVAILABLE));
		tableList.add(new Table(9, 10, Status.AVAILABLE));
		this.tableList = tableList;
	}
	public TableManager(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	public ArrayList<Table> getAvailableTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.AVAILABLE) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getAvailableTables
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Table> getOccupiedTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.OCCUPIED) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getOccupiedTables
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Table> getReservedTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.RESERVED) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getReservedTables
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param minSeats
	 */
	public int findSuitableTable() {
		System.out.println("How many seats required?");
		Scanner sc = new Scanner(System.in);
		int minSeats = sc.nextInt();
		while(minSeats > 10){
			System.out.println("Sorry at most 10 seats only.");
			minSeats = sc.nextInt();
		}
		
		ArrayList<Table> availableTables = getAvailableTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
		}
		for (int i = 0; i < availableTables.get(i).getSeatingCapacity(); i++) {
			if (availableTables.get(i).getSeatingCapacity() >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else if (availableTables.get(i).getSeatingCapacity() < availableTables.get(chosenTableNo).getSeatingCapacity()){
					chosenTableNo = i; //it is more than seats required and less than prev chosen tables
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		System.out.println("Table " + chosenTableNo + "found");
		return chosenTableNo; //returns tableNo or -1 when no tables are found
		
		// TODO - implement TableManager.findSuitableTable
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToAvailable(int tableID) {
		tableList.get(tableID+1).setStatus(Status.AVAILABLE);
		System.out.println("Table "+ tableID + "set to Available");
		// TODO - implement TableManager.setTableToAvailable
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToOccupied(int tableID) {
		tableList.get(tableID+1).setStatus(Status.OCCUPIED);
		System.out.println("Table "+ tableID + "set to Occupied");
		// TODO - implement TableManager.setTableToOccupied
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToReserved(int tableID) {
		tableList.get(tableID+1).setStatus(Status.RESERVED);
		System.out.println("Table "+ tableID + "set to Reserved");
		// TODO - implement TableManager.setTableToReserved
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservation
	 * @param table
	 */
	public void allocateTableToReservation(Reservation reservation, Table table) {
		
		// TODO - implement TableManager.allocateTableToReservation
		//throw new UnsupportedOperationException();
	}
	
	public void printTables(ArrayList<Table> tableList){
		System.out.println("\nHere is the list of " + tableList.get(0).getStatus() + " tables : ");
		for (int i=0; i<tableList.size(); i++){
			System.out.println("Table " + tableList.get(i).getId());
		}
		System.out.println("\n");
	}
}