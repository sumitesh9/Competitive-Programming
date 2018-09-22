import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
       Scanner S=new Scanner(System.in);
       int T=S.nextInt();
       int x[]=new int[T];
       int copy,dig,rev=0;
       for(int i=0;i<T;i++)
       {
           x[i]=S.nextInt();
       }
       for(int i=0;i<T;i++)
       {   
           copy=x[i];
           while(copy>0)
           {
               dig=copy%10;
               rev=(rev*10)+dig;
               copy/=10;
           }
           if(x[i]==rev)
           {
           System.out.println("wins");
           }
           else
           System.out.println("losses");
           copy=0;
           dig=0;
           rev=0;
       }
    }
}