import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a Reservation Manager in the restaurant.
 * A Reservation Manager can create, check and cancel reservations.
 * @author Tan Zheng Kai
 * @version 11
 * @since 2021-11-13
 */
public class ReservationManager {
	/**
	 * The list of all reservations made.
	 */
	private ArrayList<Reservation> reservationList;

	/**
	 * Create ReservationManager with a Reservation ArrayList
	 */
	public ReservationManager() { 
		reservationList = new ArrayList<Reservation>();
		// reservationList.add(new Reservation(91550028, "22-03-2022 18:15", 4, "Beh Ming Jun"));
		// reservationList.add(new Reservation(91550027, "13-11-2021 12:04", 6, "Tang Han Kang"));
		// reservationList.add(new Reservation(91550026, "13-11-2021 12:03", 8, "Chun Wei Jie"));
		// reservationList.add(new Reservation(91550025, "22-03-2021 18:15", 2, "Tan Zheng Kai"));
	}

	/**
	 * Prints a selection of choices for user to pick. 
	 * User can either create a reservation, check their reservation status 
	 * or cancel their current reservation.
	 * Reservation manager can also remove expired reservations present in the list.
	 */

	public void printInterface(){
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nReservation Manager Class");
			System.out.println("(1) Create Reservation");
			System.out.println("(2) Check Reservation");
			System.out.println("(3) Remove Reservation");
			System.out.println("(4) Remove Expired Reservation(s)");
			System.out.println("(5) Print Reservation List");
			System.out.println("(6) Exit");
			System.out.print("Enter the number of your choice: ");
			choice = sc.nextInt();
			System.out.println();
			sc.nextLine();
			switch (choice) {
				case 1: 					
					this.createReservation();
					break;
					
				case 2:
					this.checkReservation();
					break;
					
				case 3:
					this.removeReservation();
					break;
					
				case 4: 
					this.checkAndRemoveExpired();
					break;

				case 5:
					this.printReservationList();
			}
		} while (choice < 6);
	}

	/**
	 * Creating a Reservation with a customer's contact number, 
	 * date of reservation to be made, expected time of arrival and
	 * number of pax.
	 * Checks for available table with right number of seats to be reserved.
	 * Reservation will fail if a table cannot be found.
	 * @param contact Contact number of person creating the reservation.
	 * @param date Date of reservation.
	 * @param arrivalTime Time to arrive for reservation.
	 * @param numPax Number of people for reservation to be booked for.
	 * @param name Name of person booking the reservation.
	 */
	public void createReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Creating Reservation ..");
		System.out.print("Please enter name: ");
		String name = sc.nextLine();

		System.out.print("Please enter contact number: ");
		int contactNumber = sc.nextInt();
		
		System.out.print("Please enter date (dd-MM-yyyy): ");
		sc.nextLine();
		String date = sc.nextLine();

		System.out.print("Please enter time (HH:mm): ");
		String time = sc.nextLine();
		
		int pax = RestaurantApp.globalTableManager.getUserInput();
		int tableID = RestaurantApp.globalTableManager.findSuitableTableFromAvailable(pax);
		if (tableID == -1){
			System.out.println("Sorry, there are no more tables available for " + pax + "pax.");
			return;
		}
		else {
			RestaurantApp.globalTableManager.setTableToReserved(tableID);
		}

		Reservation reservation = new Reservation(contactNumber, date + " " + time, pax, name);
		reservationList.add(reservation);
		System.out.println("Reservation created successfully.");
	}

	/**
	 * Checking reservation using contact number of person who booked it.
	 */
	public void checkReservation(){
		//TODO - implement ReservationManager.checkReservation
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter contact number to check reservation: ");		
		int contactNumber = sc.nextInt();

		Reservation reservationFound=checkExist(contactNumber);
		System.out.print("\n");
		if(reservationFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			reservationFound.printReservation();	
		}
	}

	
	/** Checking if reservation exists.
	 * @param contactNumber Contact number to be checked with reservationList.
	 * @return The Reservation that is being searched for.
	 */
	public Reservation checkExist(int contactNumber){

		Reservation contactFound = null;
		boolean contactMatch;
		for(Reservation res : reservationList){
			contactMatch=res.checkContact(contactNumber);
			if(contactMatch==true){
				contactFound=res;
				break;
			}
		}
		return contactFound;
	}

	
	/** 
	 * Removing a reservation from reservationList with an input contactNumber.
	 */
	public void removeReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter contact number to remove reservation: ");
		int contactNumber = sc.nextInt();

		Reservation reservationFound=checkExist(contactNumber);
		if(reservationFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			System.out.println("Changing reserved table to available...");
			int minSeats = reservationFound.getNumPax();
			int tableID = RestaurantApp.globalTableManager.findSuitableTableFromReserved(minSeats);
			RestaurantApp.globalTableManager.setTableToAvailable(tableID);
			reservationList.remove(reservationFound);	
		}
		System.out.println("Reservation removed successfully.");
		//throw new UnsupportedOperationException();
	}

	/**
	 * Checks and remove expired Reservations.
	 */
	public void checkAndRemoveExpired() {

		int reservationListSize = reservationList.size();
		boolean expired = false;	
		int currentIndex = 0;	
		Reservation currentReservation;
		for (int counter = 0; counter < reservationListSize; counter++)
		{
			currentReservation = reservationList.get(currentIndex);
			expired = currentReservation.getIsExpired();
			if (expired == true){
				System.out.println("Changing reserved table to available...");
				int tableID = RestaurantApp.globalTableManager.findSuitableTableFromReserved(currentReservation.getNumPax());
				RestaurantApp.globalTableManager.setTableToAvailable(tableID);
				reservationList.remove(currentIndex);
				continue;
			}
			currentIndex++;
		}
		System.out.println("Expired reservation(s) have been removed.");
		//throw new UnsupportedOperationException();
	}

	/**
	 * Getting Reservation object.
	 * @param contact The reservation made by this contact number.
	 */
	public Reservation getReservation(int contact) {
		// TODO - implement ReservationManager.getReservation
		for (Reservation res : reservationList){
			if(res.getContact()==contact){
				return res;
			}
		}
		System.out.println("Reservation not found");
		return null;

		//throw new UnsupportedOperationException();
	}

	/**
	 * Prints the reservationList.
	 */
	public void printReservationList(){
		System.out.println("Reservation List");
		for (Reservation reservation : reservationList){
			reservation.printReservation();
		}
	}
}