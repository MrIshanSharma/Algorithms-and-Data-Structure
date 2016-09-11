import java.util.*;
import java.io.*;
public class Mergesort
{
	static int n;
	public static void Merge(int arr[],int p,int q,int r)
	{
		int n1,n2;
		n1=q-p+1;
		n2=r-q;
		int left[] = new int[n1+1];
		int right[] = new int[n2+1];
		for(int i=0;i<n1;i++)
		{
			left[i] = arr[p+i];
		}
		for(int i=0;i<n2;i++)
		{
			right[i] = arr[q+i+1];
		}
		left[n1]=Integer.MAX_VALUE;
		right[n2]=Integer.MAX_VALUE;
		int lp=0,rp=0;
		for(int i=p;i<=r;i++)
		{
			if(left[lp]<right[rp])
			{
				arr[i] = left[lp];
				lp++;
			}
			else
			{
				arr[i] = right[rp];
				rp++;	
			}
		}

		/*for(int loop=0;loop<n;loop++)
		System.out.print(Integer.toString(arr[loop])+" ");
*/
	}
	public static void mergesort(int arr[],int p,int r)
	{
		if(p<r)
		{
			int q = (p+r)/2;
			mergesort(arr,p,q);
			mergesort(arr,q+1,r);
			Merge(arr,p,q,r);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n];
		for(int loop=0;loop<n;loop++)
		{
			arr[loop]=sc.nextInt();
		}
		mergesort(arr,0,arr.length-1);
		for(int loop=0;loop<n;loop++)
		System.out.print(Integer.toString(arr[loop])+" ");



		}
}