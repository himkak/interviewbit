package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PointsOnTheStraightLine {

	/*
	 * public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	 * Map<Integer, Integer> x_cnt = new HashMap<>(); Map<Integer, List<Integer>>
	 * x_Indexes = new HashMap<>(); int maxOccuredElemX = a.get(0);
	 * 
	 * for (int i = 0; i < a.size(); i++) { int elem = a.get(i); int cnt = 0; if
	 * (x_cnt.containsKey(elem) && x_Indexes.containsKey(elem)) { cnt =
	 * x_cnt.get(elem) + 1; x_cnt.put(elem, cnt); x_Indexes.get(elem).add(i); } else
	 * { cnt = 1; x_cnt.put(elem, 1); ArrayList<Integer> indexes = new
	 * ArrayList<>(); indexes.add(i); x_Indexes.put(elem, indexes); }
	 * 
	 * if (x_cnt.get(maxOccuredElemX) < cnt) maxOccuredElemX = cnt; }
	 * 
	 * Map<Integer, Integer> y_cnt = new HashMap<>(); Map<Integer, List<Integer>>
	 * y_Indexes = new HashMap<>(); int maxOccuredElemY = b.get(0);
	 * 
	 * for (int i = 0; i < b.size(); i++) { int elem = b.get(i); int cnt = 0; if
	 * (y_cnt.containsKey(elem) && y_Indexes.containsKey(elem)) { cnt =
	 * y_cnt.get(elem) + 1; y_cnt.put(elem, cnt); y_Indexes.get(elem).add(i); } else
	 * { cnt = 1; y_cnt.put(elem, 1); ArrayList<Integer> indexes = new
	 * ArrayList<>(); indexes.add(i); y_Indexes.put(elem, indexes); }
	 * 
	 * if (y_cnt.get(maxOccuredElemY) < cnt) maxOccuredElemY = cnt; }
	 * 
	 * if (maxOccuredElemX >= maxOccuredElemY) { return x_cnt.get(maxOccuredElemX);
	 * } else { return y_cnt.get(maxOccuredElemY); } }
	 */

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		Map<String, Integer> slope_cntMapping = new HashMap<>();
		int maxCnt = 0;
		if (a == null | a.size() == 0) {
			return 0;
		}

		if (a.size() == 1) {
			return 1;
		}

		for (int i = 0; i < a.size(); i++) {
			for (int j = i+1; j < b.size() ; j++) {

				int x1 = a.get(i);
				int y1 = b.get(i);

				int x2 = a.get(j);
				int y2 = b.get(j);
				int xDiff = (x2 - x1);
				int yDiff = (y2 - y1);
				int gcd = getGcd(xDiff, yDiff);
				if (xDiff == 0 || gcd == 0) {
					xDiff = 0;
				} else {
					xDiff = xDiff / gcd;
				}
				if (yDiff == 0 || gcd == 0) {
					yDiff = 0;
				} else {
					yDiff = yDiff / gcd;
				}
				String slope = xDiff + "_" + yDiff;

				int cnt = 0;
				if (slope_cntMapping.containsKey(slope)) {
					cnt = slope_cntMapping.get(slope) + 1;
					slope_cntMapping.put(slope, cnt);
				} else {
					cnt = 1;
					slope_cntMapping.put(slope, cnt);
				}

				if (cnt > maxCnt) {
					maxCnt = cnt;
				}
			}
		}
		return maxCnt;
	}

	private int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

	@Test
	public void test3() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-6, 5, -18, 2, 5, -2));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(-17, -16, -17, -4, -13, 20));

		Assert.assertEquals(2, maxPoints(a, b));

	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 2));

		Assert.assertEquals(2, maxPoints(a, b));

	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 1, -1));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(0, 1, -1));

		Assert.assertEquals(3, maxPoints(a, b));

	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));

		Assert.assertEquals(5, maxPoints(a, b));

	}

}
