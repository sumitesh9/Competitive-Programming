/**
 * https://atcoder.jp/contests/abc383/tasks/abc383_b
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

    static int manHDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int findMaxHumidifiedCells(int H, int W, int D, char[][] grid, List<int[]> floorCells) {
        int maxHumidified = 0;
        int n = floorCells.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int[] cell1 = floorCells.get(i);
                int[] cell2 = floorCells.get(j);

                int humidifiedCount = countHumidifiedCells(H, W, D, grid, cell1, cell2);

                maxHumidified = Math.max(maxHumidified, humidifiedCount);
            }
        }

        return maxHumidified;
    }

    static int countHumidifiedCells(int H, int W, int D, char[][] grid, int[] cell1, int[] cell2) {
        boolean[][] humidified = new boolean[H][W];
        humidified[cell1[0]][cell1[1]] = true;
        humidified[cell2[0]][cell2[1]] = true;

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                // Skip non-floor cells
                if (grid[r][c] == '#')
                    continue;

                if (humidified[r][c] ||
                        manHDistance(r, c, cell1[0], cell1[1]) <= D ||
                        manHDistance(r, c, cell2[0], cell2[1]) <= D) {
                    humidified[r][c] = true;
                }
            }
        }

        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (grid[r][c] == '.' && humidified[r][c]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void solve() throws Exception {
        // Add your code here
        int h = f.ni();
        int w = f.ni();
        int d = f.ni();

        char[][] grid = new char[h][w];

        List<int[]> floorCells = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            String row = f.nextLine();
            for (int j = 0; j < w; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == '.') {
                    floorCells.add(new int[] { i, j });
                }
            }
        }

        pn(findMaxHumidifiedCells(h, w, d, grid, floorCells));
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
