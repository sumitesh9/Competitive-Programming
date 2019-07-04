import java.util.Scanner;
class Messi
{
    public static void main (String[] args)
    {
        Scanner S=new Scanner(System.in);
        int sum=0;
        int T=S.nextInt();
        int x[][]=new int[T][2];
        for(int i=0;i<T;i++)
        {
            for(int j=0;j<2;j++)
            {
                x[i][j]=S.nextInt();
            }
        }
        for(int i=0;i<T;i++)
        {
            for(int j=0;j<2;j++)
            {
                sum=sum+x[i][j];
            }
            System.out.println(sum);
            sum=0;
        }
        
    }
    
}