//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class ForegoneSolution
{
    public static void main(String[]args)throws IOException
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        int j=1;
        while(t-->0)
        {
            System.out.print("Case #"+j+":"+" ");
            StringBuffer s=new StringBuffer();
            StringBuffer s1=new StringBuffer();
            String str=S.next();
            s.append(str);
            s1.append(s);
            int flag=0;
            for(int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if((int)ch==52)
                {
                    s.setCharAt(i,'3');
                    s1.setCharAt(i,'1');
                }
                else
                s1.setCharAt(i,'0');
            }
            int i;
            for(i=0;i<s1.length()-1;i++)
            {
               if (s1.charAt(i)!='0')
               break;
            }
            System.out.print(s+" ");
            for (;i<s1.length();i++)
            System.out.print(s1.charAt(i));
            System.out.println("");
            
            j++;
        }
    }
}