/**
 * Represents the Invoice of a customer.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class Invoice {
	/**
	 * The order details of this invoice.
	 */
	private OrderDetails orderDetails;
	/**
	 * The customer who requested this invoice.
	 */
	private Customer customer;
	/**
	 * The bill of this invoice.
	 */
	private double bill;
	/**
	 * The GST of this invoice.
	 */
	public static double GST = 0.08;
	/**
	 * The service charge of this invoice.
	 */
	public static double ServiceCharge = 0.1;

	/**
	 * Creates a new Invoice with given order details.
	 * @param orderDetails this Invoice's order details
	 */
	public Invoice(OrderDetails orderDetails){
		Customer newCustomer = new Customer();
		this.customer = newCustomer;
		//ask for input for customer
		this.orderDetails = orderDetails;
		this.bill = 0;
	}

	/**
	 * Gets the order details of this Invoice
	 * @return this Invoice's order details.  
	 */
	public OrderDetails getOrderDetails() {
		return this.orderDetails;
	}

	/**
	 * Changes the order details of this Invoice.
	 * @param orderDetails This Invoice's order details.
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	/** 
	 * Gets the order details of this Invoice. 
	 * @return this Invoice's customer.
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Changes the customer of this Invoice.
	 * @param customer This Invoice's customer.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * 
	 */
	public void print(){
		System.out.println(this.orderDetails.getTableID());
	}

	
	/** 
	 * 
	 * @return 
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
	 * Gets the base price of this Invoice.  
	 * @param basePrice
	 */
	private double getPriceAfterDiscount(double basePrice) {
		basePrice *= (1-this.getCustomer().getDiscount());
		return basePrice;
	}

	/**
	 * Gets the final price of this Invoice. 
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
		System.out.println("");
	}
}