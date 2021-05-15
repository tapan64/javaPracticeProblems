package Problems1_3;

import java.util.Scanner;

/*
 *  Find the number of occurrence of a given string in the sentence.(Ignore the case sensitive)
Input : "Today is sunday, It's holiday"
Substring : Day
Output : 3
 */
public class Problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter input String: ");
		String str = lowerCase(in.nextLine());
		System.out.println("Enter substring: ");
		String substr = lowerCase(in.next());
		int count=countOccurence(str, substr);
		System.out.println("Output: " + count);
	}

	private static int countOccurence(String str,String substr) {
		int i = 0, count = 0;
		while (i < str.length() - substr.length()) {
			int innerCount = 0, j = 0;
			while (j < substr.length()) {
				if (str.charAt(i) == substr.charAt(j)) {
					innerCount++;
					j++;
				}
				i++;
			}
			if (innerCount == substr.length())
				count++;
		}
		return count;
	}
	private static String lowerCase(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
				res += (char) (str.charAt(i) + 32);
			else
				res += str.charAt(i);
		}
		return res;
	}

}
