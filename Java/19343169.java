import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T>0)
        {  
           int c=0,pos=0,flag=0;
           int N=S.nextInt();
           int U=S.nextInt();
           int D=S.nextInt();
           int x[]=new int[N];
           for(int i=0;i<N;i++)
           {
               x[i]=S.nextInt();
           }
           for(int i=0;i<N-1;i++)
           {   
               flag=0;
               if(x[i]<x[i+1])
               {
                   if(x[i+1]-x[i]<=U)
                   {
                   pos=i+1;
                   flag=1;
                   }
               }
               else if(x[i]==x[i+1])
               {
                   pos=i+1;
                   flag=1;
               }
               else
               {
                   if(x[i]-x[i+1]<=D)
                   {
                       pos=i+1;
                       flag=1;
                   }
                   else
                   {
                       if(c==0)
                       {
                       pos=i+1;
                       flag=1;
                       c=1;
                       }
                   }
               }
               if(flag==0)
               break;
           }
           System.out.println(pos+1);
           T--;
        }
    }
}