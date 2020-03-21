package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedList {

	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0;
		int j = 0;
		while (i < a.size() && j < b.size()) {
			if (a.get(i) > b.get(b.size() - 1)) {
				a.addAll(i, b.subList(j, b.size()));
				return;
			} else if (a.get(i) >= b.get(j)) {
				a.add(i, b.get(j));
				j++;
			}
			else if (i == a.size() - 1 && a.get(i) < b.get(j)) {
				a.addAll(b.subList(j, b.size()));
				return;
			}
			i++;

		}
	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 5));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4));
		merge(a, b);
		ArrayList<Integer> expecteds = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		Assert.assertEquals(expecteds, a);
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 5));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 6));
		merge(a, b);
		ArrayList<Integer> expecteds = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
		Assert.assertEquals(expecteds, a);
	}

	@Test
	public void test2() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(-1, 2));
		merge(a, b);
		ArrayList<Integer> expecteds = new ArrayList<>(Arrays.asList(-1, 1, 2, 2));
		Assert.assertEquals(expecteds, a);
	}

}
