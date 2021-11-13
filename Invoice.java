public class Invoice {

	private OrderDetails orderDetails;
	private Customer customer;
	private double bill;
	public static double GST = 0.08;
	public static double ServiceCharge = 0.1;

	public Invoice(OrderDetails orderDetails){
		Customer newCustomer = new Customer();
		this.customer = newCustomer;
		//ask for input for customer
		this.orderDetails = orderDetails;
		this.bill = 0;
	}

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
		// TODO - implement InvoiceManager.getPriceAfterDiscount
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param discountedPrice
	 */
	public double getFinalPrice() {
		double finalPrice = (1 + GST + ServiceCharge) * getPriceAfterDiscount(calculateBaseTotal());
		this.bill = finalPrice;
		return finalPrice;
		// TODO - implement InvoiceManager.getFinalPrice
		//throw new UnsupportedOperationException();
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