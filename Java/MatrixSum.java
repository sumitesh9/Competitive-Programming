import java.util.*;
class MatrixSum
{
	public static void main(String[]args)
	{
		Scanner S=new Scanner(System.in);
		int n,m;
		n=S.nextInt();
		m=S.nextInt();
		int ar[][]=new int[n][m];
		//Input
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				ar[i][j]=S.nextInt();
			}
		}
		long dp[][]=new long[n][m];

		//Using DP:
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(i==0&&j==0)
					dp[i][j]=ar[i][j];
				else
				{
					if(i==0)
                        dp[i][j]=ar[i][j]+dp[i][j-1];
                    else if(j==0)
                    	dp[i][j]=ar[i][j]+dp[i-1][j];
                    else
                        dp[i][j]=ar[i][j]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]; 
				}
			}
		}
        //Print dp
        /*for(int i=0;i<n;i++)
        {
        	for(int j=0;j<m;j++)
        	{
        		System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
        */
        //Print res
        int q=S.nextInt();
        while(q-->0)
        {
        	int x,y;
        	x=S.nextInt();
        	y=S.nextInt();
        	System.out.println(dp[x-1][y-1]);
        }
	}
}