package Entity;
import Controller.IOHandler;

import java.util.ArrayList;

public class TableList {
	ArrayList<Table> tableList = new ArrayList<Table>();
	String fileName="./tableList.csv";
	
	public TableList() {
		this.tableList=(ArrayList<Table>) IOHandler.readSerializedObject(fileName);
	}
	
	public void setTableList(int tableID, int capacity, String status) {
		Table t = new Table(tableID,capacity,status);
		tableList.add(t);
		IOHandler.writeSerializedObject(fileName, tableList);
		System.out.println("table created.");
	}
	
	public boolean getTableList() {
		System.out.printf("Table ID \t Status \t Capacity\n");
		int count =0;
		for(Table table :tableList) {
			if(table.getStatus().equals("empty")) {
				count++;
			}
			System.out.printf("%s  %20s %15s\n",table.getTableID(),table.getStatus(),table.getCapacity());
		}
		if(count==0) {
			return false;
		}else return true;
	}
	
	public void changeTableStatus(int index, String status) {
		tableList.get(index-1).setStatus(status);
		//System.out.println(tableList.get(index-1).getStatus());
		IOHandler.writeSerializedObject(fileName, tableList);
	}
	
	public String checkTableStatus(int tableID) {
		return tableList.get(tableID-1).getStatus();
	}
}