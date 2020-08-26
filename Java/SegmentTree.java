import java.io.*;
import java.util.*;
public class SegmentTree 
{ 
    long st[];
    SegmentTree(long arr[], int n) { 
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
        st = new long[max_size];
        constructSTUtil(arr, 0, n - 1, 0); 
    }
    int getMid(int s, int e) { 
        return s + (e - s) / 2; 
    }
    long getSumUtil(int ss, int se, int qs, int qe, int si) { 
        if (qs <= ss && qe >= se) 
            return st[si]; 
        if (se < qs || ss > qe) 
            return 0; 
        int mid = getMid(ss, se); 
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2); 
    }
    void updateValueUtil(int ss, int se, int i, long diff, int si) { 
        if (i < ss || i > se) 
            return;
        st[si] = st[si] + diff; 
        if (se != ss) { 
            int mid = getMid(ss, se); 
            updateValueUtil(ss, mid, i, diff, 2 * si + 1); 
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2); 
        } 
    }
    void updateValue(long arr[], int n, int i, long new_val) { 
        if (i < 0 || i > n - 1) { 
            System.out.println("Invalid Input"); 
            return; 
        } 
        long diff = new_val - arr[i]; 
        arr[i] = new_val; 
        updateValueUtil(0, n - 1, i, diff, 0); 
    }
    long getSum(int n, int qs, int qe) { 
        if (qs < 0 || qe > n - 1 || qs > qe) { 
            System.out.println("Invalid Input"); 
            return -1; 
        } 
        return getSumUtil(0, n - 1, qs, qe, 0); 
    }
    long constructSTUtil(long arr[], int ss, int se, int si) { 
        if (ss == se) { 
            st[si] = arr[ss]; 
            return arr[ss]; 
        }
        int mid = getMid(ss, se); 
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2); 
        return st[si]; 
    }
    public static void main(String args[])throws IOException 
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long arr[] = new long[n];
            Arrays.fill(arr , 0);
            SegmentTree tree = new SegmentTree(arr, n); 
            while(q --> 0) {
                st = new StringTokenizer(br.readLine());
                int ty = Integer.parseInt(st.nextToken());
                if(ty == 1) {
                    tree.updateValue(arr , n , Integer.parseInt(st.nextToken()) - 1 , Integer.parseInt(st.nextToken()));
                }
                else {
                    System.out.println(tree.getSum(n , Integer.parseInt(st.nextToken()) - 1 , Integer.parseInt(st.nextToken()) - 1));
                }
            }
        }
    } 
}