
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 */
public class MenuManager {
	/**
	 * The menu list of this menu item.
	 */
	private ArrayList<MenuItem> menuList;
	/**
	 * Creates a menu manager with a base list of menu items in menu list.
	 */
	public MenuManager() {
		menuList = new ArrayList<MenuItem>();
		menuList.add(new AlaCarte(type.MAINCOURSE, "cow's testicles", "jewel of the plains", 69.00)); // can add default menu items when global MenuManager is created
		menuList.add(new AlaCarte(type.DESSERT, "cow herded from space, rare delicacy", "milkshake from space", 68.99));
		menuList.add(new AlaCarte(type.DRINKS, "feels like i'm floating", "zero-gravity", 68.98));
		menuList.add(new PromoSetPack("family-friendly lunch","sunday fun day",180));
	}

	/**
	 * Adds a menu item into the menu list.
	 */
	public void addItem() {
		MenuItem temp = new MenuItem();
		temp = temp.create(); //menuItem object calls create which promts for user inputs to create respective menuItem
		if (menuList.contains(temp)){
			System.out.println("Menu item already exists, exitting");
			return;
		}
		if (temp instanceof AlaCarte){
			this.menuList.add(0,temp); //add to front of list
		}
		else {
			this.menuList.add(temp); // add promo to end of the list
		}
	}

	/**
	 * Removes a menu item from this menu manager's menu list based on user's choice.
	 * @param choice The choice of menu item to be removed.
	 */
	public void removeItem() {
		Scanner sc = new Scanner(System.in);
		try {
			this.printMenu();
			System.out.println("Which item would you like to delete?");
			int menuIndex = sc.nextInt();
			sc.nextLine();
			if (menuIndex <= 0 || menuIndex > this.getSizeOfMenu()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.getSizeOfMenu());
			}
			this.menuList.remove(menuIndex - 1); //delete the index - 1 menuItem from menu
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		}
	}

	/**
	 * Update a menu item in this menu manager's manu list.
	 * @param choice
	 */
	public void updateItem() {
		Scanner sc = new Scanner(System.in);
		this.printMenu();
		try {
			System.out.println("Which item would you like to update");
			int updateChoice = sc.nextInt();
			sc.nextLine();
			if (updateChoice <= 0 || updateChoice > this.getSizeOfMenu()){
				throw new ArrayIndexOutOfBoundsException("Please input a valid index from 1 to "+this.getSizeOfMenu());
			}
			MenuItem temp = this.menuList.get(updateChoice-1);
			temp.update(); //call the correct update method in respective subclasses, not sure if you need to re insert into arraylist.
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage()); 
			System.out.println("program exiting ...");
			System.exit(0);
		} 
	}

	/**
	 * Prints this menu manager's menu list.
	 */
	public void printMenu() {
		int menuSize = this.menuList.size();
		System.out.println();
		System.out.println("--------------------MENU----------------------");
		for(int i = 0; i<menuSize; i++){
			System.out.println((i+1) + ". ");
			this.menuList.get(i).print();
			System.out.println("----------------------------------------------");
		}
		System.out.println();
	}

	/**
	 * Gets a menu item in the list with given index.
	 * @param index
	 */
	public MenuItem getMenuItem(int index) {
		MenuItem menuItem = this.menuList.get(index);
		return menuItem;
	}
	/**
	 * Gets the size of the menu list of this Menu Manager.
	 * @return
	 */
	public int getSizeOfMenu() {
		return this.menuList.size();
	}

}
