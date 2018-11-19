import java.util.Scanner;
import java.lang.Math;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        while(t-->0)
        {
           long bi=0,ni=0,by=0;
           int n;
           n=S.nextInt();
           int qty;
           if(n<=26)
           {
               if(n<=2)
               System.out.println("1"+" "+"0"+" "+"0");
               else if(n>=3&&n<=10)
               System.out.println("0"+" "+"1"+" "+"0");
               else
               System.out.println("0"+" "+"0"+" "+"1");
           }
           else
           {
               if(n%26==0)
               qty=n/26;
               else
               qty=(n/26)+1;
               if(n%26==1||n%26==2)
               {
                  bi=(long)Math.pow(2,(qty-1));
                  ni=0;
                  by=0;
               }
               else if(n%26>=3&&n%26<=10)
               {
                   ni=(long)Math.pow(2,(qty-1));
                   bi=0;
                   by=0;
               }
               else
               {
                   by=(long)Math.pow(2,(qty-1));
                   ni=0;
                   bi=0;
               }
               System.out.println(bi+" "+ni+" "+by);
           }
        }
    }
}