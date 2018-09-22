import java.util.Scanner;
class Messi
{
    public static void main (String[] args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        int x[][]=new int[T][2];
        int i,j;
        for(i=0;i<T;i++)
        {
            for(j=0;j<2;j++)
            {
                x[i][j]=S.nextInt();
            }
        }
        for(i=0;i<T;i++)
        {
            for(j=0;j<2;j++)
            {
                if(j==0)
                System.out.println(x[i][j]%x[i][j+1]);
            }
        }
        
    }
      
    
}