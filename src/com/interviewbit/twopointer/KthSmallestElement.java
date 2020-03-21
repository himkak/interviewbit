package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElement {

	// using quick sort approach, working
	/*
	 * public int kthsmallest(final List<Integer> a, int B) { B = B - 1; // int
	 * pivot = A.get(B); boolean swappedHappened = true; List<Integer> A = new
	 * ArrayList<>(a); while (swappedHappened) { int left = 0; int right = A.size()
	 * - 1; swappedHappened = false; while (left < right) { if (A.get(left) >
	 * A.get(B) && A.get(right) < A.get(B)) { swap(A, left, right); swappedHappened
	 * = true; left++; right--; } if (A.get(right) >= A.get(B)) { right--; } if
	 * (A.get(left) <= A.get(B)) { left++; } if (right <= B && A.get(right) >
	 * A.get(B)) { swap(A, right, B); swappedHappened = true; } else if (left >= B
	 * && A.get(left) < A.get(B)) { swap(A, left, B); swappedHappened = true; } } }
	 * return A.get(B); }
	 */

	public int kthsmallest(final List<Integer> a, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(a.size() - B, Comparator.reverseOrder());
		pq.addAll(a.subList(0, B));
		for (int i = B; i < a.size(); i++) {
			if (a.get(i) < pq.peek()) {
				pq.poll();
				pq.add(a.get(i));
			}
		}
		return pq.peek();
	}

	private void swap(List<Integer> a, int leftIndex, int rightIndex) {
		int tmp = a.get(leftIndex);
		a.set(leftIndex, a.get(rightIndex));
		a.set(rightIndex, tmp);

	}

	@Test
	public void test() {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 1, 4, 3, 2));
		Assert.assertEquals(2, kthsmallest(a, 3));
	}

	@Test
	public void test1() {
		ArrayList<Integer> a = new ArrayList<>(
				Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66,
						35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
		Assert.assertEquals(17, kthsmallest(a, 9));
	}
}
