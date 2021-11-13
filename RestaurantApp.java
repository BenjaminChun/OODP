import java.util.Scanner;

public class RestaurantApp {

	public static ReservationManager globalReservationManager;
	public static OrderManager globalOrderManager;
	public static TableManager globalTableManager;
	public static StaffManager globalStaffManager;
	public static MenuManager globalMenuManager;
	public static InvoiceManager globalInvoiceManager;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		globalMenuManager = new MenuManager();
		globalStaffManager = new StaffManager();
		globalReservationManager = new ReservationManager();
		globalTableManager = new TableManager();
		globalInvoiceManager = new InvoiceManager();
		globalOrderManager = new OrderManager();

		System.out.println("Hello welcome to RRPS:");
		int choice = 1;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Main Menu: ");
			System.out.println("Please choose an option:");
			System.out.println(
					"\n{Main menu} .__________. \n" +
					"Which do you wish to access?\n" +
					"1. Menu Manager\n" +
					"2. Table Manager\n" +
					"3. Order Manager\n" +
					"4. Reservation Manager\n" +
					"5. Sales Report\n" +
					"6. Staff Manager\n\n" +
					"Enter 0 to cancel");

			choice = sc.nextInt(); 
			System.out.println();
			switch (choice){
				case 1://menumanager
					System.out.println("What do you want to do? :-) \n" + 
					"1. Print Menu\n" +
					"2. Add Item\n" +
					"3. Remove Item from Menu\n" +
					"4. Update Item\n\n" +
					"ENTER 0 TO QUIT\n");
					int menuChoice = 0;
					menuChoice = sc.nextInt();
					sc.nextLine();
					switch (menuChoice) {
						case 1:
							globalMenuManager.printMenu();
							break;
						case 2:
							globalMenuManager.addItem();
							break;
						case 3:
							globalMenuManager.removeItem();
							break;
						case 4:
							globalMenuManager.updateItem();
							break;
						}
					break;
				case 2:
					int tableChoice = 0;
					do {
						System.out.println("What do you want to do? :-) \n" + 
						"1. Print Available Tables\n" +
						"2. Print Occupied Tables\n" +
						"3. Print Reserved Tables\n" +
						"4. Find and Assign a suitable Table\n\n"+
						"ENTER 0 TO QUIT\n");
						
						tableChoice = sc.nextInt();
						switch (tableChoice) {
							case 1:
								globalTableManager.printTables(globalTableManager.getAvailableTables());
								break;
							case 2:
								globalTableManager.printTables(globalTableManager.getOccupiedTables());
								break;
							case 3:
								globalTableManager.printTables(globalTableManager.getReservedTables());
								break;
							case 4:
								int minSeats = globalTableManager.getUserInput();
								int tableNum = globalTableManager.findSuitableTableFromReserved(minSeats);
								globalTableManager.setTableToOccupied(tableNum);
								break;
							}
					} while (tableChoice!=0);
					break;
					

				case 3:
					int orderChoice = 0;
					do {
						System.out.println("What do you want to do? :-) \n" + 
						"1. Create Order\n" +
						"2. Cancel Order\n" +
						"3. Change Order\n" +
						"4. Print Order List\n"+
						"5. Print Order Invoice\n\n" +
						"ENTER 0 TO QUIT\n");
						
						orderChoice = sc.nextInt();
						sc.nextLine();
						switch (orderChoice) {
							case 1:
								globalOrderManager.createOrder();
								break;
							case 2:
								globalOrderManager.cancelOrder();
								break;
							case 3:
								globalOrderManager.changeOrder();
								break;
							case 4:
								globalOrderManager.printOrderList();
								break;
							case 5:
								globalInvoiceManager.chooseInvoice();
								break;
							}
					} while (orderChoice!=0);
					break;
				case 4:
					globalReservationManager.printInterface();
					break;
				case 5:
					SalesReport salesReport = new SalesReport();
					salesReport.printSalesReport();
					break;
				case 6:
					globalStaffManager.printInterface();
					break;
			}
		} while (choice != 0);

		

		// TODO - implement RestaurantApp.main
		//throw new UnsupportedOperationException();
	/*
	public MenuManager MenuManager() {
		// TODO - implement RestaurantApp.MenuManager
		//throw new UnsupportedOperationException();
	}

	public OrderManager OrderManager() {
		// TODO - implement RestaurantApp.OrderManager
		//throw new UnsupportedOperationException();
	}

	public TableManager TableManager() {
		// TODO - implement RestaurantApp.TableManager
		//throw new UnsupportedOperationException();
	}

	public ReservationManager ReservationManager() {
		// TODO - implement RestaurantApp.ReservationManager
		throw new UnsupportedOperationException();
	}

	public StaffManager StaffManager() {
		// TODO - implement RestaurantApp.StaffManager
		throw new UnsupportedOperationException();
	}
	*/
}
}
