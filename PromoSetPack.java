import java.util.Scanner;
import java.util.ArrayList;
public class PromoSetPack extends MenuItem {
	private ArrayList<MenuItem> promo;
	private String description;
	private String name;
	private double price;
	private MenuManager globalMenuManager;

	public PromoSetPack(){
		this.Type = type.PROMO;
		this.promo = new ArrayList<	>();
		
	}
	public PromoSetPack(String description, String name, double price , MenuManager globalMenuManager) {
		// TODO - implement PromoSetPack.PromoSetPack
		this.Type = type.PROMO; 
		this.description = description;
		this.name = name;
		this.price = price;
		this.promo = new ArrayList<MenuItem>();
		this.globalMenuManager = globalMenuManager;

		throw new UnsupportedOperationException();
	}

	public void update() {
		// TODO - implement PromoSetPack.update
		Scanner sc = new Scanner(System.in); // maybe can implement a while loop
		System.out.println("What would you like to update?");
		System.out.println("1. Description 2. name 3. price 4. add items to Package 5. delete items from package");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
			System.out.println("What is the new description?");
			this.description = sc.nextLine();
			break;
			case 2:
			System.out.println("What is the new name?");
			this.name = sc.nextLine();
			break;
			case 3:
			System.out.println("What is the new price?");
			this.price = sc.nextDouble();
			break;
			case 4:
			addPromoItem();
			break;
			case 5:
			if (this.promo.isEmpty()){
				System.out.println("error"); 
				sc.close();
				return;
			} 
			this.print();
			System.out.println("Which item would you like to delete?");
			int promoIndex = sc.nextInt();
			this.promo.remove(promoIndex - 1); //delete the index - 1 promoItem from promoPackage
			break;
		}
		System.out.println("Promo Set Package updated, printing updated item...");
		this.print();
		sc.close();
		throw new UnsupportedOperationException();
	}

	public void print(){
		int ListLength = this.promo.size();
		System.out.println(this.Type);
		System.out.println(this.name);
		System.out.println(this.description);
		System.out.println("$"+this.price);
		System.out.println("Featured dishes:");
		for (int i =0; i<ListLength; i++){
			System.out.print((i+1) + ". ");
			System.out.println(this.promo.get(i).getName()); //print name of ala-carte item in promo array
		}
	}
	public void addPromoItem(){
		Scanner sc = new Scanner(System.in);
		globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		System.out.println("Which item would you like to add?");
		int menuIndex = sc.nextInt();
		this.promo.add(globalMenuManager.getMenuItem(menuIndex-1)); //add the index - 1 menuItem to promoPackage
		sc.close();
	}
	/**
	 * 
	 * @param choice
	 * @param item
	 */

	public void createPromo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats the new promo's name?");
		this.name = sc.nextLine();
		System.out.println("Whats the new promo's description?");
		this.description = sc.nextLine();
		System.out.println("Whats the new promo's price?");
		this.price = sc.nextDouble();
		int createChoice = 0;
		while (createChoice < 2){
			System.out.println("What would you like to do?");
			System.out.println("1. add items 2. quit");
			createChoice = sc.nextInt();
			if (createChoice == 1){
				this.addPromoItem();
			}
		}
		sc.close();
		throw new UnsupportedOperationException();
	}

	public type getType() {
		// TODO - implement PromoSetPack.getType
		return this.Type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(type type) {
		// TODO - implement PromoSetPack.setType
		this.Type = type;
		throw new UnsupportedOperationException();
	}

	public String getName() {
		// TODO - implement PromoSetPack.getName
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO - implement PromoSetPack.setName
		this.name = name;
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		// TODO - implement PromoSetPack.getDescription
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		// TODO - implement PromoSetPack.setDescription
		this.description = description;
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		// TODO - implement PromoSetPack.getPrice
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		// TODO - implement PromoSetPack.setPrice
		this.price = price;
		throw new UnsupportedOperationException();
	}

}