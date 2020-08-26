import java.util.*;
import java.io.*;

public class BacterialReproduction {

    static long mod = (long) Math.pow(10, 9) + 7;
    static void updatewithk(TreeMap<Integer, ArrayList<Integer>> tree, TreeMap<Integer, Integer> bact, int k , int v) {

    }
    static void update(TreeMap<Integer, ArrayList<Integer>> tree, HashMap<Integer, Integer> bact) {
        
    }
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int n = f.nextInt();
        int q = f.nextInt();
        TreeMap<Integer , ArrayList<Integer>> tree = new TreeMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> bact = new HashMap<Integer, Integer>();
        for(int i = 1; i < n ;i++) {
            int a = f.nextInt();
            int b = f.nextInt();
            int son = Math.max(a, b);
            int parent = Math.min(a, b);
            if(tree.containsKey(parent)) {
                ArrayList<Integer> child = tree.get(parent);
                child.add(son);
                tree.put(parent, child);
            }
            else {
                ArrayList<Integer> child = new ArrayList<Integer>();
                child.add(son);
                tree.put(parent, child);
            }
        }
        for(int i = 0; i < n; i++) {
            bact.put(i + 1, f.nextInt());
        }
        for(int i = 0; i < q; i++) {
            char ch = f.next();
            update(tree , bact);
            if(ch == '+') {
                int v = f.nextInt();
                int k = f.nextInt();
                updatewithk(tree , bact , k , v);
            }
            else {
                int res = bact.get(f.nextInt());
                System.out.println(res);
            }
        }
    }
/******************************END OF MAIN PROGRAM*******************************************/
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

    //GCD of two integers
    int gcd(int a, int b) {
        if(b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    // GCD of a array of integers
    int gcdarray(int a[]) {
        int res = a[0];
        for(int i = 1; i < a.length; i++) {
            res = gcd(a[i] , res);
        }
        return res;
    }

    // Is Prime no.?
    boolean isPrime(int n) {
        if(n == 1) return false;
        int i = 2;
        while((i * i) <= n) {
            if(n % i == 0) return false;
            i += 1;
        }
        return true;
    }   
}