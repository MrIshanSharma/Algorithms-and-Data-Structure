import java.util.*;
import java.io.*;
/*
find the maximum sum sub array of length atleast l
in order n time and order n space complexity 
*/
public class maximumsumlenatleastl
{
	public static int maximumsubarraylengthl(int arr[],int l)
	{
		int suffixsum[] = new int[arr.length];
		int max=Integer.MIN_VALUE;
		suffixsum[arr.length-1] = arr[arr.length-1];
		for(int loop=arr.length-2;loop>=l-1;loop--)
		{
			if(suffixsum[loop+1]<0) suffixsum[loop]=arr[loop];
			else suffixsum[loop] = suffixsum[loop+1]+arr[loop];
		}
		int sum=0;
		for(int j=0;j<l-2;j++)
		{	
			sum=sum+arr[j];
		}
		int temp;
		for(int j=l-1;j<arr.length;j++)
		{
			sum=sum+arr[j-1];
			temp= sum + suffixsum[j];
			if(temp>max)max=temp;

			System.out.println(sum);

			sum=sum-arr[j-l+1];
		}
		return max;
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int arr[]= new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();
		}
		System.out.println(maximumsubarraylengthl(arr,l));

	}
}
