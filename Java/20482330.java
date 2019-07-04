import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int P1,P2,K,T,tp;
        T=S.nextInt();
        String s1="CHEF";
        String s2="COOK";
        while(T-->0)
        {
            P1=S.nextInt();
            P2=S.nextInt();
            K=S.nextInt();
            int n;
            tp=P1+P2;
            n=tp/K;
            if(n%2==0)
            System.out.println(s1);
            else
            System.out.println(s2);
        }
    }
}