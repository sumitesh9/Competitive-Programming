// Java program to print all combination of size r in an array of size n 
import java.io.*; 
class GFG { 

	/* arr[] ---> Input Array 
	data[] ---> Temporary array to store current combination 
	start & end ---> Staring and Ending indexes in arr[] 
	index ---> Current index in data[] 
	r ---> Size of a combination to be printed */
	static int gcd(int n1,int n2)
	{
		if(n2==0)
			return n1;
		else
			return gcd(n2,n1%n2);
	}
	static int res(int a,int b,int c,int d)
	{
		int sol=gcd(a,b);
		sol=gcd(sol,c);
		sol=gcd(sol,d);
		return sol;
	}
	static int count=1,f2=0,f3=0,f4=0,f5=0,f6=0,f7=0,f8=0;
	static void combinationUtil(int arr[], int n, int r, int index, 
								int data[], int i) 
	{ 
		// Current combination is ready to be printed, print it 
		if(index==r) 
		{   
		    System.out.print(count+" "); 
			int a=data[0],b=data[1],c=data[2],d=data[3];
			if(res(a,b,c,d)!=1)
			{
			     System.out.print(res(a,b,c,d)+"."+" ");
			     if(res(a,b,c,d)==2)
			     f2++;
			     else if(res(a,b,c,d)==3)
			     f3++;
			     else if(res(a,b,c,d)==4)
			     f4++;
			     else if(res(a,b,c,d)==5)
			     f5++;
			     else if(res(a,b,c,d)==6)
			     f6++;
			     else if(res(a,b,c,d)==7)
			     f7++;
			     else
			     f8++;
			}
			for(int j=0;j<r;j++)
			{
                System.out.print(data[j]+" ");
			}
			System.out.println("");
			count++;
		return; 
		} 
		// When no more elements are there to put in data[] 
		if(i>=n) 
		return; 
		// current is included, put next at next location 
		data[index] = arr[i]; 
		combinationUtil(arr, n, r, index+1, data, i+1); 
		// current is excluded, replace it with next (Note that 
		// i+1 is passed, but index is not changed) 
		combinationUtil(arr, n, r, index, data, i+1); 
	}
	// The main function that prints all combinations of size r 
	// in arr[] of size n. This function mainly uses combinationUtil() 
	static void printCombination(int arr[],int n,int r) 
	{ 
		// A temporary array to store all combination one by one 
		int data[]=new int[r]; 

		// Print all combination using temprary array 'data[]' 
		combinationUtil(arr, n, r, 0, data, 0); 
	} 

	/*Driver function to check for above function*/
	public static void main (String[] args) { 
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32}; 
		int r = 4; 
		int n = arr.length; 
		printCombination(arr, n, r); 
		System.out.println(f2+" "+f3+" "+f4+" "+f5+" "+f6+" "+f7+" "+f8);
	} 
} 
/* This code is contributed by Devesh Agrawal */