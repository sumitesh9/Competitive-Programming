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
public class ChefJudgesACompetition {

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
				solver.solve(Integer.parseInt(br.readLine()),br.readLine(),br.readLine());
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
class Solver extends ChefJudgesACompetition{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int l,String input1,String input2) {		
               String s1[]=input1.split(" ");
               String s2[]=input2.split(" ");

               long l1[]=new long[l];
               long l2[]=new long[l];
               for(int i=0;i<l;i++)
               {
                    l1[i]=Long.parseLong(s1[i]);
                    l2[i]=Long.parseLong(s2[i]);
               }
               Arrays.sort(l1);
               Arrays.sort(l2);
               long sum1=0;
               long sum2=0;
               for(int i=0;i<l-1;i++)
               {
               	sum1+=l1[i];
               	sum2+=l2[i];
               }
               if(sum1<sum2)
               	System.out.println("Alice");
               else if(sum1==sum2)
               	System.out.println("Draw");
               else
               	System.out.println("Bob");
	}
}