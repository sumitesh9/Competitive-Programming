
/**
 * https://codeforces.com/problemset/problem/158/B
 * Simple greedy algorithm will suffice here, follow this in order :-
 * 1. Send each group of 4 friends together in one car
 * 2. Club group of 3 friends with one loner
 * 3. Remaining group of size 3 will require a car because they can't be paired with group of size 2 (3 + 2 > 4) and we have exhausted loners at this point
 * 4. Now pair up 2 groups of size 2 as much as we can
 * 5. Now we have atmost a single group of size 2 and some loners left if we didn't had enough groups of size 3 in step 2 to pair with, 
 *    now it doesn't really matter how you pair remaining folks as long you fill the car entirely
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
        int n = f.ni();

        int[] cnt = new int[5];

        for (int i = 0; i < n; ++i) {
            int x = f.ni();
            cnt[x]++;
        }

        // Group of 4 will go in one car
        int ans = cnt[4];
        // pn("Sending " + ans + " cars for groups of size 4");

        // Send groups of size 3 and 1 together
        int res = Math.min(cnt[3], cnt[1]);
        ans += res;

        // pn("Sending " + res + " cars for groups of size 3 and 1");

        cnt[3] -= res;
        cnt[1] -= res;

        // Remaining 3s will go together
        ans += cnt[3];
        // pn("Sending " + cnt[3] + " cars for groups of size 3");
        cnt[3] = 0;

        // Send two groups of size 2 together
        res = (cnt[2] / 2);
        cnt[2] -= (res * 2);

        ans += res;
        // pn("Sending " + res + " cars for 2 groups of size 2 together");

        // At this point, cnt[2] can be atmost 1, now it doesn't matter how you fit
        // remaining groups as long as you can fill the car
        // pn(cnt[2] + " " + cnt[1]);
        ans += (cnt[2] * 2 + cnt[1] + 3) / 4;
        pn(ans);
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
