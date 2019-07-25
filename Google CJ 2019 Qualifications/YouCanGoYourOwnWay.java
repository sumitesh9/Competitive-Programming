import java.util.*;
import java.io.*;
class YouCanGoYourOwnWay
{
    public static void main(String[]args)throws IOException
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        int j=1;
        int n;
        while(t-->0)
        {
            n=S.nextInt();
            StringBuffer sb=new StringBuffer();
            String str=S.next();
            
            sb.append(str);
            for(int i=0;i<sb.length();i++)
            {
             if(sb.charAt(i)=='S')
             sb.setCharAt(i,'E');
             else if(sb.charAt(i)=='E')
             sb.setCharAt(i,'S');
             else
             {}
            }
            System.out.println("Case #"+j+":"+" "+sb);
            j++;
        }
    }
}