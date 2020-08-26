import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class TicTacToe {
    static long mod = (long)1e9 + 7;
    static boolean fileIO = true;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    public static boolean checkf(char b[][]) {
        if(b[0][0] == b[0][1] && b[0][2] == 'X' && b[0][1] == b[0][2]) return true;
        else if(b[0][2] == b[1][2] && b[2][2] == 'X' && b[1][2] == b[2][2]) return true;
        else if(b[2][2] == b[2][1] && b[2][0] == 'X' && b[2][1] == b[2][0]) return true;
        else if(b[2][0] == b[1][0] && b[0][0] == 'X' && b[1][0] == b[0][0]) return true;
        else if(b[0][0] == b[1][1] && b[2][2] == 'X' && b[1][1] == b[2][2]) return true;
        else if(b[2][0] == b[1][1] && b[0][2] == 'X' && b[1][1] == b[0][2]) return true;
        else if(b[1][0] == b[1][1] && b[1][2] == 'X' && b[1][2] == b[1][1]) return true;
        else if(b[0][1] == b[1][1] && b[2][1] == 'X' && b[1][1] == b[2][1]) return true;
        else {return false;}
    }

    public static boolean checks(char b[][]) {
         if(b[0][0] == b[0][1] && b[0][2] == '0' && b[0][1] == b[0][2]) return true;
        else if(b[0][2] == b[1][2] && b[2][2] == '0' && b[1][2] == b[2][2]) return true;
        else if(b[2][2] == b[2][1] && b[2][0] == '0' && b[2][1] == b[2][0]) return true;
        else if(b[2][0] == b[1][0] && b[0][0] == '0' && b[1][0] == b[0][0]) return true;
        else if(b[0][0] == b[1][1] && b[2][2] == '0' && b[1][1] == b[2][2]) return true;
        else if(b[2][0] == b[1][1] && b[0][2] == '0' && b[1][1] == b[0][2]) return true;
        else if(b[1][0] == b[1][1] && b[1][2] == '0' && b[1][2] == b[1][1]) return true;
        else if(b[0][1] == b[1][1] && b[2][1] == '0' && b[1][1] == b[2][1]) return true;
        else {return false;}
    }

    public static void main(String[] args)throws IOException {
        init();
        char b[][] = new char[3][3];
        int c = 0 , z = 0 , e = 0;
        for(int i = 0; i < 3; i++) {
            String str = f.next();
            for(int j = 0; j < 3; j++){
                b[i][j] = str.charAt(j);
                if(b[i][j] == 'X') c++;
                else if(b[i][j] == '0') z++;
                else e++;
            }
        }
        //pn(c + " " + z);
        if(c < z) {pn("illegal");}
        else if(c == z) {
            if(checkf(b) && checks(b)) pn("illegal"); 
            else {
                if(checkf(b)) pn("illegal");
                else if(checks(b)) pn("the second player won");
                else pn("first");
            }
        }
        else {
            if((c - z) > 1) pn("illegal");
            else if(c - z == 1 && !checkf(b) && e == 0) pn("draw");
            else {
                if(checkf(b)) pn("the first player won");
                else if(checks(b)) pn("illegal");
                else pn("second");
            }
        }
        pw.flush();
        pw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    public static void init()throws IOException{if(fileIO){f=new FastScanner("");}else{f=new FastScanner(System.in);}}
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
    public static void pn(Object o){pw.println(o);}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static class Point implements Comparator<Point>{int x;int y;Point(int x,int y){this.x=x;this.y=y;}Point(){}public int compare(Point a, Point b){if(a.x==b.x)return a.y-b.y;return a.x-b.x;}}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.nextInt();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nextLong();}return arr;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static boolean isPrime(int n){if(n==1)return false;for(int i=2;((i*i)<=n);i++){if(n%i==0)return false;i+=1;}return true;}
}