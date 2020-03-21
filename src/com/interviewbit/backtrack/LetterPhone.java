package com.interviewbit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LetterPhone {

	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> result = new ArrayList<>();
		char[] inputArr = A.toCharArray();

		boolean containsCalcNum = false;
		for (int i = 0; i < inputArr.length; i++) {
			if (!containsCalcNum) {
				for (int j = 2; j <= 9; j++) {
					if (Integer.parseInt(String.valueOf(inputArr[i])) == j) {
						containsCalcNum = true;
						break;
					}
				}
			}

		}
		if (containsCalcNum) {
			helper(inputArr, result, "", 0);
		} else {
			result.add(A);
		}
		return result;

	}

	private void helper(char[] inputArr, ArrayList<String> result, String existingElem, int existingElemIndex) {
		if (existingElemIndex == inputArr.length) {
			result.add(existingElem);
			return;
		}

		for (int i = existingElemIndex; i < inputArr.length; i++) {
			char[] str;
			if (inputArr[i] == '0' || inputArr[i] == '1') {
				str = new char[1];
				str[0] = (inputArr[i]);
			} else {
				str = getChars(inputArr[i]).toCharArray();
			}
			for (int j = 0; j < str.length; j++) {
				helper(inputArr, result, existingElem + Character.toString(str[j]), existingElemIndex + 1);
			}
			return;
		}

	}

	private String getChars(char c) {
		int elem = Integer.parseInt(String.valueOf(c));
		StringBuilder sb = new StringBuilder();
		if (elem == 1 || elem == 0) {
			return "";
		} else if (elem >= 2 && elem <= 6) {
			int startInt = (97 + ((elem - 2) * 3));
			for (int i = 0; i < 3; i++) {
				sb.append((char) (startInt + i));
			}
		} else if (elem == 7) {
			int startInt = (97 + ((elem - 2) * 3));
			for (int i = 0; i < 4; i++) {
				sb.append((char) (startInt + i));
			}

		} else if (elem == 8) {
			int startInt = (97 + (((elem - 2) - (elem - 7)) * 3 + (elem - 7) * 4));
			for (int i = 0; i < 3; i++) {
				sb.append((char) (startInt + i));
			}
		} else if (elem == 9) {
			int startInt = (97 + 22);
			for (int i = 0; i < 4; i++) {
				sb.append((char) (startInt + i));
			}
		}
		return sb.toString();
	}

	@Test
	public void test() {
		ArrayList<String> res=letterCombinations("12");
		ArrayList<String> expected= new ArrayList<>(Arrays.asList("1a","1b","1c"));
		Assert.assertEquals(expected, res);

	}

}
