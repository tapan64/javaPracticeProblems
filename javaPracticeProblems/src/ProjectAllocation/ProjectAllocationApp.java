package ProjectAllocation;

import java.util.Scanner;

import Problem7MovieApp.Movie;

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
				if (managerWithNewProject != null)
					displayManager(managerWithNewProject);
				break;
			case 3:
				Manager[] searchedManagers = managersWithMoreThan3Projects();
				if (searchedManagers != null)
					displayManagers(searchedManagers);
				break;
			case 4:
				Manager[] sortedManagers = sortManagersByName(managers);
				displayManagers(sortedManagers);
				break;
			case 5:
				System.out.println("System Exit......");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again.");
			}
		} while (flag);
	}

	private static Manager[] sortManagersByName(Manager[] managers2) {
		Manager[] newarr = new Manager[managersCount];
		for (int i = 0; i < managersCount; i++)
			newarr[i] = managers2[i];
		for (int i = 0; i < managersCount - 1; i++) {
			for (int j = 0; j < managersCount - i - 1; j++) {
				if (newarr[j].getManagerName().compareTo(newarr[j + 1].getManagerName()) > 0) {
					Manager temp = newarr[j];
					newarr[j] = newarr[j + 1];
					newarr[j + 1] = temp;
				}
			}
		}
		return newarr;
	}

	private static void displayManagers(Manager[] array) {
		for (int i = 0; i < array.length; i++)
			displayManager(array[i]);

	}

	private static Manager[] managersWithMoreThan3Projects() {
		int count = 0;
		for (int i = 0; i < managersCount; i++)
			if (managers[i].getProjects().length > 3)
				count++;
		if (count == 0) {
			System.out.println("There are no managers more than 3 projects.");
			return null;
		}
		Manager[] newarr = new Manager[count];
		int j = 0;
		for (int i = 0; i < managersCount; i++)
			if (managers[i].getProjects().length > 3)
				newarr[j++] = managers[i];
		return newarr;
	}

	private static Manager[] resize() {
		Manager[] newarr = new Manager[managersCount + 1];
		for (int i = 0; i < managersCount; i++)
			newarr[i] = managers[i];
		return newarr;
	}

	private static Manager assignNewProjectByManagerId(String managerId) {
		for (int i = 0; i < managersCount; i++) {
			if (managers[i].getManagerId().equals(managerId)) {
				System.out.println("Enter number of projects to be assigned to this manager: ");
				byte numberOfProjects = in.nextByte();

				if (managers[i].getProjects().length != 0) {
					Project[] projects = new Project[managers[i].getProjects().length + numberOfProjects];
					int projectsCount = 0;
					for (int j = 0; j < managers[i].getProjects().length; j++) {
						projects[j] = managers[i].getProjects()[j];
						projectsCount++;
					}
					for (int j = 0; j < numberOfProjects; j++) {
						System.out.println("Enter project Details: ");
						in.nextLine();
						System.out.println("Enter project id: ");
						String projectId = in.nextLine();
						System.out.println("Enter project name: ");
						String projectName = in.nextLine();
						System.out.println("Enter project duration: ");
						byte projectDuration = in.nextByte();
						projects[projectsCount++] = new Project(projectId, projectName, projectDuration);
					}
					managers[i].setProjects(projects);
				} else {
					Project[] projects = new Project[numberOfProjects];
					for (int j = 0; j < numberOfProjects; j++) {
						System.out.println("Enter project Details: ");
						in.nextLine();
						System.out.println("Enter project id: ");
						String projectId = in.nextLine();
						System.out.println("Enter project name: ");
						String projectName = in.nextLine();
						System.out.println("Enter project duration: ");
						byte projectDuration = in.nextByte();
						projects[j] = new Project(projectId, projectName, projectDuration);
					}
					managers[i].setProjects(projects);
				}
				return managers[i];
			}
		}
		System.out.println("Manager id doesn't exist.");
		return null;
	}

	private static void displayManager(Manager manager) {
		System.out.println("======================================");
		System.out.println("Manager id: " + manager.getManagerId());
		System.out.println("Manager name: " + manager.getManagerName());
		System.out.println("Manager department: " + manager.getDepartment());
		if (manager.getProjects() != null) {
			for (int i = 0; i < manager.getProjects().length; i++) {
				System.out.println("-----------------------------------");
				System.out.println("Project " + (i + 1) + " details: ");
				System.out.println("-----------------------------------");
				System.out.println("Project id: " + manager.getProjects()[i].getProjectId());
				System.out.println("Project name: " + manager.getProjects()[i].getProjectName());
				System.out.println("Project duration: " + manager.getProjects()[i].getProjectDuration());
				System.out.println("-----------------------------------");
			}
		}
		System.out.println("======================================");

	}

	private static Manager getNewManager() {
		if (managers.length == managersCount)
			managers = resize();
		in.nextLine();
		System.out.println("Enter manager id: ");
		String managerId = in.nextLine();
		System.out.println("Enter manager name: ");
		String managerName = in.nextLine();
		System.out.println("Enter manager department: ");
		String department = in.nextLine();
		Manager newManager = new Manager();
		newManager.setManagerId(managerId);
		newManager.setManagerName(managerName);
		newManager.setDepartment(department);
		newManager.setProjects(new Project[0]);
		return newManager;

	}

	private static void displayMenu() {
		System.out.println("----------------------------------------------------");
		System.out.println("1. Add a new manager to the company.");
		System.out.println("2. Assign a new project to particular manager.");
		System.out.println("3. Print the manager details having more than 3 projects.");
		System.out.println("4. Sort the manager list according to the manager name.");
		System.out.println("5. Exit.");
		System.out.println("----------------------------------------------------");
	}

}
