import java.util.*;
import java.io.*;
 class Messi
 {
    public static void main(String[] args)throws IOException
    {   
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            long n=Long.parseLong(st.nextToken());   //Holds total no. of coins
            long k=Long.parseLong(st.nextToken());   //Holds no. of times balances can be used
            double p=0.0;   //Holds probability to be found
            if(n==2||n==1)
            {
            p=n==2?(1.0/2):(1.0);
            } 
            else if(k==0)
            {
                p=1.0/n;
            }
            else 
            {
                n=n%4==0?n/2:n/2+1;
                k--;
                while(n>=2&&k>0)
                {
                    k--;
                    n=n%2==0?n/2:n/2+1;
                }
                p=1.0/n;
            }
            System.out.println(p);
        }
    }
}