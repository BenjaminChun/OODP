import java.util.Scanner;
public class MenuItem {
	protected type Type; //cannot have same name as enum type
	protected String description;
	protected String name;
	protected double price;

	public MenuItem(){ }

	public void print(){ //should be overridden
		System.out.println("Debug: wrong");
		return;
	}
	public String getName(){
		System.out.println("Debug: wrong");
		return name;
	}
	public double getPrice(){
		System.out.println("Debug: wrong");
		return price;
	}
	public void update(){ //should be overridden
		System.out.println("Debug: wrong");
		return;
	}
	/**
	 * 
	 * @param choice
	 * @param item
	 */
	public MenuItem create(){ //menumanager creates a new menu item object, and call menuItem.create()
		Scanner sc = new Scanner(System.in);
		System.out.println("What kind of menu item would you like to create?");
		System.out.println("1. Ala Carte 2. Promo Set Package");
		int choice = sc.nextInt();
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

	//public abstract void remove(); //do we need this, if java have garbage collector

}
