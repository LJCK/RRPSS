package Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import Controller.*;

public class Revenue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4580142174459573770L;
	private ArrayList<MenuItem> menu = MenuManager.getMenu();
	private ArrayList<PromotionalPackage> promo = PackageManager.getPackage();
	private ArrayList<String> alacarteSold = new ArrayList<String>();
	private ArrayList<Integer> alacarteQuan = new ArrayList<Integer>();
	private ArrayList<String> packageSold = new ArrayList<String>();
	private ArrayList<Integer> packageQuan = new ArrayList<Integer>();
	
	
	public Revenue() {
		
		for(MenuItem m : menu) {
			alacarteSold.add(m.getName());
			alacarteQuan.add(0);
		}
		for(PromotionalPackage p :promo) {
			packageSold.add("Package "+p.getpackageID());
			packageQuan.add(0);
		}
	}
	
	public void read() {
		System.out.printf("%-30s %20s\n","Name", "Quan");
		for(int i =0;i<alacarteSold.size();i++) {
			System.out.printf("%-30s %20s\n",alacarteSold.get(i),alacarteQuan.get(i));
		}
		
		System.out.println("---------------------------------------------------------------");
		for(int i =0;i<packageSold.size();i++) {
			System.out.printf("%-30s %20s\n",packageSold.get(i),packageQuan.get(i));
		}
	}
	
	public void setAlacarteQuan(int index, int quantity) {
		alacarteQuan.set(index,alacarteQuan.get(index)+quantity);
	}
	
	public void setPackageQuan(int index, int quantity) {
		packageQuan.set(index-1,packageQuan.get(index-1)+quantity);
	}	 
}
