public class Customer {

	private String name;
	private String gender;
	private boolean membership;
	private int contact;

	public Customer(String name, String gender, boolean membership, int contact){
		this.name = name;
		this.gender = gender;
		this.membership = membership;
		this.contact = contact;
	}

	public double getDiscount() {
		// TODO - implement Customer.getDiscount
		throw new UnsupportedOperationException();
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