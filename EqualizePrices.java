/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class EqualizePrices{

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
			    String nk[]=br.readLine().split(" ");
			    int n=Integer.parseInt(nk[0]);
			    int k=Integer.parseInt(nk[1]);
			    String cost[]=br.readLine().split(" ");
                int arr[]=new int[n];
                for(int j=0;j<n;j++)
                {
                	arr[j]=Integer.parseInt(cost[j]);
                }
				solver.solve(n,k,arr);
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
class Solver extends EqualizePrices{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int n,int k,int arr[]) {		
               Arrays.sort(arr);
               int min=arr[0];
               int max=arr[n-1];
               int res=(min+k);
               int flag=0;
               //Check for res;
               for(int i=1;i<n;i++)
               {
               	    if(Math.abs(arr[i]-res)>k)
               	    {
               	    	System.out.println("-1");
               	    	flag=1;
               	    	break;
               	    }
               }
               if(flag==0)
               	System.out.println(res);
	}
}