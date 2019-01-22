//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int status=0;
        
        for(int i=1;i<=N;i++)
        {
            System.out.println(1+" "+i);
            System.out.flush();
            status=Integer.parseInt(br.readLine());
            if(status==0) continue;
            else
            {
            System.out.println(3+" "+i);
            System.out.flush();
            break;
            }
        }
    }
}