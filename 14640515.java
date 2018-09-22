/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    int dig,sum=0;
	   for(int i=0;i<T;i++)
	   {
	   int N=Integer.parseInt(br.readLine());
	   while(N>0)
	   {
	      dig=N%10;
	      sum+=dig;
	      N/=10;
	   }
	   dig=0;
	   System.out.println(sum);
	   sum=0;
	  }
	  }
    }