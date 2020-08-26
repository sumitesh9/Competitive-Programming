import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class Main {
    static int mod = 1000_000_007;
    static long lim = (long)1e9 + 6;
    static long mod1 = 998244353;
    static boolean fileIO = false;
    static FastScanner f;
    static int inf = 2000_000_000;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    static long x0; static long y0;
    static long iinf = (long)(1e18);
    static void solve()throws IOException {
        
    }      
    public static void main(String[] args)throws IOException {
        init();
        int t = 1;
        int tt = 1;
        //fw = new FileWriter("!out.txt");
        while(t --> 0) {
            //fw.write("Case #" + (tt++) + ": ");
            //fw.write("\n");
            solve();
        }
        pw.flush(); 
        pw.close();
        //fw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    public static void init()throws IOException{f=new FastScanner(System.in);}
    public static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastScanner.SpaceCharFilter filter;
 
        public FastScanner(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
 
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int ni() {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-') {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public long nl() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
 
        }
    }
    public static void pn(Object o){pw.println(o);}
    public static void pi(Object o){pw.print(o);pw.flush();}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0l)return a;else{return gcd(b,a%b);}}
    static long lcm(long a,long b){return (a*b/gcd(a,b));}
    static long exgcd(long a,long b){if(b==0){x0=1;y0=0;return a;}long temp=exgcd(b,a%b);long t=x0;x0=y0;y0=t-a/b*y0;return temp;}
    static long pow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=res*a;b>>=1;a=a*a;}return res;}
    static long mpow(long a,long b,long m){long res=1;while(b>0){if((b&1)==1)res=((res%m)*(a%m))%m;b>>=1;a=((a%m)*(a%m))%m;}return res;}
    static long mul(long a , long b){return ((a%mod)*(b%mod)%mod);}
    static long adp(long a , long b){return ((a%mod)+(b%mod)%mod);}
    static boolean isPrime(long n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(long i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static boolean isPrime(int n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(int i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static HashSet<Integer> factors(int n){HashSet<Integer> hs=new HashSet<Integer>();for(int i=1;i<=(int)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static HashSet<Long> pf(long n){HashSet<Long> ff=factors(n);HashSet<Long> ans=new HashSet<Long>();for(Long i:ff)if(isPrime(i))ans.add(i);return ans;}
    static HashSet<Integer> pf(int n){HashSet<Integer> ff=factors(n);HashSet<Integer> ans=new HashSet<Integer>();for(Integer i:ff)if(isPrime(i))ans.add(i);return ans;}
    static int[] inpint(int n){int arr[]=new int[n+1];for(int i=1;i<=n;++i){arr[i]=f.ni();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n+1];for(int i=1;i<=n;++i){arr[i]=f.nl();}return arr;}
    static boolean ise(int x){return ((x&1)==0);}static boolean ise(long x){return ((x&1)==0);}
    static int gnv(char c){return Character.getNumericValue(c);}
    static int log(long x){return x==1?0:(1+log(x/2));} static int log(int x){return x==1?0:(1+log(x/2));}
    static void sort(int[] a){ArrayList<Integer> l=new ArrayList<>();for(int i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
    static void sort(long[] a){ArrayList<Long> l=new ArrayList<>();for(long i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
    static void sort(ArrayList<Integer> a){Collections.sort(a);}
}