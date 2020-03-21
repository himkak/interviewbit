package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SubString {

	public ArrayList<Integer> findSubstring(String s, final List<String> subStrs) {
		Map<String, Integer> subStr_cntMap = new HashMap<>();
		int subStrSize = subStrs.get(0).length();

		for (String str : subStrs) {
			if (subStr_cntMap.containsKey(str)) {
				subStr_cntMap.put(str, subStr_cntMap.get(str) + 1);
			} else {
				subStr_cntMap.put(str, 1);
			}
		}
		if (subStr_cntMap.size() == 1) {
			for (String key : subStr_cntMap.keySet()) {
				if (isAllCharsRepeated(key)) {
					ArrayList<Integer> result = new ArrayList<>();
					for (int i = 0; i <= s.length() - (key.length() * subStr_cntMap.get(key)); i++) {
						result.add(i);
					}
					return result;
				}
			}

		}

		ArrayList<Integer> startIndexesOfSubStrings = new ArrayList<>();
		Map<String, Integer> subStr_cntTmpMap = new HashMap<>(subStr_cntMap);
		boolean hastmpMapBeenModified = false;
		char[] ch = s.toCharArray();
		int subStrStartPtr = -1;
		int identifiedEndPtr = -1;
		for (int i = 0; i < ch.length - subStrSize; i++) {
			
			int startPtr = i;
			int endPtr = i + subStrSize;
			String subStrToMatch = s.substring(startPtr, endPtr);
			if (subStr_cntTmpMap.containsKey(subStrToMatch)) {
				identifiedEndPtr = endPtr - 1;
				if (subStrStartPtr == -1) {
					subStrStartPtr = startPtr;
				}
				subStr_cntTmpMap.put(subStrToMatch, subStr_cntTmpMap.get(subStrToMatch) - 1);
				hastmpMapBeenModified = true;

				// all the words found
				if (areAllWordsCntZero(subStr_cntTmpMap)) {
					subStr_cntTmpMap = new HashMap<>(subStr_cntMap);
					startIndexesOfSubStrings.add(subStrStartPtr);
					subStrStartPtr = -1;
				}
				// i=endPtr-1;
			} else if (i >= identifiedEndPtr) {
				if (hastmpMapBeenModified) {
					subStr_cntTmpMap = new HashMap<>(subStr_cntMap);
					hastmpMapBeenModified = false;
				}
				subStrStartPtr = -1;
			}

		}
		return startIndexesOfSubStrings;
	}

	private boolean isAllCharsRepeated(String key) {
		char[] ch = key.toCharArray();
		if (ch.length == 1) {
			return true;
		}
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] != ch[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private boolean areAllWordsCntZero(Map<String, Integer> subStr_cntTmpMap) {
		for (int cnt : subStr_cntTmpMap.values()) {
			if (cnt > 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test3() {
		String s = "abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
		List<String> strs = Arrays.asList("cac", "aaa", "aba", "aab", "abc");
		List<Integer> expectedStartIndexes = Arrays.asList(97);
		Assert.assertEquals(expectedStartIndexes, findSubstring(s, strs));

	}

	@Test
	public void test() {
		String s = "barfoothefoobarman";
		List<String> strs = Arrays.asList("foo", "bar");
		List<Integer> expectedStartIndexes = Arrays.asList(0, 9);
		Assert.assertEquals(expectedStartIndexes, findSubstring(s, strs));

	}

	@Test
	public void test1() {
		String s = "wordgoodgoodgoodbestword";
		List<String> strs = Arrays.asList("word", "good", "best", "word");
		List<Integer> expectedStartIndexes = Arrays.asList();
		Assert.assertEquals(expectedStartIndexes, findSubstring(s, strs));

	}

	@Test
	public void test2() {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> strs = Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa");
		List<Integer> expectedStartIndexes = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
				44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
				70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
				96, 97, 98);
		Assert.assertEquals(expectedStartIndexes, findSubstring(s, strs));

	}

}
