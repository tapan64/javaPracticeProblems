package ProblemsDay3Mar10;

import java.util.Scanner;

// input: banana, mango, apple
// input: search String: mango
// output: YES
public class Problem5 {

	public static void main(String[] args) {
		String s1="test1";
		String abc="abc";
		System.out.println(s1.compareTo(abc));
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of fruits: ");
		int size = in.nextInt();
		System.out.println("Enter fruits name: ");
		String[] fruits = new String[size];
		for (int i = 0; i < size; i++) {
			String str=in.next();
			String lowerStr=lowerCase(str);
			fruits[i] =lowerStr; 
			
		}
		fruits = bubbleSort(fruits);
		System.out.println("Enter fruit to be searched: ");
		String target = in.next();
		boolean isValid = isValidTarget(target);
		if (isValid == false) {
			System.out.println("Wrong Input");
			return;
		}
		boolean found = binarySearch(fruits, target);
		if (found)
			System.out.println("YES");
		else
			System.out.println("NO");

	}
	private static String lowerCase(String str) {
		String res="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>=65 && str.charAt(i)<=90)
				res+=(char)(str.charAt(i)+32);
			else
				res+=str.charAt(i);
		}
		return res;
	}

	private static boolean isValidTarget(String target) {
		for (int i = 0; i < target.length(); i++) {
			if (!(target.charAt(i) >= 97 && target.charAt(i) <= 122))
				return false;
		}
		return true;
	}

	private static String[] bubbleSort(String[] fruits) {
		for (int i = 0; i < fruits.length - 1; i++) {
			for (int j = 0; j < fruits.length - i - 1; j++) {
				if (fruits[j].compareTo(fruits[j + 1]) > 0) {
					String temp = fruits[j];
					fruits[j] = fruits[j + 1];
					fruits[j + 1] = temp;
				}
			}
		}
		return fruits;
	}

	private static boolean binarySearch(String[] fruits, String target) {
		int low = 0, high = fruits.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (fruits[mid].equals(target))
				return true;
			else if (fruits[mid].compareTo(target) > 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

}
