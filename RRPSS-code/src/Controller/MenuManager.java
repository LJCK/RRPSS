package Controller;
import Entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager{
	private static String FName = "./menu.csv";
	private static ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private static Scanner sc = new Scanner(System.in);
	private static int choice;
	
	public MenuManager() {
		 this.menuItemList = (ArrayList) IOHandler.readSerializedObject(FName);
	    }

	public static ArrayList<MenuItem> getMenu(){
		return menuItemList;
	}
	
	public static void createAlacarte() {
		System.out.println("Enter Item Type");
	    String type1 = sc.nextLine();
	    System.out.println("Enter Item name");
	    String name1 = sc.nextLine();
	    System.out.println("Enter Description");
	    String description1 = sc.nextLine();
	    System.out.println("Enter Item price");
	    float price1 = sc.nextFloat();
	    sc.nextLine();
	    MenuItem newFood = null;
	    if(type1.equals("maincourse")) {
	      newFood = new Maincourse(name1,description1,price1);
	    }else if(type1.equals("drink")) {
	      newFood = new Drink(name1,description1,price1);
	    }else if(type1.equals("dessert")) {
	      newFood = new Dessert(name1,description1,price1);
	    }
	    menuItemList.add(newFood);
	    IOHandler.writeSerializedObject(FName, menuItemList);
	}
	
	public static void printMenu() {
		int i;
		System.out.println("\t\t\t Name\t\t        Price(SGD)");
		System.out.println("\t\t\t\tMain Course\n");
		for (i = 0;i < menuItemList.size(); i++) {
			if(menuItemList.get(i).getType().equals("maincourse"))
				System.out.printf("%d  %26s %23.2f\n",(i+1),menuItemList.get(i).getName(),menuItemList.get(i).getPrice());	
		}
		
		System.out.println("=====================================================================");
		
		System.out.println("\t\t\t\tDrinks");
		for (i =0;i < menuItemList.size(); i++) {
			if(menuItemList.get(i).getType().equals("drink"))
				System.out.printf("%d  %26s %23.2f\n",(i+1),menuItemList.get(i).getName(),menuItemList.get(i).getPrice());	
		}
		
		System.out.println("=====================================================================");
		
		System.out.println("\t\t\t\tDessert");
		for (i =0;i < menuItemList.size(); i++) {
			if(menuItemList.get(i).getType().equals("dessert"))
				System.out.printf("%d  %26s %23.2f\n",(i+1),menuItemList.get(i).getName(),menuItemList.get(i).getPrice());	
		}
		System.out.println("\n");
}
	public static void updateAlacarte(){
		printMenu();
		String updateString;
	    float updatePrice;
	    int updateItem;
	    int updateOption;
	    System.out.println("Enter Menu ID to update");
	    updateItem = sc.nextInt();
	    if(updateItem > menuItemList.size()) {
	      System.out.println("Menu Item Not found");
	      return;
	    }
	    System.out.println("Menu Item Details");
	    System.out.println("Name:"+menuItemList.get(updateItem-1).getName());
	    System.out.println("Price:"+menuItemList.get(updateItem-1).getPrice());
	    System.out.println("Description:"+menuItemList.get(updateItem-1).getDescription());
	    System.out.println("Type:"+menuItemList.get(updateItem-1).getType());
		System.out.println("\nUpdate Options\n1. Update name; 2. Update price; 3. Update type; 4. Update description; 5. Exit");
		updateOption = sc.nextInt();
		sc.nextLine();
		switch(updateOption) {
		case 1:
			System.out.println("Enter new name");
			updateString = sc.nextLine();
			menuItemList.get(updateItem-1).setName(updateString);
			System.out.println("Name updated");
			IOHandler.writeSerializedObject(FName, menuItemList);
			break;
		case 2:
			System.out.println("Update new price");
			updatePrice = sc.nextFloat();
			menuItemList.get(updateItem-1).setPrice(updatePrice);
			System.out.println("Price updated");
			IOHandler.writeSerializedObject(FName, menuItemList);
			sc.nextLine();
			break;
		case 3:
			System.out.println("Update new type");
			updateString = sc.nextLine();
			menuItemList.get(updateItem-1).setName(updateString);
			System.out.println("Type updated");
			IOHandler.writeSerializedObject(FName, menuItemList);
			break;
		case 4:
			System.out.println("Update new description");
			updateString = sc.nextLine();
			menuItemList.get(updateItem-1).setName(updateString);
			System.out.println("Description updated");
			IOHandler.writeSerializedObject(FName, menuItemList);
			break;
		default:
			System.out.println("\n");
		}
	}
	
	
	public static void deleteAlacarte(){
		printMenu();
		String confirmation;
		System.out.println("Enter Menu ID to remove: ");
		choice = sc.nextInt();
	    if(choice > menuItemList.size()) {
	      System.out.println("Menu Item Not found");
	      return;
	    }
	    sc.nextLine();
		System.out.println("Remove "+menuItemList.get(choice-1).getName()+"? Please input yes or no");
		confirmation = sc.nextLine();
		if(confirmation.equals("yes")) {
			menuItemList.remove(choice-1);
			System.out.println("Remove successfully!\n");
			IOHandler.writeSerializedObject(FName, menuItemList);
		}
		else
			System.out.println("Remove Rejected\n");	
	}
}
