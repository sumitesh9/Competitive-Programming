import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class BobAndArrayQueries {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    static Scanner S = new Scanner(System.in);
    
    
    public static long[] build(long arr[] , int n) {
        long segtree[] = new long[2 * n];
        
        //Assign value to leaves of segment tree
        for(int i = 0 ; i < n ; i++) 
            segtree[n + i] = arr[i];
        
        //Assign value to internal node to compute minimum in a given range
        for(int i = n - 1; i >= 1; i--)
        {
            segtree[i] = (segtree[2 * i] + segtree[2 * i + 1]); 
        }
        return segtree;
    }
 
    public static void update(long segtree[] , int pos , int type , int n) {
        // pos follows 0 based indexing
        //Change the index to leaf node first
        pos += n;
 
        // Update value at leaf node at exact index
        if(type == 1)
            segtree[pos]++;
        else
            {
                if(segtree[pos] > 0)
                    segtree[pos]--;
            }
        while (pos > 1) { 
        // move up one level at a time in the tree 
        pos >>= 1; 
        // update the values in the nodes in 
        // the next higher level 
        segtree[pos] = (segtree[2 * pos] + segtree[2 * pos + 1]);
        }
    }
 
    public static long query(long segtree[] , int l , int r , int n) {
        if(l == r)
            return segtree[l + 1];
        //Change indices to leaf node
        l += n;
        r += n;
        long ans = 0;
        while(l < r) {
            if((l & 1) == 1)
            {
                ans = ans + segtree[l];
                l++;
            }
            if((r & 1) == 1) {
                r--;
                ans = ans + segtree[r];
            }
            l /= 2;
            r /= 2;
        }
        return ans;
    }
 
    public static void main(String[] args) {
        int n = f.nextInt();
        int q = f.nextInt();
        long arr[] = new long[n];
        Arrays.fill(arr , 0);
        long segtree[] = build(arr , n);
        while(q -- > 0) {
            int type = f.nextInt();
            int x , y = 0;
            x = f.nextInt();
            if(type == 3)
                y = f.nextInt();
            if(type == 1 || type == 2)
                update(segtree , x - 1 , type , n);
            else {
                long ans = query(segtree , x - 1 , y , n);
                pn(ans);
            }
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