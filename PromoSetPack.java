import java.util.Scanner;
import java.util.ArrayList;
public class PromoSetPack extends MenuItem {
	private ArrayList<MenuItem> promo;
	private String description;
	private String name;
	private double price;

	public PromoSetPack(){
		this.Type = type.PROMO;
		this.promo = new ArrayList<	>();
	}
	public PromoSetPack(String description, String name, double price){ 
		this.Type = type.PROMO; 
		this.description = description;
		this.name = name;
		this.price = price;
		this.promo = new ArrayList<MenuItem>();
	}

	public void update() {
		Scanner sc = new Scanner(System.in); // maybe can implement a while loop
		System.out.println("What would you like to update?");
		System.out.println("1. Description 2. name 3. price 4. add items to Package 5. delete items from package");
		int choice = sc.nextInt();
		sc.nextLine();
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
				return;
			} 
			this.print();
			System.out.println("Which item would you like to delete?");
			int promoIndex = sc.nextInt();
			sc.nextLine();
			this.promo.remove(promoIndex - 1); //delete the index - 1 promoItem from promoPackage
			break;
		}
		System.out.println("Promo Set Package updated, printing updated item...");
		this.print();
	}

	public void print(){
		int ListLength = this.promo.size();
		System.out.println("Type: "+this.Type);
		System.out.println("Name: "+this.name);
		System.out.println("Description: "+this.description);
		System.out.println("$"+this.price+"0");
		System.out.println("Featured dishes:");
		for (int i =0; i<ListLength; i++){
			System.out.print("\t"+(i+1) + ". ");
			System.out.println(this.promo.get(i).getName()); //print name of ala-carte item in promo array
		}
		System.out.println();
	}
	public void addPromoItem(){
		Scanner sc = new Scanner(System.in);
		RestaurantApp.globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		System.out.println("Which item would you like to add?");
		int menuIndex = sc.nextInt();
		sc.nextLine();
		this.promo.add(RestaurantApp.globalMenuManager.getMenuItem(menuIndex-1)); //add the index - 1 menuItem to promoPackage
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
			sc.nextLine();
			if (createChoice == 1){
				this.addPromoItem();
			}
		}
	}

	public type getType() {
		return this.Type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(type type) {
		this.Type = type;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
