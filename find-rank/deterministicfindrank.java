import java.util.*;
import java.io.*;
public class deterministicfindrank
{
	
	public static void print(int arr[])
	{
		System.out.print("\n");
		for(int i = 0;i<arr.length;i++)
		{
			System.out.print("Rank : "+Integer.toString(i+1)+ " Term : " + Integer.toString(arr[i])+" - ");
		}
	}
	public static int partition(int A[] ,int p , int r,int pivot)
	{
		
		int t= A[r];
				A[r] = A[pivot];
				A[pivot]= t;
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

	public static int findelementofrank(int A[],int i ,int j, int r)
	{
		int p = goodpivot(A , i , j );
		int k = partition(A,i,j,p);
		int e;
		if(r==j-k+1)
		{
			e=k;
			//e = A[k];
		}
		else if(r<j-k+1)
		{
			e = findelementofrank(A,k+1,j,r);
		}
		else
		{
			e = findelementofrank(A,i,k-1,r-(j-k+1));	
		}
		return e;
	}

	public static int goodpivot(int A[],int i , int j)
	{
		int k = i,a=i;
		int ret,end,median,temp,jump;
		while(k<=j)
		{
			if(k+4<j)
			{
				end=k+4;
				Quicksort.quicksort(A,k,end);
				jump =5;
				//k=k+5;
			}
			else 
			{
				end = j;
				Quicksort.quicksort(A,k,end);
				jump=j-k+1;
				//k=j;
			}
			median = (k+end+1)/2;
			//System.out.println(a);
			temp = A[a];
			A[a] = A[median];
			A[median] = temp;
			a++;
			k=k+jump;

		}
		a--;
		if(a-i<5)
		{
			Quicksort.quicksort(A,i,a);
			ret= (i+a)/2;
		}
		else
		{
			ret = goodpivot(A,i,a);
		}
		return ret;
	}


	//public static int findrank(int a[] )
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int term = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();
			System.out.print(Integer.toString(arr[loop])+" ");
		}
		//print(arr);
		System.out.println(findelementofrank(arr,0,arr.length-1,term));
		//Quicksort.quicksort(arr,0,arr.length-1);
		for(int loop=0;loop<n;loop++)
		{
			//arr[loop]=sc.nextInt();
			System.out.print(Integer.toString(arr[loop])+" ");
		}
		//print(arr)
;	}
}
