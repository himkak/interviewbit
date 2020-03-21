package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(ArrayList<Integer> a) {
		int index = 1;
		int prevElem = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			boolean isRepeat = prevElem == a.get(i);
			if (!isRepeat) {
				a.set(index++, a.get(i));
			}
			prevElem=a.get(i);
		}
		return index;
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 2));
		Assert.assertEquals(2, removeDuplicates(a));
	}
	
	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3,4,4,5,5,7));
		Assert.assertEquals(6, removeDuplicates(a));
	}

}
