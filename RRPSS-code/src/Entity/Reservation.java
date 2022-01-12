package Entity;
import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 5482465130398149239L;
	private Date dateTime;
    private int pax;
    private String bookingName;
    private int contactNumber;
    private int tableID;
    private Date dateLimit;

    @SuppressWarnings("deprecation")
	public Reservation(Date date, int pax, String name, int contactNo, int tableID) {
        this.dateTime = date;
        this.pax = pax;
        this.bookingName = name;
        this.contactNumber = contactNo;
        this.tableID = tableID;
        int minutes = dateTime.getMinutes()+15;
        this.dateLimit = (Date) date.clone();
        dateLimit.setMinutes(minutes);
    }
    
    public Date getDateLimit() {
    	return this.dateLimit;
    }
    
    public Date getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getPax() {
        return this.pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public String getBookingName() {
        return this.bookingName;
    }

    public void setBookingName(String name) {
        this.bookingName = name;
    }

    public int getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(int contactNo) {
        this.contactNumber = contactNo;
    }

    public int getTableID() {
        return this.tableID;
    }

    public void setTable(int tableID) {
        this.tableID = tableID;
    }
}
