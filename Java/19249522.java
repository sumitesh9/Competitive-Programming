import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner kb=new Scanner(System.in);
		 int t=kb.nextInt();
		 while(t>0)
		 { int n=kb.nextInt();
		   long roomno=0,diamond=0;
		   int z,even,odd,r,y=0;
		   int v;
		   int j=1,w=n;
		   for( j=1;j<=n;j++)
		     {   int i=1;
		         even=0;
		         odd=0;
		         y=i+j;
		         while(y>0)
		         { r=y%10;
		           if(r%2==0)
		            even=even+r;
		            else
		            odd=odd+r;
		            y=y/10; 
		         }
		       v=Math.abs(even-odd);
		       v=v*j;
		         
		         diamond=diamond+v;
		       
		       }
		        for(int i=2;i<=n;i++)
		     {   j=n;
		         even=0;
		         odd=0;
		         y=i+j;
		         while(y>0)
		         { r=y%10;
		           if(r%2==0)
		            even=even+r;
		            else
		            odd=odd+r;
		            y=y/10; 
		         }
		       v=Math.abs(even-odd);
		       v=v*(n-i+1);
		         
		         diamond=diamond+v;
		       
		       }
	
		 System.out.println(diamond);
		     
		     t--;
		 }
		  
	}
}