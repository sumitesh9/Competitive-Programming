/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
	    int a[]=new int[T];
	    int r=0,dig=0;
		for(int i=0;i<T;i++)
		a[i]=Integer.parseInt(br.readLine());    
		for(int i=0;i<T;i++)
		{
		    while(a[i]>0)
		    {
		     dig=a[i]%10;
		     r=(r*10)+dig;
		     a[i]/=10;
		    }
		    dig=0;
		    System.out.println(r);
		    r=0;
		}
	}
}