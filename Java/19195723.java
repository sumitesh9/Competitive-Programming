import java.util.Scanner;
class Messi
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        int c=0;
        int x[]=new int[T];
        for(int i=0;i<T;i++)
        {
        x[i]=S.nextInt();
        }
        for(int i=0;i<T;i++)
        {
        String s=Integer.toString(x[i]);
        for(int j=0;j<s.length();j++)
        {
        if(s.charAt(j)=='4')
        c++;
        }
        System.out.println(c);
        c=0;
        }
       
    }
}