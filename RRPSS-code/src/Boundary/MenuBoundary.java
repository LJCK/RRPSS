package Boundary;

import java.util.Scanner;
import Controller.MenuManager;
import Controller.PackageManager;

public class MenuBoundary {
	private static Scanner sc = new Scanner(System.in);
	public static void ModifyMenuItem() {
		int choice;
		System.out.println("1.New Menu Item\n2.Update Menu Item\n3.Remove Menu Item\n");
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			MenuManager.createAlacarte();
			break;
		case 2:
			MenuManager.updateAlacarte();
			break;
		case 3:
			MenuManager.deleteAlacarte();
			break;
		default:
			System.out.println("No such options\n");
		}
	}
	
	public static void ModifyPackageSet() {
		int choice;
		System.out.println("1.New promotion\n2.Update promotion\n3.Remove promotion\n");
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("You want to add new promotion\n");
			PackageManager.createPackage();
			break;
		case 2:
			System.out.println("You want to update promotion\n");
			PackageManager.updatePackage();
			break;
		case 3:
			System.out.println("You want to remove promotion\n");
			PackageManager.deletePackage();
			break;
		default:
			System.out.println("No such options\n");
		}
	}
}
