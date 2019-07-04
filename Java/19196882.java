import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
    Scanner S=new Scanner(System.in);
    int T=S.nextInt();
    int c=0;
    int x[]=new int[T];
    for(int i=0;i<T;i++)
    {
    x[i]=S.nextInt();
    }
    for(int i=0;i<T;i++)
    {
    while(x[i]>=100)
    {
        c=c+(x[i]/100);
        x[i]=x[i]%100;
    }
    while(x[i]>=50)
    {
        c=c+(x[i]/50);
        x[i]=x[i]%50;
    }
    while(x[i]>=10)
    {
        c=c+(x[i]/10);
        x[i]=x[i]%10;
    }
    while(x[i]>=5)
    {
        c=c+(x[i]/5);
        x[i]=x[i]%5;
    }
    while(x[i]>=2)
    {
        c=c+(x[i]/2);
        x[i]=x[i]%2;
    }
    while(x[i]>=1)
    {
        c=c+(x[i]/1);
        x[i]=x[i]%1;
    }
    System.out.println(c);
    c=0;
    }
}
}