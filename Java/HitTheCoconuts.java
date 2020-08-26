/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
class HitTheCoconuts {

	/*
	 * In a Programming contest, you are expected to print the output at the
	 * end, so `output` variable will hold all the processed results till the
	 * end
	 */

	// Program's starting point
	public static void main(String[] args) {

		/*
		 * A Scanner class slows down Input/Output a LOT ,thereby increasing
		 * your code execution time , Hence for best results that is Fast I/O
		 * try to use BufferedReader
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * Generally Code Chef, Hacker Rank gives X number of test cases so we
		 * process the input for each.
		 */
		final int cases;
		try {
			/*
			 * Logic of the program must be separated from the meta code to
			 * increase readability and help debugging easier
			 * Also note that Solver object is created inside for loop to
			 * avoid multiple object creation that drastically increases 
			 * execution time and memory usage
			 */
			cases=Integer.parseInt(br.readLine());
			Solver solver = new Solver();
			for (int i = 0; i < cases; i++) {	
			    String nz[]=br.readLine().split(" ");
			    int n=Integer.parseInt(nz[0]);
			    int z=Integer.parseInt(nz[1]);
			    long arr[]=new long[n];
			    String temp[]=br.readLine().split(" ");
			    for(int j=0;j<n;j++)
			    {
			    	arr[j]=Long.parseLong(temp[j]);
			    }			
				solver.solve(n,z,arr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*
 * Some basic rules while coding in Programming Contests:
 * Try to follow at least 80% of them
	Correctness
		- final declaration for required data types
		- avoid Object creation 
		- Scanner slows down, use InputReader
		- avoid too many static functions	
	Efficiency
		- use library functions as much as possible		
		- assertEquals("RESULT", functionToCall())
	Debugging-ability
		- avoid too many global variables 
		- Separate logic from meta-processing
		- variable/function pneumonics must make sense
 * 
 */
class Solver extends HitTheCoconuts{
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	static long cal(long arr[],boolean avail[],int ind)
	{
		int point=arr.length-ind;
		if(ind!=arr.length-1)
		{
			if(arr[ind]==arr[ind+1])
				point--;
			if(avail[ind+1]==false)
				point=1;
		}
		long sum=0;
		int current=1;
		for(int j=arr.length-1;j>=0;j--)
		{ 
			if(j==ind)
			{
            sum+=(arr[j]*point);
            current=0;
            }
            else
            	if(avail[j]==true)
            	current++;
                else
                {
                	sum+=(arr[j]*current);
                	current=1;
                }
		}
		return sum;
	}
	static boolean[] solveforz(long arr[],boolean avail[])
	{
		   long min=Long.MAX_VALUE;
		   int ind=arr.length-1;
           for(int i=arr.length-1;i>=0;i--)
           {
                if(avail[i]==true)
                {
                      if(cal(arr,avail,i)<min)
                      {
                      	min=cal(arr,avail,i);
                      	ind=i;
                      }
                }
           }
           avail[ind]=false;
           return avail;
	}
	public void solve(int n,int z,long arr[]) {	
	         Arrays.sort(arr);
	         boolean avail[]=new boolean[n];
	         Arrays.fill(avail,true);
	         for(int i=0;i<z;i++)
	         {
                avail=solveforz(arr,avail);
	         }
	         int point=1;
	         long sum=0;
	         for(int i=0;i<n;i++)
	         {
	         	System.out.print(avail[i]+" ");
	         }
	         System.out.println();
	         for(int i=n-1;i>=0;i--)
	         {
                 if(avail[i]==true)
                 {
                        point++;
                 }
                 else
                 {
                 	sum+=arr[i]*point;
                 	point=1;
                 }
	         }
	         System.out.println(sum);
	}
}