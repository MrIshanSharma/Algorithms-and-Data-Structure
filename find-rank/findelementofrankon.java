import java.util.*;
import java.io.*;
public class findelementofrankon
{
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
	public static int randompivot(int p , int r)
	{
		int random;
		if(p==r)return p;
		random = ((int)(Math.random()*100));
		//System.out.println("number : " + Integer.toString(random));
		random=random%(r-p);
		//System.out.println("reminder : " + Integer.toString(random));
		return random+p;

	}
	/*this method returns the element
	of given rank from specified array if
	it 
	*/
	public static int findelementofrank(int A[],int i ,int j, int r)
	{
		int p = randompivot(i,j);
		int k = partition(A,i,j,p);
		int e;
		if(r==j-k+1)
		{
			e = A[k];
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



	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop] = sc.nextInt();
		}
		System.out.println(findelementofrank(arr,0,arr.length-1,r));
	}
}
