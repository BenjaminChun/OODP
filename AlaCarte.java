import java.util.Scanner;

public class AlaCarte extends MenuItem {
	public AlaCarte(){}
	public AlaCarte(type type, String description, String name, double price) {
		this.Type = type; 
		this.description = description;
		this.name = name;
		this.price = price;
	}

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
	public void print(){
		System.out.println("Type: "+this.Type);
		System.out.println("Name: "+this.name);
		System.out.println("Description: "+this.description);
		System.out.println("$"+this.price+"0");
		System.out.println();
	}
	/**
	 * 
	 * @param choice
	 * @param item
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
