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
class ChefAndMaximumStarValue {

	/*
	 * In a Programming contest, you are expected to print the output at the
	 * end, so `output` variable will hold all the processed results till the
	 * end
	 */

	// Program's starting point
	public static void main(String[] args)throws IOException {

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
		final int cases = Integer.parseInt(br.readLine());
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
				String x[] = br.readLine().split(" ");
				int arr[] = new int[n];
				for(int j = 0; j < n; j++) {
					arr[j] = Integer.parseInt(x[j]);
				}
				solver.solve(n,arr);
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
class Solver extends ChefAndMaximumStarValue {
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public static HashSet<Integer> factors(int n) {
		HashSet<Integer> f = new HashSet<Integer>();
		for(int i = 1; i <= (int)Math.sqrt(n); i++) 
        { 
        if (n % i == 0) 
        {  
            if(n/i == i) 
                f.add(i); 
  
            else
                f.add(i);
                f.add(n / i); 
        }
        }
        return f; 
	}
	public void solve(int n, int arr[]) {
		HashMap<Integer, Integer> ar = new HashMap<Integer, Integer>();
		HashSet<Integer> fact = new HashSet<Integer>();
		fact = factors(arr[0]);
		for(Integer x:fact) {
			if(ar.containsKey(x))
				ar.put(x, ar.get(x) + 1);
			else
				ar.put(x, 1);
		}
		int res = 0;
		for(int i = 1; i < n; i++) {
			int temp = 0;
			fact = factors(arr[i]);
			//Update temp by value of corresponding key in HashMap
			//Update value of corresponding factors
			if(ar.containsKey(arr[i])) {
				temp += ar.get(arr[i]);
			}
			for(Integer x : fact) {
				if(ar.containsKey(x))
					ar.put(x, ar.get(x) + 1);
				else
					ar.put(x, 1);
			}
			System.out.println(ar);
			if(temp > res)
				res = temp;
		}
		System.out.println(res);
	}
}