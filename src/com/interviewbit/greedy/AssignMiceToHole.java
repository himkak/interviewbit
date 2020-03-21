package com.interviewbit.greedy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class AssignMiceToHole {

	public int mice(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int maxDiff = 0;

		for (int i = 0; i < B.length; i++) {
			int tmpDiff = Math.abs(A[i] - B[i]);
			maxDiff = tmpDiff > maxDiff ? tmpDiff : maxDiff;
		}
		return maxDiff;
	}

	@Test
	public void test() {
		int[] a = { 4, -4, 2 };
		int[] b = { 4, 0, 5 };

		Assert.assertEquals(4, mice(a, b));

	}

	@Test
	public void test1() {
		int[] a = { -10, -79, -79, 67, 93, -85, -28, -94 };
		int[] b = { -2, 9, 69, 25, -31, 23, 50, 78 };

		Assert.assertEquals(102, mice(a, b));

	}

}
