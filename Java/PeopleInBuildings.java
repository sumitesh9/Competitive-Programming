import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class PeopleInBuildings {

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
				int n = Integer.parseInt(br.readLine());
				int g = Integer.parseInt(br.readLine());
				for (int j = 0; j < n ;j++) {
					String x = br.readLine();
			}
			solver.solve(n, g);
		}
	}
		 catch (IOException e) {
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
class Solver extends PeopleInBuildings{
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int n, int g) {		
               System.out.println(n / g);
               if(n / g == 1) {
               	System.out.println(n);
               	for(int i = 1;i <= g;i++) {
               		System.out.print(i + " ");
               	}
               	for(int i = n;i >=g + 1;i--) {
               		System.out.print(i + " ");
               	}
               }
               else {
               	     int c = 1;
               	     int ag = 0;
               	     for(int i = 1; i <= (n/g); i++) {
               	     	if(i != n/g) {
               	     	System.out.println(g);
               	     	ag += g;
               	     	for(int j = 0;j < g;j++){ System.out.print(c+" ");
               	     		c++; 
               	     	}
               	     	System.out.println();
               	     }
               	     	else {
                           System.out.println((n-ag));
                           for(int k = 0;k < g; k++) {
                           	System.out.print(c+" ");
                            c++;
                            ag+=g;
               	     	}
               	     	for(int k = n - ag;k <= n; k++) {
               	     		System.out.print(k);
               	     	}
               	     	System.out.println();
               	     }
               }
           }
	}
}