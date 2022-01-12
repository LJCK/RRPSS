package Entity;
import java.io.Serializable;
import java.util.*;
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3481991723906043472L;
	private ArrayList<Integer> AlacarteOrder = new ArrayList<Integer>();
	private ArrayList<Integer> AlacarteQuan = new ArrayList<Integer>();
	private ArrayList<Integer> PackageOrder = new ArrayList<Integer>();
	private ArrayList<Integer> PackageQuan = new ArrayList<Integer>();
	private float total;
	private int staffID;
	private int tableNumber;
	private int orderID;

	public Order(int staffID, int tableNumber, int orderID) {
		this.staffID = staffID;
		this.tableNumber = tableNumber;
		this.orderID = orderID;
	}
		
	public int getStaff() {
		return this.staffID;
	}
	
	public void setStaff(int staffID) {
		this.staffID = staffID;
	}

	public int getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public int getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(int orderID) {
		this.tableNumber = orderID;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	//////////////////////////////////////////////////////////////////
	public void addAlacarte(int menuItemToAdd,int quantity) {
		for(int i =0; i<AlacarteOrder.size(); i++) {
			if(AlacarteOrder.get(i)==menuItemToAdd) {
				AlacarteQuan.set(i, AlacarteQuan.get(i)+1);
				return;
			}
		}
		AlacarteOrder.add(menuItemToAdd);
		AlacarteQuan.add(quantity);
	}
	
	public void removeAlacarte(int menuItemToRemove,int quantity) {
		if(menuItemToRemove>AlacarteOrder.size()) {
			System.out.println("No such order.");
			return;
		}
		if(AlacarteQuan.get(menuItemToRemove)>1) {
			if(AlacarteQuan.get(menuItemToRemove)==quantity) {
				AlacarteOrder.remove(menuItemToRemove);
				AlacarteQuan.remove(menuItemToRemove);
				return;
			}
			if(AlacarteQuan.get(menuItemToRemove)<quantity) {
				System.out.println("You cannot remove more than what you ordered");
				return;
			}
			AlacarteQuan.set(menuItemToRemove, AlacarteQuan.get(menuItemToRemove)-quantity);
			return;
		}
		else {
			if(AlacarteQuan.get(menuItemToRemove)<quantity) {
				System.out.println("You cannot remove more than what you ordered");
				return;
			}
			AlacarteOrder.remove(menuItemToRemove);
			AlacarteQuan.remove(menuItemToRemove);
			return;
		}
	}
	
	public ArrayList<Integer> getAlacarte(){
		return this.AlacarteOrder;
	}
	
	public ArrayList<Integer> getAlacarteQuan(){
		return this.AlacarteQuan;
	}
	
	///////////////////////////////////////////////////////////////////////
	
	public void addPackage(int PackageToAdd,int quantity) {
		for(int i =0; i<PackageOrder.size(); i++) {
			if(PackageOrder.get(i)==PackageToAdd) {
				PackageQuan.set(i, PackageQuan.get(i)+1);
				return;
			}
		}
		PackageOrder.add(PackageToAdd);
		PackageQuan.add(quantity);
	}
	
	public void removePackage(int PackageToRemove,int quantity) {
		if(PackageToRemove>PackageOrder.size()) {
			System.out.println("No such order.");
			return;
		}
		if(PackageQuan.get(PackageToRemove)>1) {
			if(PackageQuan.get(PackageToRemove)==quantity) {
				PackageOrder.remove(PackageToRemove);
				PackageQuan.remove(PackageToRemove);
				return;
			}
			if(PackageQuan.get(PackageToRemove)<quantity) {
				System.out.println("You cannot remove more than what you ordered");
				return;
			}
			PackageQuan.set(PackageToRemove, PackageQuan.get(PackageToRemove)-quantity);
			return;
		}
		else {
			if(PackageQuan.get(PackageToRemove)<quantity) {
				System.out.println("You cannot remove more than what you ordered");
				return;
			}
			PackageOrder.remove(PackageToRemove);
			PackageQuan.remove(PackageToRemove);
			return;
		}
	}
	
	public ArrayList<Integer> getPackage(){
		return this.PackageOrder;
	}
	
	public ArrayList<Integer> getPackageQuan(){
		return this.PackageQuan;
	}
}