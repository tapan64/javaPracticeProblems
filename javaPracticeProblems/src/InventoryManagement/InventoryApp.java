package InventoryManagement;

import java.util.Scanner;

public class InventoryApp {
	static Scanner in = new Scanner(System.in);
	static Product[] products = new Product[1];
	static int productsCount;

	public static void main(String[] args) {
		// id,name,quantity,pricePerUnit
		// 1. Add new product in inventory.
		// ask product details
		// add product in the system
		// display that product
		// 2. Update the quantity of particular product.
		// ask product id
		// search that product
		// ask quantity to be updated
		// update the quantity of that product
		// 3. Display products where quantity is less than provided by user.
		// ask product quantity
		// find products which are less that that quantity
		// display these products
		// 4. Display product sort on basis of quantity.
		// 5. Delete a particular product from inventory.
		// ask product id
		// find that id and delete from the system
		// 6. Exit.
		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Product newProduct = getNewProduct();
				products[productsCount++] = newProduct;
				displayProduct(newProduct);
				break;
			case 2:
				System.out.println("Enter product id whose quantity is to be updated: ");
				int id = in.nextInt();
				boolean found = isPresent(id);
				if (found) {
					products = updateQuantity(id);
					displayProducts(products);
				} else
					System.out.println("Product id doesn't exist in the system.");
				break;
			case 3:
				System.out.println("Enter product quantity: ");
				int quantity = in.nextInt();
				Product[] searchedProducts = getProductsLessThanQuantity(quantity);
				displayProducts(searchedProducts);
				break;
			case 4:
				Product[] sortedProducts = getSortedProductsByQuantity();
				displayProducts(sortedProducts);
				break;
			case 5:
				System.out.println("Enter product id to be deleted: ");
				int productId = in.nextInt();
				boolean idFound = isPresent(productId);
				if (idFound)
					products = deleteProductById(productId);
				else
					System.out.println("Product id doesn't exist in the system.");
				break;
			case 6:
				System.out.println("System Exit.....");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);
	}

	private static Product[] deleteProductById(int productId) {
		Product[] newarr = new Product[productsCount - 1];
		int j = 0;
		for (int i = 0; i < productsCount; i++) {
			if (products[i].getId() != productId)
				newarr[j++] = products[i];
		}
		productsCount--;
		System.out.println("Product got deleted.");
		return newarr;
	}

	private static boolean isPresent(int productId) {
		for (int i = 0; i < productsCount; i++) {
			if (products[i].getId() == productId)
				return true;
		}
		return false;
	}

	private static Product[] getSortedProductsByQuantity() {
		Product[] newarr = new Product[productsCount];
		for (int i = 0; i < newarr.length; i++)
			newarr[i] = products[i];
		for (int i = 0; i < newarr.length - 1; i++) {
			for (int j = 0; j < newarr.length - i - 1; j++) {
				if (newarr[j].getQuantity() > newarr[j + 1].getQuantity()) {
					Product temp = newarr[j];
					newarr[j] = newarr[j + 1];
					newarr[j + 1] = temp;
				}
			}
		}
		return newarr;
	}

	private static Product[] getProductsLessThanQuantity(int quantity) {
		int count = 0;
		for (int i = 0; i < productsCount; i++)
			if (products[i].getQuantity() < quantity)
				count++;
		Product[] newarr = new Product[count];
		int j = 0;
		for (int i = 0; i < productsCount; i++) {
			if (products[i].getQuantity() < quantity) {
				newarr[j++] = products[i];
			}
		}
		return newarr;
	}

	private static void displayProducts(Product[] searchedProducts) {
		for (int i = 0; i < searchedProducts.length; i++)
			displayProduct(searchedProducts[i]);
	}

	private static Product[] updateQuantity(int id) {
		System.out.println("Enter quantity to be updated");
		int quantity = in.nextInt();
		for (int i = 0; i < productsCount; i++) {
			if (products[i].getId() == id)
				products[i].setQuantity(quantity);
		}
		System.out.println("Quantity got updated");
		return products;
	}

	private static Product getNewProduct() {
		if (products.length == productsCount)
			products = resize();
		System.out.println("Enter product id: ");
		int id = in.nextInt();
		System.out.println("Enter product name: ");
		in.nextLine();
		String name = in.nextLine();
		System.out.println("Enter product quantity: ");
		int quantity = in.nextInt();
		System.out.println("Enter product price per unit: ");
		double pricePerUnit = in.nextDouble();
		return new Product(id, name, quantity, pricePerUnit);
	}

	private static Product[] resize() {
		Product[] newarr = new Product[productsCount + 1];
		for (int i = 0; i < productsCount; i++) {
			newarr[i] = products[i];
		}
		return newarr;
	}

	private static void displayProduct(Product product) {
		System.out.println("========================================");
		System.out.println("Product id: " + product.getId());
		System.out.println("Product name: " + product.getName());
		System.out.println("Product quantity: " + product.getQuantity());
		System.out.println("Product price per unit: " + product.getPricePerUnit());
		System.out.println("========================================");

	}

	private static void displayMenu() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("1. Add new product in inventory.");
		System.out.println("2. Update the quantity of particular product.");
		System.out.println("3. Display products where quantity is less than provided by user.");
		System.out.println("4. Display product sort on basis of quantity.");
		System.out.println("5. Delete a particular product from inventory.");
		System.out.println("6. Exit");
		System.out.println("------------------------------------------------------------------");

	}
}
