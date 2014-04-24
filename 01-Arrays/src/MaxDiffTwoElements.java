public class MaxDiffTwoElements {

	public static void main(String[] args) {
		int arr[] = { 100, 2, 6, 80, 1 };
		System.out.println(maxDiff(arr));
		System.out.println(maxDiff2(arr));
	}

	//max diff such that larger element appears after
	public static int maxDiff(int arr[]) {
		int size = arr.length;
		int maxDiff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < size; i++) {
			if (arr[i] - min_element > maxDiff)
				maxDiff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return maxDiff;
	}

	//max diff such that larger element appears after
	public static int maxDiff2(int arr[]) {
		int n = arr.length;
		// diff holds difference of adjacent elements
		int[] diff = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			diff[i] = arr[i + 1] - arr[i];

		//Use Kadane maximum sum subarray in diff 
		int maxDiff = diff[0];
		for (int i = 1; i < n - 1; i++) {
			if (diff[i - 1] > 0)
				diff[i] += diff[i - 1];
			if (maxDiff < diff[i])
				maxDiff = diff[i];
		}
		return maxDiff;
	}

}
