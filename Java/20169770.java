import java.util.Scanner;
class Messi  
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        while(t-->0)
        {
            int tempp=1,tempk=1;
            int n=S.nextInt();
            int m=S.nextInt();
            int x=S.nextInt();
            int y=S.nextInt();
            while((tempk+x)<=n)
                tempk+=x;
            while((tempp+y)<=m)
                tempp+=y;
            if(tempp==m&&tempk==n)
            System.out.println("Chefirnemo");
            else
            {
                if(tempp!=m&&tempk!=n)
                {
                    if(tempp+1==m&&tempk+1==n)
                    System.out.println("Chefirnemo");
                    else 
                    System.out.println("Pofik");
                }
                if(tempp!=m&&tempk==n)
                {
                    if(tempp!=1||tempk!=1)
                    {
                    if(tempk-x+1==n&&tempp+1==m)
                    System.out.println("Chefirnemo");
                    else
                    System.out.println("Pofik");
                    }
                    else
                    System.out.println("Pofik");
                }
                if(tempk!=n&&tempp==m)
                {
                    if(tempp!=1||tempk!=1)
                    {
                    if(tempp-y+1==m&&tempk+1==n)
                    System.out.println("Chefirnemo");
                    else
                    System.out.println("Pofik");
                    }
                    else
                    System.out.println("Pofik");
                }
            }
        }
    }
}