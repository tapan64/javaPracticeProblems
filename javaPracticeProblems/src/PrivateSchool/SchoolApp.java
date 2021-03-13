package PrivateSchool;

import java.util.Scanner;

public class SchoolApp {

	static Scanner in=new Scanner(System.in);
	static Student[] students=new Student[10];
	static int studentsCount;
	public static void main(String[] args) {
		/*
		 * Id, Name, class, phonedetails, Total_Fees_per_Year, Fees-Submitted
1. Add details of a student.
ask student details
store in students array
2. Sort the students on the base of name
3. Display students with pending fees
find students whose fees_submitted is less than total_fees and display them
4. Update the submitted-fee for a particular student.
ask student name whose fees to be submitted
search for that student, if found ask for the paying fees
update the fees by adding the new fees
5. Display all students of particular class
ask a class and display all students of that class
6. Exit


		 */

		boolean flag=true;
		do {
			displayMenu();
			System.out.println("Enter Choice");
			int choice=in.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter student id: ");
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Enter student name: ");
			String name=in.nextLine();
			System.out.println("Enter class of the student: ");
			byte standard=in.nextByte();
			System.out.println("Enter phone no of the student: ");
			int phone=in.nextInt();
			System.out.println("Enter total fees per year: ");
			double totalFees=in.nextDouble();
			System.out.println("Enter fees submitted by the student: ");
			double feesSubmitted=in.nextDouble();
			if(students.length==studentsCount)
				resize();
			students[studentsCount++]=new Student(id,name,standard,phone,totalFees,feesSubmitted);
			displayStudentDetails(students,studentsCount-1);
				break;
			case 2:
				Student[] sortedStudents=sortStudentsByName(students);
				displayAllStudentDetails(sortedStudents);
				
				break;
			case 3:displayManyStudentDetails(students);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:flag=true;
			break;
			default:System.out.println("Incorrect Input! Try Again");
			}
		}while(flag);
	}
	private static void displayManyStudentDetails(Student[] sortedStudents) {
		for (int i = 0; i < studentsCount; i++)
			displayStudentDetails(sortedStudents,i);
		
	}
	private static void displayAllStudentDetails(Student[] array){
		for(int i=0;i<array.length;i++)
			displayStudentDetails(array,i);
	}
	private static void displayStudentDetails(Student[] students3,int i) {
		System.out.println("======================================");
		System.out.println("Student id: "+students3[i].getId());
		System.out.println("Student name: "+students3[i].getName());
		System.out.println("Student class: "+students3[i].getStandard());
		System.out.println("Student Phone number: "+students3[i].getPhone());
		System.out.println("Student total fees per year: "+students3[i].getTotalFees());
		System.out.println("Student submitted fees: "+students3[i].getFeesSubmitted());
		System.out.println("======================================");
		
	}
	private static Student[] sortStudentsByName(Student[] students2) {
		Student[] newarr=new Student[students2.length];
		for(int i=0;i<studentsCount;i++)
			newarr[i]=students2[i];
		for (int i = 0; i < newarr.length-1; i++) {
			for (int j = 0; j < newarr.length-i-1; j++) {
				if(newarr[j].getName().compareTo(newarr[j+1].getName())>0) {
					Student temp=newarr[j];
					newarr[j]=newarr[j+1];
					newarr[j+1]=temp;
				}
			}
		}
		return newarr;
	}
	private static void resize() {
		Student[] newarr=new Student[students.length+10];
		for (int i = 0; i < students.length; i++)
			newarr[i]=students[i];
		students=newarr;
	}
	private static void displayMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. Add details of a student.");
		System.out.println("2. Sort the students based on the name");
		System.out.println("3. Display students with pending fees");
		System.out.println("4. Update the submitted-fee for a particular student.");
		System.out.println("5. Display all students of particular class");
		System.out.println("6. Exit");
		System.out.println("------------------------------------------------");
		
	}
	

}
