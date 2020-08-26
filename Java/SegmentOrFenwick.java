import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class SegmentOrFenwick {
    static long mod = (long)1e9 + 7;
    static boolean fileIO = true;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    public static void init()throws IOException {
        if(fileIO) {f = new FastScanner("");}
        else {f = new FastScanner(System.in);}
    }
    public static long[] build(long arr[] , int n) {
        long segtree[] = new long[2 * n];
        //Assign value to leaves of segment tree
        for(int i = 0 ; i < n ; i++) 
            segtree[n + i] = arr[i];
        
        //Assign value to internal node to compute minimum in a given range
        for(int i = n - 1; i >= 1; i--) {
            segtree[i] = (segtree[2 * i] + segtree[2 * i + 1]); 
        }
        return segtree;
    }

    public static void update(long segtree[] , int pos , int value , int n) {
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
            segtree[pos] = (segtree[2 * pos] + segtree[2 * pos + 1]); 
        }
    }

    // Queries are answered in range [l , r)
    public static long query(long segtree[] , int l , int r , int n) {
        if(l == r)
            return segtree[l + 1];
        //Change indices to leaf node
        l += n;
        r += n;
        long ans = 0;
        while(l < r) {
            if((l & 1) == 1) {
                ans = (ans + segtree[l]);
                l++;
            }
            if((r & 1) == 1) {
                r--;
                ans = (ans + segtree[r]);
            }
            l >>= 1;
            r >>= 1;
        }
        return ans;
    }

    public static void main(String[] args)throws IOException {
        init();
        int t = f.nextInt();
        while(t --> 0) {
            int n = f.nextInt();
            int q = f.nextInt();
            long arr[] = new long[n];
            Arrays.fill(arr , 0l);
            long tree[] = build(arr , n);
            while(q --> 0) {
                int type = f.nextInt();
                if(type == 1) {
                    int pos = f.nextInt();
                    int value = f.nextInt();
                    update(tree , pos - 1 , value , n);
                }
                else {
                    int l = f.nextInt();
                    int r = f.nextInt();
                    pn(query(tree , l - 1 , r , n));
                }
            }
            pw.flush();   
        }
        pw.flush();
        pw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    // Fast Scanner Alternative of Scanner 
    // Uses Implementation of BufferedReader Class
    public static class FastScanner {
        BufferedReader br;StringTokenizer st;
        FastScanner(InputStream stream){try{br=new BufferedReader(new InputStreamReader(stream));}catch(Exception e){e.printStackTrace();}}
        FastScanner(String str){try{br=new BufferedReader(new FileReader("!a.txt"));}catch(Exception e){e.printStackTrace();}}
        String next(){while(st==null||!st.hasMoreTokens()){try{st=new StringTokenizer(br.readLine());}catch(IOException e){e.printStackTrace();}}return st.nextToken();}
        String nextLine()throws IOException{return br.readLine();}
        int nextInt(){return Integer.parseInt(next());}
        long nextLong(){return Long.parseLong(next());}
        double nextDouble(){return Double.parseDouble(next());}
    }
    public static void pn(Object o){pw.println(o);}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static class Point implements Comparator<Point>{int x;int y;Point(int x,int y){this.x=x;this.y=y;}Point(){}public int compare(Point a, Point b){if(a.x == b.x) return a.y - b.y; return a.x - b.x;}}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.nextInt();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nextLong();}return arr;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static boolean isPrime(int n){if(n==1)return false;for(int i=2;((i*i)<=n);i++){if(n%i==0)return false;i+=1;}return true;}
}