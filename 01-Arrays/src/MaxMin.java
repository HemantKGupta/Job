
public class MaxMin {

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		System.out.println(getMinMax(arr,0,arr.length-1).max);
		System.out.println(getMinMax(arr,0,arr.length-1).min);
	}
	public static pair getMinMax(int arr[], int low, int high){
	  pair minmax = new pair();
	  pair mml = new pair();
	  pair mmr = new pair();;       
	  int mid;
	   
	  /* If there is only on element */
	  if (low == high)
	  {
	     minmax.max = arr[low];
	     minmax.min = arr[low];     
	     return minmax;
	  }    
	   
	  /* If there are two elements */
	  if (high == low + 1)
	  {  
	     if (arr[low] > arr[high])  
	     {
	        minmax.max = arr[low];
	        minmax.min = arr[high];
	     }  
	     else
	     {
	        minmax.max = arr[high];
	        minmax.min = arr[low];
	     }  
	     return minmax;
	  }
	   
	  /* If there are more than 2 elements */
	  mid = (low + high)/2;  
	  mml = getMinMax(arr, low, mid);
	  mmr = getMinMax(arr, mid+1, high);  
	   
	  /* compare minimums of two parts*/
	  if (mml.min < mmr.min)
	    minmax.min = mml.min;
	  else
	    minmax.min = mmr.min;     
	 
	  /* compare maximums of two parts*/
	  if (mml.max > mmr.max)
	    minmax.max = mml.max;
	  else
	    minmax.max = mmr.max;     
	  
	  return minmax;
	}
	


}

class pair{
	int max;
	int min;
}
 
