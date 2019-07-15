/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
class MaximumAndMinimum {

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
			    int n=Integer.parseInt(br.readLine());
			    String s=br.readLine();		
				solver.solve(n,s);
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
class Solver extends MaximumAndMinimum{
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int n,String input) {		
               BigInteger arr[]=new BigInteger[n];
               BigInteger kb=new BigInteger(String.valueOf(input));
               BigInteger nb=new BigInteger(String.valueOf(n));
               BigInteger one=new BigInteger("1");
               BigInteger zero=new BigInteger("0");
               BigInteger two=new BigInteger("2");
               if((kb.mod(nb)).compareTo(zero)==0)
               	  System.out.println("0");
               else
               {
               	BigInteger count2=new BigInteger("0");
               	count2=kb.mod(nb);
               	BigInteger count1=new BigInteger("0");
               	count1=nb.subtract(count2);
               	BigInteger d=new BigInteger("0");
               	d=(count1.subtract(count2)).abs();
               	BigInteger min=new BigInteger("0");
               	if(count1.compareTo(count2)==1)
               		min=count2;
               	else
               		min=count1;
               	if(d.compareTo(zero)==0)
               	     {
               	     	BigInteger res=new BigInteger("0");
               	     	res=(two.multiply(min)).subtract(one);
               	     	System.out.println(res);
               	     }
               	else
               	{
               		System.out.println((two.multiply(min)));
               	}
               }
           }
       }