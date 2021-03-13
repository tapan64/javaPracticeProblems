package ProjectAllocation;

import java.util.Scanner;

//1. Add a new manager to the company.
//ask user for manager details
//create manager object and store to the system
//display added manager details
//2. Assign a new project to particular manager.
//ask user for manager id
//find the manager and ask project details
//add new project to the manager
//3. Delete a particular project by given project id.
//ask user for project id
//find the project and delete the project
//4. Print the manager details having more than 3 projects.
//find managers having projects more than 3 and store in new array
//display those manager details
//5. Sort the manager list according to the manager name.
//sort the mangers based on manager name and store in a new array
//display those sorted manager details
//6. Exit.
public class ProjectAllocationApp {

	static Scanner in = new Scanner(System.in);
	static Manager[] managers = new Manager[1];
	static int managersCount;

	public static void main(String[] args) {
		boolean flag = true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Manager newManager = getNewManager();
				managers[managersCount++] = newManager;
				displayManager(newManager);
				break;
			case 2:
				in.nextLine();
				System.out.println("Enter manager id to assign a new project: ");
				String managerId = in.nextLine();
				Manager managerWithNewProject = assignNewProjectByManagerId(managerId);
				displayManager(managerWithNewProject);
				break;
			case 3:
				System.out.println("Enter project id to be deleted: ");
				String projectId = in.nextLine();
				managers = deleteProjectById(projectId);
				break;
			case 4:
				Manager[] searchedManagers = managersWithMoreThan3Projects();
				displayManagers(searchedManagers);

				break;
			case 5:
				Manager[] sortedManagers = sortManagersByName();
				displayManagers(sortedManagers);
				break;
			case 6:
				System.out.println("System Exit......");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again.");
			}
		} while (flag);
	}

	private static Manager[] sortManagersByName() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void displayManagers(Manager[] array) {
		for (int i = 0; i < array.length; i++)
			displayManager(array[i]);

	}

	private static Manager[] managersWithMoreThan3Projects() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Manager[] deleteProjectById(String projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Manager assignNewProjectByManagerId(String managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void displayManager(Manager newManager) {
		// TODO Auto-generated method stub

	}

	private static Manager getNewManager() {
		in.nextLine();
		System.out.println("Enter manager id: ");
		String managerId = in.nextLine();
		System.out.println("Enter manager name: ");
		String managerName = in.nextLine();
		System.out.println("Enter manager department: ");
		String department = in.nextLine();
		System.out.println("Enter number of projects to be assigned to this manager: ");
		byte numberOfProjects = in.nextByte();
		Project[] projects = new Project[numberOfProjects];
		for (int i = 0; i < numberOfProjects; i++) {
			System.out.println("Enter project " + (i + 1) + " Details: ");
			System.out.println("Enter project id: ");
			String projectId = in.nextLine();
			System.out.println("Enter project name: ");
			String projectName = in.nextLine();
			System.out.println("Enter project duration: ");
			byte projectDuration = in.nextByte();
			projects[i] = new Project(projectId, projectName, projectDuration);
		}
		return new Manager(managerId, managerName, department, projects);
	}

	private static void displayMenu() {
		System.out.println("----------------------------------------------------");
		System.out.println("1. Add a new manager to the company.");
		System.out.println("2. Assign a new project to particular manager.");
		System.out.println("3. Delete a particular project by given project id.");
		System.out.println("4. Print the manager details having more than 3 projects.");
		System.out.println("5. Sort the manager list according to the manager name.");
		System.out.println("6. Exit.");
		System.out.println("----------------------------------------------------");
	}

}
