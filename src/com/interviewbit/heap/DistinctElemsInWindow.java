package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class DistinctElemsInWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> elems, int windowSize) {
		Map<Integer, Integer> elemsCntMap = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();

		int distinctCnt = 0;
		for (int i = 0; i <= elems.size() - windowSize; i++) {
			int j = i;
			if (i == 0) {
				while (j < i + windowSize) {
					int elemKey = elems.get(j);
					if (elemsCntMap.containsKey(elemKey)) {
						elemsCntMap.put(elemKey, elemsCntMap.get(elemKey) + 1);
					} else {
						distinctCnt++;
						elemsCntMap.put(elemKey, 1);
					}
					j++;
				}
			} else {
				int prevElem = elems.get(i - 1);
				int prevElemCnt = elemsCntMap.get(prevElem);
				if (prevElemCnt == 1) {
					distinctCnt--;
					elemsCntMap.remove(prevElem);
				} else {
					elemsCntMap.put(prevElem, --prevElemCnt);
				}
				int nextElem = elems.get(i + windowSize - 1);
				if (elemsCntMap.containsKey(nextElem)) {
					elemsCntMap.put(nextElem, elemsCntMap.get(nextElem) + 1);
				} else {
					elemsCntMap.put(nextElem, 1);
					distinctCnt++;
				}

			}
			result.add(distinctCnt);

		}
		return result;
	}

	@Test
	public void test() {
		ArrayList<Integer> elems = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 2, 3));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 4, 3));
		Assert.assertEquals(expected, dNums(elems, 4));

	}

	@Test
	public void test1() {
		ArrayList<Integer> elems = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 3, 2));
		Assert.assertEquals(expected, dNums(elems, 3));

	}

}
