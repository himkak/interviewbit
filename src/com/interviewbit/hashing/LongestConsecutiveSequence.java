package com.interviewbit.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequence {

	public int longestConsecutive(final List<Integer> A) {
		Set<Integer> elemsSet = new HashSet<>();

		for (int i = 0; i < A.size(); i++) {
			elemsSet.add(A.get(i));
		}
		int maxCnt = 0;
		for (int i = 0; i < A.size(); i++) {
			int j = A.get(i);
			if (!elemsSet.contains(A.get(i) - 1)) {
				while (elemsSet.contains(j)) {
					j++;
				}
				int cnt = j - A.get(i);
				maxCnt = cnt > maxCnt ? cnt : maxCnt;
			}

		}
		return maxCnt;
	}

	@Test
	public void test() {
		Assert.assertEquals(4, longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2)));

	}

}
