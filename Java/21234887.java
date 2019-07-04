import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        while(t-->0)
        {
            int x=S.nextInt();
            int y=S.nextInt();
            int z=S.nextInt();
            if(x+y+z==0||-x-y-z==0||-x-y+z==0||-x+y-z==0||x-y-z==0||-x+y+z==0||x-y+z==0||x+y-z==0)
            System.out.println("yes");
            else
            System.out.println("no");
        }
    }
}