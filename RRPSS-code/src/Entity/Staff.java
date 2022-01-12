package Entity;
import java.io.Serializable;
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402376216343202686L;

	private String name;
	private String gender;
	private int emplyeeID;
	private String jobTitle;

	public Staff(String name, String gender, int emplyeeID, String jobTitle) {
		this.name = name;
		this.gender = gender;
		this.emplyeeID = emplyeeID;
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getEmplyeeID() {
		return this.emplyeeID;
	}

	public void setEmplyeeID(int emplyeeID) {
		this.emplyeeID = emplyeeID;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}