package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import Entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationManager {
	
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	ReservationList rl = new ReservationList();
	Scanner sc = new Scanner(System.in);
	
	public void createReservation() {
		Date date =null;
		sc.nextLine();
		System.out.println("Enter date & time to reserve (dd-MM-yyyy HH:mm): ");
		String dateString = sc.nextLine();
		try {
            date = dateTimeFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		System.out.println("Enter number of people:");
		int pax = sc.nextInt();
		System.out.println("Reserved by:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter contact number:");
		int contact = sc.nextInt();
		System.out.println("Enter a table number:");
		TableManager t = new TableManager();
		if(!t.getTable()) {
			System.out.println("No more empty tables. Please choose another date");
			return;
		}
		boolean checkTableStatus = false;
		int table=0;
		while(!checkTableStatus) {
			table = sc.nextInt();
			checkTableStatus = t.checkTableSatus(table, "empty");
			if(!checkTableStatus) {
				System.out.printf("Table %d is not available, please choose another table\n",table);
			}
		}
		
		rl.createReservation(date, pax, name, contact, table);
		t.statusToReserved(table);
	}
	
	public void printReservation() {
		ReservationList rl = new ReservationList();
		rl.printReservation();
	}
	
	public void  checkReservation() {
		ReservationList rl = new ReservationList();
		System.out.println("Enter your contact number for checking");
		int contact = sc.nextInt();
		if(rl.checkReservation(contact))
			System.out.println("You have reservation with us.");
		else
			System.out.println("You don't have reservation with us.");
	}
	
	public void  removeReservation() {
		ReservationList rl = new ReservationList();
		System.out.println("Enter your contact number to remove");
		int contact = sc.nextInt();
		rl.removeReservation(contact);
	}
	
	public void  removeReservation(int contact) {
		ReservationList rl = new ReservationList();
		rl.removeReservation(contact);
	}
}
