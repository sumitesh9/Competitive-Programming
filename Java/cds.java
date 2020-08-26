// Compilation of advanced data structures in java

// Fenwick tree!  Init with fen bit = new fen(n) take original n , n is increased in constructor;
	public  static class fen {		
		int fen[];// = new int[SIZE + 1];
		int n;
		// BIT 1 based indexing
		public fen(int n) {
			this.n = n;
			fen = new int[n + 1];
		}
		
		public int query(int idx) {
			int sum = 0;
			for(; idx > 0; idx -= (idx & (-idx))){
				sum += fen[idx];
			}
			return sum;
		}

		public void update(int idx , int val) {
			for(; idx <= n; idx += (idx & (-idx))){
				fen[idx]+=val;
			}
		}
	}

// Pair class in java
	public static class Pair {
		int min , idx;
		public Pair(int min , int idx) {
			this.min = min;
			this.idx = idx;
		}
	}

	public boolean equals(Object o) {
		if(o instanceof Pair) {
		    Pair p = (Pair)o;
		    return p.min == min && p.idx == idx;
		}
		return false;
	}
	public static class comparator implements Comparator<Pair> {
		@Override
		public int compare(Pair p1 , Pair p2) {
		    return p2.min - p1.min;
		}
	}

// Segment tree in java
    public static int[] build(int arr[] , int n) {
        int segtree[] = new int[2 * n];
        
        //Assign value to leaves of segment tree
        for(int i = 0 ; i < n ; i++) 
            segtree[n + i] = arr[i];
        
        //Assign value to internal node to compute minimum in a given range
        for(int i = n - 1; i >= 1; i--)
        {
            segtree[i] = Math.min(segtree[2 * i], segtree[2 * i + 1]); 
        }
        return segtree;
    }

    public static void update(int segtree[] , int pos , int value , int n) {
        // pos follows 0 based indexing
        //Change the index to leaf node first
        pos += n;

        // Update value at leaf node at exact index
        segtree[pos] = value;
        while (pos > 1) { 
        // move up one level at a time in the tree 
        pos >>= 1; 
        // update the values in the nodes in 
        // the next higher level 
        segtree[pos] = Math.min(segtree[2 * pos], 
                           segtree[2 * pos + 1]); 
        }
    }

    public static int query(int segtree[] , int l , int r , int n) {
        if(l == r)
            return segtree[l + 1];
        //Change indices to leaf node
        l += n;
        r += n;
        int ans = Integer.MAX_VALUE;
        while(l < r) {
            if((l & 1) == 1)
            {
                ans = Math.min(ans , segtree[l]);
                l++;
            }
            if((r & 1) == 1) {
                r--;
                ans = Math.min(ans , segtree[r]);
            }
            l /= 2;
            r /= 2;
        }
        return ans;
    }


// Square root decomposition 
    // Update query for sum is in O(1) ? Hmm ! Remember why ?
    // Update isn't tested yet
    static void update(int idx , int val) {
    	int bno = (idx + s - 1) / s;
    	int l = ((bno - 1) * s) + 1;
    	int ans = inf;
    	for (int i = l; i < l + s && i < arr.length; ++i) {
    		if (i == idx) continue;
    		ans = Math.min(ans , arr[i]);
    	}
    	ans = Math.min(ans , val);
    	arr[idx] = val;
    	dec[bno] = ans;
    }
    static int go(int l , int r) {
        int ans = inf;
        while (l <= r && l % s != 1) {
            ans = Math.min(ans , arr[l]);
            ++l;
        }
        while (l + s <= r) {
            ans = Math.min(ans , dec[(l + s - 1) / s]);
            l += s;
        }
        while (l <= r) {
            ans = Math.min(ans , arr[l]);
            ++l;
        }
        return ans;
    }
    static void solve()throws IOException {
        int n = f.ni(); int q = f.ni();
        arr = inpint(n);
        dec = new int[450]; Arrays.fill(dec , inf);
        // Preprocess
        int idx = 1; // block ptr
        s = (int)Math.ceil(Math.sqrt(n)); //block size
        for (int i = 1; i <= n; ++i) {
            dec[idx] = Math.min(dec[idx] , arr[i]);
            if (i % s == 0) ++idx;
        }
        while (q --> 0) {
            int l = f.ni(); int r = f.ni();
            pn(go(l , r));
        }
    }   

// Suffix array java
import java.util.*; 
class SuffixArray { 
	// Class to store information of a suffix 
	public static class Suffix implements Comparable<Suffix> { 
		int index; 
		int rank; 
		int next; 
		public Suffix(int ind, int r, int nr) { 
			index = ind; 
			rank = r; 
			next = nr; 
		} 
		
		// A comparison function used by sort() 
		// to compare two suffixes. 
		// Compares two pairs, returns 1 
		// if first pair is smaller 
		public int compareTo(Suffix s) { 
			if (rank != s.rank) return Integer.compare(rank, s.rank); 
			return Integer.compare(next, s.next); 
		} 
	} 
	
	// This is the main function that takes a string 'txt' 
	// of size n as an argument, builds and return the 
	// suffix array for the given string 
	public static int[] suffixArray(String s) { 
		int n = s.length(); 
		Suffix[] su = new Suffix[n]; 
		
		// Store suffixes and their indexes in 
		// an array of classes. The class is needed 
		// to sort the suffixes alphabatically and 
		// maintain their old indexes while sorting 
		for (int i = 0; i < n; i++) su[i] = new Suffix(i, s.charAt(i) - '$', 0);  
		for (int i = 0; i < n; i++) su[i].next = (i + 1 < n ? su[i + 1].rank : -1); 

		// Sort the suffixes using the comparison function 
		// defined above. 
		Arrays.sort(su); 

		// At this point, all suffixes are sorted 
		// according to first 2 characters. 
		// Let us sort suffixes according to first 4 
		// characters, then first 8 and so on 
		int[] ind = new int[n]; 
		
		// This array is needed to get the index in suffixes[] 
		// from original index. This mapping is needed to get 
		// next suffix. 
		for (int length = 4; length < 2 * n; length <<= 1) { 
			
			// Assigning rank and index values to first suffix 
			int rank = 0, prev = su[0].rank; 
			su[0].rank = rank; 
			ind[su[0].index] = 0; 
			for (int i = 1; i < n; i++) { 
				// If first rank and next ranks are same as 
				// that of previous suffix in array, 
				// assign the same new rank to this suffix 
				if (su[i].rank == prev && su[i].next == su[i - 1].next) { 
					prev = su[i].rank; 
					su[i].rank = rank; 
				} 
				else { 
					// Otherwise increment rank and assign 
					prev = su[i].rank; 
					su[i].rank = ++rank; 
				} 
				ind[su[i].index] = i; 
			} 
			
			// Assign next rank to every suffix 
			for (int i = 0; i < n; i++) { 
				int nextP = su[i].index + length / 2; 
				su[i].next = nextP < n ? 
				su[ind[nextP]].rank : -1; 
			} 
			
			// Sort the suffixes according 
			// to first k characters 
			Arrays.sort(su); 
		} 

		// Store indexes of all sorted 
		// suffixes in the suffix array 
		int[] suf = new int[n]; 
		
		for (int i = 0; i < n; i++) suf[i] = su[i].index; 

		// Return the suffix array 
		return suf; 
	}	 

	// Driver Code 
	public static void main(String[] args) { 
		String txt = "banana"; 
		int n = txt.length(); 
		int[] suff_arr = suffixArray(txt); 
	} 
} 

// This code is contributed by AmanKumarSingh