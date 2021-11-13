import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class SalesReport {

	private LocalDate startDate;
	private LocalDate endDate;
	private ArrayList<Invoice> invoiceList;
	private double totalRevenue;
	private ArrayList<SaleItem> saleItemList;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param invoiceList
	 */
	public SalesReport(){
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy"); 
		System.out.println("Start Date of Report: (d/MM/yyyy)\n");
		String date = sc.nextLine();
  		//convert String to LocalDate
  		LocalDate startDate = LocalDate.parse(date, formatter);
		System.out.println("End Date of Report: (d/MM/yyyy)\n");
		String date1 = sc.nextLine();
		LocalDate endDate = LocalDate.parse(date1, formatter);
		this.invoiceList = RestaurantApp.globalInvoiceManager.getInvoiceList();
		this.startDate = startDate;
		this.endDate = endDate;
		System.out.println(endDate);
		System.out.println(startDate);
		System.out.println(this.endDate.isAfter(this.startDate));
		this.invoiceList = selectRelevantInvoice();
		this.saleItemList = generateSaleItemList();
		this.totalRevenue = generateRevenue();
	}
	public SalesReport(LocalDate startDate, LocalDate endDate, ArrayList<Invoice> invoiceList) {
		//typical constructor
		this.startDate = startDate;
		this.endDate = endDate;
		this.invoiceList = invoiceList; 
		//i think need call the selectRelevantInvoice to get the invoice list for constructing right
		invoiceList = selectRelevantInvoice();
		saleItemList = generateSaleItemList();
		totalRevenue = generateRevenue();
		// TODO - implement SalesReport.SalesReport
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Invoice> selectRelevantInvoice() {
		//find array size and then loop thru
		if (invoiceList.isEmpty()){
			System.out.println("No Invoices are present");
			return null;
		}
		
		int arrSize = invoiceList.size();
		ArrayList<Invoice> returnList = new ArrayList<Invoice>(); 
		for (int i = 0; i < arrSize; i++) {
			//check if the current invoice fits requirement which is in start and end date
			//AREA FOR IMPROVEMENT if order details change attribute then this cannot work
			if (invoiceList.get(i).getOrderDetails().getDate().isAfter(startDate) && invoiceList.get(i).getOrderDetails().getDate().isBefore(endDate)) {
				//then add it into new returnList
				returnList.add(invoiceList.get(i));
			}
		}
		return returnList;
		// TODO - implement SalesReport.selectRelevantInvoice
		//throw new UnsupportedOperationException();
	}

	public ArrayList<SaleItem> generateSaleItemList() {
		if (invoiceList == null) {
			System.out.println("No Invoices are present");
			return null;
		}
		int invListSize = invoiceList.size();
		ArrayList<SaleItem> returnList = new ArrayList<SaleItem>();
		ArrayList<OrderItem> orderItemList= new ArrayList<OrderItem>();
		boolean finishedForLoop = true;
		//traverse thru the list of invoice
		for (int indexOfList = 0; indexOfList < invListSize; indexOfList++) {
			//within each invoice, traverse thru all items
			//find the orderitemlist for this invoice
			orderItemList = invoiceList.get(indexOfList).getOrderDetails().getOrder().getOrderItemList();
			if (orderItemList.isEmpty()){
				System.out.println("Empty InvoiceList");
				return null;
			}
			for (int indexOfOrderItem = 0 ; indexOfOrderItem < orderItemList.size(); indexOfOrderItem++) {
				//while traversing items, check if it is within saleitem list
				//if it is, add to quantity, if isnt then add to saleitem list
				finishedForLoop = true;
				for (int indexOfSaleItem = 0; indexOfSaleItem < returnList.size(); indexOfSaleItem++) {
					System.out.println(indexOfSaleItem);
					System.out.println(orderItemList.get(indexOfOrderItem).getMenuItem().getName());
					System.out.println(returnList.get(indexOfSaleItem).getOrderItem().getMenuItem().getName());
					if (orderItemList.get(indexOfOrderItem).getMenuItem().getName() == returnList.get(indexOfSaleItem).getOrderItem().getMenuItem().getName()) {//check if equal
						returnList.get(indexOfSaleItem).incrementQuantity(orderItemList.get(indexOfOrderItem).getQuantity()); //increment by amt in orderitem
						finishedForLoop = false;
						break;
					}
				}
				if (finishedForLoop == true){ //add new saleitem to returnlist
					SaleItem toBeAdded = new SaleItem(orderItemList.get(indexOfOrderItem) , orderItemList.get(indexOfOrderItem).getQuantity());
					toBeAdded.getOrderItem();
					returnList.add(toBeAdded);
				}
			}
		}
		return returnList;
		// TODO - implement SalesReport.generateSaleItemList
		//throw new UnsupportedOperationException();
	}

	public double generateRevenue() {
		//initialise revenue variable
		double revenue = 0;
		if (saleItemList.isEmpty()){
			System.out.println("No sale items currently");
			return 0;
		}
		for (int indexOfSaleItemList = 0 ; indexOfSaleItemList < saleItemList.size() ; indexOfSaleItemList++) {
			revenue += (saleItemList.get(indexOfSaleItemList).getOrderItem().getMenuItem().getPrice() * saleItemList.get(indexOfSaleItemList).getQuantity());
		}
		return revenue;
		// TODO - implement SalesReport.generateRevenue
		// throw new UnsupportedOperationException();
	}

	public void printSalesReport(){
		String result = "Sales Report: " + this.startDate + " - " + this.endDate;
		System.out.println(result); //print heading
		System.out.println("=====================================");
		if (saleItemList != null){
			for (int index=0; index < this.saleItemList.size(); index++) {
				result = this.saleItemList.get(index).getOrderItem().getMenuItem().getName() + " - " +  this.saleItemList.get(index).getQuantity();
				System.out.println(result); 
			}
		}
		System.out.println("=====================================");
		result = "Revenue = " + this.totalRevenue;
		System.out.println(result + "\n");
	}

}