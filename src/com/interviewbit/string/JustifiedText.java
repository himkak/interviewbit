package com.interviewbit.string;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class JustifiedText {

	public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
		ArrayList<String> result = new ArrayList<>();
		int prev = 0;
		for (int i = 0; i < A.size(); i++) {
			int len = A.get(i).length();
			if (len != 0) {
				int nextLen = i + 1 < A.size() ? len + A.get(i + 1).length() + 1 : 0;
				if (nextLen!=0) {
					while (nextLen <= B && i < A.size()-1) {

						i++;

						if (i < A.size()) {
							len = len + A.get(i).length() + 1;
						}
						if (i + 1 < A.size())
							nextLen = i + 1 < A.size() ? len + A.get(i + 1).length() + 1 : 0;
					}
				}
				String str = createString(A, i, prev, B - len, B);
				result.add(str);
				prev = i;
				// prev++;
			}
		}

		return result;
	}

	private String createString(ArrayList<String> a, int i, int prev, int spacesToBeDistributed, int B) {
		int totalSpaces = 0;
		int spacesB4Words = 0;
		StringBuilder sb = new StringBuilder();
		int startIdx = prev == 0 ? 0 : prev + 1;
		int noOfWords = i - startIdx + 1;
		if (noOfWords > 1) {
			totalSpaces = spacesToBeDistributed + noOfWords - 1;
			if(a.size()-i==1) {
				spacesB4Words=1;
			}else {
				spacesB4Words = totalSpaces / (noOfWords - 1);
			}
			for (int j = startIdx; j <= i && j < a.size(); j++) {
				if (j != startIdx || noOfWords == 1 ) {
					addSpaces(spacesB4Words, sb);
					if (j == startIdx + 1 && noOfWords!=2) {
						addSpaces(totalSpaces % (noOfWords - 1), sb);
					}
				}
				sb.append(a.get(j));
				// i++;
			}
		} else {
			sb.append(a.get(startIdx));
			addSpaces(spacesToBeDistributed, sb);
		}
		if(sb.length()<B) {
			addSpaces( B-sb.length(),sb);
		}

		// if(sb.length())
		return sb.toString();
	}

	private void addSpaces(int spacesB4Words, StringBuilder sb) {
		for (int j2 = 0; j2 < spacesB4Words; j2++) {
			sb.append(" ");
		}
	}
	
	@Test
	public void test3() {
		ArrayList<String> expected = new ArrayList<>(
				Arrays.asList("What must be", "shall be.   "));
		ArrayList<String> input = new ArrayList<>(
				Arrays.asList("What", "must", "be", "shall", "be." ));
		Assert.assertEquals(expected, fullJustify(input, 12));
	}

	@Test
	public void test() {
		ArrayList<String> expected = new ArrayList<>(
				Arrays.asList("This    is    an", "example  of text", "justification.  "));
		ArrayList<String> input = new ArrayList<>(
				Arrays.asList("This", "is", "an", "example", "of", "text", "justification."));
		Assert.assertEquals(expected, fullJustify(input, 16));
	}

	@Test
	public void test1() {
		ArrayList<String> expected = new ArrayList<>();
		ArrayList<String> input = new ArrayList<>(Arrays.asList(""));
		Assert.assertEquals(expected, fullJustify(input, 10));
	}

	@Test
	public void test2() {
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("am    fasgoprn", "lvqsrjylg     ", "rzuslwan xlaui",
				"tnzegzuzn     ", "kuiwdc        ", "fofjkkkm      ", "ssqjig        ", "tcmejefj      ",
				"uixgzm        ", "lyuxeaxsg     ", "iqiyip     msv", "uurcazjc      ", "earsrvrq   qlq",
				"lxrtzkjpg     ", "jkxymjus      ", "mvornwza zty q", "nsecqphjy     "));
		ArrayList<String> input = new ArrayList<>(Arrays.asList("am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui",
				"tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv",
				"uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"));
		Assert.assertEquals(expected, fullJustify(input, 14));
	}

}
