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
            int a[]=new int[N];
            for(int i=0;i<N;i++)
            {
                a[i]=S.nextInt();
            }
            Arrays.sort(a);
            int minDiff = a[1]-a[0];
            for(int i=2;i!=a.length;i++)
            {
            minDiff=Math.min(minDiff,a[i]-a[i-1]);
            }
            System.out.println(minDiff);
        }
    }
}