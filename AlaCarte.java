import java.util.Scanner;
/**
 * Represents an Ala Carte Item in the Restaurant's Menu.
 * @author Tan Zheng Kai
 * @version 3.0
 * @since 2021-11-13
 */
public class AlaCarte extends MenuItem {
	public AlaCarte(){}
	/**
	 * Creates a new Ala Carte item with the given name. 
	 * @param type This Ala Carte item's meal type.
	 * @param description This Ala Carte item's desciption.
	 * @param name This Ala Carte item's name.
	 * @param price This Ala Carte item's price.
	 */
	public AlaCarte(type type, String description, String name, double price) {
		this.Type = type; 
		this.description = description;
		this.name = name;
		this.price = price;
	}
	/**
	 * Scan and updates the attributes of this Ala Carte item.
	 */
	public void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to update?");
		System.out.println("1. Type 2. Description 3. name 4. price");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 1:
			System.out.println("What is its type");
			System.out.println("1. Main Course 2. Drinks 3. Desserts");
			int typeChoice = sc.nextInt();
			sc.nextLine();
			switch(typeChoice){
				case 1: this.Type = type.MAINCOURSE; break;
				case 2: this.Type = type.DRINKS; break;
				case 3: this.Type = type.DESSERT; break;
			}
			break;
			case 2:
			System.out.println("What is the new description?");
			this.description = sc.nextLine();
			break;
			case 3:
			System.out.println("What is the new name?");
			this.name = sc.nextLine();
			break;
			case 4:
			System.out.println("What is the new price?");
			this.price = sc.nextDouble();
			break;
		}
		System.out.println("Ala Carte item updated, printing updated item...");
		this.print();
	}
	/**
	 * Prints out the attributes of this Ala Carte item.
	 */
	public void print(){
		System.out.println("Type: "+this.Type);
		System.out.println("Name: "+this.name);
		System.out.println("Description: "+this.description);
		System.out.printf("$%.2f\n", this.price);
		System.out.println();
	}
	/**
	 * Scan inputs to set attributes for this Ala Carte item.
	 */
	public void createAlacarte() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats the new item's type?");
		System.out.println("1. Main Course 2. Drinks 3. Desserts");
		int newTypeChoice = sc.nextInt();
		switch(newTypeChoice){
			case 1:
				this.Type = type.MAINCOURSE;
				break;
			case 2:
				this.Type = type.DRINKS;
				break;
			case 3:
				this.Type = type.DESSERT;
				break;
		}
		sc.nextLine();
		System.out.println("Whats the new item's name?");
		this.name = sc.nextLine();
		System.out.println("Whats the new item's description?");
		this.description = sc.nextLine();
		System.out.println("Whats the new item's price?");
		this.price = sc.nextDouble();
		System.out.println("New Ala Carte item added. printing new item...");
		this.print();
	}
	/**
	 * Gets the type of this Ala Carte item.
	 * @return this Ala Carte item's type.
	 */
	public type getType() {
		return this.Type;
	}

	/**
	 * Changes the type of this Ala Carte item.
	 * @param type this Ala Carte item's type.
	 */
	public void setType(type type) {
		this.Type = type;
	}

	/**
	 * Gets the name of this Ala Carte item.
	 * @return this Ala Carte item's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of this Ala Carte item.
	 * @param name this Ala Carte item's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the description of this Ala Carte item.
	 * @return this Ala Carte item's description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Changes the description of this Ala Carte item.
	 * @param description this Ala Carte item's description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the price of this Ala Carte item.
	 * @return this Ala Carte item's price.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Changes the price of this Ala Carte item.
	 * @param price this Ala Carte item's price.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
