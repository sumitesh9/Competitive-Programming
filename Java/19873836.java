import java.util.Scanner;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T-->0)
        {
           String s=S.next();
           int c=0,l=s.length();
           int up=0,lw=0;
           StringBuffer s1=new StringBuffer(s);
           for(int i=0;i<l;i++)
           {
               char ch=s.charAt(i);
               int asc=(int)ch;
               if(asc>=65&&asc<=90)
               c++;
           }
           lw=c;
           for(int i=0;i<l;i++)
           {
               char ch=s.charAt(i);
               if(ch>=65&&ch<=90)
               {
               s1.setCharAt(up,ch);
               up++;
               }
               else
               {
                   s1.setCharAt(lw,ch);
                   lw++;
               }
           }
        System.out.println(s1);
        }
    }
}