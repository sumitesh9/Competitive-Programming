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
	int ar[]=new int[T];
	for(int i=0;i<T;i++)
	ar[i]=Integer.parseInt(br.readLine());
	for(int i=0;i<T;i++)
	System.out.println(Math.round(Math.sqrt(ar[i])));
        }
}