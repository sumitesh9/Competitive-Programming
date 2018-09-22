import java.util.Scanner;
class Messi
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        char C=S.next().charAt(0);
        if(C=='A'||C=='E'||C=='I'||C=='O'||C=='U')
        {
            System.out.println("Vowel");
        }
        else
        System.out.println("Consonant");
    }
}