import java.util.*;
import java.io.*;
/*
for an array Arr[0....] the function returns maximum
diffrence between Arr[i] and Arr[j] where j>i
*/
public class maxdiffigtj
{
	public static int returnMaxDiffrence(int Arr[])
	{
		int i=0,max = Integer.MIN_VALUE;
		for(int j=1;j<Arr.length;j++)
		{
			if(Arr[j]-Arr[i] > max)max = Arr[j]-Arr[i];
			if(Arr[j]<Arr[i])i=j;
		}
		return max;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			Arr[loop] = sc.nextInt();
			System.out.println(Arr[loop]);
		}

		System.out.println(returnMaxDiffrence(Arr));
	}
}
