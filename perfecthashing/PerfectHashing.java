import java.io.*;
import java.util.*;
public class PerfectHashing
{
	static Node table[];
	
	static int sizeofset = 1000;
	static int m= sizeofset*2;
	static int a,b;
	static long pf=10000000019L,ps=10100000011L;
	static int count[]= new int[m];
	PerfectHashing()
	{
		m = sizeofset*2;
		count = new int[m];
		pf = 10000000019L;
		ps = 10100000011L;

		//a=10000+90000*java.lang.Math.random();
		//b=10000+90000*java.lang.Math.random();
	}

	public static void print()
	{
		for(int i = 0 ;i<table.length;i++)
		{
			System.out.print(Integer.toString(i)+ " ------ ");
			Node traverse= table[i];
			while(traverse!=null)
			{
				
				System.out.println(Long.toString(traverse.data)+" ");
				traverse = traverse.next;
			}
		}

	}
	public static void printleveltwo()
	{
		for(int i = 0 ;i<table.length;i++)
		{
			
			

			Tabletwo t= table[i].point;
			if(t!=null)
			{	
			System.out.print(Integer.toString(i)+ " ------ "+ Integer.toString(t.a1)+" "+ Integer.toString(t.b1)+" "+ Integer.toString(t.n)+" ");
			for(int i1=0;i1<table[i].point.n;i1++)
			{	
			System.out.println(Long.toString(table[i].point.key[i1])+" ");
			}
			}
		}

	}
	public static void findab()
	{
		table = new Node[m];
		for(int i = 0 ;i<table.length;i++)
		{
			table[i] = new Node();
			//System.out.println(table[i].data);
		}
		Scanner sc = new Scanner(System.in);
		a=(int)(10000+90000*java.lang.Math.random());
		b=(int)(10000+90000*java.lang.Math.random());
		for(int i=0;i<m;i++)
		{
			count[i]=0;
		}
		for(int i=0;i<sizeofset;i++)
		{
			long term = sc.nextLong();
			int index;
			index = (int)(((a*term + b)% pf) % m);
			count[index]++;
			// LOGIC FOR INSERTION - - - - - - - - - 
			long value1;
			int value;
			value1 = term;
			value = index;
			Node traverse = table[value];
			if(traverse.hasValue)
			{
				while(traverse.next!=null)
				{
				traverse = traverse.next;
				}
				Node temp = new Node();
				temp.setdata(value1);
				traverse.next=temp;
			}
			
			else
			
			{
				traverse.setdata(value1);
			}
			//------------Written today

		}
		long sum = 0L;
		for(int i=0;i<m;i++)
		{
			sum = sum + count[i]*count[i];
		}
		if(sum>m)
		{
			findab();
			/*System.out.println("DIKKAT HAI BHAI");
			System.out.println(a);
			System.out.println(b);
			System.out.println(pf);
			System.out.println(m);*/
		}
		else
		{
			System.out.println("NHI HAI KOI DIKKAT BHAI");
			System.out.println(a);
			System.out.println(b);
			System.out.println(pf);
			System.out.println(m);
		}
	}

	public static void findablevel2()
	{
		for(int i =0;i<m;i++)
		{
				
			Node traverse = table[i];
			if(traverse.hasValue)
			{	
				int m1 = count[i]*count[i];
				table[i].point = new Tabletwo(count[i]*count[i]);
				table[i].point.a1=(int)(10000+90000*java.lang.Math.random());
				table[i].point.b1=(int)(10000+90000*java.lang.Math.random());
				int a =table[i].point.a1;
				int b =table[i].point.b1;
				while(traverse!=null)
				{
					long term =traverse.data;
					int index  =  (int)(((a*term + b)% ps) % m1);
					if(table[i].point.key[index]==term||table[i].point.key[index]==0)
					{
						table[i].point.key[index] = term;
						traverse = traverse.next;
							
					}
					else
					{
						table[i].point = new Tabletwo(count[i]*count[i]);
						table[i].point.a1=(int)(10000+90000*java.lang.Math.random());
						table[i].point.b1=(int)(10000+90000*java.lang.Math.random());
						a =table[i].point.a1;
						b =table[i].point.b1;
						traverse = table[i];
					}
				}



			}
			
		}
	}

	public static void main(String[] args) {
		//System.out.println(m);
		//System.out.println(count.length);
		findab();
		findablevel2();
		printleveltwo();

	}
}
