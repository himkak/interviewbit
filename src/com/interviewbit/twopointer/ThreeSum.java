package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSum {

	public int threeSumClosest(ArrayList<Integer> A, int B) {
		int sum = 0;
		int minDiff = Integer.MAX_VALUE;
		Collections.sort(A);
		for (int i = 0; i < A.size() - 2; i++) {
			int pending = B - A.get(i);

			int twoSum = twoSum(A, i, pending);
			int diff = Math.abs(B - (A.get(i) + twoSum));

			if (minDiff >= diff) {
				sum = A.get(i) + twoSum;
				minDiff = diff;
			}
		}

		return sum;

	}

	private int twoSum(ArrayList<Integer> a, int i, int pending) {
		int minDiff = Integer.MAX_VALUE;
		int finalSum = 0;
		int startPtr = i + 1;
		int endPtr = a.size() - 1;

		while (startPtr < endPtr) {
			int sum = a.get(startPtr) + a.get(endPtr);
			int diff = Math.abs(pending - sum);
			if (minDiff >= diff) {
				minDiff = diff;
				finalSum = sum;
			}

			if (sum > pending) {
				endPtr--;
			} else if (sum < pending) {
				startPtr++;
			} else {
				endPtr--;
				startPtr++;
			}

		}
		return finalSum;
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1, 2, 1, -4));
		Assert.assertEquals(2, threeSumClosest(a, 1));
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(
				Arrays.asList(-6, 1, -4, -1, 8, -4, 9, 0, -3, 7, -3, 2, -4, -2, 3, -4, 10, 0, 9, 6, 1, 3, 4, 2));
		Assert.assertEquals(-3, threeSumClosest(a, -3));
	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10));
		Assert.assertEquals(5, threeSumClosest(a, 5));
	}
}
