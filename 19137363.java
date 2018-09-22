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
		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ir);
		int L=Integer.parseInt(br.readLine());
		int B=Integer.parseInt(br.readLine());
		if((L*B)>(2*(L+B)))
		{
		System.out.println("Area");
		System.out.println((L*B));
		}
		else
		{
		System.out.println("Peri");
		System.out.println((2*(L+B)));
		}
		
	}
}