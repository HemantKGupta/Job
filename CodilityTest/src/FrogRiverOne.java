
public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = { 1,3,1,4,2,3,5,4};
		System.out.println(solution(5,A));
	}
	public static int solution(int X, int[] A) {
		int n = A.length;
		if (n == 1){			
				return 0;
		}
		
		for (int i = 0; i < A.length; i++) {
			if (A[i]== X){				
				if( searchLess (A, i, X)){
					return i;
				}
			}
		}
		
		return -1;
    }
	
	private static boolean searchLess(int[] A, int end, int maxValue){
		
	    boolean [] foundValues = new boolean [maxValue-1];
		for (int val=1; val < maxValue; val++ ){
			for (int i=0; i < end; i++){
				if (val == A[i]){
					foundValues[val-1]= true;
					break;
				}
		     }
		}
	    for (int i = 0; i < foundValues.length; i++) {
	    	if (foundValues[i]== false){
	    		return false;
	    	}
		}
	    
	    return true;
	}

}
