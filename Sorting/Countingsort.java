import java.util.*;
import java.io.*;
public class Countingsort
{
	/*
	it does counting on the basis of 100 discrete values 
	*/
	public static void csort(int Arr[],int B[])
	{
		int C[] = new int[Arr.length];
		int count[] = new int[100];
		for(int loop=0;loop<Arr.length;loop++)
		{
			count[Arr[loop]]++;
		}
		for(int loop=1;loop<100;loop++)
		{
			count[loop] = count[loop-1] + count[loop];
		}
		for(int loop=Arr.length-1;loop>=0;loop--)
		{
			B[count[Arr[loop]]-1]	 = Arr[loop];
			count[Arr[loop]] =count[Arr[loop]] -1; 
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			A[loop] = sc.nextInt();
		}
		csort(A,B);
		for(int loop = 0;loop<n;loop++)
		{
			System.out.println(Integer.toString(B[loop])+ " ");
		}
	}
}
