import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {

	private ArrayList<Reservation> reservationList;

	public ReservationManager() {
		// TODO - implement ReservationManager.ReservationManager
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

	public void printInterface(){
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("(1) Create Reservation");
			System.out.println("(2) Check Reservation");
			System.out.println("(3) Remove Reservation");
			System.out.println("(4) Remove Expired Reservation(s)");
			System.out.print("\t Enter the number of your choice: ");
			choice = sc.nextInt();
			int contactNumber;
			switch (choice) {
				case 1: 
					System.out.println("\t Creating Reservation ..");
					System.out.print("\t Please enter Name: ");
					String name = sc.nextLine();

					System.out.println("\t Please enter Contact No: ");
					contactNumber = sc.nextInt();
					//String errorPrompt = "\t Please enter a valid contact number eg. 90578213";
					//int contNo=UserInput.getPhoneNumber(inputPrompt, errorPrompt);
					
					//System.out.print("\t Please enter date(dd/MM/yyyy) between "+DateHandling.DateNoTimetoString(DateHandling.getCurrentDate())+" and "+DateHandling.DateNoTimetoString(DateHandling.getMonthLaterDate())+": ");
					System.out.println("\t Please enter date and time(dd-MM-yyyy HH:mm:ss)");
					sc.nextLine();
					String dateTime = sc.nextLine();
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

					System.out.println("\t Please enter Number of pax: ");
					int pax = sc.nextInt();
					//String inPrompt = "\t Please enter Number of pax: ";
					//int pax = UserInput.getIntFromRange(1, 10, inPrompt, null);
					
					this.createReservation(contactNumber, dateTime, pax,name);
					break;
					
				case 2:
					System.out.println("\t Please enter contact number to check reservation: ");
					//inputPrompt = "\t Please enter contact number to check reservation: ";
					//errorPrompt = "\t Please enter a valid contact number e.g.88767378";
					contactNumber = sc.nextInt();
					this.checkReservation(contactNumber);
					break;
					
				case 3:
					System.out.println("\t Please enter contact number to check reservation: ");
					//inputPrompt = "\t Please enter contact number to check reservation: ";
					//errorPrompt = "\t Please enter a valid contact number e.g.88767378";
					contactNumber = sc.nextInt();
					this.removeReservation(contactNumber);
					break;
					
				case 4: 
					this.checkAndRemoveExpired();
					System.out.println("Expired reservations have been removed.");
					break;
			}
		} while (choice < 4);
	}


	public Reservation checkExist(int contact){
		// TODO - implement ReservationManager.checkExist
		Reservation contactFound = null;
		boolean contactMatch;
		for(Reservation res : reservationList){
			contactMatch=res.checkContact(contact);
			if(contactMatch==true){
				contactFound=res;
				break;
			}
		}
		return contactFound;
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
	public void checkReservation(int contact){
		//TODO - implement ReservationManager.checkReservation
		Reservation contactFound=checkExist(contact);
		if(contactFound==null){
			System.out.println("no such reservation found!");
		}
		else{
			contactFound.printReservation();	
		}
		
	}

	public void removeReservation(int contact) {
		// TODO - implement ReservationManager.removeReservation
		Reservation contactFound=checkExist(contact);
		if(contactFound==null){
			System.out.println("no such reservation found!");
		}
		else{
			reservationList.remove(contactFound);	
		}
		//throw new UnsupportedOperationException();
	}

	public void checkAndRemoveExpired() {
		// TODO - implement ReservationManager.checkAndRemoveExpired
		boolean expiry = false;
		for (Reservation currentReservation : reservationList){
			expiry = currentReservation.getIsExpired();
			if(expiry==true){
				reservationList.remove(currentReservation);
			}
		}
		//throw new UnsupportedOperationException();
	}
}