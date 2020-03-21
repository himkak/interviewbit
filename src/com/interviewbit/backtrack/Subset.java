package com.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class Subset {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(A);
		ArrayList<Integer> prev = new ArrayList<>();
		helper(A, result, 0, prev);

		return result;
	}

	private void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, int start, ArrayList<Integer> prev) {
		result.add(prev);
		for (int j = start; j < a.size(); j++) {
			ArrayList<Integer> next = new ArrayList<>(prev);
			next.add(a.get(j));
			helper(a, result, j + 1, next);
		}

	}

	@Test
	public void test() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<ArrayList<Integer>> result = subsets(al);

	}
}
