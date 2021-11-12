

import java.util.ArrayList;

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
		System.out.println("No reservation found contact: " + contact);
		return null;
		// KIV whether need this or not
		//throw new UnsupportedOperationException();
	}

	public Reservation checkExist(int contact){
		// TODO - implement ReservationManager.checkExist
		Reservation contactFound = null;
		boolean contactMatch;
		for(Reservation currentReservation : reservationList){
			contactMatch=currentReservation.checkContact(contact);
			if(contactMatch==true){
				contactFound=currentReservation;
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
			System.out.println("No such reservation found!");
		}
		else{
			contactFound.printReservation();	
		}
		
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
		boolean expired = false;
		for (Reservation currentReservation : reservationList){
			expired = currentReservation.getIsExpired();
			if(expired==true){
				reservationList.remove(currentReservation);
			}
		}
		//throw new UnsupportedOperationException();
	}
}