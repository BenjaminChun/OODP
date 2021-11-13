import java.util.ArrayList;
import java.util.Scanner;
public class InvoiceManager {
	
	public static double GST = 0.8;
	private ArrayList<Invoice> invoiceList;
	private Invoice currentInvoice;
	
	public InvoiceManager() {
		ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
		currentInvoice = null;
	}
	
	private double calculateBaseTotal() {
		double baseTotal = 0;
		//find list of orderitem
		//iterate thru and calc base total
		for (int i = 0; i<currentInvoice.getOrderDetails().getOrder().getOrderItemList().size(); i++) {
			baseTotal +=  currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getQuantity() * currentInvoice.getOrderDetails().getOrder().getOrderItemList().get(i).getMenuItem().getPrice();
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
		basePrice *= (1-currentInvoice.getCustomer().getDiscount());
		return basePrice;
		// TODO - implement InvoiceManager.getPriceAfterDiscount
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param discountedPrice
	 */
	private double getFinalPrice() {
		double finalPrice = (1 + GST) * getPriceAfterDiscount(calculateBaseTotal());
		return finalPrice;
		// TODO - implement InvoiceManager.getFinalPrice
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 */

	public void chooseInvoice() {
		//ask for userinput for invoice to pay
		System.out.println("List of Orders, please choose the invoice to be paid for: ");
		for (int i=0; i<invoiceList.size(); i++){
			String str = "" + (i+1) + ". ";
			System.out.print(str + "Table ");
			invoiceList.get(i).print();
		}
		Scanner sc = new Scanner(System.in);
		//NOTE THAT orderId corresponds to position in invoiceList
		int index = sc.nextInt();
		sc.nextLine();
		//assign invoice as currentInvoice
		currentInvoice = invoiceList.get(index-1);
		System.out.print("This is the bill for invoice");
		System.out.println(index+1);
		System.out.print("$");
		System.out.println(getFinalPrice());
		// TODO - implement InvoiceManager.chooseInvoice
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Invoice> getInvoiceList() {
		return this.invoiceList;
	}
	//need a way to add to invoicelist
	public void addToInvoiceList(Invoice newInvoice) {
		invoiceList.add(newInvoice);
	}

	public void printInvoiceList(){
		if (this.invoiceList.isEmpty()){
			System.out.println("Empty Invoice List");
			return;
		}
		else {
			for (int i = 0; i<invoiceList.size(); i++){
				System.out.print(i + ". ");
			}
		}
	}

}