package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMedian {

	public int findMedian1(ArrayList<ArrayList<Integer>> A) {
		// int median = -1;
		ArrayList<Integer> sortedList = new ArrayList<>();

		for (int i = 0; i < A.size(); i++) {
			mergeLists(sortedList, A.get(i));
		}
		int medIndex = sortedList.size() / 2 + sortedList.size() % 2;
		return sortedList.get(medIndex - 1);
	}

	private void mergeLists(ArrayList<Integer> sortedList, ArrayList<Integer> arrayList) {
		int i = 0;
		int j = 0;
		if (sortedList.size() == 0) {
			sortedList.addAll(arrayList);
		} else if (sortedList.get(0) > arrayList.get(arrayList.size() - 1)) {
			sortedList.addAll(0, arrayList);
		} else if (sortedList.get(sortedList.size() - 1) < arrayList.get(0)) {
			sortedList.addAll(arrayList);
		} else {

			while (j < arrayList.size()) {
				int elem = arrayList.get(j);
				if (i == 0 && elem <= sortedList.get(i)) {
					sortedList.add(i, elem);
					j++;
				} else if (i + 1 == sortedList.size() && elem >= sortedList.get(i)) {
					sortedList.addAll(arrayList.subList(j, arrayList.size()));
					break;
				} else if (i != 0 && elem >= sortedList.get(i - 1) && elem <= sortedList.get(i)) {
					sortedList.add(i, elem);
					j++;
				} else {
					i++;
				}
			}
		}

	}

	// ------------------------========================--------------------

	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int rows = A.size();
		int columns = A.get(0).size();

		int medianElemIndex = (rows * columns) / 2 + 1;
		int min = getMin(A);
		int max = getMax(A, rows, columns);

		while (min < max) {
			int mid = (min + max) / 2;

			int noOfElems = noOfElemsLessThanEqual(A, mid);
			if (noOfElems >= medianElemIndex) {
				max = mid;

			} else if (medianElemIndex > noOfElems) {
				min = mid + 1;
			}

		}
		return min;

	}

	private int noOfElemsLessThanEqual(ArrayList<ArrayList<Integer>> a, int mid) {
		int noOfElems = 0;
		for (int i = 0; i < a.size(); i++) {
			noOfElems = noOfElems + noOfElemsLessThan(a.get(i), mid);
		}
		return noOfElems;
	}

	private int noOfElemsLessThan(ArrayList<Integer> a, int elem) {
		int idx= getNoOfElemLessThanEqual(0, a.size() - 1, a, elem)+1;
		return idx>=0 ? idx : 0;
	}

	private int getNoOfElemLessThanEqual(int minIndex, int maxIndex, ArrayList<Integer> a, int elem) {
		int min = a.get(minIndex);
		int max = a.get(maxIndex);
		if (elem < min) {
			return minIndex-1;
		} else {
			if (elem >= max) {
				return maxIndex ;
			} else {
				int midIndex = (minIndex + maxIndex) / 2;
				int mid = a.get(midIndex);
				if (elem == mid) {
					return midIndex;
				} else if (elem < mid) {
					maxIndex = midIndex - 1;
				} else if (elem > mid) {
					minIndex = midIndex + 1;
				}
				return getNoOfElemLessThanEqual(minIndex, maxIndex, a, elem);
				//return noOfElems >=0 ? noOfElems : 0;
			}
		}
	}

	private int getMax(ArrayList<ArrayList<Integer>> a, int rows, int cols) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			int tmp = a.get(i).get(cols - 1);
			max = max > tmp ? max : tmp;
		}
		return max;
	}

	private int getMin(ArrayList<ArrayList<Integer>> a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.size(); i++) {
			int tmp = a.get(i).get(0);
			min = min < tmp ? min : tmp;
		}
		return min;
	}

	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(new ArrayList(Arrays.asList(1, 3, 5)));
		A.add(new ArrayList(Arrays.asList(2, 6, 9)));
		A.add(new ArrayList(Arrays.asList(3, 6, 9)));

		Assert.assertEquals(5, findMedian(A));

	}

	@Test
	public void test1() {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(new ArrayList(Arrays.asList(3)));
		A.add(new ArrayList(Arrays.asList(3)));
		A.add(new ArrayList(Arrays.asList(4)));

		Assert.assertEquals(3, findMedian(A));

	}

	@Test
	public void test2() {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(new ArrayList(Arrays.asList(2)));
		A.add(new ArrayList(Arrays.asList(1)));
		A.add(new ArrayList(Arrays.asList(4)));
		A.add(new ArrayList(Arrays.asList(1)));
		A.add(new ArrayList(Arrays.asList(2)));
		A.add(new ArrayList(Arrays.asList(2)));
		A.add(new ArrayList(Arrays.asList(5)));

		Assert.assertEquals(2, findMedian(A));

	}
	
	//1, 1, 1, 3, 3
	
	@Test
	public void test3() {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(new ArrayList(Arrays.asList(1, 1, 1, 3, 3)));

		Assert.assertEquals(1, findMedian(A));

	}

}
