package ProblemsDay4Mar12;

import java.util.Scanner;

/*
 * Given two input alphanumeric strings, write a program to segregate the strings into two separate strings with numbers in 1st string and characters in 2nd string removing duplicates.
Example:
Input:
String1 = Wel123come, String2 = 2Goodbye45
Output:
String1 = 12345, String2 = WelcomeGdby
 */
public class Problem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter input 1: ");
		String str1 = in.next();
		in.nextLine();
		System.out.println("Enter input 2: ");
		String str2 = in.next();
		String res1 = "";
		String res2 = "";
		int i = 0;
		while (i < str1.length()) {
			if (str1.charAt(i) >= 48 && str1.charAt(i) <= 57) {
				if (!isPresent(res1, str1.charAt(i)))
					res1 += str1.charAt(i);
			} else {
				if (!isPresent(res2, str1.charAt(i)))
					res2 += str1.charAt(i);
			}
			i++;
		}
		i = 0;
		while (i < str2.length()) {
			if (str2.charAt(i) >= 48 && str2.charAt(i) <= 57) {
				if (!isPresent(res1, str2.charAt(i)))
					res1 += str2.charAt(i);
			} else {
				if (!isPresent(res2, str2.charAt(i)))
					res2 += str2.charAt(i);
			}
			i++;
		}

		System.out.println("Output String 1: "+res1);
		System.out.println("Output String 2: "+res2);
	}

	private static boolean isPresent(String str, char ch) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				return true;
		}
		return false;
	}

}
