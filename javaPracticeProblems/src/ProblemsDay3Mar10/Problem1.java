package ProblemsDay3Mar10;

import java.util.Scanner;

//input: array1: 1 2 3 4 5
//		 array2: 5 4 3 2 1
//output: res: -4-2 0 2 4
//		  res with negative numbers: -4 -2
public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int[] thirdArray= {2,3,4};
		int size = in.nextInt();
		int[] first = new int[size];
		int[] second = new int[size];
		System.out.println("Enter first array: ");
		for (int i = 0; i < size; i++)
			first[i] = in.nextInt();
		System.out.println("Enter second array: ");
		for (int i = 0; i < size; i++)
			second[i] = in.nextInt();

		int[] res = getResultantArray(first, second);
		System.out.println("Resultant Array: ");
		for (int i = 0; i < size; i++)
			System.out.print(res[i] + " ");
		System.out.println();

		int[] resWithNegative = getNegativeArray(res);
		System.out.println("Resultant Array with negative numbers: ");
		for (int i = 0; i < resWithNegative.length; i++)
			System.out.print(resWithNegative[i] + " ");
	}

	private static int[] getResultantArray(int[] first, int[] second) {
		int[] res = new int[first.length];
		for (int i = 0; i < first.length; i++)
			res[i] = first[i] - second[i];
		return res;
	}

	private static int[] getNegativeArray(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0)
				count++;
		}
		int[] resWithNegative = new int[count];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0)
				resWithNegative[j++] = array[i];
		}
		return resWithNegative;
	}

}
