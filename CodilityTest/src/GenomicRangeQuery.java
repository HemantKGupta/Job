import java.util.Arrays;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		String S = "GACACCATA";
		int[] P = {0, 0, 4, 7 };
		int[] Q = {8, 2, 5, 7 };
		System.out.println(Arrays.toString(solution(S, P, Q)));
	}

	public static int[] solution(String S, int[] P, int[] Q) {
		int n = S.length();
		char [] prefixMin = S.toCharArray();
		for (int i = 1; i < n; i++) {
			char val = prefixMin[i];
			if(val < prefixMin[i-1]){
				prefixMin[i] =val;
			}
		}
		int M = P.length;
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			result[i] = findMin(prefixMin,P[i],Q[i]);
		}
		return result;

	}
	
	private static int findMin(char[] prefixMin, int start, int end){
		char min = prefixMin[end];
		
		if (min=='A'){
			return 1;
		}else if(min=='C'){
			return 2;
		}else if (min=='G'){
			return 3;
		}
		return 4;
	}

	private static int findMinInString2(String s, int i, int j) {
		int result = 0;
		char min;
		if (i == j) {
			 min = s.charAt(i);
		} else {
			char[] dst = new char[j - i+1];
			System.out.println(" i is: "+ i);
			System.out.println(" j is: "+ j);
			System.out.println("The dist is: "+ Arrays.toString(dst));
			s.getChars(i, j+1, dst, 0);
			min = dst[0];
			for (char c : dst) {
				if (min > c) {
					min = c;
				}
				if (min=='A'){
					break;
				}

			}
		}
		System.out.println(min);
		switch (min) {
		case 'A':
			result = 1;
			break;
		case 'C':
			result = 2;
			break;
		case 'G':
			result = 3;
			break;
		case 'T':
			result = 4;
			break;
		}
		//System.out.println(result);
		return result;
	}
	
	private static int findMinInString(String s, int i, int j) {
		
		String target = s.substring(i, j+1);
		int result = 0;
		if(target.indexOf('A')!= -1){
			return 1;
		}else if(target.indexOf('C')!= -1){
			return 2;
		}else if(target.indexOf('G')!= -1){
			return 3;
		}else if ( target.indexOf('T')!= -1){
			return 4;
		}
		
		return result ;
	}

}
