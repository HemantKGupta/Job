
public class PassingCars {

	public static void main(String[] args) {
		int[] A = {1,0,1};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		long n = A.length;
		if(n==1){
			return 0;
		}
		long result = 0;
		long zeros = 0;
		if(A[0]== 0)
			zeros++;
		for (int i = 1; i < n ; i++) {
			int current = A[i];
				if(current == 1){					
					result = result + zeros;
				}else{
					zeros++;
				}
			}		
		if (result > 1000000000)
			return -1;
		return (int) result;
    }
	
	public static int solution2(int[] A) {
		long n = A.length;
		if (n == 2){
			if(A[0]== 0 && A[1]==1){
				return 1;
			}else{
				return 0;
			}
		}
		long result = 0;
		long zeros = 0;
		
		if(A[0]== 0)
			zeros++;
		
		for (long i = 2; i < n ; i++) {
			int current = A[(int)i];
			int previous = A[(int)(i-1)];
				if(current == 1){					
					result = result + zeros;
				}				
				if (previous != current){
					result++;
				}
				if (previous == 0){
					zeros++;
				}
				
			}		
		if (result > 1000000000)
			return -1;
		return (int) result;
    }

}
