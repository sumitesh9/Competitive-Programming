import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class cf5 {
    static long mod = (long)1e9 + 7;
    static long mod1 = 998244353;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    static long x0; static long y0;
    static FileWriter fw;
    public static void solve()throws IOException {
        
    } 
    public static void main(String[] args)throws IOException {
        init();
        int t = f.ni();
        int tt = 1;
        while(t --> 0) {
            fw.write("\n");
            solve();
        }
        pw.flush(); 
        pw.close();
        fw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    public static void init()throws IOException{if(System.getProperty("ONLINE_JUDGE")==null){f=new FastScanner("");}else{f=new FastScanner(System.in);}}
    public static class FastScanner {
        BufferedReader br;StringTokenizer st;
        FastScanner(InputStream stream){try{br=new BufferedReader(new InputStreamReader(stream));}catch(Exception e){e.printStackTrace();}}
        FastScanner(String str){try{br=new BufferedReader(new FileReader("!a.txt"));}catch(Exception e){e.printStackTrace();}}
        String next(){while(st==null||!st.hasMoreTokens()){try{st=new StringTokenizer(br.readLine());}catch(IOException e){e.printStackTrace();}}return st.nextToken();}
        String nextLine()throws IOException{return br.readLine();}int ni(){return Integer.parseInt(next());}long nl(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}
    }
    public static void pn(Object o){pw.println(o);}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long exgcd(long a,long b){if(b==0){x0=1;y0=0;return a;}long temp=exgcd(b,a%b);long t=x0;x0=y0;y0=t-a/b*y0;return temp;}
    static long pow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=res*a;b>>=1;a=a*a;}return res;}
    static long mpow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=((res%mod)*(a%mod))%mod;b>>=1;a=((a%mod)*(a%mod))%mod;}return res;}
    static long mul(long a , long b , long m){return ((a%m)*(b%m)%m);}
    static long adp(long a , long b , long m){return ((a%m)+(b%m)%m);}
    static boolean isPrime(long n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(long i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static boolean isPrime(int n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(int i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static int log2(int x){return (int)(Math.log(x)/Math.log(2));}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static HashSet<Integer> factors(int n){HashSet<Integer> hs=new HashSet<Integer>();for(int i=1;i<=(int)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static HashSet<Long> pf(long n){HashSet<Long> ff=factors(n);HashSet<Long> ans=new HashSet<Long>();for(Long i:ff)if(isPrime(i))ans.add(i);return ans;}
    static HashSet<Integer> pf(int n){HashSet<Integer> ff=factors(n);HashSet<Integer> ans=new HashSet<Integer>();for(Integer i:ff)if(isPrime(i))ans.add(i);return ans;}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.ni();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nl();}return arr;}
    static boolean ise(int x){return ((x&1)==0);}static boolean ise(long x){return ((x&1)==0);}
    static int gnv(char c){return Character.getNumericValue(c);}
    static int log(long x){return x==1?0:(1+log(x/2));} static int log(int x){return x==1?0:(1+log(x/2));}
    static void sort(int[] a){ArrayList<Integer> l=new ArrayList<>();for(int i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
    static void sort(long[] a){ArrayList<Long> l=new ArrayList<>();for(long i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
    static void sort(ArrayList<Integer> a){Collections.sort(a);}
}