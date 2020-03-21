package com.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String a) {

		char[] aArr = a.toCharArray();
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		helper(aArr, result, 0, null);
		return result;
	}

	private void helper(char[] aArr, ArrayList<ArrayList<String>> result, int startPtr, ArrayList<String> perRec) {
		if (startPtr >= aArr.length) {
			if (!result.contains(perRec) && perRec.size() > 0) {
				result.add(perRec);
			}
			return;
		}
		for (int j = startPtr; j < aArr.length; j++) {
			ArrayList<String> tempPerRec = null;
			if (perRec != null) {
				tempPerRec = new ArrayList<>(perRec);
			}
			if (startPtr == 0) {
				tempPerRec = new ArrayList<>();
			}
			String str = getSubArr(aArr, startPtr, j);
			if (checkIfPalindrome(str)) {
				tempPerRec.add(str);
				helper(aArr, result, j + 1, tempPerRec);
			}
		}

	}

	private String getSubArr(char[] aArr, int startPtr, int j) {
		StringBuilder sb = new StringBuilder();
		for (int i = startPtr; i < aArr.length && i < j + 1; i++) {
			sb.append(aArr[i]);
		}
		return sb.toString();
	}

	private boolean checkIfPalindrome(String s) {

		if (s == null || s.isEmpty()) {
			return false;
		}
		char[] chArr = s.toCharArray();
		if (chArr.length == 1) {
			return true;
		} else {
			int leftPtr = 0;
			int rightPtr = chArr.length - 1;
			for (int i = 0; i < chArr.length / 2; i++) {
				if (chArr[leftPtr] != chArr[rightPtr]) {
					return false;
				}
				leftPtr++;
				rightPtr--;
			}

		}

		return true;

	}

	@Test
	public void test() {
		ArrayList<ArrayList<String>> result = partition("aab");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		expected.add(new ArrayList(Arrays.asList("a", "a", "b")));
		expected.add(new ArrayList(Arrays.asList("aa", "b")));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void test1() {
		ArrayList<ArrayList<String>> result = partition("efe");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		expected.add(new ArrayList(Arrays.asList("e", "f", "e")));
		expected.add(new ArrayList(Arrays.asList("efe")));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void test2() {
		ArrayList<ArrayList<String>> result = partition("cccaacbcaabb");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		expected.add(new ArrayList(Arrays.asList("e", "f", "e")));
		expected.add(new ArrayList(Arrays.asList("efe")));

		Assert.assertEquals(expected, result);
	}

}
