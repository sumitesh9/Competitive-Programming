import java.util.*;
import java.io.*;

public class BadPrices {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int t = f.nextInt();
        while(t --> 0) {
            int n = f.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n; i++) {
                arr[i] = f.nextInt();
            }
            int m = arr[n - 1];
            int count = 0;
            for(int i = n - 2;i >= 0; i--) {
                if(arr[i] > m) count++;
                else
                    m = arr[i];
            }
            System.out.println(count);
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