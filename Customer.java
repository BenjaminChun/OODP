import java.util.Scanner;

public class Customer {

	private String name;
	private char gender;
	private boolean membership;
	private int contact;

	public Customer(){
		//read input to determine customer attributes
		System.out.println("What's the customer's name?");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		this.name = name;
		System.out.println("What's the customer's gender?");
		char gender = sc.nextLine().charAt(0);
		this.gender = gender;
		System.out.println("Is the customer a member? Y/N");
		char choice = sc.nextLine().charAt(0);
		if (choice == 'Y' || choice == 'y'){
			this.membership = true;
		}
		else {
			this.membership = false;
		}
		System.out.println("Please enter the contact num");
		int contact = sc.nextInt();
		this.contact = contact;
	}

	public Customer(String name, char gender, boolean membership, int contact){
		this.name = name;
		this.gender = gender;
		this.membership = membership;
		this.contact = contact;
	}

	public double getDiscount() {
		// TODO - implement Customer.getDiscount
		// assuming members receive 10% discount off basePrice
		if (this.membership == true){
			return 0.1;
		}
		else return 1;
		//throw new UnsupportedOperationException();
	}

	public int getContact() {
		return this.contact;
	}

	/**
	 * 
	 * @param contact
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}

}