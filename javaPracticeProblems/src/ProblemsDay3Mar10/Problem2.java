package ProblemsDay3Mar10;

import java.util.Scanner;

//input 3 20 5 1 8
//output: res: 1 3 5 8 20
//		  prime: 1 3 5
public class Problem2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of the array: ");
		int size = in.nextInt();
		int[] array = new int[size];
		System.out.println("Enter array items: ");
		for (int i = 0; i < size; i++)
			array[i] = in.nextInt();

		sortUsingInsertionSort(array);
		
		System.out.println("Sorted array using Insertion Sort: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		System.out.println("Prime numbers of this array: ");
		for (int i = 0; i < array.length; i++) {
			if (isPrime(array[i]))
				System.out.print(array[i] + " ");
		}
	}

	private static void sortUsingInsertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int current = array[i];
			while (j >= 0 && array[j] > current) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}
	private static boolean isPrime(int item) {
		for (int i = 2; i < item / 2; i++) {
			if (item % i == 0) {
				return false;
			}
		}
		return true;
	}
}
