package com.interviewbit.hashing;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class Fraction {

	public String fractionToDecimal(int A, int B) {
		if (A % B != 0) {
			double div = (double) A / (double) B;
			String res = new BigDecimal(div).toPlainString();

			int dotIndex = res.indexOf(".");
			char[] ch = res.toCharArray();
			HashMap<Character, Integer> charIndexMap = new HashMap<>();
			int checkRepeatPt = -1;
			for (int i = dotIndex + 1; i < ch.length; i++) {
				if (i == ch.length - 1 && charIndexMap.containsKey(ch[i])) {
					checkRepeatPt = charIndexMap.get(ch[i]);
				}

				if (!charIndexMap.containsKey(ch[i])) {
					charIndexMap.put(ch[i], i);
				}

			}
			if (checkRepeatPt > -1) {
				String checkRepeatStr = res.substring(dotIndex + 1, checkRepeatPt + 1);
				String strAfterDot = res.substring(dotIndex + 1);
				if (strAfterDot.replaceAll(checkRepeatStr, "").isEmpty()) {
					String finalRes = res.substring(0, dotIndex + 1);
					finalRes = finalRes.concat("(" + checkRepeatPt + ")");
				}
			}

			return res;
		} else {
			if (Math.abs(B) != 1) {
				return Integer.toString(A / B);
			} else {
				if (Integer.toString(A).startsWith("-")) {
					if (Integer.toString(B).startsWith("-")) {
						return Integer.toString(A).replace("-", "");
					} else {
						return Integer.toString(A);
					}
				} else {
					return Integer.toString(A);
				}
			}
		}

	}

	@Test
	public void test4() {
		Assert.assertEquals("0.0000000004656612873077392578125", fractionToDecimal(-1, -2147483648));

	}

	@Test
	public void test() {
		Assert.assertEquals("0.5", fractionToDecimal(1, 2));

	}

	@Test
	public void test1() {
		Assert.assertEquals("2", fractionToDecimal(2, 1));

	}

	@Test
	public void test2() {
		Assert.assertEquals("0.(6)", fractionToDecimal(2, 3));

	}

	@Test
	public void test3() {
		Assert.assertEquals("2147483648", fractionToDecimal(-2147483648, -1));

	}
}
