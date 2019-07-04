/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class LuckyDivision {
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
				solver.solve(Integer.parseInt(br.readLine()));
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
class Solver extends LuckyDivision{
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	static boolean isLucky(int x)
	{
		//Is x lucky?
		    String str=String.valueOf(x);
		    boolean isLucky=true;
		    for(int i=0;i<str.length();i++)
		    {
		      	if(str.charAt(i)!='4'&&str.charAt(i)!='7')
                         isLucky=false;
		    }
		    if(isLucky)
		      return true;
		    return false;
	}
	public void solve(int x) {		
		      int flag=0;
		      if(isLucky(x))
		      	System.out.println("YES");
		      else
		      {
		      	for(int i=1;i<x;i++)
		      	{
                         if(isLucky(i))
                         {
                         	if(x%i==0)
                         	{
                         		System.out.println("YES");
                         		flag=1;
                         		break;
                         	}
                         }
		      	}
		      	if(flag==0)
		      		System.out.println("NO");
		    }
	}
}