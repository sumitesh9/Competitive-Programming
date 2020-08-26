import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class KefaAndPark {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    static Scanner S = new Scanner(System.in);
    static int ans , max;
    static int visited[];
    
    public static void dfs(HashMap<Integer , ArrayList<Integer>> graph , int src , int curr , int pos[]) {
        visited[src] = 1;
        if(pos[src] == 1)
            curr++;
        else
            curr = 0;
        if(curr > max)
            return;
        int numofneighbours = 0;
        if(graph.get(src) == null)
            System.out.println(src);
        for(int i = 0; i < graph.get(src).size(); i++) {
            int neighbour = graph.get(src).get(i);
            if(visited[neighbour] == 0) {
                numofneighbours += 1;
                dfs(graph , graph.get(src).get(i) , curr , pos);
            }
        }
        if(numofneighbours == 0 && curr <= max)
            ans++;
    }

    public static void main(String[] args)throws IOException {
        int n = f.nextInt();
        int m = f.nextInt();
        int pos[] = inpint(n);

        HashMap<Integer , ArrayList<Integer>> graph = new HashMap<Integer , ArrayList<Integer>>();
        for(int i = 0; i < n - 1; i++) {
            int a = f.nextInt();
            int b = f.nextInt();
            if(graph.get(a - 1) == null)
                graph.put(a - 1 , new ArrayList<Integer>());
            if(graph.get(b - 1) == null)
                graph.put(b - 1 , new ArrayList<Integer>());
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }
        visited =  new int[n];
        max = m;
        dfs(graph , 0 , 0 , pos);
        pn(ans);
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
        String nextLine()throws IOException {
            return br.readLine();
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