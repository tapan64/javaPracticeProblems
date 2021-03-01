package MatrixProblems;

import java.util.Scanner;

public class MatrixMultiplication {
	//enter 2 matrices A & B.
	//enter no. of rows & columns.
	//create a result matrix of A-rows & B-columns
	//multiply each row with each column & store the sum in result matrix at row*column index
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Matrix 1");
		int[][] matrix1=inputMatrix();
		System.out.println("Enter Matrix 2");
		int[][] matrix2=inputMatrix();
		int[][] res=new int[matrix1.length][matrix2[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				for (int k = 0; k < matrix2.length; k++) {
					res[i][j]+=matrix1[i][k]*matrix2[k][j];
					
				}
			}
		}
		displayResult(res);
		
	}
	private static void displayResult(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int[][] inputMatrix() {
		System.out.println("Enter number of rows & columns");
		int rows=in.nextInt();
		int columns=in.nextInt();
		in.nextLine();
		int[][] matrix=new int[rows][columns];
		System.out.println("Enter matrix items");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j]=in.nextInt();
			}
			in.nextLine();
		}
		return matrix;
	}
}
