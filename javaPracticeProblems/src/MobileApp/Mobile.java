package MobileApp;
import java.util.Scanner;
public class Mobile {
	Scanner in=new Scanner(System.in);
	// Each Mobile hold the details - Id, Model, Price, NumberofSims, HasCamera
	private int id;
	private String model;
	private double price;
	private int numberOfSims;
	private boolean hasCamera;
	public Mobile() {
		
	}
	public Mobile(int id,String model,double price,int numberOfSims,boolean hasCamera) {
		this.id=id;
		this.model=model;
		this.price=price;
		this.numberOfSims=numberOfSims;
		this.hasCamera=hasCamera;
	}
	/*
	 * 1. Add a new mobile detail.
	 * 2. Display all mobile details sorted by model name.
	 * 3. Display all mobile details whose price is less than or equal to given price and with camera included
	 * 4. Update price for given Mobile id and display updated details
	 * 5. Delete the mobile details based on Mobile Id
	 * 6. Exit
	 */
	Mobile []mobiles=new Mobile[10];
	int mobileCount=0;
	private void resize() {
		Mobile []newarr=new Mobile[mobiles.length+10];
		for(int i=0;i<mobileCount;i++)
			newarr[i]=mobiles[i];
		mobiles=newarr;
	}
	private void displayDetailHeader() {
		System.out.println("Mobile id\tModel\tPrice\tNumber of sims\tHas Camera");		
	}
	// 1. Add a new mobile detail.
	public void addNewMobileDetail(){
		System.out.println("Enter mobile Id");
		int id=in.nextInt();
		System.out.println("Enter mobile Model name");
		String model=in.next();
		System.out.println("Enter mobile Price");
		double price=in.nextDouble();
		System.out.println("Enter Number of sims");
		int numberOfSims=in.nextInt();
		System.out.println("Enter whether mobile has camera (true or false)");
		boolean hasCamera=in.nextBoolean();
		if(mobiles.length==mobileCount)
			resize();
		mobiles[mobileCount++]=new Mobile(id,model,price,numberOfSims,hasCamera);
		
	}
	public void displayAllMobileDetails() {
		displayDetailHeader();
		for(int i=0;i<mobileCount;i++) {
			System.out.println(mobiles[i].id+"\t\t"+mobiles[i].model+"\t"+mobiles[i].price+"\t\t"+mobiles[i].numberOfSims+"\t"+mobiles[i].hasCamera);
		}
	}
	public void displayMobileDetailsByPrice() {
		System.out.println("Enter price");
		double price=in.nextDouble();
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].price<=price && mobiles[i].hasCamera==true) {
				displayDetailHeader();
				System.out.println(mobiles[i].id+"\t\t"+mobiles[i].model+"\t"+mobiles[i].price+"\t\t"+mobiles[i].numberOfSims+"\t"+mobiles[i].hasCamera);
				
			}
		}
	}
	public void updatePrice() {
		System.out.println("Enter Mobile Id");
		int id=in.nextInt();
		boolean found=false;
		int ind=0;
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].id==id) {
				found=true;
				ind=i;
				System.out.println("Enter price to be updated");
				double price=in.nextDouble();
				mobiles[i].price=price;
				displayDetailHeader();
				System.out.println(mobiles[i].id+"\t\t"+mobiles[i].model+"\t"+mobiles[i].price+"\t\t"+mobiles[i].numberOfSims+"\t"+mobiles[i].hasCamera);
				
				
			}
		}
		if(found==false) {
			System.out.println("Mobile Id does not exist");
			updatePrice();
		}
		
	}
	private void deleteMobile(int i) {
		Mobile []newarr=new Mobile[mobileCount];
		for(int j=0,k=0;j<mobileCount;j++,k++) {
			if(i!=j)
				newarr[k]=mobiles[j];
		}
		mobiles=newarr;
	}
	public void deleteMobileDetail() {
		System.out.println("Enter Mobile Id to be deleted");
		int id=in.nextInt();
		boolean found=false;
		for(int i=0;i<mobileCount;i++) {
			if(mobiles[i].id==id) {
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
