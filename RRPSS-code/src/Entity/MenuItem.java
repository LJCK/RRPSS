package Entity;
import java.io.Serializable;
public class MenuItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7492248544259167804L;
	/**
	 * 
	 */
	
	private String name;
	private String description;
	private float price;
	private String type;
	
	public MenuItem(String name, String description, float price, String type) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
