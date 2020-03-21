package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class Palindrome {

	public int isPalindrome(String A) {
		int left=0;
		int right = A.length()-1;
		
		char[] chars=A.toCharArray();
		int counter=0;
		while(left<right) {
			char charLeft=chars[left];
			int charLeftInt=(int)charLeft;
			while(charLeftInt<65 || (charLeftInt >90 && charLeftInt<97) || charLeftInt>122) {
				left++;
				if(left>right) {
					break;
				}
				charLeft=chars[left];
				charLeftInt=(int)charLeft;
			}
			
			
			char charRight=chars[right];
			int charRightInt=(int)charRight;
			while(charRightInt<65 || (charRightInt >90 && charRightInt<97) || charRightInt>122) {
				right--;
				if(left>right) {
					break;
				}
				charRight=chars[right];
				charRightInt=(int)charRight;
			}
			
			char charLeftLower=Character.toLowerCase(charLeft);
			char charRightLower=Character.toLowerCase(charRight);
			counter++;
			if(charLeftLower!=charRightLower ) {
				return 0;
			}
			if(left==right && counter==1) {
				return 0;
			}
			left++;
			right--;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println((int)'A');
		System.out.println((int)'Z');
		
		System.out.println((int)'a');
		System.out.println((int)'z');
		
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(0, isPalindrome("race a car"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, isPalindrome(".,"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, isPalindrome("1a2"));
	}

}
