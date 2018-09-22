import java.util.Scanner;
class Messi 
{
    public static int mirror(int n)
    {
        int dig,rev=0;
        while(n>0)
        {
            dig=n%10;
            rev=(rev*10)+dig;
            n/=10;
        }
        while(rev%10==0)
        {
            rev=rev/10;
        }
        return rev;
    }
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
            int x=S.nextInt();
            int y=S.nextInt();
            int xm=mirror(x);
            int ym=mirror(y);
            System.out.println(mirror(xm+ym));
        }
    }
}