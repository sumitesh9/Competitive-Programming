import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class ExpectedChange {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    static Scanner S = new Scanner(System.in);
    // Brute force
    
    public static long simulate(String str) {
        StringBuffer sb = new StringBuffer(str);
        //pn(sb);
        int nc = 0 , no = 0;
        long count = 0;
        for(int p = 0; p < str.length(); p++) {
            if(sb.charAt(p) == '(')
                no++;
            else if(sb.charAt(p) == ')'){
                nc++;
                if(nc > no) {
                    sb.setCharAt(p, '(');
                    count++;
                    no++;
                    nc--;
                }
            }
            else {
            }
        }
        //str = sb.toString();
        return count;
    }



    public static long modularExponentiation(long x , long n) {
        long res=1;
        
        while(n > 0) {
            if(n % 2 == 1)
                res = (res * x) % mod;
            x = (x * x) % mod;
            n = n / 2;
        }
        return res;
    }

    public static long modInverse(long a) {
        return modularExponentiation(a , mod - 2);
    }



    public static long totalways(int n) {
        long ln = (long)n;
        long t = ((ln % mod) * ((ln - 1) % mod)) / 2;
        return t + ln;
    }

    public static void main(String[] args) {
        int t = f.nextInt();
        //String ty = "abcd";
        while(t --> 0) {
            int n = f.nextInt();
            String str = f.next();
            long tot = 0;
            
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j <= n; j++) {
                    long x = simulate(str.substring(i , j));
                    //pn(str.substring(i , j) + " " + x + " ");
                    tot += x;
                }
            }

            //pn(totalways(n));
            long r = modInverse(totalways(n)) % mod;
            long ans = ((tot % mod) * r) % mod;
            pn(ans);
        }
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
    // Input int array
    static int[] inpint(int n) {
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = f.nextInt();
        return arr;
    }

    //Input long array
    static long[] inplong(int n) {
        long arr[] = new long[n];
        for(int i = 0; i < n; i++) 
            arr[i] = f.nextLong();
        return arr;
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

    // Gives next (Lexicographical) permutation of String
    public static String nextPerm(String s) {
        StringBuffer sb = new StringBuffer(s);
        String ans = "No Successor";
        int ii = -1 , jj = -1;
        for(int i = 0; i < s.length() - 1; i++) {
            if((int)s.charAt(i) < (int)s.charAt(i + 1))
                ii = i;
        }
        for(int j = ii + 1; j < s.length() && j != 0; j++) {
            if((int)s.charAt(j) > (int)s.charAt(ii))
                jj = j;
        }
        if(ii == -1)
            return ans;
        else {
        char tempi = s.charAt(ii);
        char tempj = s.charAt(jj);
        sb.setCharAt(jj , tempi);
        sb.setCharAt(ii , tempj);
        StringBuffer sub = new StringBuffer(sb.substring(ii + 1));
        sub.reverse();
        int v = sub.length();
        while(v-- > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(sub);
        ans = sb.toString();
        return ans;
        }
    }
}