import java.util.*;
import java.io.*;
class Messi 
{
    static long gcd(long a,long b)
  {
    if(b==0)
      return a;
    else 
        return gcd(b,a%b);
  }
  static long sumGCD(ArrayList<Long> a)
  {
    long res1=0;
    for(int i=0;i<a.size();i++)
    {
      res1=gcd(res1,a.get(i));
      if(res1==1)
        break;
    }
    return res1;
  }
    public static void main(String[]args)throws IOException
    { 
        Scanner S=new Scanner(System.in);
        int t=S.nextInt();
        while(t-->0)
        {
            int n=S.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=S.nextLong();
            }
             HashSet<Long> h=new HashSet<Long>();
             ArrayList<Long> a=new ArrayList<Long>();
               for(int i=0;i<n;i++)
               {
                       h.add(arr[i]);
               }
               if(h.size()==1)
               {
                     for(long f : h)
                      System.out.println(2*f);
               }
               else
               {
                   ArrayList<Long> sor=new ArrayList<Long>(h);
                   Collections.sort(sor);
                   long hi=sor.get(0);
                   long sh=sor.get(1);
                   long temp1=0,temp2=0;
                   for(long f:h)
                   {
                     if(f!=hi)
                      a.add(f);
                   }
                   temp1=sumGCD(a)+hi;
                   for(long f:h)
                   {
                    if(f!=sh)
                      a.add(f);
                   }
                   temp2=sumGCD(a)+sh;
                   System.out.println(Math.max(temp1,temp2));
               }
        }
    }
  }