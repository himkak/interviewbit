package com.interviewbit.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubsequence {

	public int longestSubsequence(String x, String y) {
		if (x == null || x.isEmpty()) {
			return 0;
		}
		int maxSubseq = 0;
		for (int i = 0; i < x.length(); i++) {
			StringBuilder sb = new StringBuilder(x);
			int subSqlLen = 0;
			if (y.contains(x)) {
				subSqlLen = x.length();
				maxSubseq = subSqlLen > maxSubseq ? subSqlLen : maxSubseq;
			}
			subSqlLen = longestSubsequence(sb.deleteCharAt(i).toString(), y);
			maxSubseq = subSqlLen > maxSubseq ? subSqlLen : maxSubseq;
		}

		return maxSubseq;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, longestSubsequence("ABCD", "BACDBDCD"));
	}

}
