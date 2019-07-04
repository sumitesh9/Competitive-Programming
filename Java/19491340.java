import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
            String s1=S.next();
            String s2=S.next();
            int cb=0,co=0,flag=0;
            for(int i=0;i<3;i++)
            {
                if((int)s1.charAt(i)==98||(int)s2.charAt(i)==98)
                cb++;
                if((int)s1.charAt(i)==111||(int)s2.charAt(i)==111)
                co++;
            }
            if(cb<2||co<1)
            System.out.println("no");
            else
            {
                for(int i=0;i<3;i++)
                {
                    if((int)s1.charAt(i)!=98&&(int)s2.charAt(i)!=111&&(int)s1.charAt(i)!=111&&(int)s2.charAt(i)!=98)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                System.out.println("no");
                else
                System.out.println("yes");
            }
        }
    }
}