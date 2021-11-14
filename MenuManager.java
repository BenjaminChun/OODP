
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Represents a Menu Manager in a restaurant.
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-13
 */
public class MenuManager {
	/**
	 * The menu list of this menu manager.
	 */
	private ArrayList<MenuItem> menuList;
	/**
	 * Creates a menu manager with a base list of menu items in menu list.
	 */
	public MenuManager() {
		menuList = new ArrayList<MenuItem>();
		menuList.add(new AlaCarte(type.MAINCOURSE, "Mildly spicy, lightly cooked pasta with shrimps and peppers", "Aglio Olio", 6.90)); // can add default menu items when global MenuManager is created
		menuList.add(new AlaCarte(type.DESSERT, "Classic Banana and Vanilla ice-cream combo", "Banana Split", 7.00));
		menuList.add(new AlaCarte(type.DRINKS, "Carbonated sweet drink", "Sprite", 2.10));
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
