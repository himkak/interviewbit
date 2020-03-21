package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstring {

	// option 1: with 2 pointers, one at start and other at end. One for loop to
	// move start pointer, and other for loop inside it to move the end and keep on
	// comparing them.

	// option 2 : create all the substrings and check if its a palindrome and find
	// the biggest palindrome

	// option 3 (Preferred): take every point as centre of the palindrome and expand
	// it. Do
	// this in a loop and compare with previous size which ever is bigger capture
	// its start and end. Finally return the substring

	public String longestPalindrome(String s) {
		
		if(s==null || s.length()==0) {
			return "";
		}
		char[] sCharArr = s.toCharArray();
		int start = 0;
		int end = 0;
		int maxSize = -1;
		for (int i = 0; i < sCharArr.length; i++) {
			int size = getMaxSizeOfPalindromeFromMid(sCharArr, i, i +1);
			int sizeNxt = getMaxSizeOfPalindromeFromMid(sCharArr, i -1 , i+1);

			if (size > sizeNxt && size > maxSize) {
				maxSize = size;
				start = i - (maxSize / 2)+1;
				end = i + maxSize / 2;
			} else if (size < sizeNxt && sizeNxt > maxSize) {
				maxSize = sizeNxt;
				start = i - maxSize / 2;
				end = i + maxSize / 2;
			}
		}
		return s.substring(start, end +1);
	}

	private int getMaxSizeOfPalindromeFromMid(char[] sCharArr, int left, int right) {
		boolean palindromeFound=false;
		while (left >= 0 && right < sCharArr.length && sCharArr[left] == sCharArr[right]) {
			palindromeFound=true;
			left--;
			right++;
		}
		return palindromeFound ? right - left -1 : 0;
	}

	@Test
	public void test() {
		Assert.assertEquals("abba", longestPalindrome("cabba"));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals("abba", longestPalindrome("abba"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("ccddabbaddcc", longestPalindrome("ahjgfbebdsjccddabbaddccuhcjncjs"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("", longestPalindrome(""));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals("a", longestPalindrome("a"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals("aa", longestPalindrome("aa"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals("a", longestPalindrome("abcd"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals("aaabaaa", longestPalindrome("aaaabaaa"));
	}
}
