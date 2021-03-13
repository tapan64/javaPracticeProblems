package TaskAssigningSystem;

import java.util.Scanner;

public class TaskAssignApp {
	static Scanner in=new Scanner(System.in);
	static Task[] tasks=new Task[5];
	static int tasksCount;
	public static void main(String[] args) {
		/*
		ask  user for task details.
		add the task into the tasks system.
		display all tasks present in the system.

		ask user for a task status.
		sort the tasks based on AssignedTo. 
		display the sorted tasks.

		ask user for task id
		update the status of that task
		display the updated task details
		*/
		boolean flag=true;
		do {
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice =in.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter task id: ");;
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Enter task description: ");
			String description=in.nextLine();
			System.out.println("Enter task assigned to: ");
			String assignedTo=in.nextLine();
			String status=inputTaskStatus();
			tasks[tasksCount++]=new Task(id,description,assignedTo,status);
			displayAllTasks();
				break;
			case 2:String stat=inputTaskStatus();
			Task[] tasksWithGivenStatus=searchTasksForGivenStatus(stat);
			Task[] sortedTasks=sortTasksByAssignedTo(tasksWithGivenStatus);
			displaySortedTasks(sortedTasks);
				break;
			case 3:
				break;
			case 4:
			System.out.println("Exiting from the app");
			flag=false;
				break;
			}
		}while(flag);
	}
	private static Task[] searchTasksForGivenStatus(String stat) {
		int count=0;
		Task[] searchedTasks=new Task[tasksCount];
		int j=0;
		for(int i=0;i<tasksCount;i++) {
			if(tasks[i].getStatus().equals(stat)) {
				searchedTasks[j++]=tasks[i];
				count++;
			}
		}
		return searchedTasks;
	}
	private static Task[] sortTasksByAssignedTo(Task[] tasksWithGivenStatus) {
		for(int i=0;i<tasksWithGivenStatus.length-1;i++) {
			for(int j=0;j<tasksWithGivenStatus.length-i-1;j++) {
				if(tasksWithGivenStatus[j].getAssignedTo().compareTo(tasksWithGivenStatus[j+1].getAssignedTo())>0) {
					Task temp=tasksWithGivenStatus[j];
					tasksWithGivenStatus[j]=tasksWithGivenStatus[j+1];
					tasksWithGivenStatus[j+1]=temp;
				}
			}
		}
			return tasksWithGivenStatus;
	}
	private static void displaySortedTasks(Task[] sortedTasks) {
		for(int i=0;i<sortedTasks.length;i++) {
			displayOneTaskByIndex(i);
		}
		
	}
	private static void displayOneTaskByIndex(int i) {
		System.out.println("==========================================");
		System.out.println("task id: "+tasks[i].getId());
		System.out.println("task description: "+tasks[i].getDescription());
		System.out.println("task assigned to: "+tasks[i].getAssignedTo());
		System.out.println("task status: "+tasks[i].getStatus());
		System.out.println("==========================================");
		
	}
	private static void displayMenu() {
		System.out.println("---------------------------------------");
		System.out.println("1. Add new task to the system.");
		System.out.println("2. Search for an particular task by Status and display all Tasks sorted by ‘AssignedTo’ for given status.");
		System.out.println("3. Update the status of task for given Id and display updated Task details.");
		System.out.println("4. Exit");
		System.out.println("---------------------------------------");
		
	}
	private static void displayAllTasks() {
		for(int i=0;i<tasksCount;i++){
			displayOneTaskByIndex(i);
		}
	}
	private static String inputTaskStatus() {
			System.out.println("Enter task status: ");
			System.out.println("1. Open");
			System.out.println("2. InProgress");
			System.out.println("3. Completed");
			int ch=in.nextInt();
			switch(ch) {
			case 1: return "Open";
			case 2: return "InProgress";
			case 3: return "Completed";
			default:System.out.println("Incorrect Input! Try Again");
			}
		return inputTaskStatus();
	}
}
