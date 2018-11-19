//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            String st=br.readLine();
            String gar[]=new String[st.length()];
            for(int i=0;i<st.length();i++)
            {
                gar[i]=Character.toString(st.charAt(i));
            }
            
            int r=0,g=0;
            for(int i=0;i<st.length();i++)
            {
                if(gar[i].equals("R")) r++;
                else g++;
            }
            
            if(r!=g)
            System.out.println("no");
            else
            {   
                boolean flag=false;
                if(!gar[st.length()-1].equals(gar[0]))
                {
                String prev=gar[0];
                for(int i=1;i<st.length();i++)
                {
                    if(gar[i].equals(prev))
                    {
                        flag=true;
                        break;
                    }
                    prev=gar[i];
                }
                }
                if((gar[st.length()-1].compareTo(gar[0])!=0&&flag==false))
                System.out.println("yes");
                else
                {
                    int cont=0;
                    String prev=gar[0];
                    for(int i=1;i<st.length();i++)
                    {
                        if(gar[i].equals(prev))
                        cont++;
                        prev=gar[i];
                    }
                    if(gar[0].equals(gar[st.length()-1]))
                    cont++;
                    if(cont>2)
                    System.out.println("no");
                    else
                    System.out.println("yes");
                }
            }
        }
    }
}