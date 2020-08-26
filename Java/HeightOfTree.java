import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class HeightOfTree {
    static long mod = (long) Math.pow(10, 9) + 7;
    static boolean fileIO = true;
    static FastScanner f;
    static Scanner S = new Scanner(System.in);
    public static int findheight(HashMap<Integer , ArrayList<Integer>> tree , int root) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);
        //pn(root);
        int height = 0;
        while(true) {
            int nodecount = q.size();
            if(nodecount == 0) return height;
            height++;
            //pn(q);
            while(nodecount > 0) {
                int temp = q.peek();
                q.remove();
                for(Integer i : tree.get(temp)) {
                    q.add(i);
                }
                nodecount--;
            }
        }
    }
    public static void main(String[] args)throws IOException {
        if(fileIO) {f = new FastScanner("");}
        else {f = new FastScanner(System.in);}
        int n = f.nextInt();
        int arr[] = inpint(n);
        HashMap<Integer , ArrayList<Integer>> tree = new HashMap<Integer , ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            tree.put(i , new ArrayList<Integer>());
        }
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] != -1) {
                ArrayList<Integer> ar = tree.get(arr[i]);
                ar.add(i);
                tree.put(arr[i] , ar);
            }
            else
                root = i;
        }
        //pn(tree);
        //pn(root);
        pn(findheight(tree , root));
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
    static void pn(Object o){System.out.println(o);}
    static void p(Object o){System.out.print(o);}
    static void pni(Object o){System.out.println(o);System.out.flush();}
    static class Point implements Comparator<Point>{int x;int y;Point(int x,int y){this.x=x;this.y=y;}Point(){}public int compare(Point a, Point b){if (a.x == b.x) return a.y - b.y; return a.x - b.x;}}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.nextInt();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nextLong();}return arr;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static boolean isPrime(int n){if(n==1)return false;for(int i=2;((i*i)<=n);i++){if(n%i==0)return false;i+=1;}return true;}
}