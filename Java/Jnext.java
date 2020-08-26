import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Jnext {
    static long mod = (long) Math.pow(10, 9) + 7;
    static Reader R = new Reader(System.in);
    static Scanner S = new Scanner(System.in);
    static void solve(int arr[] , int n) {
        int x = -1;
        int y = -1;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] < arr[i + 1])
                x = i;
        }
        if(x == -1)
            pn(-1);
        else {
            for(int i = 0; i < n; i++) {
                if(arr[x] < arr[i])
                    y = i;
            }
            // Swap
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;

            // Reverse
            int l1 = x + 1 , r1 = n - 1;
            int gg = (r1 - l1 + 1) >> 1;
            for(int i = 0; i < gg; i++) {
                temp = arr[l1];
                arr[l1] = arr[r1];
                arr[r1] = temp;
                l1++;
                r1--;
            }

            for(int i = 0; i < n; i++) {
                p(arr[i]);
            }
            pn("");
        }
    }
    public static void main(String[] args)throws Exception {
        int t = R.nextInt();
        while(t --> 0) {
            int n = R.nextInt();
            int arr[] = inpint(n);
            solve(arr , n);
        }   
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    // Fast Scanner Alternative of Scanner 
    // Uses Implementation of BufferedReader Class
    public static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(InputStream in) {
          din = new DataInputStream(in);
          buffer = new byte[BUFFER_SIZE];
          bufferPointer = bytesRead = 0;
        }

        public long nextLong() throws Exception {
          long ret = 0;
          byte c = read();
          while (c <= ' ') c = read();
          boolean neg = c == '-';
          if (neg) c = read();
          do {
             ret = ret * 10 + c - '0';
             c = read();
          } 
          while (c > ' ');
          if (neg) return -ret;
          return ret;
        }
       
        //reads in the next string
        public String next() throws Exception {
          StringBuilder ret =  new StringBuilder();
          byte c = read();
          while (c <= ' ') c = read();
          do {
             ret = ret.append((char)c);
             c = read();
          } 
          while (c > ' ');
          return ret.toString();
        }

        public int nextInt() throws Exception {
          int ret = 0;
          byte c = read();
          while (c <= ' ') c = read();
          boolean neg = c == '-';
          if (neg) c = read();
          do {
             ret = ret * 10 + c - '0';
             c = read();
          }
          while (c > ' ');
          if (neg) return -ret;
          return ret;
        }
       
        private void fillBuffer() throws Exception {
          bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
          if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception {
          if (bufferPointer == bytesRead) fillBuffer();
          return buffer[bufferPointer++];
        }
    }
    
    // Print in console
    static void pn(Object o){System.out.println(o);}
    static void p(Object o){System.out.print(o);}
    static void pni(Object o){System.out.println(o);System.out.flush();}

    // Pair class in java
    static class Point implements Comparator<Point>{
        int x;int y;
        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
        Point(){}
        public int compare(Point a, Point b){
            if (a.x == b.x) 
                return a.y - b.y;
            return a.x - b.x;
        }
    }

    //GCD of two integers
    static int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }
    // Input int array
    static int[] inpint(int n)throws Exception {
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = R.nextInt();
        return arr;
    }

    //Input long array
    static long[] inplong(int n)throws Exception {
        long arr[] = new long[n];
        for(int i = 0; i < n; i++) 
            arr[i] = R.nextLong();
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
}