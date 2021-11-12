public class PrintOrderInvoice {

	/**
	 * 
	 * @param orderDetails
	 */
	public PrintOrderInvoice() {
	}
	public void printOrderInvoice(Invoice invoice, double price, double discountRate) {
		String result = "Invoice Receipt ";
		System.out.println(result); //print heading
		System.out.println("=====================================");
		for (int i = 0; i<invoice.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			result = invoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getName() + invoice.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() + " * $" + invoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
			System.out.println(result);
		}
		result = "after discount of " + discountRate;
		System.out.println(result); 
		result = "Total = " + price;
		System.out.println(result); //print heading
		// TODO - implement PrintOrderInvoice.printOrderInvoice
		//throw new UnsupportedOperationException();
	}

}