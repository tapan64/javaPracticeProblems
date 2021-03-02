package StringProblems;

import java.util.Scanner;

public class StringUtils {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		replaceCharacters();

	}

	static void replaceCharacters() {
		// ask user for String input.
		// if words of String is other than 2, return Invalid String.
		// replace characters except first & last characters.
		System.out.println("Enter String of 2 words");
		String str = in.nextLine();
		if(!isValidInputString(str)) {
			System.out.println("Invalid String ");
			return;
		}
		String str1 = "";
		String str2 = "";
		int i = 0, j = 0;
		while (str.charAt(j) != ' ') {
			j++;
		}
//		System.out.println("first length"+j);
		j++; 		// hello world  
				    // i     j
		str1 += str.charAt(i++);
		str2 += str.charAt(j++);		// hello world		output- 	h     w
	    								//  i     j
		while (str.charAt(i + 1) != ' ') {
			str1 += str.charAt(j++);
			str2 += str.charAt(i++);
		}								// hello world		output- 	horl     well
										//     i     j
		str1 += str.charAt(i++);
		str2 += str.charAt(j++);		// output- 	horlo     welld
		System.out.println("Output- "+str1 + " " + str2);
	}

	private static boolean isValidInputString(String str) {
		int count=0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==' ')
				count++;
		}
		if(count==1)
			return true;
		return false;
	}

	static void replaceSpecialCharacters() {
		// special characters- 33–47 / 58–64 / 91–96 / 123–126
		System.out.println("Enter the input String");
		String str = in.nextLine();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (isSpecialCharacter(str.charAt(i)))
				res += '*';
			else
				res += str.charAt(i);
		}
		System.out.println("Output- " + res);
	}

	private static boolean isSpecialCharacter(char ch) {
		if ((ch >= 33 && ch <= 47) || (ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96) || (ch >= 123 && ch <= 126))
			return true;
		return false;
	}
}
