/**
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    @SuppressWarnings("unused")
    static int mod = 1000_000_007;

    @SuppressWarnings("unused")
    static long mod1 = 998244353;

    static boolean memory = false;

    static FastScanner f;

    static PrintWriter pw;

    @SuppressWarnings("unused")
    static double eps = 1e-6;

    @SuppressWarnings("unused")
    static int oo = (int) 1e9;

    static boolean testCases = false;

    public static void solve() throws Exception {
        // Add your code here
        char[] inp = f.nextLine().toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('Y');
        
        for (int i = 0; i < inp.length; ++i) {
            if (!vowels.contains(inp[i])) {
                p('.');
                p(Character.toLowerCase(inp[i]));
            }   
        }
    }

    public static void main(String[] args) throws Exception {
        if (memory) {
            new Thread(null, () -> {
                try {
                    new Main().run();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }, "", 1 << 28).start();
        } else {
            new Main().run();
        }
    }

    void run() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            f = new FastScanner("");
            File file = new File("!output.txt");
            pw = new PrintWriter(file);
        } else {
            f = new FastScanner();
            pw = new PrintWriter(System.out);
        }

        int t = testCases ? f.ni() : 1;
        while (t-- > 0) {
            solve();
        }

        pw.flush();
        pw.close();
    }

    public static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String str) throws Exception {
            try {
                br = new BufferedReader(new FileReader("!input.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int ni() throws IOException {
            return Integer.parseInt(next());
        }

        public long nl() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nd() throws IOException {
            return Double.parseDouble(next());
        }

    }

    public static void pn(Object... o) {
        for (int i = 0; i < o.length; ++i) {
            pw.print(o[i] + (i + 1 < o.length ? " " : "\n"));
        }
    }

    public static void p(Object... o) {
        for (int i = 0; i < o.length; ++i) {
            pw.print(o[i] + (i + 1 < o.length ? " " : ""));
        }
    }

    public static void pni(Object... o) {
        for (Object obj : o) {
            pw.print(obj + " ");
        }
        pw.println();
        pw.flush();
    }

    public static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) {
            l.add(i);
        }
        Collections.sort(l);
        for (int i = 0; i < a.length; ++i) {
            a[i] = l.get(i);
        }
    }

    public static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a) {
            l.add(i);
        }
        Collections.sort(l);
        for (int i = 0; i < a.length; ++i) {
            a[i] = l.get(i);
        }
    }
}
