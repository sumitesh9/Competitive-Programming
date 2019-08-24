/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;
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
class  Pair {
	long  first;
	long second;
	int third;
	Pair() {
		first = 0;
		second = 0;
		third = 0;
	}
}

class GM {
	/*
	 * Logic goes here ...
	 * Add to the global variables after processing the input
	 * Maybe reverse a string or parse to an integer or , etc.
	 */
	public static void main(String[] args)throws IOException {
		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        int cases = Integer.parseInt(br.readLine());
		        while(cases --> 0) {
		        int n = Integer.parseInt(br.readLine());
		        int arr[] = new int[n];
		        String x[] = br.readLine().split(" ");
		        for(int i = 0;i < n;i++)
		        {
                     arr[i] = Integer.parseInt(x[i]);
		        }
		        int temp = (int)Math.pow(2,20);
	            Pair hm[] = new Pair[temp];
	            for(int i = 0; i < temp; i++) {
	            	hm[i] = new Pair();
	            }	
                long ans;
                //int xorSum = 0;
                int prefix[] = new int[n];
                prefix[0] = arr[0];
                ans = 0;
                hm[0].first = 1;
                hm[0].second = 0;
                hm[0].third = -1;
                hm[prefix[0]].first= 1;
                		hm[prefix[0]].second = 0;
                		hm[prefix[0]].third = 0;
                	
                for (int i = 1; i < n; i++) {
                      prefix[i] = arr[i] ^ prefix[i-1];
                }
                
                //int currentIndex = 1, ls = 0;
                for(int i = 1; i<n; i++) {
                	if (hm[prefix[i]].first==0){
                		hm[prefix[i]].first= 1;
                		hm[prefix[i]].second = 0;
                		hm[prefix[i]].third= i;
                	}
                	else if (hm[prefix[i]].first >= 1) {

                		hm[prefix[i]].second = hm[prefix[i]].second + (hm[prefix[i]].first - 1)*((long)i- hm[prefix[i]].third ) + (long)i - hm[prefix[i]].third -1;
                		hm[prefix[i]].first++;
                		ans += (long)hm[prefix[i]].second;
                		hm[prefix[i]].third = i; 
                	}
                    else {}
                }
                System.out.println(ans);
            }
	}
}