package Controller;
import Entity.*;
import java.util.*;
import Controller.IOHandler;


public class MemberManager {
    private static String FName = "./member.csv";
	private static ArrayList<Member> memberList  = new ArrayList<Member>();
	private static Scanner sc = new Scanner(System.in);
	
    public MemberManager(){
        this.memberList = (ArrayList) IOHandler.readSerializedObject(FName);
    }

    public static void CreateMember(){
        String member_name;
        int member_contact;
        System.out.println("Enter member name: ");
        member_name = sc.nextLine();
        System.out.println("Enter member contact: ");
        member_contact = sc.nextInt();
        Member m = new Member(member_name,member_contact);
        memberList.add(m);
        IOHandler.writeSerializedObject(FName, memberList);
        sc.nextLine();
    }
    
    
    public static void printMembership() {
    	System.out.println("Name \t Contact");
    	for (int i = 0; i < memberList.size(); i++)
    		System.out.printf("%-10s %5d\n",memberList.get(i).getName(),memberList.get(i).getContactNo());
    }

    public void RemoveMember(){
        int member_id;
        int count = 0;
        System.out.println("Enter your contact number:");
        member_id = sc.nextInt();
        for(int x = 0; x < memberList.size(); x++) {
        	if(memberList.get(x).getContactNo()==member_id) {
        		memberList.remove(x);
        		count = 1;
        		System.out.println("Member removed");
                IOHandler.writeSerializedObject(FName, memberList);
        	}
        }
        if(count == 0)
        	System.out.println("Member not exist");
        sc.nextLine();
    }
    public static boolean CheckMember(){
        int number;
        System.out.println("Enter your contact number to check membership: ");
        number = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while( i < memberList.size()){
            if(number == memberList.get(i).getContactNo()){
               return true;
            }
            i++;
        }
        return false;
        
    }


	
}
