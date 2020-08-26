import java.util.*;
import java.io.*;
class AzamonWebServices {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static String sortString(String inputString) 
    {
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int t = f.nextInt();
        while(t-- > 0) {
            String s1 = f.next();
            String s2 = f.next();
            StringBuffer sb1 = new StringBuffer(s1);
            String sorted = sortString(s1);
            StringBuffer sortedsb = new StringBuffer(sorted);
            int c = 0;
            for(int i = 0 ; i < s1.length(); i++) {
                if((int)sb1.charAt(i) != (int)sortedsb.charAt(i))
                {
                    int x = s1.lastIndexOf(sortedsb.charAt(i));
                    char temp1 = sb1.charAt(x);
                    char temp2 = sb1.charAt(i);
                    sb1.setCharAt(x , temp2);
                    sb1.setCharAt(i , temp1);
                    c++;
                }
                if(c == 1)
                    break;
            }
            s1 = sb1.toString();
            if(s1.compareTo(s2) < 0) 
                pn(s1);
            else
                pn("---");
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