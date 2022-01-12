package Boundary;

import java.util.Scanner;
import Controller.StaffManager;

public class StaffBoundary {
    static Scanner sc = new Scanner(System.in);
        public static void callStaffManager(){
            
            int userInput;
            StaffManager Staff = new StaffManager();
            System.out.println("\n1.Create Staff \n"
                            + "2.Delete Staff \n"
                            + "3.Print Staff\n"
																												+ "4.Exit\n");
            		userInput = sc.nextInt();
		switch(userInput) {
		case 1:
			//sc.nextLine();
			Staff.createStaff();
			break;
		case 2:              
			Staff.deleteStaff();
			break;
		case 3:
                        Staff.printStaff();
			break;
			default:
				System.out.println("Exit");
		}
        }
}
