import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
       Scanner S=new Scanner(System.in);
       int T=S.nextInt();
       int x[]=new int[T];
       for(int i=0;i<T;i++)
       {
           x[i]=S.nextInt();
       }
       for(int i=0;i<T;i++)
       {
           if(x[i]<10)
           System.out.println("What an obedient servant you are!");
           else
           System.out.println(-1);
       }
    }
}