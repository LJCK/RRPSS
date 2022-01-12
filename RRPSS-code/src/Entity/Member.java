package Entity;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2913495345578007086L;
	private String name;
	private int contact_no;
    
    public Member(String n, int c){
        this.name = n;
        this.contact_no = c;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    public void setContactNo(int contact){
        this.contact_no = contact;
    }

    public String getName(){
        return this.name;
    }
    public int getContactNo(){
        return this.contact_no;
    }
}
