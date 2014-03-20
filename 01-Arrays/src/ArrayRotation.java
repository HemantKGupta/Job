
public class ArrayRotation {

	public static void main(String[] args) {
		int[] ar = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		leftRotate(ar,2);
		printArray(ar);
		rotateByThreeReverese(ar,2, ar.length);
		printArray(ar);
		leftRotateBlockIter(ar, 2, ar.length);
		printArray(ar);
		//leftRotateBlockRecur(ar, 2, ar.length);
		printArray(ar);
	}
	
	/*Function to left rotate arr[] by d*/
	public static void leftRotate(int arr[], int d)
	{
	  int i;
	  for (i = 0; i < d; i++)
	    leftRotatebyOne(arr, arr.length);
	}
	 
	public static void leftRotatebyOne(int arr[], int n)
	{
	  int i, temp;
	  temp = arr[0];
	  for (i = 0; i < n-1; i++)
	     arr[i] = arr[i+1];
	  arr[i] = temp;
	}
	
	/*Function to left rotate arr[] of siz n by d*/
	void leftRotateJuggling(int arr[], int d, int n)
	{
	  int i, j, k, temp;
	  for (i = 0; i < gcd(d, n); i++)
	  {
	    /* move i-th values of blocks */
	    temp = arr[i];
	    j = i;
	    while(true)
	    {
	      // move j+d item to j	
	      k = j + d;
	      if (k >= n)
	        k = k - n;
	      if (k == i)
	        break;
	      arr[j] = arr[k];
	      j = k;
	    }
	    arr[j] = temp;
	  }
	}
	
	/*Fuction to get gcd of a and b*/
	public static int gcd(int a,int b)
	{
	   if(b==0)
	     return a;
	   else
	     return gcd(b, a%b);
	}
	
	/*Function to reverse arr[] from index start to end*/
	public static void rotateByThreeReverese(int arr[], int d, int n)
	{
		revereseArray(arr, 0, d-1);
		  revereseArray(arr, d, n-1);
		  revereseArray(arr, 0, n-1);
	}	
	public static void revereseArray(int arr[], int start, int end)
	{
	  int i;
	  int temp;
	  while(start < end)
	  {
	    temp = arr[start];
	    arr[start] = arr[end];
	    arr[end] = temp;
	    start++;
	    end--;
	  }
	}
	
	public static void leftRotateBlockRecur(int arr[], int d, int n)
	{ 
	  if(d == 0 || d == n)
	    return;
	  
	  if(n-d == d)
	  {
	    swap(arr, 0, n-d, d);   
	    return;
	  }  
	     
	 /* If A is shorter*/             
	  if(d < n-d)
	  {  
	    swap(arr, 0, n-d, d);
	    leftRotateBlockRecur(arr, d, n-d);    
	  }    
	  else /* If B is shorter*/             
	  {
	    swap(arr, 0, d, n-d);
	    leftRotateBlockRecur(arr, 2*d-n, d); /*This is tricky*/
	  }
	}
	
	public static void leftRotateBlockIter(int arr[], int d, int n)
	{
	  int i, j;
	  if(d == 0 || d == n)
	    return;
	  i = d;
	  j = n - d;
	  while (i != j)
	  {
	    if(i < j) /*A is shorter*/
	    {
	      swap(arr, d-i, d+j-i, i);
	      j -= i;
	    }
	    else /*B is shorter*/
	    {
	      swap(arr, d-i, d, j);
	      i -= j;
	    }
	    // printArray(arr, 7);
	  }
	  /*Finally, block swap A and B*/
	  swap(arr, d-i, d, i);
	}
	
	/*Swap d elements in arr from range (fi,fi+d) to (si, si+d)*/
	public static void swap(int arr[], int fi, int si, int d)
	{
	   int i, temp;
	   for(i = 0; i<d; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
	}
	
	public static void printArray(int[] arr){
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}

}
