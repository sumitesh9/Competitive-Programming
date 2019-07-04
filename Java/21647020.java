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
            int tr=Integer.parseInt(br.readLine());
            int atr[]=new int[tr];
            StringTokenizer st=new StringTokenizer(br.readLine());
            
            for(int i=0;i<tr;i++)
            atr[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(atr);
            
            int dr=Integer.parseInt(br.readLine());
            int adr[]=new int[dr];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<dr;i++)
            adr[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(adr);
            
            int ts=Integer.parseInt(br.readLine());
            int ats[]=new int[ts];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<ts;i++)
            ats[i]=Integer.parseInt(st.nextToken());
            
            
            int ds=Integer.parseInt(br.readLine());
            int ads[]=new int[ds];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<ds;i++)
            ads[i]=Integer.parseInt(st.nextToken());
            
            int flag=0;
            for(int i=0;i<ts;i++)
            {
                if(Arrays.binarySearch(atr,ats[i])<0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                for(int i=0;i<ds;i++)
                {
                    if(Arrays.binarySearch(adr,ads[i])<0)
                    {
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0)
            System.out.println("yes");
            else
            System.out.println("no");
        }
    }
}