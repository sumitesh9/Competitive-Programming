import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class ExitToAMaze {
    static long mod = (long)1e9 + 7;
    static long mod1 = 998244353;
    static boolean fileIO = true;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    static int flag = 0;
    static boolean visited[];
    public static void dfs(HashMap<Integer , ArrayList<Integer>> g , int src , int des) {
        visited[src] = true;
        for(Integer i : g.get(src)) {
            if(i == des) {flag = 1; return;}
            else {if(!visited[i]) dfs(g , i , des);}
        }
    }
    public static void main(String[] args)throws IOException {
        init();
        int n = f.nextInt();
        int m = f.nextInt();
        HashMap<Integer , ArrayList<Integer>> g = new HashMap<Integer , ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {g.put(i + 1 , new ArrayList<Integer>());}
        for(int i = 0; i < m; i++) {
            int a = f.nextInt();
            int b = f.nextInt();
            ArrayList<Integer> temp = g.get(a);
            ArrayList<Integer> temp1 = g.get(b);
            temp.add(b);
            temp1.add(a);
            g.put(a , temp);
            g.put(b , temp1);
        }
        visited = new boolean[g.size() + 1];
        Arrays.fill(visited , false);
        //pn(g);
        int src = f.nextInt();
        int des = f.nextInt();
        dfs(g , src , des);
        if(flag == 0) pn(0);
        else pn(1);
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
}