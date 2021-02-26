package ProjectManagementApp;

import java.util.Scanner;

public class ProjectDriver {

	static Scanner in=new Scanner(System.in);
	static Project []projects;
	public static void main(String[] args) {
		/*
		 * 1. Add project details to the system and display all project details 
		 * 2. Display all project details
		 * 3. Sort all projects by project Name and display all project details 
		 * 4. Update duration for given project id and display updated details 
		 * 5. Display Project which has highest number of team size 
		 * 6. Search for all projects associated with user given technology 
		 * 	  Example: If user has provided input as Java for Technology, List out all the projects which includes Java technology 
		 * 7. Exit
		 * 
		 * 
		 * write menu driven program for above list
		 * write methods for switch cases:
		 * implement Project class
		 * implement all the methods
		 */
		
		while(true) {
			System.out.println("1. Add new project details");
			System.out.println("2. Display all project details");
			System.out.println("3. Sort projects by project name");
			System.out.println("4. Update duration for given project Id");
			System.out.println("5. Display project which has highest number of team size");
			System.out.println("6. Display projects associated with given technology");
			System.out.println("7. Exit");
			System.out.println("==========================================================");
			System.out.println("Enter Choice");
			int choice=in.nextInt();
			in.nextLine();
			switch (choice) {
			case 1: addNewProjectDetail();
			break;
			case 2: displayAllProjects();
			break;
			case 3: sortProjectsByProjectName();
			break;
			case 4: updateDurationGivenProjectId();
			break;
			case 5: displayHighestTeamSize();
			break;
			case 6: displayProjectsOfGivenTechnology();
			break;
			case 7: System.exit(0);
			break;
			default:
				System.out.println("Incorrect Input! Try Again");
			}
		}
	}
	static void addNewProjectDetail() {
		System.out.println("Enter number of projects to be added");
		int numberOfProjects=in.nextInt();
		projects=new Project[numberOfProjects];
		for (int i = 0; i < numberOfProjects; i++) {
			System.out.println("Enter Id of the project-"+(i+1));
			int id=in.nextInt();
			System.out.println("Enter Name of the project-"+(i+1));
			in.nextLine();
			String name=in.nextLine();
			System.out.println("Enter Description of the project-"+(i+1));
			String description=in.nextLine();
			System.out.println("Enter Team Size of the project-"+(i+1));
			int teamSize=in.nextInt();
			System.out.println("Enter Duration(in months) of the project-"+(i+1));
			int duration=in.nextInt();
			System.out.println("Enter number of technologies included in the project-"+(i+1));
			int numberOfTechnologies=in.nextInt();
			in.nextLine();
			String []technologies=new String[numberOfTechnologies];
			for (int j = 0; j < numberOfTechnologies; j++) {
				System.out.println("Enter Technology-"+(j+1));
				String technology=in.nextLine();
				technologies[j]=technology;
			}
			projects[i]=new Project(id,name,description,teamSize,duration,technologies,numberOfTechnologies);
		}
		displayAllProjects();
	}
	static void displayOneProject(int i) {
		System.out.println("=======================================");
		System.out.println("Project-"+(i+1)+" Id- "+ projects[i].getId());
		System.out.println("Project-"+(i+1)+" Name- "+ projects[i].getName());
		System.out.println("Project-"+(i+1)+" Description- "+ projects[i].getDescription());
		System.out.println("Project-"+(i+1)+" Team Size- "+ projects[i].getTeamSize());
		System.out.println("Project-"+(i+1)+" Duration(in months)- "+ projects[i].getDuration());
		System.out.print("Project-"+(i+1)+" Technologies used- ");
		projects[i].getTechnologiesDetails();
		System.out.println("=======================================");
	}
	static void displayAllProjects() {
		for (int i = 0; i < projects.length; i++) {
			displayOneProject(i);
		}
	}
	static void sortProjectsByProjectName() {
		for (int i = 0; i < projects.length-1; i++) {
			for (int j = i+1; j < projects.length; j++) {
				if(projects[i].getName().compareTo(projects[j].getName())>0)
					swap(i,j);
			}
		}
		displayAllProjects();
	}
	private static void swap(int i,int j) {
		Project temp=projects[i];
		projects[i]=projects[j];
		projects[j]=temp;
	}
	static void updateDurationGivenProjectId() {
		System.out.println("Enter project id whose duration to be updated");
		int id=in.nextInt();
		boolean found=false;
		for (int i = 0; i < projects.length; i++) {
			if(projects[i].getId()==id) {
				found=true;
				System.out.println("Enter duration to be updated");
				int duration=in.nextInt();
				projects[i].setDuration(duration);
				System.out.println("Duration for the project "+projects[i].getName()+" got updated to "+projects[i].getDuration());
				displayOneProject(i);
			}
		}
		if(found==false) {
			System.out.println("Given Project Id doesn't exist! Try Again");
			updateDurationGivenProjectId();
		}
	}
	static void displayHighestTeamSize() {
		int max=0,index=0;
		for (int i = 0; i < projects.length; i++) {
			if(projects[i].getTeamSize()>max) {
				max=projects[i].getTeamSize();
				index=i;
			}
		}
		System.out.println("Project with highest number of team size is- "+projects[index].getName());
		System.out.println("Its details are-");
		displayOneProject(index);
	}
	static void displayProjectsOfGivenTechnology() {
		System.out.println("Enter Technology to be searched");
		String technology=in.nextLine();
		boolean found=false;
		for (int i = 0; i < projects.length; i++) {
			for (int j = 0; j < projects[i].getTechnologies().length; j++) {
				if(projects[i].getTechnologies()[j].equals(technology)) {
					found=true;
					System.out.println("Project Name- "+projects[i].getName());
					break;
				}
			}
		}
		if(found==false) {
			System.out.println("This technology doesn't exist! Try Again");
			displayProjectsOfGivenTechnology();
		}
	}
}
