package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class NMaxPairCombination {

	 class SumIndexTuple {
		int sum;
		int aIndex;
		int bIndex;

		public SumIndexTuple(int sum, int aIndex, int bIndex) {
			super();
			this.sum = sum;
			this.aIndex = aIndex;
			this.bIndex = bIndex;
		}

		@Override
		public boolean equals(Object obj) {
			SumIndexTuple curr = (SumIndexTuple) obj;
			if (sum == curr.sum && aIndex == curr.aIndex && bIndex == curr.bIndex) {
				return true;
			}
			return super.equals(obj);
		}

		@Override
		public String toString() {
			return "sum:"+sum+",aIndex:"+aIndex+",bIndex:"+bIndex;
		}
		
		@Override
		public int hashCode() {
			return sum+aIndex+bIndex;
		}
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		int size = A.size();
		Collections.sort(A);
		Collections.sort(B);
		Comparator<SumIndexTuple> c = (o1, o2) -> Integer.valueOf(o2.sum).compareTo(Integer.valueOf(o1.sum));
		PriorityQueue<SumIndexTuple> maxHeap = new PriorityQueue<>(c);
		int highestSum = A.get(size - 1) + B.get(size - 1);
		Set<SumIndexTuple> alreadyAddedElems = new HashSet<>();
		SumIndexTuple t1 = new SumIndexTuple(highestSum, size - 1, size - 1);
		maxHeap.add(t1);
		alreadyAddedElems.add(t1);

		for (int k = 0; k < size; k++) {

			SumIndexTuple sumIdxTuple = maxHeap.poll();
			result.add(sumIdxTuple.sum);

			int i = sumIdxTuple.aIndex;
			int j = sumIdxTuple.bIndex;

			if (i > 0) {
				SumIndexTuple t2 = new SumIndexTuple(A.get(i - 1) + B.get(j), i - 1, j);
				if (!alreadyAddedElems.contains(t2)) {
					maxHeap.add(t2);
					alreadyAddedElems.add(t2);
				}
			}
			if (j > 0) {
				SumIndexTuple t3 = new SumIndexTuple(A.get(i) + B.get(j - 1), i, j - 1);
				if (!alreadyAddedElems.contains(t3)) {
					maxHeap.add(t3);
					alreadyAddedElems.add(t3);
				}
			}
		}
		return result;

	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6, 5));
		Assert.assertEquals(expected, solve(a, b));
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13,
				-24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6,
				-39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45,
				-25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36,
				44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21,
				-19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47,
				-31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(97, 95, 95, 95, 95, 94, 94, 93, 93, 93, 93, 92, 92,
				92, 92, 92, 92, 92, 91, 91, 91, 91, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 89, 89, 89, 89, 89, 89, 89,
				89, 88, 88, 88, 88, 88, 88, 88, 88, 87, 87, 87, 87, 87, 87, 87, 87, 87, 86, 86, 86, 86, 86, 86, 86, 86,
				85, 85, 85, 85, 85, 85, 85, 85, 84, 84, 84, 84, 84, 84, 84, 84, 84, 84));
		Assert.assertEquals(expected, solve(a, b));
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10, 9, 9, 8));
		Assert.assertEquals(expected, solve(a, b));
	}

}
