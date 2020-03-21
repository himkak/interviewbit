package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxContinuousSeriesOfOnesBruteForce {

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

		int maxNoOfOnes = 0;
		int biggestSeriesStartIdx = -1;
		int biggestSeriesEndIdx = -1;

		for (int j = 0; j < A.size(); j++) {
			int startIdx = -1;
			int endIdx = -1;
			int noOfOnes = 0;
			int noOfFlipsPossible = B;

			if (!(j < 0 && A.get(j - 1) == 1)) {

				for (int i = j; i < A.size(); i++) {
					int elem = A.get(i);

					if (elem == 1) {
						if (startIdx == -1) {
							startIdx = i;
						}
						noOfOnes++;
					}

					if (elem == 0 && noOfFlipsPossible > 0) {
						noOfFlipsPossible--;
						noOfOnes++;
						if (startIdx == -1) {
							startIdx = i;
						}
					} else if (elem == 0 && noOfFlipsPossible == 0 && endIdx == -1) {
						endIdx = i - 1;
						if (noOfOnes > maxNoOfOnes) {
							maxNoOfOnes = noOfOnes;
							biggestSeriesStartIdx = startIdx;
							biggestSeriesEndIdx = endIdx;
							startIdx = -1;
							endIdx = -1;
							noOfFlipsPossible = B;
							noOfOnes = 0;
						} else if (noOfOnes == maxNoOfOnes && startIdx < biggestSeriesStartIdx) {
							maxNoOfOnes = noOfOnes;
							biggestSeriesStartIdx = startIdx;
							biggestSeriesEndIdx = endIdx;
							startIdx = -1;
							endIdx = -1;
							noOfFlipsPossible = B;
							noOfOnes = 0;
						}
					}
					if (endIdx == -1 && i == A.size() - 1) {
						endIdx = i;
						if (noOfOnes > maxNoOfOnes) {
							maxNoOfOnes = noOfOnes;
							biggestSeriesStartIdx = startIdx;
							biggestSeriesEndIdx = endIdx;
							startIdx = -1;
							endIdx = -1;
							noOfFlipsPossible = B;
							noOfOnes = 0;
						} else if (noOfOnes == maxNoOfOnes && startIdx < biggestSeriesStartIdx) {
							maxNoOfOnes = noOfOnes;
							biggestSeriesStartIdx = startIdx;
							biggestSeriesEndIdx = endIdx;
							startIdx = -1;
							endIdx = -1;
							noOfFlipsPossible = B;
							noOfOnes = 0;
						}
					}

				}
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int j = biggestSeriesStartIdx; j <= biggestSeriesEndIdx; j++) {
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
