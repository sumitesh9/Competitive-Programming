import java.util.*;
import java.io.*;
public class ModuloEquality {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int n = f.nextInt();
        int m = f.nextInt();
        long a[] = new long[n];
        long b[] = new long[n];
        HashSet<Long> h = new HashSet<Long>();
        for(int i = 0; i < n ;i++) {
            a[i] = f.nextLong();
        }
        for(int i = 0; i < n; i++) {
            b[i] = f.nextLong();
        }
        for(int i = 0 ; i < n ;i++) {
            h.add((((b[0] - a[i]) % m) + m) % m) ;
        }
        long res = 999999999;
        Arrays.sort(b);
        int flag = 0;
        for(Long i : h) {
            long copy[] = a.clone();
            for(int j = 0; j < n; j++) {
                copy[j] = (copy[j] + i) % m;
            }
            Arrays.sort(copy);
            for(int j = 0 ; j < n ; j++) {
                if(copy[j] != b[j]) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0 && i < res)
                res = i;
            flag = 0;
        }
        pn(res);
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    // Fast Scanner Alternative of Scanner 
    // Uses Implementation of BufferedReader Class
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
 
    //GCD of two integers
    static int gcd(int a, int b) {
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
    
    // Return boolean sieve of first n prime nos.
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
 
    // Return HashSet of factors of a number
    static HashSet<Long> factors(long n) {
        HashSet<Long> hs = new HashSet<Long>();
        for(long i = 1; i <= (long)Math.sqrt(n); i++) {
            if(n % i == 0) {
                hs.add(i);
                hs.add(n / i);
            }
        }
        return hs;
    }
 
    //Is n prime ?
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