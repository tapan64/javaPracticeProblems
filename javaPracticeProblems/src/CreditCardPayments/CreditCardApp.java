package CreditCardPayments;

import java.util.Scanner;

public class CreditCardApp {

	static Scanner in = new Scanner(System.in);
	static Payment[] payments = new Payment[10];
	static int paymentsCount = 0;

	public static void main(String[] args) {
		/*
		 * Id     CustomerName     AmountPaid     CardType [ Master/VISA/AMEX ]    
		 * CardNumber     ExpiryDate [ MM/YY ]
		 * 
		 * Add Payment details to the system and display all payment details present in
		 * system While displaying card details, only last 4 digits of card number
		 * should be displayed Example : If card number is given as 4444444444444441 ,
		 * while displaying card details we should display only 4441  Search for an card
		 * type and display all payment details that were processed through given Card
		 * Type Example : If input is given as “Master” display all payment details that
		 * were processed through Master card Sort PaymentDetails by AmountPaid in
		 * descending order and display Top 2 payments Update ExpriyDate for given
		 * CustomerName and display updated card details Exit
		 */
		/*
		 * ask user the details of a payment & store it in the system. display all the
		 * payment details, display only last 4 digits of the card number. ask user a
		 * card type & display details of that card type. sort payment details by amount
		 * paid in descending order and display top 2 payments. ask user the customer
		 * name & update expiry date & display updated details.
		 */

		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the payment details: ");
				System.out.println("Enter payment id: ");
				int id = in.nextInt();
				in.nextLine();
				System.out.println("Enter customer name: ");
				String customerName = in.nextLine();
				System.out.println("Enter amount paid: ");
				double amountPaid = in.nextDouble();
				String cardType;
				do {
					System.out.println("Enter card type(Master/Visa/Amex): ");
					cardType = in.next();
				} while (!cardType.equals("Master") && !cardType.equals("Visa") && !cardType.equals("Amex"));
				System.out.println("Enter card number: ");
				long cardNumber = in.nextLong();
				System.out.println("Enter expiry month & year");
				byte month = in.nextByte();
				short year = in.nextShort();
				String expiryDate = month + "/" + year;
				payments[paymentsCount++] = new Payment(id, customerName, amountPaid, cardType, cardNumber, expiryDate);
				displayAllPaymentDetails();
				break;
			case 2:
				System.out.println(2);
				break;
			case 3:
				System.out.println(3);
				break;
			case 4:
				System.out.println(4);
				break;
			case 5:
				System.out.println(5);
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);

	}

	private static void displayAllPaymentDetails() {
		for (int i = 0; i < paymentsCount; i++) {
			System.out.println("==============================================");
			System.out.println("Payment id: " + payments[i].getId());
			System.out.println("Customer Name: " + payments[i].getCustomerName());
			System.out.println("Amount paid: " + payments[i].getAmountPaid());
			System.out.println("Card type: " + payments[i].getCardType());
			System.out.println("Card number: " + payments[i].getCardNumber());
			System.out.println("Expiry Date: " + payments[i].getExpiryDate());
			System.out.println("==============================================");
		}

	}

	private static void displayMenu() {
		System.out.println("====================================================================");
		System.out.println("1. Add a new payment detail");
		System.out.println("2. Display all payment details");
		System.out.println("3. Search for a card type and display all the payment details");
		System.out.println("4. Sort payment details by amount paid in descending order and display top 2 payments");
		System.out.println("5. Update Expiry date for a given customer name");
		System.out.println("9. Exit");
		System.out.println("====================================================================");

	}

}
