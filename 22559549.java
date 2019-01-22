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
        long modulo=1000000000+7;
        while(t-->0)            //for printing all test cases
        {
            //your code goes here 
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            if(n%2==0||m%2==0)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}