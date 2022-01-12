package Controller;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.*;
import Controller.*;

public class OrderManager {
	private static Scanner sc = new Scanner(System.in);
	private static String FName = "./orderList.csv";
	private static ReservationList rl = new ReservationList();
	private static TableManager t = new TableManager();
	private static ReservationManager rm = new ReservationManager();
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	private static ArrayList<PromotionalPackage> PackageItem = PackageManager.getPackage();
	private static ArrayList<MenuItem> FoodItem = MenuManager.getMenu();
	
	public OrderManager() {
        this.orderList = (ArrayList) IOHandler.readSerializedObject(FName);
    }
	
	private static int findPackageID(int id) {
        for (int i = 0; i < PackageItem.size(); i++) {
            if (PackageItem.get(i).getpackageID() == id) return i;
        }
        System.out.println("Package ID not found\n");
        return -1;
    }
	
	private static int findOrderID(int id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderID() == id) return i;
        }
        System.out.println("Order ID not found\n");
        return -1;
    }
	
	public static void createOrder() {
		int staffID;
		int tableNumber;
		int orderID;
		int choice;
		int FoodID, contact;
		System.out.println("Enter the staff ID");
		staffID = sc.nextInt();
		System.out.println("Enter your number to check your reservation:");
		contact = sc.nextInt();
		tableNumber = rl.retrieveReservation(contact);
		if(tableNumber==-1) {
			System.out.println("You don't have reservation with us, please choose a table:");
			boolean Tstatus = t.getTable();
			if(Tstatus == false) {
				System.out.println("All table full. Please come next time.");
				return;
			}
			tableNumber = sc.nextInt();
		}
		System.out.println("Enter the Order ID");
		orderID = sc.nextInt();
		Order NewOrder = new Order(staffID,tableNumber,orderID);
		do {
			System.out.println("1.Add Alacarte\n2.Add Promotion Package\n3.Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				Controller.MenuManager.printMenu();;
				System.out.println("Enter the MenuItem ID");
				FoodID = sc.nextInt();
				FoodID--;
				if(FoodID > FoodItem.size()) {
					System.out.println("No such MenuItem ID");
				}
				else {
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					NewOrder.addAlacarte(FoodID,quantity);
					System.out.println(FoodItem.get(FoodID).getName()+" added to Order");
				}
				break;
			case 2:
				Controller.PackageManager.printPackage();
				System.out.println("Enter the Package ID");
				FoodID = sc.nextInt();
				int i = findPackageID(FoodID);
				if (i == -1)
					System.out.println("No such Package ID");
				else {
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					NewOrder.addPackage(FoodID,quantity);
					System.out.println("Package"+FoodID+" added to Order");
				}
				break;
			default:
				System.out.println("Exit");
			}
		}while(choice!=3);
		sc.nextLine();
		orderList.add(NewOrder);
		CalculateTotal(NewOrder.getOrderID());
		IOHandler.writeSerializedObject(FName, orderList);
		ReservationManager rm = new ReservationManager();
		rm.removeReservation(contact);
		t.statusToOccupied(tableNumber);
	}
	
	public static void viewOrder() {
		int orderID;
		System.out.println("Enter the Order ID to view");
		orderID = sc.nextInt();
		int i  = findOrderID(orderID);
		if(i == -1)
			System.out.println("No such order");
		else {
			Order O1 = orderList.get(i);
			System.out.println("Order ID: " + orderID);
			System.out.println("Staff ID: "+ O1.getStaff());
			System.out.println("Table Number: " + O1.getTableNumber());
			System.out.println("Ordered Item");
			System.out.println("========================");
			System.out.println("Alacarte Item");
			for (int x = 0; x < O1.getAlacarte().size(); x ++) {
				System.out.println((x+1)+". "+FoodItem.get(O1.getAlacarte().get(x)).getName()+"*"+ O1.getAlacarteQuan().get(x));
			}
			System.out.println("========================");
			System.out.println("\nPackage Item");
			for (int x = 0; x < O1.getPackage().size(); x++) {
				System.out.println((x+1)+". Package "+O1.getPackage().get(x)+"*"+ O1.getPackageQuan().get(x));
			}
			System.out.println("========================");
			System.out.println("Total Price:"+O1.getTotal());
		}
		sc.nextLine();
		System.out.println("\n");
	}
	
	public static void viewOrder(int orderID) {
		int i  = findOrderID(orderID);
		if(i == -1)
			System.out.println("No such order");
		else {
			Order O1 = orderList.get(i);
			System.out.println("Order ID: " + orderID);
			System.out.println("Staff ID: "+ O1.getStaff());
			System.out.println("Table Number: " + O1.getTableNumber());
			System.out.println("Ordered Item");
			System.out.println("========================");
			System.out.println("Alacarte Item");
			for (int x = 0; x < O1.getAlacarte().size(); x ++) {
				System.out.println((x+1)+". "+FoodItem.get(O1.getAlacarte().get(x)).getName()+"*"+ O1.getAlacarteQuan().get(x));
			}
			System.out.println("========================");
			System.out.println("\nPackage Item");
			for (int x = 0; x < O1.getPackage().size(); x++) {
				System.out.println((x+1)+". Package "+O1.getPackage().get(x)+"*"+ O1.getPackageQuan().get(x));
			}
			System.out.println("========================");
			System.out.println("Total Price:"+O1.getTotal());
		}
		sc.nextLine();
		System.out.println("\n");
	}
	
	
	
	public static Order getOrder(int orderID) {
		int i  = findOrderID(orderID);
		if(i == -1) {
			System.out.println("No such order");
			return null;
		}
		else {
			return orderList.get(i);
		}
	}
	
	public static int printOrder(int orderID) {
		int i  = findOrderID(orderID);
		if(i == -1)
			System.out.println("No such order");
		else {
			Order O1 = orderList.get(i);
			
			System.out.printf("%s \t %s \t\t\t\t %s\n","Qty", "Item","Amount");
			if(O1.getAlacarte().size()!=0) {
				System.out.println("---------------------------------------------------------------");
				for (int x = 0; x < O1.getAlacarte().size(); x ++) {
					System.out.printf("%-5d %-30s %10.2f\n",O1.getAlacarteQuan().get(x),FoodItem.get(O1.getAlacarte().get(x)).getName(),
							FoodItem.get(O1.getAlacarte().get(x)).getPrice()*O1.getAlacarteQuan().get(x));
					//System.out.println(O1.getAlacarteQuan().get(x)+"\t"+FoodItem.get(O1.getAlacarte().get(x)).getName()+"\t"
				//+FoodItem.get(O1.getAlacarte().get(x)).getPrice()*O1.getAlacarteQuan().get(x));
				}
			}
			if(O1.getPackage().size()!=0) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("Package Item");
				for (int x = 0; x < O1.getPackage().size(); x++) {
					int n = findPackageID(O1.getPackage().get(x));
					System.out.printf("%-5d Package %-30s %10.2f\n",O1.getPackageQuan().get(x),O1.getPackage().get(x),
							PackageItem.get(n).getPackagePrice()*O1.getPackageQuan().get(x));
				}
			}
			System.out.println("---------------------------------------------------------------");
		}
		return i;
	}
	
	public static void ModifyOrder() {
		int orderID;
		int choice;
		int food;
		int option;
		System.out.println("Enter Order ID to modify");
		orderID = sc.nextInt();
		int i  = findOrderID(orderID);
		if(i == -1) {
			System.out.println("No such Order ID");
		}
		else {
			Order ModifyID = orderList.get(i);
			viewOrder(orderID);
			System.out.println("1.Add order item\n2.Remove order Item");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("1.Add Alacarte\n2.Add Package");
				option = sc.nextInt();
				if(option == 1) {
					Controller.MenuManager.printMenu();
					System.out.println("1.Enter Alacarte ID");
					food = sc.nextInt();
					food--;
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					ModifyID.addAlacarte(food,quantity);
				}
				else {
					Controller.PackageManager.printPackage();
					System.out.println("1.Enter Package ID");
					int packageID = sc.nextInt();
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					ModifyID.addPackage(packageID,quantity);
				}
				break;
			case 2:
				System.out.println("1.Remove Alacarte\n2.Remove Package");
				option = sc.nextInt();
				if(option == 1) {
					System.out.println("1.Enter Item ID");
					food = sc.nextInt();
					food--;
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					ModifyID.removeAlacarte(food,quantity);
					CalculateTotal(orderID);
					IOHandler.writeSerializedObject(FName, orderList);
					return;
				}
				else {
					System.out.println("1.Enter Package ID");
					food = sc.nextInt();
					food--;
					System.out.println("Enter Quantity");
					int quantity = sc.nextInt();
					ModifyID.removePackage(food, quantity);
					CalculateTotal(orderID);
					IOHandler.writeSerializedObject(FName, orderList);
					}
				break;
			}
			CalculateTotal(orderID);
			IOHandler.writeSerializedObject(FName, orderList);
		}
		System.out.println("\n");
	}
	
	private static void CalculateTotal(int orderID) {
		int i  = findOrderID(orderID);
		Order O1 = orderList.get(i);
		float alacateSum = 0;
		float packageSum = 0;
		for(int x = 0; x < O1.getAlacarte().size(); x++) {
			alacateSum += (FoodItem.get(O1.getAlacarte().get(x)).getPrice()*O1.getAlacarteQuan().get(x));
		}
		for(int x = 0; x < O1.getPackage().size(); x++) {
			int z = findPackageID(O1.getPackage().get(x));
			packageSum += (PackageItem.get(z).getPackagePrice()*O1.getPackageQuan().get(x));
		}
		O1.setTotal(packageSum+alacateSum);
	}
	
	public static void deleteOrderID(int orderID) {
		for(int x = 0; x < orderList.size(); x++) {
			if(orderID ==orderList.get(x).getOrderID()) {
				orderList.remove(x);
				IOHandler.writeSerializedObject(FName, orderList);
			}	
		}
	}
}
