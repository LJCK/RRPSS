package Entity;

import Controller.*;
import java.util.ArrayList;
import java.util.Date;

public class ReservationList {
  private static ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	private static String fileName = "./reservation.csv";
	TableManager t = new TableManager();
	
	public ReservationList(){
		this.reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
	}
	
	public void createReservation(Date date, int pax, String name, int contact, int table) {
		Reservation r = new Reservation(date,pax,name, contact,table);
		reservationList.add(r);
		System.out.printf("Table \t Reserved by \t\t Date \t\t\t Contact number\n");
		System.out.printf("%d  | %10s   | %30s | %15d \n",r.getTableID(),r.getBookingName(),r.getDateTime(),r.getContactNumber());
		IOHandler.writeSerializedObject(fileName, reservationList);
		System.out.println("reservation created.");
		
	}
	
	public void printReservation() {
		reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
		System.out.printf("Table \t Reserved by \t\t Date \t\t\t Contact number\n");
		for(int i=0;i<reservationList.size();i++) {
			System.out.printf("%d  | %10s   | %30s | %15d \n",reservationList.get(i).getTableID(),reservationList.get(i).getBookingName(),reservationList.get(i).getDateTime(),reservationList.get(i).getContactNumber());
		}
	}
	
	private void  manageReservation() {
		reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
		Date now = new Date();
		
		for(int i=0;i<reservationList.size();i++) {
	    	if(reservationList.get(i).getDateLimit().before(now)||t.checkTableSatus(reservationList.get(i).getTableID(), "occupied")) {
	    		if(t.checkTableSatus(reservationList.get(i).getTableID(), "reserved"))
	    			t.statusToEmpty(reservationList.get(i).getTableID());
	    		reservationList.remove(i);
	    	}
		}
		IOHandler.writeSerializedObject(fileName, reservationList);
	}
	
	public boolean checkReservation(int contact) {
		manageReservation();
		reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
		for(Reservation reserve : reservationList) {
			if(reserve.getContactNumber()==contact)
				return true;
		}
		return false;
	}
	
	public int retrieveReservation(int contact) {
		manageReservation();
		reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
		for(Reservation reserve : reservationList) {
			if(reserve.getContactNumber()==contact)
				return reserve.getTableID();
		}
		return -1;
	}
	
	public void removeReservation(int contact) {
		reservationList = (ArrayList<Reservation>) IOHandler.readSerializedObject(fileName);
		for(int i=0;i<reservationList.size();i++) {
			if(reservationList.get(i).getContactNumber()==contact) {
				t.statusToEmpty(reservationList.get(i).getTableID());
				reservationList.remove(i);
				System.out.println("Reservation removed");
				IOHandler.writeSerializedObject(fileName, reservationList);
				return;
			}
		}
		System.out.println("No reservation with us.");		
	}
}
