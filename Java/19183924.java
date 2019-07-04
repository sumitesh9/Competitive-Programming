import java.util.Scanner;
class Messi
{
    public static void main (String[] args)
    {
        Scanner S=new Scanner(System.in);
        int n,k,c=0;
        n=S.nextInt();
        k=S.nextInt();
        int x[]=new int[n];
        for(int i=0;i<n;i++)
        {
            x[i]=S.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(x[i]%k==0)
            {
                c++;
            }
        }
        System.out.println(c);
    }
} 