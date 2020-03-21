package com.interviewbit.greedy;

import org.junit.Assert;
import org.junit.Test;

public class Bulbs {

	/*
	 * public int bulbs(int[] A) { int chances = 0; for (int i = 0; i < A.length;
	 * i++) { if (A[i] == 0) { chances++; updateBulbsState(A, i); }
	 * 
	 * } return chances; }
	 * 
	 * private void updateBulbsState(int[] a, int i) { for (int j = i+1; j <
	 * a.length; j++) { if (a[j] == 0) { a[j] = 1; } else { a[j] = 0; } }
	 * 
	 * }
	 */

	public int bulbs(int[] A) {
		int count = 0;
		int result = 0;
		for (int num : A) {
			if ((num == 1 && count % 2 != 0) || (num == 0 && count % 2 == 0)) {
				result++;
				count++;
			}

		}
		return result;
	}

	@Test
	public void test() {
		int[] A = { 1 };
		Assert.assertEquals(0, bulbs(A));
	}

	@Test
	public void test1() {
		int[] A = { 0, 1, 0, 1 };
		Assert.assertEquals(4, bulbs(A));
	}

}
