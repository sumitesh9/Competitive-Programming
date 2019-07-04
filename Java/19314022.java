import java.util.Scanner;
import java.lang.*;
class Messi 
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int T=S.nextInt();
        while(T>0)
        {
            int N=S.nextInt();
            String s=S.next();
            int l=s.length();
            StringBuffer sb=new StringBuffer();
            if(l%2==0) 
            {
            for(int i=0;i<s.length()-1;i=i+2)
            {
            char a=s.charAt(i);
            char b=s.charAt(i+1);
            sb.append(b).append(a);
            }
            } 
            else 
            {
            for (int i=0;i<s.length()-1;i=i+2)
            {
            char a=s.charAt(i);
            char b=s.charAt(i + 1);
            sb.append(b).append(a);
            }
            sb.append(s.charAt(l-1));
            }
            for(int i=0;i<l;i++)
            {
                char c=sb.charAt(i);
                if(c=='a')
                sb.setCharAt(i,'z');
                if(c=='b')
                sb.setCharAt(i,'y');
                if(c=='c')
                sb.setCharAt(i,'x');
                if(c=='d')
                sb.setCharAt(i,'w');
                if(c=='e')
                sb.setCharAt(i,'v');
                if(c=='f')
                sb.setCharAt(i,'u');
                if(c=='g')
                sb.setCharAt(i,'t');
                if(c=='h')
                sb.setCharAt(i,'s');
                if(c=='i')
                sb.setCharAt(i,'r');
                if(c=='j')
                sb.setCharAt(i,'q');
                if(c=='k')
                sb.setCharAt(i,'p');
                if(c=='l')
                sb.setCharAt(i,'o');
                if(c=='m')
                sb.setCharAt(i,'n');
                if(c=='n')
                sb.setCharAt(i,'m');
                if(c=='o')
                sb.setCharAt(i,'l');
                if(c=='p')
                sb.setCharAt(i,'k');
                if(c=='q')
                sb.setCharAt(i,'j');
                if(c=='r')
                sb.setCharAt(i,'i');
                if(c=='s')
                sb.setCharAt(i,'h');
                if(c=='t')
                sb.setCharAt(i,'g');
                if(c=='u')
                sb.setCharAt(i,'f');
                if(c=='v')
                sb.setCharAt(i,'e');
                if(c=='w')
                sb.setCharAt(i,'d');
                if(c=='x')
                sb.setCharAt(i,'c');
                if(c=='y')
                sb.setCharAt(i,'b');
                if(c=='z')
                sb.setCharAt(i,'a');
            }
            System.out.println(sb);
            T--;
        }
    }
}      