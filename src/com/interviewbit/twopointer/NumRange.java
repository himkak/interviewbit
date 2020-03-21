package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NumRange {

	public int numRange(ArrayList<Integer> A, int B, int C) {

		int noOfElems = 0;
		// ArrayList<Integer> elems = new ArrayList<>();
		int prevSum = 0;

		for (int i = 0; i < A.size(); i++) {
			prevSum = 0;
			if (A.get(i) <= C) {
				for (int j = i; j < A.size(); j++) {
					if (isInBetween(A.get(j) + prevSum, B, C)) {
						noOfElems++;
						System.out.println("i:" + i + ", j:" + j+", sum:"+ (A.get(j) + prevSum));
					}
					prevSum = prevSum + A.get(j);
					if (prevSum > C) {
						prevSum = 0;
						break;
					}
				}
			}
		}

		/*
		 * while (left < right) { if (isInBetween(prevSum + A.get(left), B, C)) {
		 * noOfElems++; } if (isInBetween(prevSum + A.get(right), B, C)) { noOfElems++;
		 * }
		 * 
		 * if (prevSum>0 && isInBetween(prevSum + A.get(right) + A.get(left), B, C)) {
		 * noOfElems++; }
		 * 
		 * if (isInBetween(A.get(right) + A.get(left), B, C)) { noOfElems++; } prevSum =
		 * A.get(left) + A.get(right); if (A.get(left) > A.get(right)) { left++; } else
		 * if (A.get(left) < A.get(right)) { right--; } else { left++; right--; } if
		 * (prevSum > C) { prevSum = 0; }
		 * 
		 * }
		 */ return noOfElems;
	}

	private boolean isInBetween(int sum, int b, int c) {
		return sum >= b && sum <= c;
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, 5, 1, 0, 2));
		Assert.assertEquals(3, numRange(a, 6, 8));
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(
				Arrays.asList(80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90));
		Assert.assertEquals(58, numRange(a, 99, 269));
	}
}
