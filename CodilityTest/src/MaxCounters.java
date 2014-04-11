import java.util.Arrays;


public class MaxCounters {

	public static void main(String[] args) {
		int[] A = {1,2,4,1,4};
		System.out.println(Arrays.toString(solution(3,A)));
	}
	
	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		for (int val : A) {
			if (val <= N){
				counters[val-1] = counters[val-1] +1;
			}else if (val == N+1){
				int max = getMaxCounter(counters);
				Arrays.fill(counters, max);				
			}
		}
		return counters;
    }
	private static int getMaxCounter(int[] counters){
		int max = 0;
		for (int value : counters) {
			if(max < value){
				max= value;
			}
		}
		return max;
	}
	
	private static int getMaxCounter2(int[] counters){
		int len = counters.length;
		int[] copy = Arrays.copyOf(counters,len);
		Arrays.sort(copy);
		return copy[len-1];
	}

}
