import java.util.*;
import java.io.*;
/*
this class implements quicksort on an array 
*/
public class Quicksort
{
	public static int partition(int A[] ,int p , int r)
	{
		int i=p-1;
		int term =  A[r];
		for(int j = p;j<r;j++)
		{
			if(A[j]<=term)
			{
				i++;
				int temp = A[j];
				A[j] = A[i];
				A[i]= temp;
			}
		}
		int temp = A[r];
				A[r] = A[i+1];
				A[i+1]= temp;
				return i+1;

	}
	public static void quicksort(int A[], int p ,int r )
	{
		if(p<r)
		{
			int q =  partition(A,p,r);
			quicksort(A,p,q-1);
			quicksort(A,q+1,r);
		}
	}
	public static void print(int arr[])
	{
		System.out.println("Sorted seqquence is : ");
		for(int i = 0;i<arr.length;i++)
		{
			System.out.print(Integer.toString(arr[i])+" ");
			//System.out.print("Rank : "+Integer.toString(i+1)+ " Term : " + Integer.toString(arr[i])+" - ");
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int term = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();
		}
		//print(arr);
		quicksort(arr,0,arr.length-1);
		print(arr)
;	}
}
