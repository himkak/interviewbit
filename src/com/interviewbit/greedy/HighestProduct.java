package com.interviewbit.greedy;

import org.junit.Assert;
import org.junit.Test;

public class HighestProduct {

	public int maxp3(int[] A) {
		int highestNum = Integer.MIN_VALUE;
		int secondHightestNum = Integer.MIN_VALUE;
		int thirdHightestNum = Integer.MIN_VALUE;
		int lowest = Integer.MAX_VALUE;
		int secondLowest = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {

			if (A[i] >= highestNum) {
				thirdHightestNum = secondHightestNum;
				secondHightestNum = highestNum;
				highestNum = A[i];
			} else if (A[i] >= secondHightestNum) {
				thirdHightestNum = secondHightestNum;
				secondHightestNum = A[i];
			} else if (A[i] > thirdHightestNum) {
				thirdHightestNum = A[i];
			} 
			if (A[i] < lowest) {
				secondLowest = lowest;
				lowest = A[i];
			} else if (A[i] < secondLowest) {
				secondLowest = A[i];
			}
		}
		

		return Math.max(highestNum * secondHightestNum * thirdHightestNum, highestNum * lowest * secondLowest);
	}
	
	@Test
	public void test4() {
		int[] A = {-1, -2, -3, -4, -5};
		Assert.assertEquals(24, maxp3(A));
	}


	@Test
	public void test() {
		int[] A = { 1, 2, 3, 4 };
		Assert.assertEquals(24, maxp3(A));
	}

	@Test
	public void test1() {
		int[] A = { 1, 3, 2, 4 };
		Assert.assertEquals(24, maxp3(A));
	}

	@Test
	public void test2() {
		int[] A = { 0, -1, 3, 100, -70, -50 };
		Assert.assertEquals(350000, maxp3(A));
	}

	@Test
	public void test3() {
		int[] A = { -10000000, 1, 2, 3, 4 };
		Assert.assertEquals(24, maxp3(A));
	}
}
