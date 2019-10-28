import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class GCDProblem {

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
				solver.solve(Integer.parseInt(br.readLine()));
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
class Solver extends GCDProblem {
	/*
	 * Logic goes here ...s
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public void solve(int n) {	
         int size=n/4;           //size of array
         BigInteger dp[]=new BigInteger[size+1];
         Arrays.fill(dp,BigInteger.valueOf(0));
         long mod=((long)Math.pow(10,9))+7;
         BigInteger modb=new BigInteger(String.valueOf(mod));
         BigInteger tfour=new BigInteger("24");
         BigInteger nb=new BigInteger(String.valueOf(n));
         BigInteger nb1=new BigInteger(String.valueOf(n-1));
         BigInteger nb2=new BigInteger(String.valueOf(n-2));
         BigInteger nb3=new BigInteger(String.valueOf(n-3));
         BigInteger tot;
         BigInteger total_comb;
         BigInteger valid_comb;
         tot=(((nb.multiply(nb1)).multiply(nb2)).multiply(nb3)).divide(tfour);
         for(int i=size;i>=2;i--)     // Remove GCD of i'th element
         {
                 BigInteger bi=new BigInteger(String.valueOf(i));
                 BigInteger tcb;
                 tcb=nb.divide(bi);
                 BigInteger tcb1,tcb2,tcb3;
                 tcb1=tcb.subtract(BigInteger.valueOf(1));
                 tcb2=tcb.subtract(BigInteger.valueOf(2));
                 tcb3=tcb.subtract(BigInteger.valueOf(3));
                 valid_comb=(((tcb.multiply(tcb1)).multiply(tcb2)).multiply(tcb3)).divide(tfour);
                 dp[i]=valid_comb;
         }
        //for(int i=0;i<size+1;i++)
        //System.out.print(dp[i]+" ");
        BigInteger sum=new BigInteger("0");
        for(int i=size/2;i>=2;i--)
        {
          BigInteger temp=new BigInteger("0");
          for(int j=2*i;j<=size;j+=i)
          {
            temp=temp.add(dp[j]);
            }
            dp[i]=dp[i].subtract(temp);
        }
         for(int i=0;i<size+1;i++)
          {
            BigInteger bi=new BigInteger(String.valueOf(i));
            BigInteger pres;
            pres=bi.pow(4);
            sum=sum.add(dp[i].multiply(pres));
          }
          BigInteger su=new BigInteger("0");
          for(int i=0;i<size+1;i++)
          {
            su=su.add(dp[i]);
          }
          System.out.println(((tot.subtract(su)).add(sum)).mod(modb));
}
}