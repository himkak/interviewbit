package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class AmazingSubString {

	public int solve(String A) {
		int cnt = 0;
		for (int startIndex = 0; startIndex <= A.length() - 1; startIndex++) {
			String stIdx = A.substring(startIndex, startIndex + 1);
			if ("aeiou".contains(stIdx.toLowerCase())) {
				for (int noOfChars = 1; noOfChars <= A.length() - startIndex; noOfChars++) {
					 System.out.println(A.substring(startIndex, startIndex+noOfChars));
					cnt++;
				}
			}

		}
		return cnt%10003;
	}

	@Test
	public void test() {
		Assert.assertEquals(6, solve("ABEC"));
	}
	

	@Test
	public void test1() {
		Assert.assertEquals(1033, solve("kFbwEBGMTPcOVqenWEempRwOsjuxgMEhohXKqSxZWcqUuDHsRAGNTzwBYvVmTfPCwzFomjtTKLKjUCzHuNaAVoYoDysQWphGyexu"));
	}
	
}
