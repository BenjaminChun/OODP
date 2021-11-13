import java.util.Scanner;
/**
 * Represents a Customer in the Restaurant. 
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class Customer {
	/**
	 * The name of this Customer.
	 */
	private String name;
	/**
	 * The gender of this Customer.
	 */
	private char gender;
	/**
	 * The membership status of this Customer.
	 */
	private boolean membership;
	/**
	 * The contact number of this Customer.
	 */
	private int contact;
	/**
	 * Read input to determine customer attributes.
	 */
	public Customer(){
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

	/**
	 * Create a new Customer with given name.
	 * @param name This Customer's name.
	 * @param gender This Customer's gender.
	 * @param membership This Customer's membership.
	 * @param contact This Customer's contact number.
	 */
	public Customer(String name, char gender, boolean membership, int contact){
		this.name = name;
		this.gender = gender;
		this.membership = membership;
		this.contact = contact;
	}

	
	/** Gets the discount of this customer.
	 * @return this Customer's discount price.
	 */
	public double getDiscount() {
		// TODO - implement Customer.getDiscount
		// assuming members receive 10% discount off basePrice
		if (this.membership == true){
			return 0.1;
		}
		else return 1;
		//throw new UnsupportedOperationException();
	}

	
	/** 
	 * Gets the contact number of this Customer.
	 * @return int
	 */
	public int getContact() {
		return this.contact;
	}

	/**
	 * Sets the contact number of this Customer.
	 * @param contact
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}

}