/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        int fac=1;   
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
	    int ar[]=new int[T];
	    for(int i=0;i<T;i++)
	    ar[i]=Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++)
	    {
	        for(int j=ar[i];j>1;j--)
	        {
	            fac=fac*j;
	 	    }
	        
	    System.out.println(fac);
	    fac=1;
	    }
      }
}