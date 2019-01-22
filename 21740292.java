//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Read no. of test cases
        int t=Integer.parseInt(br.readLine());
        while(t-->0)            //for printing all test cases
        {
            //your code goes here 
            int g = Integer.parseInt(br.readLine()); // No. of games
            
            
            while(g-->0)
            {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());  // Heads or tails
            long n = Long.parseLong(st.nextToken());   // No. of coins/rounds 
            int q = Integer.parseInt(st.nextToken());  // Which face is required?
            long term = 0;
            
            if(i==1)   // Intially heads is faced up
            {
                if(n%2==1)    // Odd no. of games
                {
                   term = (n+1)/2; // No. of tails
                   if(q==1)
                   System.out.println(n-term);
                   else
                   System.out.println(term);
                }
                else    // Even no. of games
                {
                    term = n/2; // No. of tails
                    if(q==1)
                    System.out.println(n-term);
                    else
                    System.out.println(term);
                }
            }
            else    // Intially tails is faced up
            {
                if(n%2==1)  // Odd no. of games
                {
                    term = (n+1)/2; // No. of heads
                    if(q==1) 
                    System.out.println(term);
                    else
                    System.out.println(n-term);
                }
                else   //Even no. of games
                {
                    term = n/2;
                    if(q==1)
                    System.out.println(term);
                    else
                    System.out.println(n-term);
                }
            }
            }
        }
    }
}