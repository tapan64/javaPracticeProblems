package ProblemsDay3Mar10;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int size = in.nextInt();
		int[] first = new int[size];
		int[] second = new int[size];
		System.out.println("Enter first array: ");
		for (int i = 0; i < size; i++)
			first[i] = in.nextInt();
		System.out.println("Enter second array: ");
		for (int i = 0; i < size; i++)
			second[i] = in.nextInt();
		int[] res = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			res[i] = first[i] - second[i];
			if (res[i] < 0)
				count++;
		}
		System.out.println("Resultant Array: ");
		for (int i = 0; i < size; i++)
			System.out.print(res[i] + " ");
		int[] resWithNegative = new int[count];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (res[i] < 0)
				resWithNegative[j++] = res[i];
		}
		System.out.println();
		System.out.println("Resultant Array with negative numbers: ");
		for (int i = 0; i < count; i++)
			System.out.print(resWithNegative[i] + " ");
	}
}
