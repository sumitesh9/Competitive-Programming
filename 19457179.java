import java.util.Scanner;
class Messi 
{
    int gcd(int n1,int n2)
    {
        if(n2==0)
        return n1;
        else
        return(gcd(n2,n1%n2));
    }
    public static void main(String[]args)
    {
        Messi obj=new Messi();
        int T;
        Scanner S=new Scanner(System.in);
        T=S.nextInt();
        while(T-->0)
        {
            int A=S.nextInt();
            int B=S.nextInt();
            int N=S.nextInt();
            int sum=(int)(Math.pow(A,N)+Math.pow(B,N));
            int x=Math.abs((A-B));
            int y=1000000007;
            int res=obj.gcd(sum,x);
            System.out.println(res%y);
        }
    }
}