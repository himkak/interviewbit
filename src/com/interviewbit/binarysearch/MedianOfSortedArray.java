package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MedianOfSortedArray {

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		int totalSize = a.size() + b.size();
		int medianIndex = totalSize / 2 + 1;
		int aMin = a.size() > 0 ? a.get(0) : 0;
		int bMin = b.size() > 0 ? b.get(0) : 0;
		int minElem = Math.min(aMin, bMin);
		int aMax = a.size() > 0 ? a.get(a.size() - 1) : 0;
		int bMax = b.size() > 0 ? b.get(b.size() - 1) : 0;
		int maxElem = Math.max(aMax, bMax);
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		al.add(new ArrayList<>(a));
		al.add(new ArrayList<>(b));
		int mid = getMid(medianIndex, minElem, maxElem, al);
		int midPrev=0;
		if (totalSize % 2 == 0) {
			 midPrev = getMid(medianIndex - 1, minElem, maxElem, al);
			 return ((double)(mid+midPrev))/2;
		}
		return (double)mid;
	}

	private int getMid(int medianIndex, int minElem, int maxElem, ArrayList<ArrayList<Integer>> al) {
		while (minElem < maxElem ){
			int midElem = (minElem + maxElem) / 2;

			int noOfElemsLessThanEq = noOfElemsLessThanEqual(al, midElem);

			if (noOfElemsLessThanEq < medianIndex) {
				if(midElem + 1==minElem) {
					break;
				}
				minElem = midElem + 1;
			} else if (noOfElemsLessThanEq >= medianIndex) {
				if(maxElem == midElem) {
					break;
				}
				maxElem = midElem;
			}
		}
		return minElem;
	}

	private int noOfElemsLessThanEqual(ArrayList<ArrayList<Integer>> a, int mid) {
		int noOfElems = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).size() > 0)
				noOfElems = noOfElems + noOfElemsLessThan(a.get(i), mid);
		}
		return noOfElems;
	}

	private int noOfElemsLessThan(ArrayList<Integer> a, int elem) {
		int idx = getNoOfElemLessThanEqual(0, a.size() - 1, a, elem) + 1;
		return idx >= 0 ? idx : 0;
	}

	private int getNoOfElemLessThanEqual(int minIndex, int maxIndex, ArrayList<Integer> a, int elem) {
		int min = a.get(minIndex);
		int max = a.get(maxIndex);
		if (elem < min) {
			return minIndex - 1;
		} else {
			if (elem >= max) {
				return maxIndex;
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
				// return noOfElems >=0 ? noOfElems : 0;
			}
		}
	}
	
	@Test
	public void test5() {
		ArrayList<Integer> a = new ArrayList(Arrays.asList(-37, -10, -5, 5, 17, 34, 39 ));
		ArrayList<Integer> b = new ArrayList(Arrays.asList(-30, -27, -21, -21, 41));
		Assert.assertEquals(-7.5, findMedianSortedArrays(a, b), 0);
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList(Arrays.asList(1, 4, 5));
		ArrayList<Integer> b = new ArrayList(Arrays.asList(2, 3));
		Assert.assertEquals(3.0, findMedianSortedArrays(a, b), 0);
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList(Arrays.asList());
		ArrayList<Integer> b = new ArrayList(Arrays.asList(2, 3));
		Assert.assertEquals(2.5, findMedianSortedArrays(a, b), 0);
	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList(Arrays.asList());
		ArrayList<Integer> b = new ArrayList(Arrays.asList(20));
		Assert.assertEquals(20.0, findMedianSortedArrays(a, b), 0);
	}
	
	@Test
	public void test3() {
		ArrayList<Integer> a = new ArrayList(Arrays.asList(-50, -41, -40, -19, 5, 21, 28));
		ArrayList<Integer> b = new ArrayList(Arrays.asList(-50, -21, -10));
		Assert.assertEquals(-20.0, findMedianSortedArrays(a, b), 0);
	}
}
