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
public class TrystWithChess {

	/*
	 * In a Programming contest, you are expected to print the output at the
	 * end, so `output` variable will hold all the processed results till the
	 * end
	 */

	// Program's starting point
	static int chess[][] = new int[10][10];
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
		final int cases = 1;
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
				String ijn[]=br.readLine().split(" ");	
				for (int r = 0; r < 10; r++)
				{
				for(int c = 0; c < 10; c++)
				      chess[r][c] = 0;
				}
				int r = Integer.parseInt(ijn[0]);
				int c = Integer.parseInt(ijn[1]);
				int n = Integer.parseInt(ijn[2]);
				System.out.println(solver.solve(r - 1, c - 1, n + 1));
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
class Solver extends TrystWithChess {
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public int solve(int i, int j, int n) {		
            int count = 0;
            if(i < 0 || i > 9 || j < 0 || j > 9)
            	return 0;
            if(n == 0)
                return 0;
            if(chess[i][j] == 1 && n == 1)
                return 0;
            if(n == 1) {
                count = 1;
                chess[i][j] = 1;
            }
        return count+ solve(i-2,j-1,n-1) + solve(i-2,j+1,n-1) + solve(i-1,j-2,n-1) + solve(i-1,j+2,n-1) + solve(i+2,j-1,n-1) + solve(i+2,j+1,n-1) + solve(i+1,j-2,n-1) + solve(i+1,j+2,n-1);
    }
}