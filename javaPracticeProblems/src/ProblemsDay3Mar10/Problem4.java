package ProblemsDay3Mar10;

import java.util.Scanner;

// input:  I am a good boy
// output: I an a gooe boz
public class Problem4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Sentence: ");
		String str = in.nextLine();
		String res = solution(str);
		System.out.println(res);
	}

	private static String solution(String str) {
		int i = 0;
		String res = "";
		while (i < str.length() - 1) {
			if (str.charAt(i) == ' ') {
				res += ' ';
				i++;
			} else if (isVowel(str.charAt(i))) {
				res += str.charAt(i);
				i++;
				if (str.charAt(i) == ' ') {
					res += ' ';
					i++;
				} else if (!isVowel(str.charAt(i))) {
					if (str.charAt(i) == 'z')
						res += 'a';
					else if (str.charAt(i) == 'Z')
						res += 'A';
					else
						res += (char) (str.charAt(i) + 1);
					i++;
				}
			} else {
				res += str.charAt(i);
				i++;
			}
		}
		return res;
	}

	private static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U')
			return true;
		return false;
	}
}
