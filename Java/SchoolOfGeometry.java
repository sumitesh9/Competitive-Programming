import java.util.*;
import java.io.*;
public class SchoolOfGeometry {
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastScanner f = new FastScanner(System.in);
        int t = f.nextInt();
        while(t-->0) {
            int n = f.nextInt();
            int arr1[] = new int[n];
            int arr2[] = new int[n];

            for(int i = 0; i < n; i++) {
                arr1[i] = f.nextInt();
            }

            for(int i = 0; i < n; i++) {
                arr2[i] = f.nextInt();
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += Math.min(arr1[i] , arr2[i]);
            }

            pn(sum);
        }
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
}