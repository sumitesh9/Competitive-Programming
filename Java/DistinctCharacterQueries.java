import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class DistinctCharacterQueries {
    static long mod = (long) Math.pow(10, 9) + 7;
    static Reader f = new Reader();
    static Scanner S = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static int[] build(int arr[] , int n) {
        int segtree[] = new int[2 * n];
        
        //Assign value to leaves of segment tree
        for(int i = 0 ; i < n ; i++) 
            segtree[n + i] = arr[i];
        
        //Assign value to internal node to compute minimum in a given range
        for(int i = n - 1; i >= 1; i--)
        {
            segtree[i] = (segtree[2 * i], segtree[2 * i + 1]); 
        }
        return segtree;
    }

    public static void update(int segtree[] , int pos , int value , int n) {
        // pos follows 0 based indexing
        //Change the index to leaf node first
        pos += n;

        // Update value at leaf node at exact index
        segtree[pos] = value;
        while (pos > 1) { 
        // move up one level at a time in the tree 
        pos >>= 1; 
        // update the values in the nodes in 
        // the next higher level 
        segtree[pos] = Math.min(segtree[2 * pos], 
                           segtree[2 * pos + 1]); 
        }
    }

    // Queries are answered in range [l , r)
    public static int query(int segtree[] , int l , int r , int n) {
        if(l == r)
            return segtree[l + 1];
        //Change indices to leaf node
        l += n;
        r += n;
        int ans = Integer.MAX_VALUE;
        while(l < r) {
            if((l & 1) == 1)
            {
                ans = Math.min(ans , segtree[l]);
                l++;
            }
            if((r & 1) == 1) {
                r--;
                ans = Math.min(ans , segtree[r]);
            }
            l /= 2;
            r /= 2;
        }
        return ans;
    }


    public static void main(String[] args)throws IOException {
        String s = f.next();
        int q = f.nextInt();
        int n = s.length();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = (int)s.charAt(i);
        }

        int segtree[] = build(arr , n);
        while(q --> 0) {
            int type =  f.nextInt();
            
            if(type == 1) {
                int pos = f.nextInt();
                char c = f.next().charAt(0);
                update(pos - 1 , (int)c);
            }

            else {
                int l = f.nextInt();
                int r = f.nextInt();
                query(l - 1 , r);
            }
        }
        pw.close();   
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    // Fast Scanner Alternative of Scanner 
    // Uses Implementation of BufferedReader Class
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
    
    // Print in console
    static void pn(Object o){pw.println(o);}
    static void p(Object o){pw.print(o);}
    static void pni(Object o){pw.println(o);pw.flush();}

    //GCD of two integers
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }
    // Input int array
    static int[] inpint(int n)throws IOException {
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = f.nextInt();
        return arr;
    }

    //Input long array
    static long[] inplong(int n)throws IOException {
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