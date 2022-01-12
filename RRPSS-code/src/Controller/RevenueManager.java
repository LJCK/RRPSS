package Controller;

import java.util.Date;
import java.util.ArrayList;

import Entity.Invoice;
import Entity.Revenue;

public class RevenueManager {
	
	private static String FName = "./revenue.csv";
	private ArrayList<Revenue> revenueList  = new ArrayList<Revenue>();
	private ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	static Revenue r = new Revenue();
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void printDailyReport(Date date) {
		invoiceList= (ArrayList<Invoice>) IOHandler.readSerializedObject("./invoice.csv");
		float total=0;
		for(Invoice i: invoiceList) {
			if(i.getDate().getDate()==date.getDate() && i.getDate().getMonth() == date.getMonth() && i.getDate().getYear()==date.getYear()) {
				for(int y =0;y<i.getOrder().getAlacarte().size();y++) {
					r.setAlacarteQuan(y, i.getOrder().getAlacarteQuan().get(y));
				}
				for(int y =0;y<i.getOrder().getPackage().size();y++) {
					r.setPackageQuan(i.getOrder().getPackage().get(y), i.getOrder().getPackageQuan().get(y));
				}
				total+=i.getFinalPrice();
			}
		}
		System.out.println("---------------------------------------------------------------");
		System.out.printf("Daily revenue for %s\n",date);
		r.read();
		System.out.println("---------------------------------------------------------------");
		System.out.printf("total: $%.2f\n",total);
		System.out.println("---------------------------------------------------------------");
		
	}

}