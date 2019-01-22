//Standard_JAVA_Template
/*@author SUMITESH NAITHANI somu_9 */
import java.io.*;
import java.util.*;
class Messi
{
    static int lastDig(int x)
    {
        return x%10;
    }
    public static void main(String[]args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int correct = a-b;
        
        if(lastDig(correct)==9)
        System.out.println(correct-1);
        else
        System.out.println(correct+1);
    }
}