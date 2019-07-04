import java.util.*;
class CapitalsAndCities
{
      public static void main(String[]args)
      {
      	Scanner S=new Scanner(System.in);
      	int n=S.nextInt();
      	long k=S.nextLong();
        long ar[]=new long[n];
        long pr[]=new long[n]; //Duplicate array
        long sum=0;

        //Input
        for(int i=0;i<n;i++)
        {
        	ar[i]=S.nextLong();
        	pr[i]=ar[i];
        }
        Arrays.sort(ar);
        long ele=0;
        int ind=0;

        //Find middle element in sorted array
        if(n%2==1)
        {
        	ele=ar[n/2];
        }

        long mid1,mid2;
        else
        {
        	mid1=ar[n/2];
        	mid2=ar[(n/2)-1];
        	for(int i=0;i<n;i++)
        	{
        		if(pr[i]==mid1||pr[i]==mid2)
        		{
        			if(pr[i]==mid1)
        			{
        				ele=mid1;
        				ind=i;
        			}
        			else
        			{
        				ele=mid2;
        				ind=i;
        			}
        			break;
        		}
        	}
        }
        if(n%2==1)
        {
        	for(int i=0;i<n;i++)
        	{
        		if(pr[i]==ele)
        		{
        			ind=i;
        			break;
        		}
        	}
        }
        System.out.print((ind+1)+" ");

        //Distance Calculation
        for(int i=0;i<n;i++)
        {
        	sum+=(long)Math.abs(pr[i]-pr[ind]);
        }
        if(sum-k>=0)
            System.out.println(sum-k);
        else
        	
      }
}