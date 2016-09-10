import java.util.*;
import java.io.*;
/*
for an array Arr[0....] the function returns maximum
diffrence between Arr[i] and Arr[j] where j>i+l
this algorithm works in o(n) time
*/
public class maxdiffjgtiml
{
	public static int returnMaxDiffrence(int Arr[],int l)
	{
		int i=0,max = Integer.MIN_VALUE;
		for(int j=l;j<Arr.length;j++)
		{
			if(Arr[j-l]<Arr[i])i=j-l;
			if(Arr[j]-Arr[i] > max)max = Arr[j]-Arr[i];
			
		
		}
		return max;
	}
/*
this function uses an array B[] as an additional data structure 
to solve the poblem it also qorks in o(n) time.
*/
	public static int returnMaxDiffrenceADS(int Arr[],int l)
	{
		int i=0,max = Integer.MIN_VALUE;
		int B[] = new int[Arr.length];
		B[l] = Arr[0];
		//System.out.println("B array is : ");
		for(int loop = l+1;loop<Arr.length;loop++)
		{
			if(Arr[loop-l]<B[loop-1])
			{
				B[loop] = Arr[loop-l];
			}
			else 
			{
				B[loop] = B[loop-1];
			}
			//System.out.print(Integer.toString(B[loop]) + " ");
		}

		for(int j=l;j<Arr.length;j++)
		{
			//System.out.println("Diffrence is : ");
			if(Arr[j]-B[j]>max)
				{
					max=Arr[j]-B[j];
				}
		//System.out.print(Integer.toString(Arr[j]-B[j]) + " ");
		//System.out.println("Minimum is : ");
		//System.out.print(Integer.toString(B[j])+ " ");
		
		//System.out.println("Maximum is : ");
		
		//System.out.print(Integer.toString(max)+ " ");		
		}
		return max;
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int Arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			Arr[loop] = sc.nextInt();
			System.out.print(Integer.toString(Arr[loop]) + " ");
			//System.out.println(Arr[loop]);
		}

		System.out.println(returnMaxDiffrence(Arr,l));
		System.out.println("hey baby");
		System.out.println(returnMaxDiffrenceADS(Arr,l));
	}
}
