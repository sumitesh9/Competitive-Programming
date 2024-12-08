/**
 * https://atcoder.jp/contests/abc383/tasks/abc383_c
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
import java.util.LinkedList;
import java.util.Queue;
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

    // Directions for moving up, down, left, and right
    private static final int[] ROW_DIR = { -1, 1, 0, 0 };
    private static final int[] COL_DIR = { 0, 0, -1, 1 };

    public static int countHumidifiedCells(int h, int w, int d, char[][] grid) {
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 'H') {
                    queue.add(new int[] { i, j, 0 }); // {row, col, distance}
                    visited[i][j] = true;
                }
            }
        }

        int humidifiedCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (grid[row][col] == '.' || grid[row][col] == 'H') {
                humidifiedCount++;
            }

            if (distance == d) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + ROW_DIR[i];
                int newCol = col + COL_DIR[i];
                
                if (newRow >= 0 && newRow < h && newCol >= 0 && newCol < w && !visited[newRow][newCol]
                        && grid[newRow][newCol] != '#') {
                    queue.add(new int[] { newRow, newCol, distance + 1 });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return humidifiedCount;
    }

    public static void solve() throws Exception {
        // Add your code here
        int h = f.ni();
        int w = f.ni();
        int d = f.ni();

        char[][] grid = new char[h][w];

        for (int i = 0; i < h; ++i) {
            String s = f.nextLine();
            for (int j = 0; j < w; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }

        pn(countHumidifiedCells(h, w, d, grid));
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
