import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
            int N=S.nextInt();
            int c=0;
            while(N-->0)
            {
                int x=S.nextInt();
                int y=S.nextInt();
                if(y-x>5)
                c++;
            }
            System.out.println(c);
        }
    }
}