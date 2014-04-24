public class GivenSumSubarray {

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		subArraySum(arr, arr.length, 23);
	}

	public static boolean subArraySum(int arr[], int n, int sum) {

		int currsum = arr[0], start = 0, i;

		// if currsum exceeds then remove starting element

		for (i = 1; i <= n; i++) {
			while (currsum > sum && start < i - 1) {
				currsum = currsum - arr[start];
				start++;
			}
			if (currsum == sum) {
				System.out.printf("Sum indexes %d and %d", start, i - 1);
				return true;
			}
			if (i < n)
				currsum = currsum + arr[i];
		}
		System.out.printf("No subarray found");
		return false;
	}

}
