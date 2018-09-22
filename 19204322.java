import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int N1=S.nextInt();
        int N2=S.nextInt();
        if(N1>N2)
        {
            System.out.println((N1-N2));
        }
        else
        System.out.println((N1+N2));
    }
}