package javaPracticeProblems;

public class ArrayProblems {
	void printTriplets(int[] a) {
		for(int i=0;i<a.length-2;i++)
			for(int j=i+1;j<a.length-1;j++)
				for(int k=j+1;k<a.length;k++)
					if(a[i]+a[j]==a[k])
						System.out.println(a[i]+" "+a[j]+" "+a[k]);
	}

}
