
public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};
		System.out.println(solution(A));
	}
	
	public static int solution(int A[]) {
		if(A.length == 0 || A.length ==1){
			return 0;
		}
		if(A.length==2){
			return Math.abs(A[0]-A[1]);
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum +=A[i];
		}
		System.out.println("sum is: "+sum);
		int minDiff = Math.abs(sum-(2*A[0]));
		int currentSum = A[0];
		for (int i = 1; i < A.length; i++) {
			currentSum += A[i];
			//System.out.println("currentSum is: "+currentSum);
			int remainSum = sum -currentSum;
			//System.out.println("remainSum is: "+remainSum);
			int currentDiff = Math.abs(currentSum-remainSum);
			//System.out.println("currentDiff is: "+currentDiff);
			if (minDiff > currentDiff){
				minDiff = currentDiff;
			}
			//System.out.println("minDiff is: "+minDiff);		
		}
		return minDiff;
	   
	}

}
