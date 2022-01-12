package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.MenuItem;
import Entity.PromotionalPackage;

public class PackageManager{
	private static Scanner sc = new Scanner(System.in);
	
	private static String FName = "./PromotionalSet.csv";
	
	private static ArrayList<PromotionalPackage> packageList = new ArrayList<PromotionalPackage>();
	private static ArrayList<MenuItem> FoodItem = MenuManager.getMenu();
	
	public PackageManager() {
        this.packageList = (ArrayList) IOHandler.readSerializedObject(FName);
    }
	
	public static ArrayList<PromotionalPackage> getPackage(){
		return packageList;
	}
	
	private static int findIndex(int id) {
        for (int i = 0; i < packageList.size(); i++) {
            if (packageList.get(i).getpackageID() == id) return i;
        }
        System.out.println("Package ID not found\n");
        return -1;
    }
	
	public static void createPackage() {
		int number;
		int id;
		float price;
		int FoodID;
		System.out.println("Enter a New Promotional ID:");
		id = sc.nextInt();
		if(findIndex(id)!=-1) {
			System.out.println("Package exist\n");
			return;
		}
		System.out.println("Enter the price for this packageSet");
		price = sc.nextFloat();
		System.out.println("Create a promotion set successfully");
		PromotionalPackage NewPromotion = new PromotionalPackage(id,price);
		System.out.println("ID:"+NewPromotion.getpackageID()+"  Price:"+NewPromotion.getPackagePrice());
		System.out.println("Enter Package Size");
		number = sc.nextInt();
		MenuManager.printMenu();
		System.out.println("Add food to Package "+id);
		for(int i = 0; i < number; i++) {
			FoodID = sc.nextInt();
			System.out.println(FoodItem.get(FoodID-1).getName()+" added to package");
			NewPromotion.addMenuIdList(FoodID-1);
		}
		sc.nextLine();
		packageList.add(NewPromotion);
		IOHandler.writeSerializedObject(FName, packageList);
	} 
	
	public static void printPackage() {
		for(int i = 0; i < packageList.size(); i++) {
			PromotionalPackage P1 = packageList.get(i);
			System.out.println("Package ID:"+P1.getpackageID());
			System.out.println("Food in package:");
			for(int j = 0; j < P1.getMenuIdList().size(); j++) {
				System.out.println((j+1)+"."+FoodItem.get(P1.getMenuIdList().get(j)).getName()+"("+FoodItem.get(P1.getMenuIdList().get(j)).getType()+")");
			}
			System.out.println("Total Price:$"+packageList.get(i).getPackagePrice()+"\n");
		}
	}
	
	public static void printByPackageID(int packageID) {
			int position;
			for (int x = 0; x < packageList.size(); x++) {
				if(packageList.get(x).getpackageID()==packageID) {
					position = x;
					PromotionalPackage P1 = packageList.get(position);
					System.out.println("Package ID:"+P1.getpackageID());
					System.out.println("Food in package:");
					for(int j = 0; j < P1.getMenuIdList().size(); j++) {
						System.out.println((j+1)+"."+FoodItem.get(P1.getMenuIdList().get(j)).getName()+"("+FoodItem.get(P1.getMenuIdList().get(j)).getType()+")");
					}
				}
			}
		}
	
	public static void deletePackage() {
		printPackage();
		System.out.println("Enter the package ID you want to remove:");
		int id;
		id = sc.nextInt();
		int i = findIndex(id);
		if(i!=-1) {
			packageList.remove(i);
			System.out.println("Package ID:"+id+" removed!\n");
			IOHandler.writeSerializedObject(FName, packageList);
		}
		sc.nextLine();
	}
	
	public static void updatePackage() {
		printPackage();
		System.out.println("Enter the package ID you want to update:");
		int id;
		id = sc.nextInt();
		int i = findIndex(id);
		if(i!=-1) {
			System.out.println("Package Details");
			printByPackageID(id);
			System.out.println("\n1.Update Price\n2.Add item to package\n3.Remove item from package");
			id = sc.nextInt();
			switch(id) {
			case 1:
				System.out.println("Enter the new price:");
				float price = sc.nextFloat();
				packageList.get(i).setPackagePrice(price);
				System.out.println("Package Updated");
				break;
			case 2:
				Controller.MenuManager.printMenu();
				System.out.println("Enter the Alacarte ID to add to the package");
				id = sc.nextInt();
				if(id > FoodItem.size()) {
					System.out.println("No ID found\n");
					return;
				}
				packageList.get(i).addMenuIdList(id-1);
				System.out.println("Package Updated");
				break;
			case 3:
				System.out.println("Enter the item to remove from the package");
				int itemID = sc.nextInt();
				if(id > FoodItem.size()) {
					System.out.println("No ID found\n");
					return;
				}
				packageList.get(i).getMenuIdList().remove(itemID-1);
				System.out.println("Package Updated");
				break;
			default:
					System.out.println("Wrong input");
			}
		}
		IOHandler.writeSerializedObject(FName, packageList);
		sc.nextLine();
	}
}
