import java.util.*;
import java.io.*;
public class findelementofrankonlogn
{
	public static int findelementofrank(int arr[] , int rank)
	{
		Quicksort q= new Quicksort();
		q.quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(Integer.toString(arr[i])+" ");		}
		int term = arr[rank-1];
		return term;
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rank = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();
		}

		System.out.println(findelementofrank(arr,rank));

	}
}
