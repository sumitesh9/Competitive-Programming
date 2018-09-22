import java.util.Scanner;
import java.util.Arrays;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
            int N=S.nextInt();
            int K=S.nextInt();
            int a[]=new int[N];
            int b[]=new int[N];
            int ctr=0,ptr=0;
            for(int i=0;i<N;i++)
            {
                a[i]=S.nextInt();
            }
             for(int i=0;i<N;i++)
            {
                b[i]=S.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i=0;i<N;i++)
            {
                for(int j=ptr;j<N;j++)
                {
                    if(b[i]>a[j])
                    {
                    ctr++;
                    ptr=i;
                    break;
                    }
                    else
                    break;
                }
                if(ctr==K)
                break;
            }
            if(ctr==K)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}