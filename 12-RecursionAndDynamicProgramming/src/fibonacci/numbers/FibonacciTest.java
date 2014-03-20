package fibonacci.numbers;

public class FibonacciTest {
	private static final int MAX = 100;
	private static final int NIL = -1;
	private static int[] lookup = new int[MAX];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] fib = new int [5]; 
		 fib = fibDynamic(5);
		 for (int i = 0; i < fib.length; i++) {
			
			 System.out.print(fib[i]+" ");
		}
		System.out.println("fib 7 is: "+ fibTwoTemp(7)); 
		 
	}
	public static int fibRecur(int n)
	{
	   if (n == 1|| n== 0)
	      return n;
	   return fibRecur(n-1) + fibRecur(n-2);
	}
	public static int[] fibDynamic(int n)
	{
		  /* Declare an array to store fibonacci numbers. */
		  int[] f = new int [n+1];
		  int i;
		 
		  /* 0th and 1st number of the series are 0 and 1*/
		  f[0] = 0;
		  f[1] = 1;
		 
		  for (i = 2; i <= n; i++)
		  {
		      /* Add the previous 2 numbers in the series
		         and store it */
		      f[i] = f[i-1] + f[i-2];
		  }
		 
		  return f;
	}
	
	public static void initialize()
	{
	  int i;
	  for (i = 0; i < MAX; i++)
	    lookup[i] = NIL;
	}
	 
	/* function for nth Fibonacci number */
	public static int fib(int n)
	{
	   if(lookup[n] == NIL)
	   {
	    if ( n <= 1 )
	      lookup[n] = n;
	    else
	      lookup[n] = fib(n-1) + fib(n-2);
	   }
	 
	   return lookup[n];
	}
	public static int fibTwoTemp(int n)
	{
		  int a = 0, b = 1, c, i;
		  if( n == 0)
		    return a;
		  if (n == 1)
			  return b;
		  
		  for (i = 2; i <= n; i++)
		  {
		     c = a + b;
		     a = b;
		     b = c;
		  }
		  return b;
		}
}
