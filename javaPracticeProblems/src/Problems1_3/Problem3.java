package Problems1_3;

import java.util.Scanner;

// input: 3*3 matrix
// output: average of diagonals
public class Problem3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] matrix = new int[3][3];
		System.out.println("Enter 3 * 3 matrix items: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int average = getDiagonalAverage(matrix);
		System.out.println("Secondary diagonal odd numbers average: " + average);
	}

//		Primary diagonal odd numbers average: (1 + 5 + 9) / 3 = 5
//				Secondary diagonal odd numbers average: (5 + 7) /2 = 6
	private static int getDiagonalAverage(int[][] matrix) {
		int primarySum = 0, primaryCount = 0, secondarySum = 0, secondaryCount = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < i + 1; j++) {
				if (matrix[i][j] % 2 != 0) {
					primarySum += matrix[i][j];
					primaryCount++;
				}
			}
		}
		System.out.println("Primary diagonal odd numbers average: " + primarySum / primaryCount);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix.length - i - 1; j < matrix.length - i; j++) {
				if (matrix[i][j] % 2 != 0) {
					secondarySum += matrix[i][j];
					secondaryCount++;
				}
			}
		}
		return secondarySum / secondaryCount;
	}

}
