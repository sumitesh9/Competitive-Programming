/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class GuessThePrime {

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
		int flag=0;
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
			    if(flag==0)			
				solver.solve();
			    else
			    	break;
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
public class Solver extends GuessThePrime{
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	GuessThePrime obj=new GuessThePrime();
	static HashSet primefactors(long n)
	{
		HashSet<Long> hs=new HashSet<Long>();
		long two=2;
		 while(n%2==0)
		 { 
             hs.add(two); 
             n=n/2;
         }
         for(int i=3;i<=(int)Math.sqrt(n)+1;i+=2)
         {
             while(n%i==0)
             {
                 hs.add((long)i);
                  n=n/i;
              }
         }
         if(n>2) 
         hs.add(n);
             return hs;
	}
	public void solve()throws IOException {		
             System.out.println(1+" "+31623);
             long res=Long.parseLong(br.readLine());
             long temp=(1000014129-res);
             long ans=0;
             HashSet<Long> res1=new HashSet<Long>();
             res1=primefactors(temp);
             for(long x:res1)
             {
                  ans=x;
                  break;
             }
             System.out.println(2+" "+ans);
             String check=br.readLine();
             if(check.equals("No"))
             	GuessThePrime.flag=1;
	}
}