package Controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.*;



public class InvoiceManager {
	private static Order o; 
	private Invoice invoice;
	private ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	private static String FName = "./invoice.csv";
	static Scanner sc = new Scanner(System.in);
	
	public InvoiceManager() {
		invoiceList = (ArrayList<Invoice>) IOHandler.readSerializedObject(FName);
	}
	
	public void createInvoice(int invoiceID, Order order) {
		this.invoice = new Invoice(invoiceID, o);
		o = order;
	}
	
	public void printInvoice() {
		System.out.println("Enter your order ID:");
		int orderID = sc.nextInt();
		o=OrderManager.getOrder(orderID);
		if(o == null) {
			return;
		}
		createInvoice(100,o);
		boolean isMember = MemberManager.CheckMember();
		System.out.println("\t\t\tFine Food");
		System.out.println("\t\t50 Nanyang Ave, 639798");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Server: "+ o.getStaff());
		System.out.println("Table: "+o.getTableNumber()+"\t\t\t\t "+invoice.getDate());
		
		System.out.println("---------------------------------------------------------------");
		
		float fPrice = invoice.calculateFinalPrice(isMember);
		int i = OrderManager.printOrder(orderID);
		System.out.printf("Subtotal:\t\t\t\t %.2f\n", invoice.getOriginalPrice());
		System.out.printf("Service Charge:\t\t\t\t %.2f\n", invoice.getServiceamt());
		System.out.printf("GST:\t\t\t\t\t %.2f\n", invoice.getGSTamt());
		if(isMember) {
			System.out.printf("Discount:\t\t\t\t %.2f\n", invoice.getDiscountamt());
		}
		System.out.printf("Total:\t\t\t\t\t %.2f\n", fPrice);
		System.out.println("---------------------------------------------------------------");
		invoiceList.add(invoice);
		IOHandler.writeSerializedObject(FName, invoiceList);
		Controller.OrderManager.deleteOrderID(orderID);
		TableManager.statusToEmpty(o.getTableNumber());
		
	}

}