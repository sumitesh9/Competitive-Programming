import java.util.*;
class Messi 
    {
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		long[] a=new long[60];
		while(t-->0)
		{
		  long n=in.nextLong();
		  for(int i=0;i<60;i++){
			  a[i]=(long)Math.pow(2,i);  
		}
		  long max=9223372036854775807L;
		  for(int i=0;i<60;i++)
		  {
			  if(max>Math.abs(a[i]-n))
			  {
				 max=Math.abs(a[i]-n);
			  }
		  }
		  System.out.println(max);
		}
	}
}