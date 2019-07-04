//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    public static void main(String[]args)
    {
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        while(t-->0)
        {
            String s=S.next();
            String e=S.next();
            int l=S.nextInt();
            int r=S.nextInt();
            String day[]=new String[]{"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
            
            int indexs=0,indexe=0,dif;
            
            for(int i=0;i<7;i++)
            {
            if(day[i].equalsIgnoreCase(s))
            indexs=i;
            if(day[i].equalsIgnoreCase(e))
            indexe=i;
            }
            
            if(indexe>indexs)
            {
            dif=indexe-indexs;
            dif++;
            }
            else if(indexs>indexe)
            {
            dif=(7-indexs)+indexe;
            dif++;
            }
            else
            dif=1;
            int res=0,count=0;
            
            for(int i=dif;i<=r;i+=7)
            {
                if(i>=l&&i<=r)
                {
                    res=i;
                    count++;
                }
                if(count>1)
                break;
            }
            
            if(count>1)
            System.out.println("many");
            if(count==0)
            System.out.println("impossible");
            if(count==1)
            System.out.println(res);
        }
    }
}