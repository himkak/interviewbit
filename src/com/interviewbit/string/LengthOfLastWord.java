package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLastWord {

	public int lengthOfLastWord( String A) {
		if (A == null || A.length() == 0) {
			return 0;
		} else {
			A = A.trim();
			char[] aChars = A.toCharArray();
			for (int i = aChars.length - 1; i > 0; i--) {
				if (aChars[i] == ' ') {
					return aChars.length -1 - i;
				}
			}
			return aChars.length;
		}
	}
	
	@Test
	public void test() {
		Assert.assertEquals(5, lengthOfLastWord("Hello World"));
	}
}
