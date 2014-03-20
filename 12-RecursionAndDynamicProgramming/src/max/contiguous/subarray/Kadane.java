package max.contiguous.subarray;
public class Kadane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSum = maxSumOfSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
		System.out.println(maxSum);
	}

	public static int maxSumOfSubArray(int[] array) {
		int maxSoFar = 0;
		int maxSumEndingHere = 0;
		for (int i = 0; i < array.length; i++) {
			maxSumEndingHere = Math.max(0, array[i] + maxSumEndingHere);
			maxSoFar = Math.max(maxSoFar, maxSumEndingHere);
		}
		return maxSoFar;
	}

	public static int[] maxSumOfSubArrayWithIndex(int[] array) {

		int maxSoFar = 0, maxSumEndingHere = 0;
		// Four pointers 2 each to keep the start and end of max sub array till
		// now and current max array
		int startOfMaxSoFar = 0, endofMaxSoFar = 0, startOfMaxSumEndingHere = 0, endOfMaxSumEndingHere = 0;
		for (int i = 0; i < array.length; i++) {
			int sum = array[i] + maxSumEndingHere;
			// if sum is greater than zero, then update the current maxSum and
			// also the end index
			if (0 < sum) {
				maxSumEndingHere = sum;
				endOfMaxSumEndingHere = i;
				// sum has gone negative, reset the start and end index of
				// current maxSum sub array to next index
			} else {
				maxSumEndingHere = 0;
				startOfMaxSumEndingHere = i + 1;
				endOfMaxSumEndingHere = startOfMaxSumEndingHere;
			}
			// If maxSoFar is getting updated, update the start and end indices
			// also
			if (maxSoFar < maxSumEndingHere) {
				maxSoFar = maxSumEndingHere;
				startOfMaxSoFar = startOfMaxSumEndingHere;
				endofMaxSoFar = endOfMaxSumEndingHere;
			}
		}
		int[] subArray = new int[endofMaxSoFar - startOfMaxSoFar + 1];
		System.arraycopy(array, startOfMaxSoFar, subArray, 0, subArray.length);
		return subArray;
	}

}
