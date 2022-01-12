package Entity;

import java.io.Serializable;

public class Table implements Serializable {

	private static final long serialVersionUID = -3559014916589242976L;
	public static final int MAX_TABLE_CAP = 10;
	public static final int MIN_TABLE_CAP = 2;
	

	private int tableID;
	private int tableCapacity;
	private String status;


	public Table(int tableID, int tableCapacity, String status) {
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.status = status;
	}

	void setTableID(int ID) {
		this.tableID = ID;
	}

	public int getTableID() {
		return this.tableID;
	}

	public void setCapacity(int cap) {
		
		if(cap > MAX_TABLE_CAP){
			this.tableCapacity = MAX_TABLE_CAP;
		}
		else if(cap < MIN_TABLE_CAP){
			this.tableCapacity = MIN_TABLE_CAP;
		}
		else{
			this.tableCapacity = cap;
		}
	}

	public int getCapacity() {

		return this.tableCapacity;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}