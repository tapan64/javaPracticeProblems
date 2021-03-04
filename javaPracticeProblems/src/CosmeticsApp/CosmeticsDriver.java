package CosmeticsApp;

import java.util.Scanner;

public class CosmeticsDriver {

	static Scanner in = new Scanner(System.in);
	static Cosmetic[] cosmetics = new Cosmetic[10];
	static int cosmeticsCount;

	public static void main(String[] args) {
		boolean flag=true;
		do {
			int choice = displayMenuAndTakeChoice(in);
			switch (choice) {
			case 1:
				addNewCosmetic();
				break;
			case 2:
				displayAllCosmetics();
				break;
			case 3:
				searchCosmeticsByRange();
				break;
			case 4:
				searchCosmeticBrandByName();
				break;
			case 5:
				updateQuantity();
				break;
			case 9:
				flag=false;
				break;
			default:
				System.out.println("Incorrect Input");
			}
		}while(flag);
	}

	private static int displayMenuAndTakeChoice(Scanner in) {
		System.out.println("======================================================");
		System.out.println("1. Add a new cosmetic");
		System.out.println("2. Display all the cosmetics");
		System.out.println("3. Search cosmetics by given range");
		System.out.println("4. Search cosmetic brands by given cosmetic Name");
		System.out.println("5. Update the quantity of the cosmetic by given id");
		System.out.println("9. Exit");
		System.out.println("======================================================");
		System.out.println("Enter choice");
		int choice = in.nextInt();
		return choice;
	}

	// create cosmetics array
	// resize array size;
	static void resize() {
		Cosmetic[] newarr = new Cosmetic[cosmetics.length + 10];
		for (int i = 0; i < cosmetics.length; i++) {
			newarr[i] = cosmetics[i];
		}
		cosmetics = newarr;
	}

	// add new cosmetic
	static void addNewCosmetic() {
		if (cosmetics.length == cosmeticsCount)
			resize();
		System.out.println("Enter Id");
		int id = in.nextInt();
		System.out.println("Enter Name");
		String name = in.next();
		System.out.println("Enter Brand");
		String brand = in.next();
		System.out.println("Enter Quantity");
		int quantity = in.nextInt();
		System.out.println("Enter Price");
		double price = in.nextDouble();
		cosmetics[cosmeticsCount++] = new Cosmetic(id, name, brand, quantity, price);
	}

	// display all cosmetics
	static void displayAllCosmetics() {
		if (cosmeticsCount == 0)
			System.out.println("No Cosmetic data available");
		else {
			for (int i = 0; i < cosmeticsCount; i++)
				displayOneCosmetic(i);

		}

	}

	// display a cosmetic by index
	static void displayOneCosmetic(int i) {
		System.out.println("=============================");
		System.out.println("Cosmetic Id- " + cosmetics[i].getId());
		System.out.println("Cosmetic Name- " + cosmetics[i].getName());
		System.out.println("Cosmetic Brand- " + cosmetics[i].getBrand());
		System.out.println("Cosmetic Quantity- " + cosmetics[i].getQuantity());
		System.out.println("Cosmetic Price- " + cosmetics[i].getPrice());
		System.out.println("=============================");
	}

	// search by price range and sort by brand
	static void searchCosmeticsByRange() {
		System.out.println("Enter price range");
		double lowRange = in.nextDouble();
		double highRange = in.nextDouble();
		boolean found = false;
		for (int i = 0; i < cosmeticsCount; i++) {
			if (cosmetics[i].getPrice() >= lowRange && cosmetics[i].getPrice() <= highRange) {
				found = true;
				displayOneCosmetic(i);
			}
		}
		if (found == false)
			System.out.println("Cosmetics does not exist in this price range");
	}

	// search all brands by a given cosmetic name
	static void searchCosmeticBrandByName() {
		System.out.println("Enter cosmetic Name");
		String name = in.next();
		boolean found = false;
		for (int i = 0; i < cosmeticsCount; i++) {
			if (cosmetics[i].getName().equals(name)) {
				found = true;
				displayOneCosmetic(i);
			}
		}
		if (found == false)
			System.out.println("Cosmetics does not exist for this cosmetic name");
	}

	// update quantity by id
	static void updateQuantity() {
		System.out.println("Enter id of the cosmetic to be updated");
		int id = in.nextInt();
		System.out.println("Enter new quantity");
		int quantity = in.nextInt();
		boolean found = false;
		for (int i = 0; i < cosmeticsCount; i++) {
			if (id == cosmetics[i].getId()) {
				found = true;
				cosmetics[i].setQuantity(quantity);
			}
		}
		if (found == false)
			System.out.println("Cosmetic id does not exist");
		displayAllCosmetics();
	}

}
