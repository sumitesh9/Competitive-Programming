
/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class RoadSigns {

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
class Solver extends RoadSigns{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
    static long MOD = (long) (1e9 + 7);
    static long power(long x, long n)  
    { 
        long res = 1; 
        while(n>0)  
        { 
            if(n%2==1)  
            { 
                res=res*x%MOD; 
            } 
            n=n/2; 
            x=x*x%MOD; 
        } 
        return res; 
    } 
	static long powerStrings(String sa, String sb)  
    { 
        long a=0,b=0; 
        for(int i=0;i<sa.length();i++)  
        { 
            a=(a*10+(sa.charAt(i)-'0'))%MOD;                                
        }   
        for(int i=0;i<sb.length();i++)  
        { 
            b=(b*10+(sb.charAt(i)-'0'))%(MOD-1);
        }  
        return power(a,b); 
    }
	public void solve(long num) {
		 System.out.println((10*(powerStrings("2",String.valueOf(num-1))))%(1000000007)); 
}
}