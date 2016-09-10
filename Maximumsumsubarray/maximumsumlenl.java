import java.util.*;
import java.io.*;
/*
This prints maximum of sum of all possible
subarrays of length l of the given array
*/
public class maximumsumlenl
{
	static int maxximumsumlenl(int arr [], int l)
	{
		int sum=0;
		int max= Integer.MIN_VALUE;
		for(int loop=0;loop<l-1;loop++)
		{
			sum = sum+arr[loop];
		}	

		for(int loop=l-1;loop<arr.length;loop++)
		{
			sum = sum + arr[loop];
			if(sum>max)max=sum;
			sum = sum - arr[loop-l+1];
		}
		return max;
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int arr[]=new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop] = sc.nextInt();
		}
		System.out.println(maxximumsumlenl(arr,l));
	}
}
