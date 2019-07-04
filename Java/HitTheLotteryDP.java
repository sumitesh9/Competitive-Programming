/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class HitTheLotteryDP{

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
		final int cases=1;
		try {
			/*
			 * Logic of the program must be separated from the meta code to
			 * increase readability and help debugging easier
			 * Also note that Solver object is created inside for loop to
			 * avoid multiple object creation that drastically increases 
			 * execution time and memory usage
			 */
			Solver solver = new Solver();
			for (int i = 0; i < cases; i++) {	
				solver.solve(Long.parseLong(br.readLine()));
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
class Solver extends HitTheLotteryDP{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */

	public void solve(long n) {
        long dp[]=new long[5];
		Arrays.fill(dp,0);
	    while(n!=0)
	    {
	    if(n<5)
	    {
	        dp[0]+=n;
	        n=0;
	    }

        else if(n>=5&&n<10)
        {
        	dp[1]+=(n/5);
        	n%=5;
        }

        else if(n>=10&&n<20)
        {
        	dp[2]+=(n/10);
        	n%=10;
        }

        else if(n>=20&&n<100)
        {
        	dp[3]+=(n/20);
        	n%=20;
        }

        else
        {
        	dp[4]+=(n/100);
             n%=100;
        }
      }
		long sum=0;
		for(int i=0;i<5;i++)
			sum+=dp[i];
		System.out.println(sum);
	}
}