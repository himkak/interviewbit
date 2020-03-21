package com.interviewbit.string;

import org.junit.Assert;
import org.junit.Test;

public class RomanTOInt {

	// I, II, III, IV, V, VI, VII, VIII, IX, X
	// XI, XII, XIII, XIV, ...XX

	public int romanToInt(String A) {

		if (A == null || A.length() == 0) {
			return 0;
		} else {
			char[] aChars = A.toCharArray();
			int num = 0;
			int currNum = 0;
			for (int i = 0; i < aChars.length; i++) {
				switch (aChars[i]) {
				case 'I':
					currNum = 1;
					num = num + currNum;

					break;
				case 'V':
					currNum = 5;
					num = getNum(num, currNum, 1);
					break;
				case 'X':
					currNum = 10;
					num = getNum(num, currNum, 5);
					break;
				case 'L':
					currNum = 50;
					num = getNum(num, currNum, 10);
					break;
				case 'C':
					currNum = 100;
					num = getNum(num, currNum, 50);
					break;
				case 'D':
					currNum = 500;
					num = getNum(num, currNum, 100);
					break;
				case 'M':
					currNum = 1000;
					num = getNum(num, currNum, 500);
					break;

				default:
					break;

				}
			}
			return num;
		}

	}

	private int getNum(int num, int currNum, int prev) {
		if (num !=0 && num%currNum < currNum) {
			num = num + currNum - 2*(num%currNum);
		} else  {
			num = num + currNum;
		}
		return num;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, romanToInt("III"));
	}

	@Test
	public void test1() {
		Assert.assertEquals(4, romanToInt("IV"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(7, romanToInt("VII"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(9, romanToInt("IX"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(10, romanToInt("X"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(11, romanToInt("XI"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(14, romanToInt("XIV"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(17, romanToInt("XVII"));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(27, romanToInt("XXVII"));
	}
	
	@Test
	public void test9() {
		Assert.assertEquals(51, romanToInt("LI"));
	}
	
	@Test
	public void test10() {
		Assert.assertEquals(60, romanToInt("LX"));
	}
	
	@Test
	public void test14() {
		Assert.assertEquals(40, romanToInt("XL"));
	}
	
	@Test
	public void test15() {
		Assert.assertEquals(44, romanToInt("XLIV"));
	}
	
	@Test
	public void test11() {
		Assert.assertEquals(90, romanToInt("XC"));
	}
	
	@Test
	public void test12() {
		Assert.assertEquals(400, romanToInt("CD"));
	}
	
	@Test
	public void test13() {
		Assert.assertEquals(600, romanToInt("DC"));
	}
	
	@Test
	public void test16() {
		Assert.assertEquals(2475, romanToInt("MMCDLXXV"));
	}

}
