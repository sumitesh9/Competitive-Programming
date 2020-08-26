import java.util.*;
import java.io.*;
public class MikeAndFraud {
    static long mod = (long) Math.pow(10, 9) + 7;
    static int MAX = 200002;    
    static long seg_tree[] = new long[4 * MAX]; 
    static void build(int node, int s, int e, int arr[], int k) 
    { 
        if (s == e) 
        { 
            seg_tree[node] = (1L * arr[s]) % k; 
            return; 
        } 
        int mid = (s + e) >> 1; 
        build(2 * node, s, mid, arr, k); 
        build(2 * node + 1, mid + 1, e, arr, k); 
        seg_tree[node] = (seg_tree[2 * node] * seg_tree[2 * node + 1]) % k; 
    }

    static long query(int node, int s, int e, int l, int r, int k) 
    { 
        if (s > e || s > r || e < l)  
        { 
            return 1; 
        } 
        if (s >= l && e <= r)  
        { 
            return seg_tree[node] % k; 
        } 
        int mid = (s + e) >> 1; 
        long q1 = query(2 * node, s, mid, l, r, k); 
        long q2 = query(2 * node + 1, mid + 1, e, l, r, k); 
        return (q1 * q2) % k; 
    }

    static long countSub(int arr[], int n, int k) 
    { 
        long ans = 0; 
        for (int i = 0; i < n; i++)  
        { 
            int low = i , high = n - 1;
            while(low <= high) {
                int mid = (low + high) >> 1;
                if(query(1 , 0 , n - 1 , i , mid , k) == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            ans += n - low;
        } 
        return ans; 
    } 
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int n = f.nextInt();
        int k = f.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = f.nextInt();
        }
        build(1, 0, n - 1, arr, k);
        System.out.println(countSub(arr, n, k));
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