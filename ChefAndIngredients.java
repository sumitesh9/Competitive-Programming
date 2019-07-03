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
class ChefAndIngredients {

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
				solver.solve(br.readLine());
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
class Solver extends ChefAndIngredients{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(String input) {		
               String s[]=input.split(" ");
               long n=Long.parseLong(s[0]);
               long k=Long.parseLong(s[1]);
               long mod=(long)(Math.pow(10,9)+7);
               if(k<=n)
               	System.out.println((k-1)%mod);
               else
               {
               	long count=(k-1)%mod;
                if(n==2)
                	System.out.println((((k%mod)*((k-1)%mod))/2)%mod);
                else
                {
                	BigInteger two=new BigInteger("2");
                	BigInteger one=new BigInteger("1");
                	BigInteger bmod=new BigInteger("1000000007");
                	BigInteger bk,bn,bno,bsum;
                	bk=BigInteger.valueOf(k);
                	bn=BigInteger.valueOf(n);
                	bno=((bk.subtract(bn)).divide((bn.subtract(one)))).add(one);
                	BigInteger z,x,c,res;
                	z=two.multiply(bk.subtract(bn));
                	x=(bno.subtract(one)).multiply(bn.subtract(one));
                    c=((z.subtract(x)).multiply(bno)).divide(two);
                    res=(c.add(bk.subtract(one))).mod(bmod);
                    System.out.println(res);
                }
               }
	}
}