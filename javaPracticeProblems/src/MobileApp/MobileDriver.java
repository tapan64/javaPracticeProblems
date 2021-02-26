package MobileApp;
import java.util.Scanner;
public class MobileDriver {

	public static void main(String[] args) {
		/*
		 * 1. Add a new mobile detail.
		 * 2. Display all mobile details sorted by model name.
		 * 3. Display all mobile details whose price is less than or equal to given price and with camera included.
		 * 4. Update price for given Mobile id and display updated details.
		 * 5. Delete the mobile details based on Mobile Id.
		 * 6. Exit
		 */
		Scanner in=new Scanner(System.in);
		Mobile mobile=new Mobile();
		while(true) {
			System.out.println("1. Add a new mobile detail.");
			System.out.println("2. Display all mobile details sorted by model name.");
			System.out.println("3. Display all mobile details whose price is less than or equal to given price and with camera included");
			System.out.println("4. Update price for given Mobile id and display updated details.");
			System.out.println("5. Delete the mobile details based on Mobile Id.");
			System.out.println("9. Exit.");
			System.out.println("Enter Choice");
			int choice=in.nextInt();
			switch(choice) {
			case 1:mobile.addNewMobileDetail();
			break;
			case 2:mobile.displayAllMobileDetails();
			break;
			case 3:mobile.displayMobileDetailsByPrice();
			break;
			case 4:mobile.updatePrice();
			break;
			case 5:mobile.deleteMobileDetail();
			break;
			case 9:System.exit(0);
			break;
			default:System.out.println("Incorrect Input, Try Again");
			}
		}
	}

}
