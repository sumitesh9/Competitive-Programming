import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Main {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    static Scanner S = new Scanner(System.in);
    public static long findcost(int arr[][] , int i , int j , int k , int l) {
        int comb[] = new int[4];
        comb[0] = arr[0][i];
        comb[1] = arr[1][j];
        comb[2] = arr[2][k];
        comb[3] = arr[3][l];
        Arrays.sort(comb);
        long sum = 0;
        for(int m = 0; m < 4; m++) {
            if(comb[m] == 0)
                sum -= 100;
            else
                sum += ((25) * (m + 1) * comb[m]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int t = f.nextInt();
        long tot = 0;
        while(t --> 0) {
            int n = f.nextInt();
            int arr[][] = new int[4][4];

            for(int i = 0; i < n; i++) {
                String movie = f.next();
                int time = f.nextInt();
                if(movie.equals("A")) {
                    arr[0][(time / 3) - 1]++;
                }
                else if(movie.equals("B")) {
                    arr[1][(time / 3) - 1]++;
                }
                else if(movie.equals("C")) { 
                    arr[2][(time / 3) - 1]++;
                }
                else {
                    arr[3][(time / 3) - 1]++;
                }
            }


            long res = Long.MIN_VALUE;
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        for(int l = 0; l < 4; l++) {
                            if(i != j && i != k && i != l && j != k && j != l && k != l) {
                                res = Math.max(findcost(arr , i , j , k , l) , res);
                            }
                        }
                    }
                }
            }
            pn(res);
            tot += res;
        }
        pn(tot);
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
}