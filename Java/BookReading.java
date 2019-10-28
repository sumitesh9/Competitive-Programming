import java.util.*;
import java.io.*;

public class BookReading {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int t = f.nextInt();
        while(t --> 0) {
            long n = f.nextLong();
            long m = f.nextLong();
            if(n < m) System.out.println(0);
            else {
                long x = n / (10 * m);
                long y = n % (10 * m);
                long sum = 0;
                for(int i = 0; i < 10; i++) {
                    sum += ((i + 1) * m) % 10;
                }
                sum *= x;
                long r = (x * 10 * m);
                for(long i = r + m; i <= n; i += m) {
                    sum += (i % 10);
                }
                System.out.println(sum);
            }
        }
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