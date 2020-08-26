import java.util.*;
import java.io.*;
public class Frog1 {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    public static long solve(int h[] , int n) {
        long dp[] = new long[n];
        for(int i = 0; i < n; i++) {
            if(i == 0)
                dp[i] = 0;
            else if(i == 1)
                dp[i] = Math.abs(h[i] - h[i - 1]);
            else
                dp[i] = Math.min(dp[i - 1] + Math.abs(h[i] - h[i - 1]) , dp[i - 2] + Math.abs(h[i] - h[i - 2]));
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int n = f.nextInt();
        int h[] = inpint(n);
        pn(solve(h , n));
        
    }
/******************************END OF MAIN PROGRAM*******************************************/
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
        	return Long.parseLong(next());
        }
        double nextDouble() {
        	return Double.parseDouble(next());
        }
    }


    // Print in console
    static void pn(Object o){System.out.println(o);}
    static void p(Object o){System.out.print(o);}
    static void pni(Object o){System.out.println(o);System.out.flush();}

      // Input int array
    static int[] inpint(int n) {
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = f.nextInt();
        return arr;
    }


    //GCD of two integers
    int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    // GCD of a array of integers
    int gcdarray(int a[]) {
        int res = a[0];
        for(int i = 1; i < a.length; i++) {
            res = gcd(a[i] , res);
        }
        return res;
    }

    // Is Prime no.?
    boolean isPrime(int n) {
        if(n == 1) return false;
        int i = 2;
        while((i * i) <= n) {
            if(n % i == 0) return false;
            i += 1;
        }
        return true;
    }   
}