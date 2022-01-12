package Boundary;

import java.util.Scanner;
import Controller.MemberManager;
public class MemberBoundary {
    static Scanner sc = new Scanner(System.in);

    public static void callMemoryManager(){
    	MemberManager m = new MemberManager();
        int userInput = -1;
        
        
        while(userInput != 4){

        
                System.out.println("\n1.Create Member \n"
                                + "2.Remove Member \n"
                                + "3.Print membership\n"
                                + "4.Exit\n");
                        userInput = sc.nextInt();
                        
                switch(userInput) {
                        case 1:
                                //sc.nextLine();
                                m.CreateMember();
                                break;
                        case 2:
                                m.RemoveMember();
                                break;

                        case 3:
                        		m.printMembership();
                        		break;
                        case 4:break;
                        default:
                        	System.out.println("No such option.");
                }
        }
        System.out.println("Exiting...");
    }

    
}
