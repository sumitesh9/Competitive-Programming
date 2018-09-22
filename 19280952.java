import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        int t;
        for(int i=0;i<T;i++)
        {
            int N=S.nextInt();
            int x[]=new int[N];
            for(int j=0;j<N;j++)
            {
                x[j]=S.nextInt();
            }
            for(int j=0;j<N-1;j++)
            {
                for(int k=0;k<N-1;k++)
                {
                    if(x[k]>x[k+1])
                    {
                    t=x[k];
                    x[k]=x[k+1];
                    x[k+1]=t;
                    }
                }
            }
            System.out.println((x[0]*(N-1)));
        }
    }
}
        