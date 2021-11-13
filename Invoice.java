public class Invoice {

	private OrderDetails orderDetails;
	private Customer customer;
	private double bill;
	public static double GST = 0.8;

	public Invoice(OrderDetails orderDetails){
		Customer newCustomer = new Customer();
		this.customer = newCustomer;
		//ask for input for customer
		this.orderDetails = orderDetails;
		this.bill = 0;
		getFinalPrice();
		RestaurantApp.globalInvoiceManager.addToInvoiceList(this);
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
		double finalPrice = (1 + GST) * getPriceAfterDiscount(calculateBaseTotal());
		this.bill = finalPrice;
		return finalPrice;
		// TODO - implement InvoiceManager.getFinalPrice
		//throw new UnsupportedOperationException();
	}
}