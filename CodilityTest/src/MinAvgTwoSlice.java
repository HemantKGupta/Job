public class MinAvgTwoSlice {

	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test() {
		int[] ar = { 4, 2, 2, 5, 1, 5, 8};
		int start = 0;
		int oldStart = 0;
		
		float oldAvg = (4 + 2) / 2;
		float currentAvg = (4 + 2) / 2;
		
		int oldSum = 4 + 2;		
		int currentSum = 4 + 2;

		for (int i = 2; i < ar.length; i++) {
			if (ar[i] < currentAvg) {
				while(ar[start]> ar[i]){
					currentSum = currentSum -ar[start];
					start++;
				}
				currentSum = currentSum + ar[i];
				currentAvg = currentSum /(i-start+1);
			} else {
				oldStart = start;
				oldAvg = currentAvg;
				oldSum = currentSum;
				start = i;
				currentSum = ar[i];
				currentAvg = ar[i];
			}
		}
		
		if (currentAvg > oldAvg){
			return oldStart;
		}
		
		return start;
	}

}
