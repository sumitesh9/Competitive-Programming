//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    static boolean allones(StringBuffer l)    //Check if StringBuffer is only 1
    {
        for(int i=0;i<l.length();i++){
            if(l.charAt(i)!='1')
            return false;}
        return true;
    }
    static boolean allzeroes(StringBuffer l)    //Check if StringBuffer is only 0
    {
        for(int i=0;i<l.length();i++){
            if(l.charAt(i)!='0')
            return false;}
        return true;
    }
    static int cal(StringBuffer sb,int p)
    {
        if(allones(sb)||(allzeroes(sb)))
        {
            if(allzeroes(sb)) return 0;
            return p;
        }
        int res;
        int first=sb.indexOf("0");
        int last=sb.lastIndexOf("0");
        
        if(first>=p||(sb.length()-last-1)>=p)
        return p;
        
        int t;
        if(first>sb.length()-last-1)
        res=first;
        else
        res=sb.length()-last-1;
        for(int i=first;i<sb.lastIndexOf("0");)
        {
            t=sb.indexOf("0",i+1)-i-1;
            if(t>=p)
                return p;
            if(t>res)
                res=t;
            i=sb.indexOf("0",i+1);
        }
        return res;
    }
    public static void main(String[]args)throws IOException
    {
        //*** Taking Input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        
        StringBuffer seq=new StringBuffer();
        StringBuffer qu=new StringBuffer();
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        seq.append(st.nextToken());
        
        qu.append(br.readLine());
        //Input part and assigning is over 
        
        // Calculation part assigning based on queries
        
        for(int i=0;i<qu.length();i++)
        {
            if(qu.charAt(i)=='?')    // Print longest contiguous subsequence
            {
                System.out.println(cal(seq,k));
            }
            else    // Right Shift the sequence
            {
                StringBuffer temp=new StringBuffer();
                temp.append(seq.charAt(seq.length()-1));
                temp.append(seq.substring(0,seq.length()-1));
                seq=temp;
            }
        }
    }
}