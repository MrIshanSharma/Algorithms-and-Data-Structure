import java.util.*;
import java.io.*;
/*
Finding the subarray with maximum sum
in order n time
*/
public class maximumsumsubarrayon
{
	static int B[] = new int[2];
	public static int maximumsum(int arr[])
	{
		int max = Integer.MIN_VALUE;
		int i=0,sum=0;
		for(int j=0;j<arr.length;j++)
		{
			sum=sum+arr[j];
			if(sum>max)
			{
				max=sum;
				B[0]=i;
				B[1]=j;
			}
			if(sum<0)
			{
				sum=0;
				i=j+1;
			}
		}
		return max;
	}
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]= sc.nextInt();
		}
		System.out.println(maximumsum(arr));
		for(int i=B[0];i<=B[1];i++)
		{
			System.out.print(Integer.toString(arr[i])+" ");
		}
	}
}
