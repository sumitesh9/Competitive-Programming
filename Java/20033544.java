import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int n,x,s,t;
        t=S.nextInt();
        while(t-->0)
        {
            n=S.nextInt();
            x=S.nextInt();
            s=S.nextInt();
            while(s-->0)
            {
                int a=S.nextInt();
                int b=S.nextInt();
                if(a==x||b==x)
                {
                        if(a==x)
                        x=b;
                        else
                        x=a;
                }
            }
            System.out.println(x);
        }
        
    }
}