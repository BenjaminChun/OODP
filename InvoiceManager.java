import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the Invoice Manager in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class InvoiceManager {
	/**
	 * The GST rate of an invoice manager.
	 */
	public static double GST = 0.08;
	/**
	 * The list of invoices of this invoice manager.
	 */
	private ArrayList<Invoice> invoiceList;
	/**
	 * The current invoice of this invoice manager.
	 */
	private Invoice currentInvoice;
	
	public InvoiceManager() {
		this.invoiceList = new ArrayList<Invoice>();
		currentInvoice = null;
	}
	
	/**
	 * Calculates base total using the current invoice of this invoice manager.
	 */
	private double calculateBaseTotal() {
		double baseTotal = 0;
		//find list of orderitem
		//iterate thru and calc base total
		for (int i = 0; i<currentInvoice.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			baseTotal +=  currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() * currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
		}
		return baseTotal;
		//throw new UnsupportedOperationException();
	}

	/**
	 * Calculates the discounted price using the current invoice.
	 * @param basePrice The base price of the current invoice.
	 */
	private double getPriceAfterDiscount(double basePrice) {
		basePrice *= (1-currentInvoice.getCustomer().getDiscount());
		return basePrice;
		// TODO - implement InvoiceManager.getPriceAfterDiscount
		//throw new UnsupportedOperationException();
	}

	/**
	 * Calculates the final price using GST of an Invoice Manager.
	 * @param discountedPrice The final price after facoring GST.
	 */
	private double getFinalPrice() {
		double finalPrice = (1 + GST) * getPriceAfterDiscount(calculateBaseTotal());
		return finalPrice;
		// TODO - implement InvoiceManager.getFinalPrice
		//throw new UnsupportedOperationException();
	}

	/**
	 * Prints out an interface to choose an invoice from the list of invoices.
	 * @param price the price of the invoice chosen.
	 */

	public void chooseInvoice() {
		//ask for userinput for invoice to pay
		System.out.println("List of Orders, please choose the invoice to be paid for based on index given: ");
		for (int i=0; i<invoiceList.size(); i++){
			String str = "" + (i+1) + ". ";
			System.out.print(str + "Table ");
			invoiceList.get(i).print();
		}
		Scanner sc = new Scanner(System.in);
		//NOTE THAT orderId corresponds to position in invoiceList
		try {
			//assign invoice as currentInvoice
			int index = sc.nextInt();
			sc.nextLine();
			if (index <= 0 || index > this.invoiceList.size()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.invoiceList.size());
			}
			currentInvoice = invoiceList.get(index-1);
			//print invoice here
			currentInvoice.printInvoice();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Gets the invoice list of this Invoice Manager.
	 * @return this Invoice Manager's invoice list.
	 */
	public ArrayList<Invoice> getInvoiceList() {
		return this.invoiceList;
	}
	/**
	 * Adds an invoice to this Invoice Manager's invoice list.
	 * @param od Invoice to be added to invoice list.
	 */
	//need a way to add to invoicelist
	public void createInvoice(OrderDetails od) {
		Invoice temp = new Invoice(od);
		invoiceList.add(temp);
	}

	/*public void printInvoice(){
		String result = "Invoice Receipt ";
		System.out.println(result); //print heading
		System.out.println("=====================================");
		System.out.println("Menu Item Name : Quantity * Price");
		for (int i = 0; i<currentInvoice.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			System.out.println(currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getName() +": " +currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() + " * $" + currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice());
		}
		result = "after discount of " + currentInvoice.getCustomer().getDiscount();
		System.out.println(result); 
		result = "Total = " + currentInvoice.getFinalPrice();
		System.out.println(result); //print heading
	}*/
	
}