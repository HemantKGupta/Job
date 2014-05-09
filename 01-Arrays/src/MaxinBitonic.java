public class MaxinBitonic {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 50, 10, 9, 7, 6 };
		System.out.println(findMaximum(arr, 0, arr.length - 1));
	}

	public static int findMaximum(int arr[], int low, int high) {

		//Only one element
		if (low == high)
			return arr[low];

		// first is greater then second
		if ((high == low + 1) && arr[low] >= arr[high])
			return arr[low];

		// second is greater then first
		if ((high == low + 1) && arr[low] < arr[high])
			return arr[high];

		int mid = (low + high) / 2; /* low + (high - low)/2; */

		// arr[mid] is greater than both
		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
			return arr[mid];

		if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
			return findMaximum(arr, low, mid - 1);
		else
			return findMaximum(arr, mid + 1, high);
	}

}
