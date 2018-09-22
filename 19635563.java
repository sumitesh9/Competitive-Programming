import java.util.Scanner;
class Messi 
{
    int cal(int n)
    {
        for(int i=1;i<n;i*=2)
        {
            for(int j=1;j<n;j*=2)
            {
                if(i!=j)
                {
                    if((i+j)==n)
                    {
                        return 1;
                    }
                }
            }
        }
    return 0;
    }
    public static void main(String[]args)
    {
        Messi obj=new Messi();
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
        int N=S.nextInt();
        if(N==1)
        System.out.println(2);
        else if(N==2)
        System.out.println(1);
        else
        {
            int u=0,d=0;
            int x=obj.cal(N);
            int y=x;
            int copy=N;
            if(x==1)
            {
                System.out.println(0);
            }
            else
            {
                while(x==0)
                {
                    u++;
                    N=N+1;
                    x=obj.cal(N);
                }
                while(y==0)
                {
                    d++;
                    copy=copy-1;
                    y=obj.cal(copy);
                }
                if(u<d)
                System.out.println(u);
                else
                System.out.println(d);
            }
        }
        }
    }
}