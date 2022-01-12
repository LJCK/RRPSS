package Controller;
import Entity.Staff;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager{
    private static String FName = "./staff.csv";
	private static ArrayList<Staff> StaffList = new ArrayList<Staff>();
	private static Scanner sc = new Scanner(System.in);
        
    public StaffManager() {
    	this.StaffList = (ArrayList) IOHandler.readSerializedObject(FName);
    }
                 
	public void createStaff() {
        System.out.println("Name :");
        String userName = sc.nextLine();
        System.out.println("Gender :");
        String userGender = sc.nextLine();
        System.out.println("Job title :");
        String userJobTitle = sc.nextLine();
        System.out.println("Emp Id :");
        int userEmpId = sc.nextInt();
        sc.nextLine();
		Staff newStaff = new Staff(userName,userGender,userEmpId,userJobTitle);
		StaffList.add(newStaff);
		IOHandler.writeSerializedObject(FName, StaffList);
	    System.out.println("Staff  " + userName + " Added Successfully");	         
	}       

	public void deleteStaff() {
    	System.out.print("Enter Emp ID: \n" );
		int removeID = sc.nextInt();
		sc.nextLine();
        System.out.println("Deleting Emp ID " + removeID );
		StaffList.remove(removeID-1);
        IOHandler.writeSerializedObject(FName, StaffList);
        System.out.println("Emp ID  " + removeID + " Removed Successfully");
	}

	public void printStaff() {
	
	if(StaffList.size() == 0){
	    System.out.println(
		"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("No Staff Records");
		System.out.println(
		"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }               
	else{
	    for(int i = 0;i < StaffList.size();i++ ){
        	System.out.println(
			"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");							
			System.out.printf("%20s %20s %20s %20s", "Staff ID", "Name", "Gender","Job Title");
			System.out.println();
			System.out.format("%20s %20s %20s %20s", StaffList.get(i).getEmplyeeID(), StaffList.get(i).getName(),StaffList.get(i).getGender(), StaffList.get(i).getJobTitle());
			System.out.println();
			System.out.println(
			"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        };
        }
			
	}
}