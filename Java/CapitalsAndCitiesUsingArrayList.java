import java.util.*;
class CapitalsAndCitiesUsingArrayList
{
      public static void main(String[]args)
      {
      	Scanner S=new Scanner(System.in);
      	int n=S.nextInt();
      	long k=S.nextLong();
        ArrayList<Long> ar=new ArrayList<Long>();
        ArrayList<Long> pr=new ArrayList<Long>(); //Duplicate array
        long sum=0;

        //Input
        for(int i=0;i<n;i++)
        {
        	long temp=S.nextLong();
            ar.add(temp);
        	pr.add(temp);
        }
        Collections.sort(ar);
        long ele=0,mid1,mid2;
        int ind=0;

        //Find middle element in sorted array
        if(n%2==1)
        {
        	ele=ar.get(n/2);
        }
        else
        {
        	mid1=ar.get(n/2);
        	mid2=ar.get((n/2)-1);
        	for(int i=0;i<n;i++)
        	{
        		if(pr.get(i)==mid1||pr.get(i)==mid2)
        		{
        			if(pr.get(i)==mid1)
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
        		if(pr.get(i)==ele)
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
        	sum+=(long)Math.abs(pr.get(i)-pr.get(ind));
        }
        if(sum-k>=0)
            System.out.println(sum-k);
        else
        {
            if(k%2==0)
                System.out.println(0);
            else
                System.out.println(1);
        	
        }
    }
}