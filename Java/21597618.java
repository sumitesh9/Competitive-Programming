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
        while(t-->0)            //for printing all test cases
        {
            //your code goes here 
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n+1];       //Storing sequence to array
            a[0]=-1;              //Random Values for index issue
            //Taking input from User 
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                a[i]=Integer.parseInt(st.nextToken());
            }
            int flag=0;
            for(int i=1;i<n;i++)
            {
                for(int j=i+1;j<=n;j++)
                {
                    if(a[a[i]]==a[a[j]]&&a[i]!=a[j])
                    {
                        flag=1;
                        System.out.println("Truly Happy");
                        break;
                    }
                }
                if(flag==1)
                break;
            }
            if(flag==0)
            System.out.println("Poor Chef");
        }
    }
}