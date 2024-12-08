/**
 * https://atcoder.jp/contests/abc383/tasks/abc383_d
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    static boolean fileIO = false;

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void solve() throws Exception {
        // Add your code here

        long n = f.nl();

        int ub = (int) Math.sqrt(n);
        boolean[] isPrime = sieveOfEratosthenes(ub);
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= ub; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int count = 0;
        
        for (int prime : primes) {
            long power8 = 1;
            for (int i = 0; i < 8; i++) {
                power8 *= prime;
                if (power8 > n) {
                    power8 = -1;
                    break;
                }
            }
            if (power8 != -1 && power8 <= n)
                ++count;
        }

        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = (long) primes.get(i) * primes.get(i);
            if (p2 > n)
                break;

            for (int j = i + 1; j < size; j++) {
                long q2 = (long) primes.get(j) * primes.get(j);
                if (q2 > n / p2) {
                    break;
                }
                count++;
            }
        }

        pn(count);

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
        if (fileIO) {
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
