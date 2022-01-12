package Boundary;
import Controller.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RRPSS {
	static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public static void main(String[] args) {
		ReservationManager Reservation = new ReservationManager();
		TableManager table = new TableManager();
		MenuManager Menumanage = new MenuManager();
		PackageManager Packagemanage = new PackageManager();
		StaffManager Staff = new StaffManager();
		OrderManager OrderList = new OrderManager();
		MemberManager member = new MemberManager();
		int choice;
		do{ // Input 10 to exit
            System.out.println( "1. View menu items\n" +
			                    "2. View promotion package\n" +
			                    "3. Create order\n" +
			                    "4. View order\n" +
			                    "5. Add/Remove order item/s to/from order\n" +
			                    "6. Create reservation booking\n" +
			                    "7. Check reservation booking\n" +
								"8. Remove reservation booking\n"+
			                    "9. Print reservation list\n"+
			                    "10. Check table availability\n" +
			                    "11. Print order invoice\n" +
			                    "12. Exit\n" +
			                    "13. Manager Function\n");
        System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("---------------------------------------------------------------");
			MenuManager.printMenu();
			System.out.println("---------------------------------------------------------------");
            break;
            
        case 2:
        	System.out.println("---------------------------------------------------------------");
        	PackageManager.printPackage();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 3:
        	OrderManager.createOrder();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 4:
        	System.out.println("---------------------------------------------------------------");
        	OrderManager.viewOrder();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 5:
        	System.out.println("---------------------------------------------------------------");
        	OrderManager.ModifyOrder();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 6:
        	System.out.println("---------------------------------------------------------------");
			Reservation.createReservation();
			System.out.println("---------------------------------------------------------------");
            break;

        case 7:
        	System.out.println("---------------------------------------------------------------");
			Reservation.checkReservation();
			System.out.println("---------------------------------------------------------------");
            break;
				
		case 8:
			Reservation.removeReservation();
			System.out.println("---------------------------------------------------------------");
			break;
						
		case 9:
			System.out.println("---------------------------------------------------------------");
			Reservation.printReservation();
			System.out.println("---------------------------------------------------------------");
			break;
			
        case 10:
        	System.out.println("---------------------------------------------------------------");
        	table.getTable();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 11:
        	System.out.println("---------------------------------------------------------------");
        	InvoiceManager im = new InvoiceManager();
        	im.printInvoice();
        	System.out.println("---------------------------------------------------------------");
            break;

        case 12:
        	System.out.println("---------------------------------------------------------------");
            System.out.println("EXIT APPLICATION ...");
            System.out.println("---------------------------------------------------------------");
            break;
            
        case 13:
        	System.out.println("---------------------------------------------------------------");
        	System.out.println( "1. Create/Remove/Print Staff\n" +
			                    "2. Create/Update/Remove MenuItem\n" +
			                    "3. Create/Update/Delete promotion package\n" +
			                    "4. Print daily sale revenue report\n" +
			                    "5. Handle member\n"+
			                    "6. Handle Table\n"+
			                    "7. Exit\n");
        	System.out.print("Enter your choice: ");
        	int option = sc.nextInt();
        	switch(option) {
        	case 1:
				StaffBoundary.callStaffManager();
				break;
        	case 2:
        		MenuBoundary.ModifyMenuItem();
        		break;
        	case 3:
        		MenuBoundary.ModifyPackageSet();
        		break;
        	case 4:
        		RevenueManager rm = new RevenueManager();
        		System.out.println("Enter the date  (dd-MM-yyyy): ");
        		sc.nextLine();
        		String dateString = sc.nextLine();
        		Date date= null;
        		try {
                    date = dateTimeFormat.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        		rm.printDailyReport(date);
        		break;  	
			case 5:
				MemberBoundary.callMemoryManager();
				break;
			case 6:
				TableBoundary.showUI();
				break;
			case 7:
				break;
				
        	default:
            	System.out.println("Please choose correct option\n");
        	}
        	break;
        	
        default:
        	System.out.println("Wrong Options");
		}
	}while(choice != 12);
}}
