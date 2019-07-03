import java.util.*;
class HelpAshwin
{
	public static void main(String[] args)
	{
		Scanner S=new Scanner(System.in);
		int t=S.nextInt();
		while(t-->0)
		{
			int n=S.nextInt();
			int m=S.nextInt();
			int ar[][]=new int[n][m];
			int dp[]=new int[n];
			//Input
			int max=ar[0][0];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
				ar[i][j]=S.nextInt();
			    }
			}


		}
	}
}
	
