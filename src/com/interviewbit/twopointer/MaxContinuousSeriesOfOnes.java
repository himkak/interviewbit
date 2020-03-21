package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxContinuousSeriesOfOnes {

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

		int maxNoOfOnes = 0;
		int biggestSeriesStartIdx = -1;

		int left = 0;
		int right = 0;
		int noOfZeros = 0;

		while (right < A.size()) {

			if (noOfZeros <= B) {
				if (A.get(right) == 0) {
					noOfZeros++;
				}
				right++;
			}

			if (noOfZeros > B) {
				if (A.get(left) == 0) {
					noOfZeros--;
				}
				left++;
			}

			if ((right - left) > maxNoOfOnes) {
				biggestSeriesStartIdx = left;
				maxNoOfOnes = right - left;
			}

		}

		ArrayList<Integer> res = new ArrayList<>();
		for (int j = biggestSeriesStartIdx; j < biggestSeriesStartIdx + maxNoOfOnes; j++) {
			res.add(j);
		}

		return res;
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		Assert.assertEquals(expected, maxone(a, 1));
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 1, 1, 1));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
		Assert.assertEquals(expected, maxone(a, 0));
	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
		Assert.assertEquals(expected, maxone(a, 2));
	}

	@Test
	public void test3() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
		Assert.assertEquals(expected, maxone(a, 4));
	}

	@Test
	public void test4() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1,
				1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32));
		Assert.assertEquals(expected, maxone(a, 7));
	}

}
