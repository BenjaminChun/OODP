import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a Invoice Manager in a restaurant.
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
		for (int i = 0; i<currentInvoice.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			baseTotal +=  currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() * currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
		}
		return baseTotal;
	}

	/**
	 * Calculates the discounted price using the current invoice.
	 * @param basePrice The base price of the current invoice.
	 */
	private double getPriceAfterDiscount(double basePrice) {
		basePrice *= (1-currentInvoice.getCustomer().getDiscount());
		return basePrice;
	}

	/**
	 * Calculates the final price using GST of an Invoice Manager.
	 * @param discountedPrice The final price after factoring GST.
	 */
	private double getFinalPrice() {
		double finalPrice = (1 + GST) * getPriceAfterDiscount(calculateBaseTotal());
		return finalPrice;
	}

	/**
	 * Prints out an interface to choose an invoice from the list of invoices.
	 * @param price the price of the invoice chosen.
	 */

	public void chooseInvoice() {
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
	public Invoice createInvoice(OrderDetails od) {
		Invoice temp = new Invoice(od);
		invoiceList.add(temp);
		return temp;
	}

	
}