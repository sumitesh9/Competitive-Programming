import java.util.Arrays;
class Temp
{
  static long nc4(long n)
  {
    long mod=(long)Math.pow(10,9)+7;
    long x1=((n%mod)*((n-1)%mod))%mod;
    long x2=(((n-2)%mod)*((n-3)%mod))%mod;
    long x3=(((x1%mod)*(x2%mod))%mod)/24;
    return x3;
  }
  static void nos(long n)
  {
         int size=((int)n)/4;           //size of array
         long dp[]=new long[size+1];
         long mod=(long)Math.pow(10,9)+7;
         Arrays.fill(dp,0);
         long tot=((n*(n-1))/24)*(n-2)*(n-3);
         for(int i=size;i>=2;i--)     // Remove GCD of i'th element
         {
                 long total_comb=n/i;
                 long valid_comb=((total_comb)*(total_comb-1)/24)*((total_comb-2)*(total_comb-3));
                 dp[i]=valid_comb;
         }
        //for(int i=0;i<size+1;i++)
        //System.out.print(dp[i]+" ");
        long sum=0;
        for(int i=size/2;i>=2;i--)
        {
          long temp=0;
          for(int j=2*i;j<=size;j+=i)
          {
            temp+=dp[j];
            }
            dp[i]=dp[i]-temp;
        }
         for(int i=0;i<size+1;i++)
          {
            sum+=dp[i]*(long)(Math.pow(i,4));
          }
          long su=0;
          for(int i=0;i<size+1;i++)
          {
            su+=dp[i];
          }
          System.out.println((tot-su+sum)%mod);
    }
  public static void main(String[]args)
  {
         nos(99999);
         nos(10019);
         nos(10029);
         nos(10039);
         nos(10049);
  }
}