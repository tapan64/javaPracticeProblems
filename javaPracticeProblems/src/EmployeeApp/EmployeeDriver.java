package EmployeeApp;

import java.util.Scanner;

public class EmployeeDriver {

	static Scanner in = new Scanner(System.in);
	static Employee[] employees;

	public static void main(String[] args) {
		// Enter Employee details to the system and display employee details present in
		// System.
		// 1. Add new Employee details.
		// 2. Display all Employee details.
		// 3. Display Employee details for given experience range.
		// 4. Search Employee details by Designation and display the details.
		// 5. Delete an employee for given EmpId.
		// 6. Update Employee designation with provided designation for given Employee
		// name.
		boolean flag=true;
		do {
			int choice = displayMenuAndEnterChoice();
			switch (choice) {
			case 1:
				addNewEmployeeDetail();
				break;
			case 2:
				displayAllEmployees();
				break;
			case 3:
				displayDetailsForGivenExperienceRange();
				break;
			case 4:
				displayDetailsForGivenDesignation();
				break;
			case 5:
				deleteEmployeeForGivenEmployeeId();
				break;
			case 6:
				updateEmployeeDesignationByGivenName();
				break;
			case 9:
				flag=false;
				break;
			}
		}while (flag);
	}

	private static int displayMenuAndEnterChoice() {
		System.out.println("========================================================");
		System.out.println("1. Add new Employee details");
		System.out.println("2. Display all the Employees");
		System.out.println("3. Display Employee details for given experience range");
		System.out.println("4. Display Employee details by given designation");
		System.out.println("5. Delete an employee for given Employee id");
		System.out.println("6. Update Employee designation with provided designation for given employee name");
		System.out.println("========================================================");
		System.out.println("Enter Choice");
		int choice = in.nextInt();
		in.nextLine();
		return choice;
	}

	static void addNewEmployeeDetail() {
		System.out.println("Enter number of Employees to be added");
		int numberOfEmployees = in.nextInt();
		employees = new Employee[numberOfEmployees];
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Enter Employee id for Employee-" + (i + 1));
			int EmpId = in.nextInt();
			in.nextLine();
			System.out.println("Enter Employee name for Employee-" + (i + 1));
			String EmpName = in.nextLine();
			System.out.println("Enter Department name for Employee-" + (i + 1));
			String DeptName = inputDeptName();
			System.out.println("Enter Experience of Employee-" + (i + 1));
			byte Experience = in.nextByte();
			in.nextLine();
			System.out.println("Enter Designation of Employee-" + (i + 1));
			String Designation = inputDesignation();
			employees[i] = new Employee(EmpId, EmpName, DeptName, Experience, Designation);
		}
		displayAllEmployees();
	}

	private static String inputDeptName() {
		System.out.println("1. Computers");
		System.out.println("2. Arts");
		System.out.println("3. Physics");
		int ch = in.nextInt();
		in.nextLine();
		switch (ch) {
		case 1:
			return "Computers";
		case 2:
			return "Arts";
		case 3:
			return "Physics";
		default:
			System.out.println("Invalid Department! Try Again");
		}
		return inputDeptName();
	}

	private static String inputDesignation() {
		System.out.println("1. HOD");
		System.out.println("2. Assistant Professor");
		System.out.println("3. Professor");
		System.out.println("4. Instructor");
		int ch = in.nextInt();
		in.nextLine();
		switch (ch) {
		case 1:
			return "HOD";
		case 2:
			return "Assistant Professor";
		case 3:
			return "Professor";
		case 4:
			return "Instructor";
		default:
			System.out.println("Invalid Designation! Try Again");
		}
		return inputDesignation();
	}

	static void displayAllEmployees() {
		for (int i = 0; i < employees.length; i++) {
			displayOneEmployee(i);
		}
	}

	private static void displayOneEmployee(int i) {
		System.out.println("=============================================================");
		System.out.println("Employee-" + (i + 1) + " Id- " + employees[i].getEmpId());
		System.out.println("Employee-" + (i + 1) + " Name- " + employees[i].getEmpName());
		System.out.println("Employee-" + (i + 1) + " Department Name- " + employees[i].getDeptName());
		System.out.println("Employee-" + (i + 1) + " Experience- " + employees[i].getExperience());
		System.out.println("Employee-" + (i + 1) + " Designation- " + employees[i].getDesignation());
		System.out.println("=============================================================");
	}

	static void displayDetailsForGivenExperienceRange() {
		System.out.println("Enter Experience Range");
		int low = in.nextInt();
		int high = in.nextInt();
		in.nextLine();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getExperience() <= high && employees[i].getExperience() >= low) {
				displayOneEmployee(i);
			}
		}
	}

	static void displayDetailsForGivenDesignation() {
		System.out.println("Enter Designation to be searched");
		String Designation = inputDesignation();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getDesignation().equals(Designation))
				displayOneEmployee(i);
		}
	}

	static void deleteEmployeeForGivenEmployeeId() {
		System.out.println("Enter Employee id which is to be deleted");
		int EmpId = in.nextInt();
		in.nextLine();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getEmpId() == EmpId) {
				deleteEmployee(i);
			}
		}
	}

	private static void deleteEmployee(int i) {
		Employee[] newarr = new Employee[employees.length - 1];
		int k = 0;
		for (int j = 0; j < employees.length; j++) {
			if (i != j) {
				newarr[k++] = employees[j];
			}
		}
		employees = newarr;
		System.out.println("This employee got deleted");
		displayAllEmployees();
	}

	static void updateEmployeeDesignationByGivenName() {
		System.out.println("Enter Employee Name whose Designation to be updated");
		String EmpName = in.nextLine();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getEmpName().equals(EmpName)) {
				System.out.println("Enter new Designation to be updated");
				String Designation = inputDesignation();
				employees[i].setDesignation(Designation);
				displayOneEmployee(i);
			}
		}
	}

}
