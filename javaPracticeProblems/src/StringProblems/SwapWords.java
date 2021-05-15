package StringProblems;

import java.util.Scanner;

public class SwapWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a sentence having two words");
		String sentence = in.nextLine();
		boolean isValid = validateSentence(sentence);
		if (isValid) {
			String[] separatedWords = getSeparatedWords(sentence);
			String res = swapWords(separatedWords[0], separatedWords[1]);
			System.out.println("Resultant string after swapping is: " + res);
		} else {
			System.out.println("Wrong input, it should have only two words.");
		}
	}

	private static String swapWords(String str1, String str2) {
		int i = 0;
		String res1 = "";
		String res2 = "";
		while (i < str1.length()) {
			if (!searchCharacter(str1.charAt(i), str2))
				res2 += str1.charAt(i);
			i++;
		}
		int j = 0;
		while (j < str2.length()) {
			if (!searchCharacter(str2.charAt(j), str1))
				res1 += str2.charAt(j);
			j++;
		}
		return res1 + " " + res2;
	}

	private static boolean searchCharacter(char target, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (makeCharLower(str.charAt(i)) == makeCharLower(target))
				return true;
		}
		return false;
	}

	private static String[] getSeparatedWords(String sentence) {

		String[] array = new String[2];
		array[0] = "";
		array[1] = "";
		int i = 0;
		while (sentence.charAt(i) != ' ') {
			array[0] += sentence.charAt(i);
			i++;
		}
		i++;
		while (i < sentence.length()) {
			array[1] += sentence.charAt(i);
			i++;
		}
		return array;
	}

	private static boolean validateSentence(String sentence) {
		int spaceCount = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ')
				spaceCount++;
		}
		if (spaceCount == 1)
			return true;
		return false;
	}

	private static char makeCharLower(char ch) {
		if (ch >= 65 && ch <= 90)
			return (char) (ch + 32);
		return ch;
	}

}
