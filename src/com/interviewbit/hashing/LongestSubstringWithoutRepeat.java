package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {

		char[] ch = A.toCharArray();
		int maxLen = 0;
		int startPtr = 0;
		int endPtr = 0;
		Map<Character, Integer> lastIndexMapper = new HashMap<>();

		for (int i = 0; i < ch.length; i++) {

			if (lastIndexMapper.containsKey(ch[i])) {
				int lastInder = lastIndexMapper.get(ch[i]);
				if (lastInder >= startPtr && lastInder <= endPtr) {
					startPtr = lastInder + 1;
				}
			}
			endPtr++;
			lastIndexMapper.put(ch[i], i);

			if (endPtr - startPtr > maxLen) {
				maxLen = endPtr - startPtr;
			}

		}
		return maxLen;

	}

	@Test
	public void test() {
		Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));

	}

	@Test
	public void test1() {
		Assert.assertEquals(1, lengthOfLongestSubstring("a"));

	}

	@Test
	public void test2() {
		Assert.assertEquals(4, lengthOfLongestSubstring("dadbc"));

	}

}
