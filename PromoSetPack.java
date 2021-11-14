import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents the Promotional Set Package on the menu in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class PromoSetPack extends MenuItem {
	/**
	 * The list of promotional items in this Promotional set package.
	 */
	private ArrayList<MenuItem> promo;
	/**
	 * The description of this promotional set package.
	 */
	private String description;
	/**
	 * The name of this promotional set package.
	 */
	private String name;
	/**
	 * The price of this promotional set package.
	 */
	private double price;

	/**
	 * Creates a new promotional set package.
	 */
	public PromoSetPack(){
		this.Type = type.PROMO;
		this.promo = new ArrayList<	>();
	}
	/**
	 * Creates a new promotional set package with given name.
	 * @param description The description of this promotional set package.
	 * @param name The name of this promotional set package.
	 * @param price The price of this promotional set package.
	 */
	public PromoSetPack(String description, String name, double price){ 
		this.Type = type.PROMO; 
		this.description = description;
		this.name = name;
		this.price = price;
		this.promo = new ArrayList<MenuItem>();
	}

	/**
	 * Update the attributes of the Promotional Set Package.
	 */
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

	/**
	 * Prints out the attributes of the promotional set package. 
	 */
	public void print(){
		int ListLength = this.promo.size();
		System.out.println("Type: "+this.Type);
		System.out.println("Name: "+this.name);
		System.out.println("Description: "+this.description);
		System.out.printf("$%.2f\n", this.price);
		System.out.println("Featured dishes:");
		for (int i =0; i<ListLength; i++){
			System.out.print("\t"+(i+1) + ". ");
			System.out.println(this.promo.get(i).getName()); //print name of ala-carte item in promo array
		}
		System.out.println();
	}

	/**
	 * Adds a promotional set item into the promotional item list.
	 */
	public void addPromoItem(){
		Scanner sc = new Scanner(System.in);
		try {
			int i = 0;
			System.out.println();
			System.out.println("----------------------------------------------");
			while (RestaurantApp.globalMenuManager.getMenuItem(i).Type != type.PROMO){
				System.out.println((i+1)+". ");
				RestaurantApp.globalMenuManager.getMenuItem(i).print();
				System.out.println("----------------------------------------------");
				i++;
			}
			//RestaurantApp.globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
			System.out.println("Which item would you like to add?");
			int menuIndex = sc.nextInt();
			sc.nextLine();
			if(menuIndex <= 0 || menuIndex >i){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+i);
			}
			this.promo.add(RestaurantApp.globalMenuManager.getMenuItem(menuIndex-1)); //add the index - 1 menuItem to promoPackage
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("program exiting...");
			System.exit(0);
		}
		/*
		RestaurantApp.globalMenuManager.printMenu(); //create a globalmenuManager so that other classes can access the menu
		System.out.println("Which item would you like to add?");
		int menuIndex = sc.nextInt();
		sc.nextLine();
		this.promo.add(RestaurantApp.globalMenuManager.getMenuItem(menuIndex-1)); //add the index - 1 menuItem to promoPackage
		*/
	}
	/**
	 * A new promotional set package is made through asking for each attribute.
	 * @param choice Choice the user makes to proceed with creation of the promo.
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

	/**
	 * Gets the type of this promotional set package.
	 * @return the type of the promotional set package.
	 */
	public type getType() {
		return this.Type;
	}

	/**
	 * Changes the type of this promotional set package.
	 * @param type The type of this promotional set package.
	 */
	public void setType(type type) {
		this.Type = type;
	}

	/**
	 * Gets the name of this promotional set package.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of this promotional set package.
	 * @param name The name of this promotional set package.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name of this promotional set package.
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Changes the name of this promotional set package.
	 * @param description The description of this promotional set package.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the price of this promotional set package.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Changes the price of this promotional set package.
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
