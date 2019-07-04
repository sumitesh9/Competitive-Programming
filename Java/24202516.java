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
            int ar[]=new int[102];
            for(int i=0;i<102;i++)
            ar[i]=0;
            
            int m=S.nextInt();
            int x=S.nextInt();
            int y=S.nextInt();
            int cop[]=new int[m];
            for(int i=0;i<m;i++)
            cop[i]=S.nextInt();
            
            
            int li=0,ri=0,cov=x*y;
            for(int i=0;i<m;i++)
            {
                li=cop[i]-cov;
                ri=cop[i]+cov;
                if(li<0)
                li=1;
                if(ri>100)
                ri=101;
                Arrays.fill(ar,li,ri+1,1);
            }
            int count=0;
            for(int i=1;i<=100;i++){
            if(ar[i]==0) count++;}
            System.out.println(count);
        }
    }
}