package javaPracticeProblems;

import java.util.Scanner;

public class StringUtil {

	static char makeCapital(char ch) {
		if(ch>96 && ch<123)
			return (char)(ch-32);
		else
			return ch;
	}
	static String convert(String str) {
		int i=0;
		String first="";
		while(str.charAt(i)!=' ') {
			first+=str.charAt(i++);
		}
		int j=str.length()-1;
		String last="";
		last+=makeCapital(str.charAt(j));
		while(str.charAt(j-1)!=' ') {
			j--;
		}
		last=makeCapital(str.charAt(j))+last;
		String middle="";
		for(int k=i+1;k<j;k++) {
			if(str.charAt(k)==' ')
				middle+=' ';
			else
				middle+=(char)(str.charAt(k)+1);
		}
		String res= first+" "+middle+last;
		return res;
	}
	public void perform() {	
	Scanner in =new Scanner(System.in);
	System.out.println("Enter Input String");
	String str=in.nextLine();
	String res=convert(str);
	System.out.println("Output");
	System.out.println(res);
	}
}
