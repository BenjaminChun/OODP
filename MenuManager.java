
import java.util.Scanner;
import java.util.ArrayList;
public class MenuManager {

	private ArrayList<MenuItem> menuList;

	public MenuManager() {
		// TODO - implement MenuManager.MenuManager
		menuList = new ArrayList<MenuItem>();
		menuList.add(new AlaCarte(type.MAINCOURSE, "cow's testicles", "jewel of the plains", 69.00)); // can add default menu items when global MenuManager is created
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * 
	 */
	public void addItem() {
		// TODO - implement MenuManager.AddItem
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
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param choice
	 */
	public void removeItem() {
		// TODO - implement MenuManager.RemoveItem
		Scanner sc = new Scanner(System.in);
		this.printMenu();
		System.out.println("Which item would you like to delete?");
		int menuIndex = sc.nextInt();
		this.menuList.remove(menuIndex - 1); //delete the index - 1 menuItem from menu
		sc.close();
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param choice
	 */
	public void updateItem() {
		// TODO - implement MenuManager.UpdateItem
		Scanner sc = new Scanner(System.in);
		this.printMenu();
		System.out.println("Which item would you like to update");
		int updateChoice = sc.nextInt();
		MenuItem temp = this.menuList.get(updateChoice-1);
		temp.update(); //call the correct update method in respective subclasses, not sure if you need to re insert into arraylist. 
		sc.close();
		//throw new UnsupportedOperationException();
	}

	public void printMenu() {
		// TODO - implement MenuManager.DisplayMenu
		int menuSize = this.menuList.size();
		for(int i = 0; i<menuSize; i++){
			System.out.print((i+1) + ". ");
			this.menuList.get(i).print();
			System.out.println("----------------------------------------------");
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public MenuItem getMenuItem(int index) {
		MenuItem menuItem = this.menuList.get(index);
		return menuItem;
		// TODO - implement MenuManager.getMenuItem
	}

	public int getSizeOfMenu() {
		return this.menuList.size();
		// TODO - implement MenuManager.getSizeOfMenu
	}

}