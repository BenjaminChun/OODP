
import java.util.Scanner;
import java.util.ArrayList;
public class MenuManager {

	private ArrayList<MenuItem> menuList;

	public MenuManager() {
		menuList = new ArrayList<MenuItem>();
		menuList.add(new AlaCarte(type.MAINCOURSE, "cow's testicles", "jewel of the plains", 69.00)); // can add default menu items when global MenuManager is created
	}

	/**
	 * 
	 * 
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
	 * 
	 * @param choice
	 */
	public void removeItem() {
		Scanner sc = new Scanner(System.in);
		this.printMenu();
		System.out.println("Which item would you like to delete?");
		int menuIndex = sc.nextInt();
		this.menuList.remove(menuIndex - 1); //delete the index - 1 menuItem from menu
	}

	/**
	 * 
	 * @param choice
	 */
	public void updateItem() {
		Scanner sc = new Scanner(System.in);
		this.printMenu();
		System.out.println("Which item would you like to update");
		int updateChoice = sc.nextInt();
		MenuItem temp = this.menuList.get(updateChoice-1);
		temp.update(); //call the correct update method in respective subclasses, not sure if you need to re insert into arraylist. 
	}

	public void printMenu() {
		int menuSize = this.menuList.size();
		System.out.println();
		System.out.println("----------------------------------------------");
		for(int i = 0; i<menuSize; i++){
			System.out.print((i+1) + ". ");
			this.menuList.get(i).print();
			System.out.println("----------------------------------------------");
		}
	}

	/**
	 * 
	 * @param index
	 */
	public MenuItem getMenuItem(int index) {
		MenuItem menuItem = this.menuList.get(index);
		return menuItem;
	}

	public int getSizeOfMenu() {
		return this.menuList.size();
	}

}
