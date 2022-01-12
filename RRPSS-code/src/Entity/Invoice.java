package Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4061961030782456226L;
	private int invoiceID;
	private Order order;
	private int staffId;
	private float originalPrice; //subtotal
	private float finalPrice;
	private static final float serviceCharge = 0.10f;
	private static final float GST = 0.07f;
	private static final float discount = 0.10f;
	private float absGST;
	private float absSVC;
	private float absDisc;
	private Date now = new Date();

	public Invoice(int invoiceID, Order order) {
		this.invoiceID = invoiceID;
		this.order = order;
		this.originalPrice = order.getTotal();
		this.staffId = order.getStaff();
	}
	
	public Date getDate() {
		return now;
	}
	
	public int getInvoiceID() {
		return this.invoiceID;
	}

	
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
    /////////////////////////////////////////////////////////////////////////////////
	public float getOriginalPrice() {
		return this.originalPrice;
	}


	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}

    /////////////////////////////////////////////////////////////////////////////////
	public float calculateFinalPrice(boolean isMember) {
		
		if(isMember) {
			float proxy = this.originalPrice;
			absSVC = serviceCharge*proxy;
			proxy = proxy + absSVC;
			absDisc  =  proxy *(discount);
			proxy = proxy - absDisc;
			absGST = proxy * GST;
			this.finalPrice = proxy+absGST;
			return finalPrice;
		}
		else
		{
			float proxy = this.originalPrice;
			absSVC = serviceCharge*proxy;
			proxy = proxy + absSVC;
			absGST = proxy * GST;
			this.finalPrice = proxy+absGST;
			return finalPrice;
		}
	}
	
	public float getFinalPrice(){
		return this.finalPrice;
		
	}

    /////////////////////////////////////////////////////////////////////////////////
	public float getGSTamt() {
		return absGST;
		
	}
	
	public float getServiceamt() {
		return absSVC;
		
	}

    /////////////////////////////////////////////////////////////////////////////////
	public float getDiscountamt() {
		return absDisc;
	}

    /////////////////////////////////////////////////////////////////////////////////
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    /////////////////////////////////////////////////////////////////////////////////

}