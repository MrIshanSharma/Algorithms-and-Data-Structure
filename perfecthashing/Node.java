import java.util.*;
import java.io.*;
public class Node
{
	public long data;
	public Node next;
	public Tabletwo point;
	public Boolean hasValue ;
	Node()
	{
		hasValue = false;
		data=0;
		next=null;
		point = null;
	}
	public void setdata(long d)
	{
		
		this.data = d;
		this.hasValue =true;
	} 

}
