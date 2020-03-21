import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(-1);
		System.out.println(new MaximumAbsoluteDifference().maxArr(a));
	}

	public int maxArr(ArrayList<Integer> A) {
		// List<Integer> sorted=new ArrayList<>(A);
		// Comparator<Integer> comp=(a,b)->;
		// Collections.sort(sorted,comp);
		// int maxValue = Integer.MIN_VALUE;
		/*
		 * for (int i = 1; i <= A.size(); i++) { for (int j = 1; j <= A.size(); j++) {
		 * // System.out.println("elems:i" + i + ",j:" + j); if (i != j) { int value =
		 * Math.abs(A.get(i - 1) - A.get(j - 1)) + Math.abs(i - j); maxValue = maxValue
		 * < value ? value : maxValue; } } }
		 */
		/*
		 * int maxElem=sorted.get(A.size()-1); int minElem=sorted.get(0);
		 * 
		 * int maxElemIndex=A.indexOf(maxElem); int minElemIndex=A.indexOf(minElem);
		 * return Math.abs(maxElem-minElem)+Math.abs(maxElemIndex-minElemIndex);
		 */
		int maxAiPlusI = Integer.MIN_VALUE;
		int minAiMinusI = Integer.MAX_VALUE;
		for (int i = 1; i <= A.size(); i++) {
			// for (int j = 1; j <= A.size(); j++) {
			int AiPlusI = A.get(i) + i;
			int AiMinusI = A.get(i) - i;
			maxAiPlusI = AiPlusI > maxAiPlusI ? AiPlusI : maxAiPlusI;
			minAiMinusI = AiMinusI < minAiMinusI ? AiMinusI : minAiMinusI;
			// }
			System.out.println(maxAiPlusI+","+minAiMinusI);
		}
		return maxAiPlusI;
		
	}

}
