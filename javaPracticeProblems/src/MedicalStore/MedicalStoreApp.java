package MedicalStore;

import java.util.Scanner;

public class MedicalStoreApp {

	static Scanner in=new Scanner(System.in);
	static Customer[] customers=new Customer[1];
	public static void main(String[] args) {
		/*1. Add medicine bought by a particular customer.
		2. Display bill of the particular customer by printing customer detail and total price he need to pay .
		3. If the customer has senior citizen card decrease the MRP of each medicine by 5%.(Update)
		4. Sort customer on the basis of age.
		5. Delete particular medicine for a particular customer
		6. Exit
*/
		boolean flag=true;
		do {
			displayMenu();
			System.out.println("Enter Choice");
			int choice=in.nextInt();
			switch(choice) {			
			case 1:System.out.println("Enter customer id who is purchasing");
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Enter medicine name");
			String customerName=in.nextLine();
			System.out.println("Enter quantity");
			int quantity=in.nextInt();
			System.out.println("Enter medicine price");
			int price=in.nextInt();
			new Medicine(customerName,quantity,price);
			
			break;
			case 2:System.out.println(2);
			break;
			case 3:System.out.println(3);
			break;
			case 4:System.out.println(4);
			break;
			case 5:System.out.println(5);
			break;
			case 9:flag=false;
			break;
			default:System.out.println("Incorrect Choice! Try Again");
			}
			
		}while(flag);
	}
	private static void displayMenu() {
		System.out.println("========================================================");
		System.out.println("1. Add medicine bought by a particular customer.");
		System.out.println("2. Display bill of the particular customer.");
		System.out.println("3. If the customer has senior citizen card decrease the MRP of each medicine by 5%.");
		System.out.println("4. Sort customer on the basis of age.");
		System.out.println("5. Delete particular medicine for a particular customer.");
		System.out.println("9. Exit");
		System.out.println("========================================================");
		
	}

}
