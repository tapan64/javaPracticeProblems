package ProblemsDay3Mar10;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows & columns of the matrix: ");
		int rows = in.nextInt();
		int columns = in.nextInt();
		int[][] matrix = new int[rows][columns];
		int[] array = new int[rows * columns];
		int k = 0;
		System.out.println("Enter unique elements to the matrix: ");
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = in.nextInt();
				array[k++] = matrix[i][j];
			}

		if (isUnique(array)) {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			int minFirst = 0, minSecond = 0, maxFirst = 0, maxSecond = 0;
			for (int s = 0; s < rows; s++) {
				for (int t = 0; t < columns; t++) {
					if (matrix[s][t] < min) {
						min = matrix[s][t];
						minFirst = s;
						minSecond = t;
					}
					if (matrix[s][t] > max) {
						max = matrix[s][t];
						maxFirst = s;
						maxSecond = t;
					}
				}
			}
			int temp = matrix[minFirst][minSecond];
			matrix[minFirst][minSecond] = matrix[maxFirst][maxSecond];
			matrix[maxFirst][maxSecond] = temp;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}

		else {
			System.out.println("Items are not unique");
		}

	}

	private static boolean isUnique(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				return false;
		}
		return true;
	}
}
