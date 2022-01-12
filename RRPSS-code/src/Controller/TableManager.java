package Controller;

import java.util.Scanner;
import Entity.TableList;

public class TableManager {
	static TableList t = new TableList();
	
	public static void setTable() {
		Scanner s = new Scanner(System.in);
		int id;
		int capacity;
		String status = "empty";
		System.out.println("Enter the table ID: ");
		id = s.nextInt();
		System.out.println("Enter the capacity: ");
		capacity = s.nextInt();
		t.setTableList(id, capacity, status);
	}
	
	public static boolean getTable() {
		boolean emptyTable = t.getTableList();
		return emptyTable;
	}
	
	public static void changeTableStatus() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the table number:");
		int id = s.nextInt();
		System.out.printf("1: change table to empty\n2: change table to occupied\n3: change table to reserved\n");
		int option= s.nextInt();
		switch(option) {
		case 1:
			statusToEmpty(id);
			break;
		case 2:
			statusToOccupied(id);
			break;
		case 3:
			statusToReserved(id);
			break;
		}
	}
	
	public boolean checkTableSatus(int tableID, String status) {
		if(status.equals(t.checkTableStatus(tableID)) ) {
			return true;
		}
		return false;
	}
	
	public static void statusToEmpty(int id) {
		String status = "empty";
		t.changeTableStatus(id, status);
	}
	
	public static void statusToOccupied(int id) {
		String status = "occupied";
		t.changeTableStatus(id, status);
	}
	
	public static void statusToReserved(int id) {
		String status = "reserved";
		t.changeTableStatus(id, status);
	}
}
