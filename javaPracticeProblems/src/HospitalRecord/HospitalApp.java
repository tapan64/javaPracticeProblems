package HospitalRecord;

import java.util.Scanner;

public class HospitalApp {
	static Scanner in = new Scanner(System.in);
	static Patient[] patients = new Patient[1];
	static int patientsCount;

	public static void main(String[] args) {
		// Patient: name,numberOfDaysAdmitted,illnessOccured,billAmount,doctorTreated
		// 1. add incoming patient
		// ask patient details
		// add that patient to the system
		// display that patient
		// 2. delete outgoing patient
		// ask patient name
		// search for that patient
		// remove that patient from the system
		// 3. display patients having a particular illness
		// ask user the illness
		// search that illness and display patients having that illness
		// 4. display patients having same illness
		// 5. display patient name who have billed lowest
		// find out the lowest bill amount and display patient name
		// 6. Exit
		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			in.nextLine();
			switch (choice) {
			case 1:
				Patient addedPatient = addIncomingPatient();
				patients[patientsCount++] = addedPatient;
				displayPatient(addedPatient);
				break;
			case 2:
				System.out.println("Enter outgoing patient name: ");
				String name = in.nextLine();
				boolean found = isPresent(name);
				if (found)
					patients = deleteOutgoingPatient(name);
				else
					System.out.println("This patient is not present in the system.");
				break;
			case 3:
				System.out.println("Enter the illness: ");
				String illness = in.nextLine();
				displayPatientsByIllness(illness);
				break;
			case 4:

				break;
			case 5:
				Patient patientWithLowestBill = getPatientWithLowestBill();
				System.out.println("Patient with lowest bill: " + patientWithLowestBill.getName());
				displayPatient(patientWithLowestBill);
				break;
			case 6:
				System.out.println("System Exit....");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);
	}

	private static void displayMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1. Add incoming patient.");
		System.out.println("2. Delete outgoing patient.");
		System.out.println("3. Display patients having a particular illness.");
		System.out.println("4. Display patients having same illness.");
		System.out.println("5. Display patient name who have billed lowest.");
		System.out.println("6. Exit");
		System.out.println("---------------------------------------------------");

	}

	private static Patient addIncomingPatient() {
		if (patients.length == patientsCount)
			patients = resize();
		System.out.println("Enter patient name: ");
		String name = in.nextLine();
		System.out.println("Enter number of days admitted: ");
		short numberOfDaysAdmitted = in.nextShort();
		System.out.println("Enter illness occured: ");
		in.nextLine();
		String illnessOccured = in.nextLine();
		System.out.println("Enter bill amount: ");
		double billAmount = in.nextDouble();
		System.out.println("Enter doctor treated: ");
		in.nextLine();
		String doctorTreated = in.nextLine();
		return new Patient(name, numberOfDaysAdmitted, illnessOccured, billAmount, doctorTreated);
	}

	private static Patient[] resize() {
		Patient[] newarr = new Patient[patientsCount + 1];
		for (int i = 0; i < patientsCount; i++) {
			newarr[i] = patients[i];
		}
		return newarr;
	}

	private static void displayPatient(Patient patient) {
		System.out.println("=======================================");
		System.out.println("patient name: " + patient.getName());
		System.out.println("number of days admitted: " + patient.getNumberOfDaysAdmitted());
		System.out.println("illness occured: " + patient.getIllnessOccured());
		System.out.println("bill amount: " + patient.getBillAmount());
		System.out.println("doctor treated: " + patient.getDoctorTreated());
		System.out.println("=======================================");
	}

	private static boolean isPresent(String name) {
		for (int i = 0; i < patientsCount; i++) {
			if (patients[i].getName().equals(name))
				return true;
		}
		return false;
	}

	private static Patient[] deleteOutgoingPatient(String name) {
		Patient[] newarr = new Patient[patientsCount - 1];
		int j = 0;
		for (int i = 0; i < patientsCount; i++) {
			if (!patients[i].getName().equals(name)) {
				newarr[j++] = patients[i];
			}
		}
		patientsCount--;
		System.out.println("patient got deleted");
		return newarr;
	}

	private static void displayPatientsByIllness(String illness) {
		boolean found = false;
		for (int i = 0; i < patientsCount; i++) {
			if (patients[i].getIllnessOccured().equals(illness)) {
				found = true;
				displayPatient(patients[i]);
			}
		}
		if (!found)
			System.out.println("This illness doesn't exist in the system.");

	}

	private static Patient getPatientWithLowestBill() {
		if (patientsCount == 0) {
			System.out.println("No data available");
			return null;
		}
		Patient min = patients[0];
		for (int i = 1; i < patientsCount; i++) {
			if (patients[i].getBillAmount() < min.getBillAmount())
				min = patients[i];
		}
		return min;
	}

}
