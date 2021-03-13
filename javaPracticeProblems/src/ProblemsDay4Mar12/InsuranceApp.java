package ProblemsDay4Mar12;

import java.util.Scanner;

import Problem7MovieApp.Movie;
//1. Add Policy details to the system and display all Policy details present in system
//ask user for policy details
//create a policy object and store in the system
//display all the policy details
//2. Display policies whose premium fee is less than or equal to given Amount for given Mode
//ask user for premium fee and premium mode
//find policies with less than given premium fee and given premium mode
//display those searched policies
//3. Sort policy details by Number and display all Policy details present in system
//sort the policy details based on number
//display those sorted policies
//4. Update Premium Fee details for given Policy Number
//ask user for policy number
//search the policy with that number
//ask new policy details
//update the policy details

public class InsuranceApp {

	static Scanner in = new Scanner(System.in);
	static Policy[] policies = new Policy[1];
	static int policiesCount;

	public static void main(String[] args) {
		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Policy newPolicy = getNewPolicy();
				policies[policiesCount++] = newPolicy;
				displayAllPolicies(policies);
				break;
			case 2:
				System.out.println("Enter premium fee to be searched: ");
				double premiumFee = in.nextDouble();
				String premiumMode = inputPremiumMode();
				Policy[] searchedPolicies = searchPolicies(premiumFee, premiumMode);
				displayAllPolicies(searchedPolicies);
				break;
			case 3:
				Policy[] sortedPolicies = sortPoliciesByNumber(policies);
				displayAllPolicies(sortedPolicies);
				break;
			case 4:
				System.out.println("Enter Policy number to be updated: ");
				int number = in.nextInt();
				if (isPresent(number)) {
					Policy updatedPolicy = updatePolicyByNumber(number);
					displayPolicy(updatedPolicy);
				} else
					System.out.println("Policy id doesn't exist in the system.");
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

	private static Policy updatePolicyByNumber(int number) {
		for (int i = 0; i < policiesCount; i++) {
			if (policies[i].getNumber() == number) {
				System.out.println("Enter new policy id to update: ");
				int id = in.nextInt();
				in.nextLine();
				System.out.println("Enter new policy type to update: ");
				String type = in.nextLine();
				System.out.println("Enter new premium fee to update: ");
				double premiumFee = in.nextDouble();
				in.nextLine();
				System.out.println("Enter new premium Mode to update: ");
				String premiumMode = inputPremiumMode();
				policies[i].setId(id);
				policies[i].setType(type);
				policies[i].setPremiumFee(premiumFee);
				policies[i].setPremiumMode(premiumMode);
				System.out.println("Policy details got updated.");
				return policies[i];
			}
		}
		return null;
	}

	private static void displayPolicy(Policy policy) {
		System.out.println("========================================");
		System.out.println("Policy id: " + policy.getId());
		System.out.println("Policy number: " + policy.getNumber());
		System.out.println("Policy type: " + policy.getType());
		System.out.println("Policy premium fee: " + policy.getPremiumFee());
		System.out.println("Policy premium mode: " + policy.getPremiumMode());
		System.out.println("========================================");

	}

	private static Policy[] searchPolicies(double premiumFee, String premiumMode) {
		int count = 0;
		for (int i = 0; i < policiesCount; i++) {
			if (policies[i].getPremiumFee() <= premiumFee && policies[i].getPremiumMode().equals(premiumMode))
				count++;
		}
		Policy[] newarr = new Policy[count];
		int k = 0;
		for (int i = 0; i < policiesCount; i++) {
			if (policies[i].getPremiumFee() <= premiumFee && policies[i].getPremiumMode().equals(premiumMode))
				newarr[k++] = policies[i];
		}
		return newarr;
	}

	private static Policy[] sortPoliciesByNumber(Policy[] policies2) {
		Policy[] newarr = new Policy[policiesCount];
		for (int i = 0; i < policiesCount; i++)
			newarr[i] = policies2[i];
		for (int i = 0; i < policiesCount - 1; i++) {
			for (int j = 0; j < policiesCount - i - 1; j++) {
				if (newarr[j].getNumber() > newarr[j + 1].getNumber()) {
					Policy temp = newarr[j];
					newarr[j] = newarr[j + 1];
					newarr[j + 1] = temp;
				}
			}
		}
		return newarr;
	}

	private static Policy getNewPolicy() {
		if (policies.length == policiesCount)
			policies = resize();
		System.out.println("Enter policy id: ");
		int id = in.nextInt();
		System.out.println("Enter policy number: ");
		int number = in.nextInt();
		in.nextLine();
		System.out.println("Enter policy type: ");
		String type = in.nextLine();
		System.out.println("Enter premium fee: ");
		double premiumFee = in.nextDouble();
		in.nextLine();
		String premiumMode = inputPremiumMode();
		return new Policy(id, number, type, premiumFee, premiumMode);
	}

	private static void displayAllPolicies(Policy[] array) {
		for (int i = 0; i < array.length; i++)
			displayPolicy(array[i]);
	}

	private static void displayMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1. Add new policy details to the system and display all Policy details");
		System.out
				.println("2. Display policies whose premium fee is less than or equal to given Amount for given Mode");
		System.out.println("3. Sort policy details by Number and display all Policy details present in system");
		System.out.println("4. Update Premium Fee details for given Policy Number");
		System.out.println("5. Exit.");
		System.out.println("---------------------------------------------------");
	}

	private static Policy[] resize() {
		Policy[] newarr = new Policy[policiesCount + 1];
		for (int i = 0; i < policiesCount; i++)
			newarr[i] = policies[i];
		return newarr;
	}

	private static boolean isPresent(int number) {
		for (int i = 0; i < policiesCount; i++)
			if (policies[i].getNumber() == number)
				return true;
		return false;
	}

	private static String inputPremiumMode() {
		System.out.println("Enter premium mode: ");
		System.out.println("1. Quaterly\n2. HalfYearly\n3. Yearly");
		int ch = in.nextInt();
		switch (ch) {
		case 1:
			return "Quaterly";
		case 2:
			return "HalfYearly";
		case 3:
			return "Yearly";
		}
		System.out.println("Wrong Input! Try Again");
		return inputPremiumMode();
	}
}
