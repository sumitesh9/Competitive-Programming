import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0)
		{
		    long a = input.nextLong();
		    long b = input.nextLong();
		    System.out.printf("%d %d\n",gcd(a,b),lcm(a,b));
		}
	}
    private static long gcd(long a, long b)
    {
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    private static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
}
 