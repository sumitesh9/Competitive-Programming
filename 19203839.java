import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int N=S.nextInt();
        if(N%4==0)
        N=N+1;
        else
        N=N-1;
        System.out.println(N);
    }
}