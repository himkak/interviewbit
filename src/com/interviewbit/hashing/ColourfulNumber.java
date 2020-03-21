package com.interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ColourfulNumber {
	public int colorful(int A) {
		char[] numbers = Integer.toString(A).toCharArray();
		Set<Integer> numsCombination = new HashSet<>();
		boolean result = getAllCombinations(numbers, 0, numsCombination, 1);

		return result ? 1 : 0;
	}

	private boolean getAllCombinations(char[] numbers, int startPt, Set<Integer> prodColl, int prevMul) {
		if (startPt >= numbers.length) {
			return true;
		}

		for (int i = startPt; i < numbers.length; i++) {
			int elem = Integer.parseInt(String.valueOf(numbers[i]));
			int mul = elem * prevMul;
			if (prodColl.contains(mul)) {
				return false;
			}
			prodColl.add(mul);

			if (!helper(numbers, i + 1, prodColl, mul))
				return false;
		}
		return true;
	}

	private boolean helper(char[] numbers, int startPt, Set<Integer> prodColl, int prevMul) {
		if (startPt >= numbers.length) {
			return true;
		}

		int elem = Integer.parseInt(String.valueOf(numbers[startPt]));
		int mul = elem * prevMul;
		if (prodColl.contains(mul)) {
			return false;
		}
		prodColl.add(mul);

		return helper(numbers, startPt + 1, prodColl, mul);

	}

	@Test
	public void test4() {

		Assert.assertEquals(0, colorful(231));

	}

	@Test
	public void test() {

		Assert.assertEquals(1, colorful(23));

	}

	@Test
	public void test1() {

		Assert.assertEquals(1, colorful(3245));

	}

	@Test
	public void test2() {

		Assert.assertEquals(0, colorful(121));

	}

	@Test
	public void test3() {

		Assert.assertEquals(0, colorful(422));

	}
}
