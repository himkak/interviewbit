package com.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		helper(A, result, 0, new ArrayList<>());
		return result;
	}

	private void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, int startPtr,
			ArrayList<Integer> singlePrem) {
		if (singlePrem.size() == a.size()) {
			result.add(singlePrem);
			return;
		}
		if(startPtr==a.size()) {
			return;
		}
		for (int i = 0; i < a.size(); i++) {
			i = i % a.size();
			ArrayList<Integer> temp = new ArrayList<>(singlePrem);
			if (!temp.contains(a.get(i))) {
				temp.add(a.get(i));
			}
			helper(a, result, startPtr + 1, temp);

		}

	}

	@Test
	public void test() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
		permute(al);

	}

}
