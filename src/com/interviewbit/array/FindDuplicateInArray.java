package com.interviewbit.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInArray {

	public int repeatedNumber(final List<Integer> A) {

		Map<Integer, Integer> numberCnt = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			if (!numberCnt.containsKey(A.get(i))) {
				numberCnt.put(A.get(i), 1);
			}else {
				return A.get(i);
			}
		}
		return -1;
	}

}
