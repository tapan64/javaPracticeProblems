package MobileApp;
import java.util.Scanner;
public class MobileDriver {

	static Scanner in=new Scanner(System.in);
	static Mobile []mobiles=new Mobile[10];
	static int mobileCount;
	public static void main(String[] args) {
		/*
		 * 1. Add a new mobile detail.
		 * 2. Display all mobile details sorted by model name.
		 * 3. Display all mobile details whose price is less than or equal to given price and with camera included.
		 * 4. Update price for given Mobile id and display updated details.
		 * 5. Delete the mobile details based on Mobile Id.
		 * 6. Exit
		 */
		boolean flag=true;
		do {
			int choice = displayMenuAndTakeInput();
			switch(choice) {
			case 1:addNewMobileDetail();
			break;
			case 2:displayAllMobileDetails();
			break;
			case 3:displayMobileDetailsByPrice();
			break;
			case 4:updatePrice();
			break;
			case 5:deleteMobileDetail();
			break;
			case 9:flag=false;
			break;
			default:System.out.println("Incorrect Input, Try Again");
			}
		}while (flag);
	}
	private static int displayMenuAndTakeInput() {
		System.out.println("========================================================================================================");
		System.out.println("1. Add a new mobile detail.");
		System.out.println("2. Display all mobile details sorted by model name.");
		System.out.println("3. Display all mobile details whose price is less than or equal to given price and with camera included");
		System.out.println("4. Update price for given Mobile id and display updated details.");
		System.out.println("5. Delete the mobile details based on Mobile Id.");
		System.out.println("9. Exit.");
		System.out.println("========================================================================================================");
		System.out.println("Enter Choice");
		int choice=in.nextInt();
		return choice;
	}
	
	
	static void resize() {
		Mobile []newarr=new Mobile[mobiles.length+10];
		for(int i=0;i<mobileCount;i++)
			newarr[i]=mobiles[i];
		mobiles=newarr;
	}
	static void displayOneMobile(int i) {
		System.out.println("==============================");
		System.out.println("Mobile Id- "+mobiles[i].getId());		
		System.out.println("Mobile Name- "+mobiles[i].getModel());		
		System.out.println("Mobile Price- "+mobiles[i].getPrice());		
		System.out.println("Number of sims- "+mobiles[i].getNumberOfSims());		
		System.out.println("Does mobile has camera- "+mobiles[i].isHasCamera());		
		System.out.println("==============================");
	}
	// 1. Add a new mobile detail.
	static void addNewMobileDetail(){
		System.out.println("Enter mobile Id");
		int id=in.nextInt();
		in.nextLine();
		System.out.println("Enter mobile Model name");
		String model=in.next();
		in.nextLine();
		System.out.println("Enter mobile Price");
		double price=in.nextDouble();
		in.nextLine();
		System.out.println("Enter Number of sims");
		byte numberOfSims=in.nextByte();
		in.nextLine();
		System.out.println("Enter whether mobile has camera (true or false)");
		boolean hasCamera=in.nextBoolean();
		in.nextLine();
		if(mobiles.length==mobileCount)
			resize();
		mobiles[mobileCount++]=new Mobile(id,model,price,numberOfSims,hasCamera);
		
	}
	static void displayAllMobileDetails() {
		if(mobileCount==0)
			System.out.println("No Mobile data available");
		else{
			for(int i=0;i<mobileCount;i++) {
				displayOneMobile(i);
			}
		}
	}
	static void displayMobileDetailsByPrice() {
		System.out.println("Enter price");
		double price=in.nextDouble();
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].getPrice()<=price && mobiles[i].isHasCamera()==true)
				displayOneMobile(i);
		}
	}
	static void updatePrice() {
		System.out.println("Enter Mobile Id");
		int id=in.nextInt();
		boolean found=false;
		int ind=0;
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].getId()==id) {
				found=true;
				ind=i;
				System.out.println("Enter price to be updated");
				double price=in.nextDouble();
				mobiles[i].setPrice(price);
				displayOneMobile(i);
			}
		}
		if(found==false) {
			System.out.println("Mobile Id does not exist");
			updatePrice();
		}
		
	}
	static void deleteMobile(int i) {
		Mobile []newarr=new Mobile[mobileCount];
		int k=0;
		for(int j=0;j<mobileCount;j++) {
			if(i!=j)
				newarr[k++]=mobiles[j];
		}
		mobiles=newarr;
		mobileCount--;
	}
	static void deleteMobileDetail() {
		System.out.println("Enter Mobile Id to be deleted");
		int id=in.nextInt();
		in.nextLine();
		boolean found=false;
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].getId()==id) {
				found=true;
				deleteMobile(i);
			}
		}
		if(found==false) {
			System.out.println("Mobile Id does not exist");
			deleteMobileDetail();
		}
	}

}
