public class Invoice {

	private OrderDetails orderDetails;
	private Customer customer;
	private double bill;
	public static double GST = 0.08;
	public static double ServiceCharge = 0.1;

	/**
	 * Invoice Constructor to instantiate an instance of Invoice
	 * 
	 * Takes in parameter orderDetails of Class OrderDetails
	 * instantiate attributes to default values to be updated later on
	 * 
	 * @param orderDetails instance of orderDetails that corresponds to the instance of invoice being constructed
	 */
	public Invoice(OrderDetails orderDetails){
		Customer newCustomer = new Customer();
		this.customer = newCustomer;
		//ask for input for customer
		this.orderDetails = orderDetails;
		this.bill = 0;
	}

	/**
	 * getOrderDetails is a simple getter function for attribute orderDetails
	 * 
	 * @return attribute orderDetails 
	 */
	public OrderDetails getOrderDetails() {
		return this.orderDetails;
	}

	/**
	 * 
	 * @param orderDetails
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	/** 
	 * @return Customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void print(){
		System.out.println(this.orderDetails.getTableID());
	}

	
	/** 
	 * @return double
	 */
	private double calculateBaseTotal() {
		double baseTotal = 0;
		//find list of orderitem
		//iterate thru and calc base total
		for (int i = 0; i<this.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			baseTotal +=  this.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() * this.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
		}
		return baseTotal;
		// TODO - implement InvoiceManager.calculateBaseTotal
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param basePrice
	 */
	private double getPriceAfterDiscount(double basePrice) {
		basePrice *= (1-this.getCustomer().getDiscount());
		return basePrice;
	}

	/**
	 * 
	 * @param discountedPrice
	 */
	public double getFinalPrice() {
		double finalPrice = (1 + GST + ServiceCharge) * getPriceAfterDiscount(calculateBaseTotal());
		this.bill = finalPrice;
		return finalPrice;
	}

	public void printInvoice(){
		String result = "Invoice Receipt for Table " + this.getOrderDetails().getTableID() + " for datetime = "+ this.getOrderDetails().getDate() + this.orderDetails.getTime();
		System.out.println(result); //print heading
		System.out.println("Menu Item Name : Quantity * Price");
		System.out.println("=====================================");
		for (int i = 0; i<this.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			result = this.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getName() + " : "+ this.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() + " * $" + this.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
			System.out.println(result);
		}
		System.out.println();
		System.out.println("Subtotal : " + this.calculateBaseTotal());
		System.out.println("Member Discount : " + this.customer.getDiscount()*calculateBaseTotal());
		System.out.println("Taxes (GST+ServiceCharge) : " + this.getPriceAfterDiscount(this.calculateBaseTotal())*(ServiceCharge + GST));
		this.getFinalPrice();
		result = "Total = " + this.bill;
		System.out.println(result); //print heading
		System.out.println("=====================================");

		RestaurantApp.globalTableManager.setTableToAvailable(this.getOrderDetails().getTableID());
	}
}