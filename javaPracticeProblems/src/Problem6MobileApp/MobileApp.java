package Problem6MobileApp;

import java.util.Scanner;
//1. ask user for mobile details
//create a mobile object and store in the mobile array
//display all the mobiles
//2. sort mobiles based on mobile model
//display those sorted mobiles
//3. ask user for mobile id
//search that mobile id, if it exist ask user for price to be updated
//display the updated mobile
//4. ask user for mobile id
//if it exist, delete that mobile 

public class MobileApp {

	static Scanner in = new Scanner(System.in);
	static Mobile[] mobiles = new Mobile[1];
	static int mobilesCount;

	public static void main(String[] args) {
		boolean flag = true;
		do {
			int id = 0;
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Mobile newMobile = getNewMobile();
				mobiles[mobilesCount++] = newMobile;
				displayAllMobiles(mobiles);
				break;
			case 2:
				Mobile[] sortedMobiles = sortMobilesByModel(mobiles);
				displayAllMobiles(sortedMobiles);
				break;
			case 3:
				System.out.println("Enter mobile id whose price to be updated: ");
				id = in.nextInt();
				if (isPresent(id)) {
					Mobile updatedMobile = updatePriceById(id);
					displayMobile(updatedMobile);
				} else
					System.out.println("Mobile id doesn't exist in the system.");
				break;
			case 4:
				System.out.println("Enter mobile id to be deleted: ");
				id = in.nextInt();
				if (isPresent(id))
					mobiles = deleteMobileById(id);
				else
					System.out.println("Mobile id doesn't exist in the system.");
				break;
			case 5:
				System.out.println("System Exit.....");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);

	}

	private static boolean isPresent(int id) {
		for (int i = 0; i < mobilesCount; i++)
			if (mobiles[i].getId() == id)
				return true;
		return false;
	}

	private static Mobile[] deleteMobileById(int id) {
		int j = 0;
		Mobile[] newarr = new Mobile[mobilesCount - 1];
		for (int i = 0; i < mobilesCount; i++) {
			if (mobiles[i].getId() != id)
				newarr[j++] = mobiles[i];
		}
		mobilesCount--;
		System.out.println("This mobile got deleted.");
		return newarr;
	}

	private static void displayMobile(Mobile item) {
		System.out.println("========================================");
		System.out.println("Mobile id: " + item.getId());
		System.out.println("Mobile model: " + item.getModel());
		System.out.println("Mobile price: " + item.getPrice());
		System.out.println("Mobile date of manufacture: " + item.getDateOfManufature());
		System.out.println("========================================");

	}

	private static Mobile updatePriceById(int id) {
		for (int i = 0; i < mobilesCount; i++) {
			if (mobiles[i].getId() == id) {
				System.out.println("Enter mobile price to be updated: ");
				double price = in.nextDouble();
				mobiles[i].setPrice(price);
				System.out.println("Mobiel price got updated.");
				return mobiles[i];
			}
		}
		return null;
	}

	private static Mobile[] sortMobilesByModel(Mobile[] originalMobiles) {
		Mobile[] array = new Mobile[mobilesCount];
		for (int i = 0; i < mobilesCount; i++)
			array[i] = originalMobiles[i];
		for (int i = 0; i < mobilesCount - 1; i++) {
			for (int j = 0; j < mobilesCount - i - 1; j++) {
				if (array[j].getModel().compareTo(array[j + 1].getModel()) > 0) {
					Mobile temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	private static void displayAllMobiles(Mobile[] array) {
		for (int i = 0; i < array.length; i++)
			displayMobile(array[i]);
	}

	private static Mobile getNewMobile() {
		if (mobiles.length == mobilesCount)
			mobiles = resize();
		System.out.println("Enter mobile id: ");
		int id = in.nextInt();
		in.nextLine();
		boolean unique = true;
		String model = "";
		do {
			unique = true;
			System.out.println("Enter mobile model: ");
			model = in.nextLine();
			for (int i = 0; i < mobilesCount; i++) {
				if (mobiles[i].getModel().equals(model)) {
					System.out.println("Mobile model already exist!");
					unique = false;
					break;
				}
			}
		} while (!unique);
		System.out.println("Enter mobile price: ");
		double price = in.nextDouble();
		in.nextLine();
		System.out.println("Enter date of manufacture: ");
		String dateOfManufacture = in.nextLine();
		return new Mobile(id, model, price, dateOfManufacture);
	}

	private static Mobile[] resize() {
		Mobile[] newarr = new Mobile[mobilesCount + 1];
		for (int i = 0; i < mobilesCount; i++)
			newarr[i] = mobiles[i];
		return newarr;
	}

	private static void displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("1. Add new mobile in the system.");
		System.out.println("2. Sort mobiles by mobile model.");
		System.out.println("3. Update mobile price by mobile id.");
		System.out.println("4. Delete mobile by mobile id.");
		System.out.println("5. Exit.");
		System.out.println("-----------------------------------------------------------");
	}

}
