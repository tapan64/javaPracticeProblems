package MatrixProblems;

import java.util.Scanner;

public class MatrixRowSum {

	public static void main(String[] args) {
		// ask user for number of rows & columns.
		// ask user the elements of the matrix.
		// calculate sum of elements of each row & display.
		// find the maximum sum of all & display.

		Scanner in = new Scanner(System.in);
		// ask user for number of rows & columns.
		System.out.println("Enter number of rows & columns");
		int rows = in.nextInt();
		int columns = in.nextInt();
		in.nextLine();
		int[][] matrix = new int[rows][columns];
		// ask user the elements of the matrix.
		System.out.println("Enter elements of the matrix");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = in.nextInt();
			}
			in.nextLine();
		}
		// calculate sum of elements of each row & display.
		int max = 0;
		for (int i = 0; i < rows; i++) {
			int sum = 0;
			for (int j = 0; j < columns; j++) {
				sum += matrix[i][j];
			}
			System.out.println("Row-" + (i + 1) + " Sum => " + sum);
			if (sum > max)
				max = sum;
		}
		// find the maximum sum of all & display.
		System.out.println();
		System.out.println("Largest sum among them is- " + max);
	}

}
