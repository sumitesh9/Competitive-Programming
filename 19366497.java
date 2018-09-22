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
            int x[]=new int[4];
            int i=0;
            while(i<4)
            {
                x[i]=S.nextInt();
                i++;
            }
            Arrays.sort(x);
            if(x[0]==x[1]&&x[2]==x[3])
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}