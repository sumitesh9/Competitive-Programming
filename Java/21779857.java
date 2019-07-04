//StandardJavaTemplate
//@author - Sumitesh Naithani
import java.util.*;
import java.io.*;
class Messi {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        if(r>=1300&&r<=1501&&N>=1&&N<=1000)
        {
        while(N-->0)
        {
            int R = Integer.parseInt(br.readLine());  //Rating of each contestant
            if(R>=r&&R>=1300&&R<=1501)
            {
                System.out.println("Good boi");
                System.out.flush();
            }
            else
            {
                if(R>=1300&&R<=1501)
                {
                System.out.println("Bad boi");
                System.out.flush();
                }
            }
            System.out.flush();
        }
        }
        }
    }