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
public class CircleMetro {

	/*
	 * In a Programming contest, you are expected to print the output at the
	 * end, so `output` variable will hold all the processed results till the
	 * end
	 */
	public static String output = "";

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
				solver.solve(br.readLine());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Print the final output
		System.out.println(output);
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
class Solver extends CircleMetro {

	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */	
	public void solve(String input) {					
		int n,a,x,b,y;
		String s[]=input.split(" ");
		n=Integer.parseInt(s[0]);
		a=Integer.parseInt(s[1]);
		x=Integer.parseInt(s[2]);
		b=Integer.parseInt(s[3]);
		y=Integer.parseInt(s[4]);
        int step1,step2;
        if(x>a)
        	step1=x-a+1;
        else
        	step1=n-a+x+1;
        if(y<b)
            step2=b-y+1;
        else
            step2=b+n-y+1;
        int i=0;
        int pos[]=new int[2];
        pos[0]=a;
        pos[1]=b;
        int flag=0;
        while(i<Math.min(step1,step2))
        {
             if(pos[0]==pos[1])
             {
             	CircleMetro.output="YES";
             	flag=1;
             	break;
             }
             else
             {
             	if(pos[0]<n)
             		pos[0]++;
             	else
             		pos[0]=1;
             	if(pos[1]>1)
             		pos[1]--;
             	else
             		pos[1]=n;
             }
             i++;
        }
        if(flag==0)
        CircleMetro.output="NO"; 
	}
}