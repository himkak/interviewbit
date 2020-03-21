package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class MinimumCharsToMakePalindrome {

	public int solve(String A) {
		int result = 0;

		char[] aChars = A.toCharArray();
		int left = 0;
		for (int i = aChars.length - 1; i >= 0; i--) {
			int right = i;
			if (isPalindrome(aChars, left, right)) {
				result = aChars.length - (right+1);
				return result;
			}
		}

		return result;
	}

	private boolean isPalindrome(char[] aChars, int left, int right) {
		
		while(left<right ) {
			if(aChars[left]!=aChars[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(2, solve("ABC"));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, solve("aabaaa"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, solve("abaaa"));
	}

}
