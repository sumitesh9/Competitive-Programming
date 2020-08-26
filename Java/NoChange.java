import java.util.*;
import java.io.*;
import java.math.BigInteger;
class NoChange {
    static long mod = (long) Math.pow(10, 9) + 7;
    static FastScanner f = new FastScanner(System.in);
    static Scanner S = new Scanner(System.in);
    
    public static boolean check_divisibility(int p , int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            if((p % arr[i]) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int t = f.nextInt();
        while(t --> 0) {
            int n = f.nextInt();
            int p = f.nextInt();
            int arr[] = inpint(n);
            int flag = 0;
            
            if(!check_divisibility(p , arr)) {
                p("YES" + " ");
                for(int i = 0; i < n; i++) {
                    if(flag == 0 && (p % arr[i]) != 0) {
                        p(((p / arr[i]) + 1) + " ");
                        flag = 1;
                    }
                    else
                        p("0" + " ");
                }
            }

            else {
                
                if(n == 1) 
                    p("NO");
                else {
                    int p1 = 0;
                    int p2 = 0;
                    int x = 0;
                    int q = 0;
                    for(int i = 0 ; i < n; i++) {
                        for(int j = i + 1; j < n; j++) {
                            if(arr[j] != 1 && arr[j] != p && arr[i] != 1 && arr[i] != p) {
                                q = (((p / arr[j]) - 1) * arr[j]);
                                x = p - q;
                                if((x % arr[i]) == 0)
                                    continue;
                                else {
                                p1 = i;
                                p2 = j;
                                flag = 1;
                                break;
                                } 
                            }
                        }
                         if(flag == 1)
                                break;
                    }
                    
                    if(flag == 1) {
                         p("YES" + " ");
                        int x1 = (((p / arr[p2]) - 1) * arr[p2]);
                        int x2 = p  - x1;
                        int x3 = x2 % arr[p1];
                        x2 = x2 - x3 + arr[p1];
                        x3 = x2 / arr[p1];
                        for(int i = 0; i < n; i++) {
                            if(i == p1) 
                                p(x3 + " ");
                            else if(i == p2) 
                                p((p / arr[p2] - 1) + " ");
                            else
                                p("0" + " ");
                        }
                    }

                    else
                       p("NO");
                }
            }
            pn(" ");
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