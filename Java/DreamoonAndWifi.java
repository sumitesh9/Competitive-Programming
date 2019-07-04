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
public class DreamoonAndWifi {

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
				solver.solve(br.readLine(),br.readLine());
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
class Solver extends DreamoonAndWifi{

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(String sent, String rec) {		
		     int c=0;
             if(!rec.contains("?"))
             {
             	int pr=0,ps=0;
             	for(int i=0;i<rec.length();i++)
             	{
                     if(sent.charAt(i)=='+')
                     	ps++;
                     if(rec.charAt(i)=='+')
                     	pr++;
             	}
             	if(pr==ps)
             		System.out.println("1.000000000");
             	else
             		System.out.println("0.000000000");
             }
             else
             {
             	int val_sent=0,val_rec=0;
             	for(int i=0;i<rec.length();i++)
             	{
                      if(sent.charAt(i)=='+')
                      	val_sent++;
                      else
                      	val_sent--;
                      if(rec.charAt(i)=='+')
                      	val_rec++;
                      if(rec.charAt(i)=='-')
                      	val_rec--;
                      if(rec.charAt(i)=='?')
                      	c++;
             	}
             	System.out.println(c);
                if(Math.abs(val_sent-val_rec)<=c)
                {
                        System.out.println((c*(c+1)/2)/(Math.pow(2,c)));
                }
                else
             	System.out.println("0.000000000");
	    }
    }
}