import java.util.ArrayList;
import java.util.Scanner;
public class InvoiceManager {

	private ArrayList<Invoice> invoiceList;
	private Invoice currentInvoice;
	
	public InvoiceManager() {
		this.invoiceList = new ArrayList<Invoice>();
		currentInvoice = null;
	}

	/**
	 * 
	 * @param price
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

	public ArrayList<Invoice> getInvoiceList() {
		return this.invoiceList;
	}
	//need a way to add to invoicelist
	public void createInvoice(OrderDetails od) {
		Invoice temp = new Invoice(od);
		invoiceList.add(temp);
	}
}