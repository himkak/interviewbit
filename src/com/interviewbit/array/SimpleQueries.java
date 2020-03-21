package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SimpleQueries {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j <= A.size(); j++) {

				List<Integer> subList = A.subList(i, j);
				int elem = getMax(subList);

				list.add(findDivisorSProd(elem));
			}
		}
		Collections.sort(list, (x, y) -> Integer.compare(y, x));

		ArrayList<Integer> queryResult = new ArrayList<>();

		for (int i = 0; i < B.size(); i++) {
			queryResult.add(list.get(B.get(i) - 1));
		}

		return queryResult;

	}

	private int findDivisorSProd(int elem) {
		int prod = 1;
		for (int i = 2; i <= elem; i++) {
			if (elem % i == 0) {
				prod = prod * i%1000000007;
			}
		}
		return  prod ;
	}

	private int getMax(List<Integer> subList) {
		int max = Integer.MIN_VALUE;

		for (int i : subList) {
			max = i > max ? i : max;
		}
		return max;
	}

	@Test
	public void test() {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(8, 8, 8, 2, 2, 1));

		Assert.assertEquals(expected, solve(A, B));

	}

	@Test
	public void test1() {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90,
				32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45,
				40, 95, 94, 86, 2, 89, 57, 52, 91, 45));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310,
				403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(7569, 1000000000, 1000000000, 440996283, 778688,
				1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 83, 1000000000, 440996283, 778688, 3364,
				59969536, 1000000000, 1000000000, 7569, 1000000000, 970299, 1000000000, 59969536, 1000000000, 970299));

		Assert.assertEquals(expected, solve(A, B));

	}

}
