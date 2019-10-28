import java.util.*;
import java.io.*;
public class FootBallSeason {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        long n = f.nextLong();
        long p = f.nextLong();
        long w = f.nextLong();
        long d = f.nextLong();
        long g = gcd(w, d);
        long y, k;
        int flag = 0;
        if(p % g == 0) {
            p = p / g;
            w = w / g;
            d = d / g;
            for(long x = 0; x < d; x++) {
                if((p - (x * w)) % d == 0) {
                    y = (p - (x * w)) / d;
                    if(y < 0)
                        break;
                    k = y / w;
                    y = y - (k * w);
                    x = x + k * d;
                    if((x + y) <= n) {
                        System.out.println(x + " " + y + " " + (n - (x + y)));
                        flag = 1;
                    }
                }
            }
        }
        if(flag == 0)
            System.out.println(-1);
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
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    // GCD of a array of integers
    static int gcdarray(int a[]) {
        int res = a[0];
        for(int i = 1; i < a.length; i++) {
            res = gcd(a[i] , res);
        }
        return res;
    }
    
    static boolean[] sieve(int n) {
        boolean isprime[] = new boolean[n + 1];
        for(int i = 0; i <= n;++i) {
            isprime[i] = true;
        }
        isprime[0] = false;
        isprime[1] = false;
        for(int i = 2; i * i <= n; ++i) {
             if(isprime[i] == true) {               
                 for(int j = i * i; j <= n;j += i)
                     isprime[j] = false;
            }
        }
        return isprime;
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;
        int i = 2;
        while((i * i) <= n) {
            if(n % i == 0) return false;
            i += 1;
        }
        return true;
    }
}