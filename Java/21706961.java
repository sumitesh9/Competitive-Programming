//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
        static long gcd(long a, long b)   //Returns GCD
        {
        if(b==0)
            return a;
        else
            return gcd(b, a % b);
        }
    public static void main(String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Read no. of test cases
        int t=Integer.parseInt(br.readLine());
        long modulo=1000000000+7;
        while(t-->0)            //for printing all test cases
        {
            //your code goes here 
            int n = Integer.parseInt(br.readLine());
            long [] a = new long[n];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
                a[i] = Integer.parseInt(st.nextToken());
            long g = a[0];
            for(int i=1;i<n;i++)
                g = gcd(g,a[i]);
            if(g==1)
                System.out.println(0);
            else
                System.out.println(-1);
        }
    }
}