//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    public static void main(String[]args)throws IOException
    {
        Scanner S=new Scanner(System.in);
        //Read no. of test cases
        int t=S.nextInt();
        long modulo=1000000000+7;
        while(t-->0)            //for printing all test cases
        {
            //your code goes here
            int n=S.nextInt();
            String str;
            str=S.next();
            long count=0;
            for(int i=0;i<str.length();i++)
            {
                char ch=str.charAt(i);
                if(ch=='1')
                count++;
            }
            System.out.println((count*(count+1)/2));
        }
    }
}