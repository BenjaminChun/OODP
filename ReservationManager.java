import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {

	private ArrayList<Reservation> reservationList;

	public ReservationManager() {
		// TODO - implement ReservationManager.ReservationManager
		//throw new UnsupportedOperationException();
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
					//String errorPrompt = "\t Please enter a valid contact number eg. 90578213";
					//int contNo=UserInput.getPhoneNumber(inputPrompt, errorPrompt);
					
					//System.out.print("\t Please enter date(dd/MM/yyyy) between "+DateHandling.DateNoTimetoString(DateHandling.getCurrentDate())+" and "+DateHandling.DateNoTimetoString(DateHandling.getMonthLaterDate())+": ");
					System.out.print("\t Please enter date (dd-MM-yyyy): ");
					sc.nextLine();
					String date = sc.nextLine();

					System.out.print("\t Please enter time (HH:mm): ");
					String time = sc.nextLine();
					/*while(!DateHandling.isThisDateValid(dateTime)) {
						System.out.print("\t Please enter a valid date in the format (dd/MM/yyyy): ");
						dateTime = sc.nextLine();
					}*/
					/*while(!DateHandling.withinOneMonth(dateTime)) {
						System.out.print("\t Please enter date(dd/MM/yyyy) between "+DateHandling.DateNoTimetoString(DateHandling.getCurrentDate())+" and "+DateHandling.DateNoTimetoString(DateHandling.getMonthLaterDate())+": ");
						dateTime = sc.nextLine();
						while(!DateHandling.isThisDateValid(dateTime)) {
							System.out.print("\t Please enter a valid date in the format (dd/MM/yyyy): ");
							dateTime = sc.nextLine();
						}
					}*/
					
					/*System.out.print("\t Please enter a time(HH:mm) between AM Session(11:00 to 15:00) or PM Session(18:00 to 22:00): ");
					
					String time = sc.nextLine();
					time = dateTime + " " + time;
					
					while(!DateHandling.isThisTimeValid(time)) {
						System.out.print("\t Please enter a time(HH:mm) between AM Session(11:00 to 15:00) or PM Session(18:00 to 22:00): ");
						time = sc.nextLine();
						time = dateTime + " " + time;
					}
					dateTime=time;*/

					System.out.print("\t Please enter number of pax: ");
					int pax = sc.nextInt();
					//String inPrompt = "\t Please enter Number of pax: ";
					//int pax = UserInput.getIntFromRange(1, 10, inPrompt, null);
					
					this.createReservation(contactNumber, date + " " + time, pax, name);
					break;
					
				case 2:
					System.out.print("\t Please enter contact number to check reservation: ");
					//inputPrompt = "\t Please enter contact number to check reservation: ";
					//errorPrompt = "\t Please enter a valid contact number e.g.88767378";
					contactNumber = sc.nextInt();
					this.checkReservation(contactNumber);
					break;
					
				case 3:
					System.out.print("\t Please enter contact number to remove reservation: ");
					//inputPrompt = "\t Please enter contact number to check reservation: ";
					//errorPrompt = "\t Please enter a valid contact number e.g.88767378";
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
	 * 
	 * @param contact
	 * @param date
	 * @param arrivalTime
	 * @param numPax
	 * @param name
	 */
	public void createReservation(int contact, String dateAndArrivalTime, int numPax, String name) {
		// TODO - implement ReservationManager.createReservation
		Reservation reservation = new Reservation(contact, dateAndArrivalTime, numPax, name);
		reservationList.add(reservation);

		//throw new UnsupportedOperationException(); 
	}

		/**
	 * 
	 * @param contact
	 */
	public void checkReservation(int contactNumber){
		//TODO - implement ReservationManager.checkReservation
		Reservation contactFound=checkExist(contactNumber);
		System.out.print("\n");
		if(contactFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			contactFound.printReservation();	
		}
	}

	public Reservation checkExist(int contactNumber){
		// TODO - implement ReservationManager.checkExist
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

	public void removeReservation(int contact) {
		// TODO - implement ReservationManager.removeReservation
		Reservation contactFound=checkExist(contact);
		if(contactFound==null){
			System.out.println("No such reservation found!");
		}
		else{
			reservationList.remove(contactFound);	
		}
		//throw new UnsupportedOperationException();
	}

	public void checkAndRemoveExpired() {
		// TODO - implement ReservationManager.checkAndRemoveExpired
		ArrayList<Reservation> removalList = new ArrayList<Reservation>();
		boolean expiry = false;
		for (Reservation currentReservation : reservationList){
			expiry = currentReservation.getIsExpired();
			if(expiry==true){
				removalList.add(currentReservation);
			}
		}

		for (Reservation expiredReservation : removalList){
			reservationList.remove(expiredReservation);
		}
		
		//throw new UnsupportedOperationException();
	}

	/**
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

		// KIV whether need this or not
		//throw new UnsupportedOperationException();
	}

	public void printReservationList(){
		System.out.println("Reservation List");
		for (Reservation reservation : reservationList){
			reservation.printReservation();
		}
	}
}