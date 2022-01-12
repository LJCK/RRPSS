package Boundary;

import Controller.TableManager;
import java.util.Scanner;

public class TableBoundary {

	public static void showUI() {
		TableManager t = new TableManager();
		Scanner sc = new Scanner(System.in);
		System.out.printf("1: create table\n2: display table\n3: change table status\n0:Exit\n");
		int input = sc.nextInt();
		while(input!=0) {
			switch(input) {
			case 1:
				t.setTable();
				break;
			case 2:
				t.getTable();
				break;
			case 3:
				t.changeTableStatus();
				break;
			}
			System.out.printf("1: create table\n2: display table\n3: change table status\n0:Exit\n");
			input = sc.nextInt();
		}
	}
}