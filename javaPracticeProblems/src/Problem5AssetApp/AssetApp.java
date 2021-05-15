package Problem5AssetApp;

import java.util.Scanner;

//1. Add asset details to the system and display all asset details
//ask user for asset details
//create a new asset object and store in the system
//display all the assets
//2. Search assets for given Month and sort the data by Model
//ask user for month
//search assets with given months
//sort those assets by asset model
//display those sorted assets
//3. Display total quantity allotted for given Model
//ask user for asset model
//find total quantity and display
//4. Update Quantity for given Model and display the updated details
//ask user for asset model
//search that model and update and ask for new quantity to update
//display updated asset
public class AssetApp {

	static Scanner in = new Scanner(System.in);
	static Asset[] assets = new Asset[1];
	static int assetsCount;

	public static void main(String[] args) {
		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Asset newAsset = getNewAsset();
				assets[assetsCount++] = newAsset;
				displayAllAssets(assets);
				break;
			case 2:
				System.out.println("Enter allocated month to be searched: ");
				String month = in.next();
				Asset[] searchedAssets = searchAssetsByMonth(month);
				Asset[] sortedAssets = sortAssetsByModel(searchedAssets);
				displayAllAssets(sortedAssets);
				break;
			case 3:
				String model = inputModel();
				if (isPresent(model)) {
					int totalQuantity = findTotalQuantity(model);
					System.out.println("Total quantity for the model " + model + " is: " + totalQuantity);
				} else
					System.out.println("Asset model doesn't exist in the system.");
				break;

			case 4:
				System.out.println("Enter Asset model to be updated: ");
				String modell = in.next();
				if (isPresent(modell)) {
					Asset updatedAsset = updateAssetByModel(modell);
					displayAsset(updatedAsset);
				} else
					System.out.println("Asset model doesn't exist in the system.");
				break;
			case 5:
				System.out.println("System Exit......");
				flag = false;
				break;

			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);
	}

	private static int findTotalQuantity(String model) {
		int quantity = 0;
		for (int i = 0; i < assetsCount; i++) {
			if (assets[i].getModel().equals(model))
				quantity += assets[i].getQuantity();
		}
		return quantity;
	}

	private static Asset[] sortAssetsByModel(Asset[] assets2) {
		Asset[] newarr = new Asset[assets2.length];
		for (int i = 0; i < assets2.length; i++)
			newarr[i] = assets2[i];
		for (int i = 0; i < assets2.length - 1; i++) {
			for (int j = 0; j < assets2.length - i - 1; j++) {
				if (newarr[j].getModel().compareTo(newarr[j + 1].getModel()) > 0) {
					Asset temp = newarr[j];
					newarr[j] = newarr[j + 1];
					newarr[j + 1] = temp;
				}
			}
		}
		return newarr;
	}

	private static Asset updateAssetByModel(String model) {
		for (int i = 0; i < assetsCount; i++) {
			if (assets[i].getModel().equals(model)) {
				System.out.println("Enter new Asset quantity to update: ");
				int quantity = in.nextInt();
				assets[i].setQuantity(quantity);
				System.out.println("Asset details got updated.");
				return assets[i];
			}
		}
		return null;
	}

	private static void displayAsset(Asset Asset) {
		System.out.println("========================================");
		System.out.println("Asset sno: " + Asset.getSno());
		System.out.println("Asset model: " + Asset.getModel());
		System.out.println("Asset allocated month: " + Asset.getAllotedMonth());
		System.out.println("Asset quantity: " + Asset.getQuantity());
		System.out.println("========================================");

	}

	private static Asset[] searchAssetsByMonth(String month) {
		int count = 0;
		for (int i = 0; i < assetsCount; i++) {
			if (assets[i].getAllotedMonth().equals(month))
				count++;
		}
		Asset[] newarr = new Asset[count];
		int k = 0;
		for (int i = 0; i < assetsCount; i++) {
			if (assets[i].getAllotedMonth().equals(month))
				newarr[k++] = assets[i];
		}
		return newarr;
	}

	private static Asset getNewAsset() {
		if (assets.length == assetsCount)
			assets = resize();
		System.out.println("Enter asset sno.: ");
		int sno = in.nextInt();
		String model = inputModel();
		System.out.println("Enter asset allocated month(JAN/FEB): ");
		String allocatedMonth = in.next();
		System.out.println("Enter assert quantity: ");
		int quantity = in.nextInt();
		return new Asset(sno, model, allocatedMonth, quantity);
	}

	private static void displayAllAssets(Asset[] array) {
		for (int i = 0; i < array.length; i++)
			displayAsset(array[i]);
	}

	private static void displayMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1. 1. Add asset details to the system and display all asset details");
		System.out.println("2. Search assets for given Month and sort the data by Model");
		System.out.println("3. Display total quantity allotted for given Model");
		System.out.println("4. Update Quantity for given Model and display the updated details");
		System.out.println("5. Exit.");
		System.out.println("---------------------------------------------------");
	}

	private static Asset[] resize() {
		Asset[] newarr = new Asset[assetsCount + 1];
		for (int i = 0; i < assetsCount; i++)
			newarr[i] = assets[i];
		return newarr;
	}

	private static boolean isPresent(String model) {
		for (int i = 0; i < assetsCount; i++)
			if (assets[i].getModel().equals(model))
				return true;
		return false;
	}

	private static String inputModel() {
		System.out.println("Enter Assert model: ");
		System.out.println("1. HP\n2. Lenovo\n3. Dell");
		int ch = in.nextInt();
		switch (ch) {
		case 1:
			return "HP";
		case 2:
			return "Lenovo";
		case 3:
			return "Dell";
		}
		System.out.println("Wrong Input! Try Again");
		return inputModel();
	}
}
