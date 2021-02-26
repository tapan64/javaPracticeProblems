package CosmeticsApp;

import java.util.Scanner;
public class Cosmetic {
	//create cosmetics class
	//with id, name, brand, quantity & price
	static Scanner in=new Scanner(System.in);
	private int id;
	private String name;
	private String brand;
	private int quantity;
	private double price;
	public Cosmetic(int id,String name,String brand,int quantity,double price) {
		this.id=id;
		this.name=name;
		this.brand=brand;
		this.quantity=quantity;
		this.price=price;
	}
	public Cosmetic() {
		
	}
	//create cosmetics array
	static Cosmetic[] cosmetics=new Cosmetic[10];
	static int cosmeticsCount=0;
	//resize array size;
	static void resize() {
		Cosmetic[] newarr=new Cosmetic[cosmetics.length+10];
		for(int i=0;i<cosmetics.length;i++) {
			newarr[i]=cosmetics[i];
		}
		cosmetics=newarr;
	}
	//add new cosmetic
	public void addNewCosmetic(){
		if(cosmetics.length==cosmeticsCount)
			resize();
		System.out.println("Enter Id");
		int id=in.nextInt();
		System.out.println("Enter Name");
		String name=in.next();
		System.out.println("Enter Brand");
		String brand=in.next();
		System.out.println("Enter Quantity");
		int quantity=in.nextInt();
		System.out.println("Enter Price");
		double price=in.nextDouble();
		cosmetics[cosmeticsCount++]=new Cosmetic(id,name,brand,quantity,price);
	}
	//display all cosmetics
	public void displayAllCosmetics() {
		System.out.println("Id\tName\tBrand\tQuantity\tPrice");
		for(int i=0;i<cosmeticsCount;i++) {
		System.out.print(cosmetics[i].id+"\t");
		System.out.print(cosmetics[i].name+"\t");
		System.out.print(cosmetics[i].brand+"\t");
		System.out.print(cosmetics[i].quantity+"\t\t");
		System.out.println(cosmetics[i].price);
		}
	}
	//display a cosmetic by index 
	public void displayCosmetic(int index) {
			System.out.print(cosmetics[index].id+"\t");
			System.out.print(cosmetics[index].name+"\t");
			System.out.print(cosmetics[index].brand+"\t");
			System.out.print(cosmetics[index].quantity+"\t\t");
			System.out.println(cosmetics[index].price);
	}
	//search by price range and sort by brand
	public void searchCosmeticsByRange() {
		System.out.println("Enter price range");
		double lowRange=in.nextDouble();
		double highRange=in.nextDouble();
		boolean found=false;
		for(int i=0;i<cosmeticsCount;i++) {
			if(cosmetics[i].price>=lowRange && cosmetics[i].price<=highRange) {
				found=true;
				displayCosmetic(i);
			}
		}
		if(found==false)
			System.out.println("Cosmetics does not exist in this price range");
	}
	//search all brands by a given cosmetic name
	public void searchCosmeticBrandByName() {
		System.out.println("Enter cosmetic Name");
		String name=in.next();
		boolean found=false;
		for(int i=0;i<cosmeticsCount;i++) {
			if(cosmetics[i].name.equals(name)) {
				found=true;
				displayCosmetic(i);
			}
		}
		if(found==false)
			System.out.println("Cosmetics does not exist for this cosmetic name");
	}
	//update quantity by id
	public void updateQuantity() {
		System.out.println("Enter id of the cosmetic to be updated");
		int id=in.nextInt();
		System.out.println("Enter new quantity");
		int quantity=in.nextInt();
		boolean found=false;
		for(int i=0;i<cosmeticsCount;i++) {
			if(id==cosmetics[i].id) {
				found=true;
				cosmetics[i].quantity=quantity;
			}
		}
		if(found==false)
			System.out.println("Cosmetic id does not exist");
		displayAllCosmetics();
	}
	
	
	
}
