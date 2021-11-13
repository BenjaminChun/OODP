import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {

	private ArrayList<Reservation> reservationList;

	public ReservationManager() { 
		reservationList = new ArrayList<Reservation>();
		reservationList.add(new Reservation(91550028, "22-03-2022 18:15", 4, "Beh Ming Jun"));
		reservationList.add(new Reservation(91550027, "13-11-2021 12:04", 6, "Tan Han Kang"));
		reservationList.add(new Reservation(91550026, "13-11-2021 12:03", 8, "Chun Wei Jie"));
		reservationList.add(new Reservation(91550025, "22-03-2021 18:15", 2, "Tan Zheng Kai"));
	}

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
			System.out.print("Enter the number of your choice: ");
			choice = sc.nextInt();
			System.out.println();
			sc.nextLine();
			int contactNumber;
			switch (choice) {
				case 1: 
					System.out.println("\t Creating Reservation ..");
					System.out.print("\t Please enter name: ");
					String name = sc.nextLine();

					System.out.print("\t Please enter contact number: ");
					contactNumber = sc.nextInt();
					
					System.out.print("\t Please enter date (dd-MM-yyyy): ");
					sc.nextLine();
					String date = sc.nextLine();

					System.out.print("\t Please enter time (HH:mm): ");
					String time = sc.nextLine();
					

					System.out.print("\t Please enter number of pax: ");
					int pax = sc.nextInt();
					
					this.createReservation(contactNumber, date + " " + time, pax, name);
					break;
					
				case 2:
					System.out.print("\t Please enter contact number to check reservation: ");
					
					contactNumber = sc.nextInt();
					this.checkReservation(contactNumber);
					break;
					
				case 3:
					System.out.print("\t Please enter contact number to remove reservation: ");
					
					contactNumber = sc.nextInt();
					this.removeReservation(contactNumber);
					break;
					
				case 4: 
					this.checkAndRemoveExpired();
					System.out.println("Expired reservations have been removed.");
					break;

				case 5:
					this.printReservationList();
			}
		} while (choice < 6);
	}

	/**
	 * Creating a Reservation
	 * @param contact Contact number of person creating reservation.
	 * @param date Date of reservation.
	 * @param arrivalTime Arrival Time of Reservation.
	 * @param numPax Number of pax of people doing the reservation.
	 * @param name Name of person booking the reservation.
	 */
	public void createReservation(int contact, String dateAndArrivalTime, int numPax, String name) {
		
		Reservation reservation = new Reservation(contact, dateAndArrivalTime, numPax, name);
		reservationList.add(reservation);

	}

		/**
	 * Checking reservation using contact number of person who booked it.
	 * @param contact Contact number of person whose reservation is booked under. 
	 */
	public void checkReservation(int contactNumber){
		//TODO - implement ReservationManager.checkReservation
		Reservation reservationFound=checkExist(contactNumber);
		System.out.print("\n");
		if(reservationFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			reservationFound.printReservation();	
		}
	}

	
	/** Method to check if the reservation exists 
	 * @param contactNumber Contact number to be checked with reservationList.
	 * @return Reservation
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

	
	/** Removing a reservation from reservationList
	 * @param contactNumber Contact number to be checked with reservationList
	 */
	public void removeReservation(int contactNumber) {

		Reservation reservationFound=checkExist(contactNumber);
		if(reservationFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			reservationList.remove(reservationFound);	
		}
		//throw new UnsupportedOperationException();
	}

	public void checkAndRemoveExpired() {

		int reservationListSize = reservationList.size();
		boolean expired = false;	
		int currentIndex = 0;	
		for (int counter = 0; counter < reservationListSize; counter++)
		{
			expired = reservationList.get(currentIndex).getIsExpired();
			if (expired == true){
				reservationList.remove(currentIndex);
				continue;
			}
			currentIndex++;
		}
		//throw new UnsupportedOperationException();
	}

	/**Getting Reservation
	 * 
	 * @param contact
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

	public void printReservationList(){
		System.out.println("Reservation List");
		for (Reservation reservation : reservationList){
			reservation.printReservation();
		}
	}
}