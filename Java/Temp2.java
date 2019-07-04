import java.math.BigInteger;
import java.util.Arrays;
class Temp2
{
  static void nos(int n)
  {
         int size=n/4;           //size of array
         BigInteger dp[]=new BigInteger[size+1];
         Arrays.fill(dp,BigInteger.valueOf(0));
         long mod=((long)Math.pow(10,9))+7;
         BigInteger modb=new BigInteger(String.valueOf(mod));
         BigInteger tfour=new BigInteger("24");
         BigInteger nb=new BigInteger(String.valueOf(n));
         BigInteger nb1=new BigInteger(String.valueOf(n-1));
         BigInteger nb2=new BigInteger(String.valueOf(n-2));
         BigInteger nb3=new BigInteger(String.valueOf(n-3));
         BigInteger tot;
         BigInteger total_comb;
         BigInteger valid_comb;
         tot=(((nb.multiply(nb1)).multiply(nb2)).multiply(nb3)).divide(tfour);
         for(int i=size;i>=2;i--)     // Remove GCD of i'th element
         {
                 BigInteger bi=new BigInteger(String.valueOf(i));
                 BigInteger tcb;
                 tcb=nb.divide(bi);
                 BigInteger tcb1,tcb2,tcb3;
                 tcb1=tcb.subtract(BigInteger.valueOf(1));
                 tcb2=tcb.subtract(BigInteger.valueOf(2));
                 tcb3=tcb.subtract(BigInteger.valueOf(3));
                 valid_comb=(((tcb.multiply(tcb1)).multiply(tcb2)).multiply(tcb3)).divide(tfour);
                 dp[i]=valid_comb;
         }
        //for(int i=0;i<size+1;i++)
        //System.out.print(dp[i]+" ");
        BigInteger sum=new BigInteger("0");
        for(int i=size/2;i>=2;i--)
        {
          BigInteger temp=new BigInteger("0");
          for(int j=2*i;j<=size;j+=i)
          {
            temp=temp.add(dp[j]);
            }
            dp[i]=dp[i].subtract(temp);
        }
         for(int i=0;i<size+1;i++)
          {
            BigInteger bi=new BigInteger(String.valueOf(i));
            BigInteger pres;
            pres=bi.pow(4);
            sum=sum.add(dp[i].multiply(pres));
          }
          BigInteger su=new BigInteger("0");
          for(int i=0;i<size+1;i++)
          {
            su=su.add(dp[i]);
          }
          System.out.println(((tot.subtract(su)).add(sum)).mod(modb));
    }
  public static void main(String[]args)
  {
         nos(100000);
         nos(99999);
         nos(98997);
         nos(89778);
         nos(78866);
         nos(23432);
         nos(23412);
         nos(43434);
  }
}