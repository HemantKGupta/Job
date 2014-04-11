import java.util.Arrays;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int[] A = { 5, 3, 6, 3, 4, 2 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		if (A.length == 0 || A.length == 1) {
			return 0;
		}
		NavigableMap<Data, Integer> map = new TreeMap<Data, Integer>();
		int[] dist = new int[A.length];
		SortedMap<Data, Integer> lower = null;
		map.put(new Data(0, A[0]), 0);
		
		for (int i = 1; i < A.length; i++) {
			lower = map.headMap(new Data(i, A[i]), true);
			System.out.println("For i : "+ i);
			System.out.println("lower: "+ lower);
			map.put(new Data(i, A[i]), i);
			for (Entry<Data, Integer> e : lower.entrySet()) {
				int index = e.getValue();
				dist[index] = i - index;
			}
			lower = null;
		}
		System.out.println(Arrays.toString(dist));
		int max = 0;
		for (int i = 0; i < dist.length; i++) {
			if (max < dist[i]) {
				max = dist[i];
			}
		}
		return max;
	}
}

class Data implements Comparable<Data>{
	public int value;
	public int index;
	public Data(int index,int value) {
		this.value= value;
		this.index = index;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (index != other.index)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public int compareTo(Data o) {
		int result = this.value - o.value;
		if (result == 0){
			result = this.index - o.index;
		}
		return result;
	}
	
	@Override
	public String toString() {
		
		return "index: "+index+" and value: "+value;
	}
	
}
