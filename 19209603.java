import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int T,X,Y;
	    Scanner sc=new Scanner(System.in);
	    T=sc.nextInt();
	    while(T--!=0)
	    {
	    X=sc.nextInt();
	    Y=sc.nextInt();
	      while(X!=Y&&X!=0&&Y!=0)
	      {
	           if(X%Y==0||Y%X==0)
	            {  if(X>Y)
                    X=Y;
                    else
                    Y=X;
	            }   
	          else 
	               {
	               if(X>Y)
                    X%=Y;
                    else
                    Y%=X;
	               }
	     }
	      System.out.println(X+Y);
	   }
}
}