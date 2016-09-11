import java.util.*;
import java.io.*;
public class Bubblesort
{
	public static void bubblesort(int arr[])
	{
		int n = arr.length,temp=0;
		boolean swapped = false;
		for(int i=0;i<n-1;i++)
		{
			swapped = false;
			for (int j=0;j<n-1-i ;j++ ) {
				if(arr[j+1]<arr[j])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped = true;
				}
			}
			if(!swapped)break;
		}

	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();

		}
		bubblesort(arr);
		System.out.println();
		for(int loop=0;loop<n;loop++)
		{
			System.out.print(Integer.toString(arr[loop]) +" ");

		}
	}
}