//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    static long gcd(long a,long b)        //Euclid's Algorithm for calculating GCD
    { 
      if(b==0) 
        return a; 
      return gcd(b,a%b);
    } 
    public static void main(String[]args)throws IOException
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        long modulo=1000000000+7;
        while(t-->0)            //for printing all test cases
        {
            //your code goes here 
            int n=S.nextInt();
            long x,y;   //for storing result
            if(n==1)
                System.out.print(1+" "+2+" ");
            if(n==2)
                System.out.print(1+" "+4+" ");
            if(n==3)
                System.out.print(3+" "+8+" ");
            if(n==4)
                System.out.print(5+" "+16+" ");
            if(n==5)
            {
                System.out.print(11+" "+32+" ");
            }
            if(n==6)
            {
                y=64;
                x=21;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==7)
            {
                y=128;
                x=43;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==8)
            {
                y=256;
                x=85;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==9)
            {
                y=512;
                x=171;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==10)
            {
                y=1024;
                x=341;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==11)
            {
                y=2048;
                x=683;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==12)
            {
                y=4096;
                x=1365;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==13)
            {
                y=8192;
                x=2731;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==14)
            {
                y=16384;
                x=5461;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==15)
            {
                y=32768;
                x=10923;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==16)
            {
                y=65536;
                x=21845;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==17)
            {
                y=131072;
                x=43691;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==18)
            {
                y=262144;
                x=87381;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==19)
            {
                y=524288;
                x=174763;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==20)
            {
                y=1048576;
                x=349525;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==21)
            {
                y=2097152;
                x=699051;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==22)
            {
                y=4194304;
                x=1398101;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==23)
            {
                y=8388608;
                x=2796203;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==24)
            {
                y=16777216;
                x=5592405;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
            if(n==25)
            {
                y=33554432;
                x=11184811;
                System.out.print(x/gcd(x,y)+" "+y/gcd(x,y)+" ");
            }
        }
    }
}