
public class FindInPivotedArray {

	public static void main(String[] args) {
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		System.out.println(pivotedBinarySearch(arr1,9,2));
	}
	
	public static int pivotedBinarySearch(int arr[], int arr_size, int no)
	{
	   int pivot = findPivot(arr, 0, arr_size-1);
	 
	   if (pivot == -1)
	     return binarySearch(arr, 0, arr_size-1, no);
	 
	   if (arr[pivot] == no)
	     return pivot;
	   if (arr[0] <= no)
	     return binarySearch(arr, 0, pivot-1, no);
	   else
	     return binarySearch(arr, pivot+1, arr_size-1, no);
	}
	 
	/* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will
	   return 3. If array is not rotated at all, then it returns -1 */
	public static int findPivot(int arr[], int low, int high)
	{
	   // base cases
	   if (high < low)  return -1;
	   if (high == low) return low;
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	   if (mid < high && arr[mid] > arr[mid + 1])
	     return mid;
	   if (mid > low && arr[mid] < arr[mid - 1])
	     return (mid-1);
	   if (arr[low] >= arr[mid])
	     return findPivot(arr, low, mid-1);
	   else
	     return findPivot(arr, mid + 1, high);
	}
	 
	/* Standard Binary Search function*/
	public static int binarySearch(int arr[], int low, int high, int no)
	{
	   if (high < low)
	       return -1;
	   int mid = (low + high)/2;  /*low + (high - low)/2;*/
	   if (no == arr[mid])
	     return mid;
	   if (no > arr[mid])
	     return binarySearch(arr, (mid + 1), high, no);
	   else
	     return binarySearch(arr, low, (mid -1), no);
	}

}
