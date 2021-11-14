import java.util.Scanner;
/**
 * Represents the Invoice Manager in a restaurant.
 * @author Tan Zheng Kai
 * @version 2.0
 * @since 2021-11-13
 */
public class MenuItem {
	/**
	 * The type of this Menu Item.
	 */
	protected type Type; //cannot have same name as enum type
	/**
	 * The description of this menu item.
	 */
	protected String description;
	/**
	 * The name of this menu item.
	 */
	protected String name;
	/**
	 * The price of this menu item.
	 */
	protected double price;
	
	/*
	 * Empty Constructor.
	 */
	public MenuItem(){}

	/**
	 * Will be overridden.
	 */
	public void print(){ 
		System.out.println("Debug: wrong");
		return;
	}
	/**
	 * Gets name of this menu item.
	 * @return this menu's name.
	 */
	public String getName(){
		System.out.println("Debug: wrong");
		return name;
	}
	/**
	 * Gets price of this menu item.
	 * @return this menu's price.
	 */
	public double getPrice(){
		System.out.println("Debug: wrong");
		return price;
	}
	/**
	 * Will be overidden.
	 */
	public void update(){ 
		System.out.println("Debug: wrong");
		return;
	}
	/**
	 * Creates a new menu item.
	 * Menu item can be an Ala Carte or Promotional Set Package.
	 * @return menu item created.
	 */
	public MenuItem create(){ //menumanager creates a new menu item object, and call menuItem.create()
		Scanner sc = new Scanner(System.in);
		System.out.println("What kind of menu item would you like to create?");
		System.out.println("1. Ala Carte 2. Promo Set Package");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice ==1){
			AlaCarte temp = new AlaCarte();
			temp.createAlacarte();
			return temp;
		}
		else {
			PromoSetPack temp = new PromoSetPack();
			temp.createPromo();
			return temp;
		}
	}
}
