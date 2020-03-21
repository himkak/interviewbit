package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Anagrams {

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		Map<String, ArrayList<Integer>> hashCodeIndexMapping = new LinkedHashMap<>();
		for (int i = 0; i < A.size(); i++) {
			String hashCode = hashCode(A.get(i));
			if (hashCodeIndexMapping.containsKey(hashCode)) {
				hashCodeIndexMapping.get(hashCode).add(i+1);
			} else {
				ArrayList<Integer> anaGramIndexes = new ArrayList<>();
				anaGramIndexes.add(i+1);
				hashCodeIndexMapping.put(hashCode, anaGramIndexes);
			}

		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>(hashCodeIndexMapping.values());
		return result;

	}

	public String hashCode(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);

		return new String(ch);
	}

	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> result = anagrams(Arrays.asList("cat", "dog", "god", "tca"));

		ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
		expected.add(new ArrayList<>(Arrays.asList(1, 4)));
		expected.add(new ArrayList<>(Arrays.asList(2, 3)));

		Assert.assertEquals(expected, result);

	}

}
