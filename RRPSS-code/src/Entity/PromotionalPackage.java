package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class PromotionalPackage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7519788014379901411L;
	
	private ArrayList<Integer> promotionSet = new ArrayList<Integer>();
	private float packagePrice;
	private int packageID;

	public PromotionalPackage(int packageID,float packagePrice) {
		this.packageID = packageID;
		this.packagePrice = packagePrice;
	}

	public float getPackagePrice() {
		return this.packagePrice;
	}

	public void setPackagePrice(float packagePrice) {
		this.packagePrice = packagePrice;
	}

	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}
	
	public int getpackageID() {
		return this.packageID;
	}
	
	public ArrayList<Integer> getMenuIdList() {
        return this.promotionSet;
    }

    public void addMenuIdList(Integer FoodID) {
        this.promotionSet.add(FoodID);
    }

    public void removeMenuIdList(Integer FoodID) {
        this.promotionSet.remove(FoodID);
    }
		

}