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
class ArrayModification {

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
			cases = Integer.parseInt(br.readLine());
			/*
			 * Logic of the program must be separated from the meta code to
			 * increase readability and help debugging easier
			 * Also note that Solver object is created inside for loop to
			 * avoid multiple object creation that drastically increases 
			 * execution time and memory usage
			 */
			Solver solver = new Solver();
			int n;
			long k;
			for (int i = 0; i < cases; i++) {				
			String nk[] = br.readLine().split(" ");
			n = Integer.parseInt(nk[0]);
			k = Long.parseLong(nk[1]);
			long ar[] = new long[n];
			String x[] = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				ar[j] = Long.parseLong(x[j]);
			}
			solver.solve(n, k ,ar);
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
class Solver extends ArrayModification {

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int n , long k, long arr[]) {
	  int q = 0;
	  if(k >= (3 * n))
	  {
	  	if(k >= (n + 1) / 2)
	  		q++;
	  	k = k % (3 * n);
	  	for(int i = 0; i < k; i++) {
	  		arr[i % n] = arr[i % n] ^ arr[n - i%n - 1];
	  	}
	  	if(q == 1 && n % 2 == 1) 
	  		arr[(n - 1) / 2] = 0;
	  }
	  else {
	  	for(int i = 0; i < k; i++)
	  		arr[i % n] = arr[i % n] ^ arr[n - i % n -1];
	  }
	  for(int i = 0; i < n; i++) {
	  	System.out.print(arr[i] + " ");
	  }
	  System.out.println();
}
}