import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class gcjq1 {
    static long mod = (long)1e9 + 7;
    static long mod1 = 998244353;
    static boolean fileIO = true;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    public static void main(String[] args)throws IOException {
        init();
        int t = f.nextInt();
        int x = 1;
        while(t --> 0) {
            int n = f.nextInt();
            long arr[][] = new long[n][n];
            long tsum = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    arr[i][j] = f.nextLong();
                    tsum = i == j ? tsum + arr[i][j] : tsum;
                }
            }
            HashSet<Long> rr = new HashSet<Long>();
            HashSet<Long> cc = new HashSet<Long>();
            int rep_rows = 0 , rep_col = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    rr.add(arr[i][j]); cc.add(arr[j][i]);
                }
                rep_rows = rr.size() == n ? rep_rows : rep_rows + 1; rr.clear();
                rep_col = cc.size() == n ? rep_col : rep_col + 1; cc.clear();
            }
            pn("Case " + "#" + (x++) + ": " + tsum + " " + rep_rows + " " + rep_col);
        }
        pw.flush();
        pw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    public static void init()throws IOException{if(fileIO){f=new FastScanner("");}else{f=new FastScanner(System.in);}}
    public static class FastScanner {
        BufferedReader br;StringTokenizer st;
        FastScanner(InputStream stream){try{br=new BufferedReader(new InputStreamReader(stream));}catch(Exception e){e.printStackTrace();}}
        FastScanner(String str){try{br=new BufferedReader(new FileReader("!a.txt"));}catch(Exception e){e.printStackTrace();}}
        String next(){while(st==null||!st.hasMoreTokens()){try{st=new StringTokenizer(br.readLine());}catch(IOException e){e.printStackTrace();}}return st.nextToken();}
        String nextLine()throws IOException{return br.readLine();}int nextInt(){return Integer.parseInt(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}
    }
    public static void pn(Object o){pw.println(o);}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static class Point implements Comparator<Point>{int x;int y;Point(int x,int y){this.x=x;this.y=y;}Point(){}public int compare(Point a, Point b){if(a.x==b.x)return a.y-b.y;return a.x-b.x;}}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long pow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=res*a;b>>=1;a=a*a;}return res;}
    static long mpow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=((res%mod)*(a%mod))%mod;b>>=1;a=((a%mod)*(a%mod))%mod;}return res;}
    static boolean isPrime(long n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(long i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.nextInt();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nextLong();}return arr;}
    static HashSet<Integer> hsi(){return new HashSet<Integer>();}static HashSet<Long> hsl(){return new HashSet<Long>();}
    static ArrayList<Integer> ali(){return new ArrayList<Integer>();}static ArrayList<Long> all(){return new ArrayList<Long>();}
    static HashMap<Integer,Integer> hii(){return new HashMap<Integer,Integer>();}
    static HashMap<Integer,ArrayList<Integer>> g(){return new HashMap<Integer,ArrayList<Integer>>();}
    static boolean ise(int x){return ((x&1)==0);}static boolean ise(long x){return ((x&1)==0);}
}