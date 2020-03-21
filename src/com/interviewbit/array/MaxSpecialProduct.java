package com.interviewbit.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MaxSpecialProduct {

	/*
	 * public int maxSpecialProduct(List<Integer> A) { int maxSpProd = 0; for (int i
	 * = 1; i < A.size() - 1; i++) { int maxLeft = getMaxLeft(i, A); int minRight =
	 * getMaxRight(i, A);
	 * 
	 * int currSpProd = maxLeft * minRight; if (currSpProd > maxSpProd) { maxSpProd
	 * = currSpProd; System.out.println("maxSpProd:" + maxSpProd + ",maxLeft:" +
	 * maxLeft + ",minRight:" + minRight); } } return maxSpProd % 1000000007; }
	 * 
	 * private int getMaxLeft(int i, List<Integer> A) { int maxLeftIndex = 0; for
	 * (int j = i - 1; j >= 0; j--) { if (A.get(j) > A.get(i)) { // if (maxLeftIndex
	 * < j) { // maxLeftIndex = j; // } return j; }
	 * 
	 * } return maxLeftIndex; }
	 * 
	 * private int getMaxRight(int i, List<Integer> A) { int minRightIndex = 0; if
	 * (i + 1 < A.size()) { minRightIndex = 0; for (int j = i + 1; j < A.size();
	 * j++) { if (A.get(j) > A.get(i)) { return j;
	 * 
	 * }
	 * 
	 * } } return minRightIndex; }
	 */
	public int maxSpecialProduct(List<Integer> A) {
		int n = A.size();
		int[] left = new int[n];
		int[] right = new int[n];

		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(0);

		for (int i = 1; i < n; i++) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i))
					break;
				q.removeLast();
			}
			left[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		q = new ArrayDeque<>();
		q.addLast(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i))
					break;
				q.removeLast();
			}
			right[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		long mx = -1;
		for (int i = 0; i < n; i++) {
			mx = Long.max(mx, 1L * left[i] * right[i]);
		}
		return (int) (mx % 1000000007);
	}

	@Test
	public void test() {
		Assert.assertEquals(10, maxSpecialProduct(Arrays.asList(6, 7, 9, 5, 5, 8)));
	}

	@Test
	public void test3() {
		Assert.assertEquals(88, maxSpecialProduct(Arrays.asList(4, 6, 5, 5, 6, 6, 5, 6, 7, 5, 5, 7, 7)));
	}

	@Test
	public void test4() {
		Assert.assertEquals(80, maxSpecialProduct(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9)));
	}

	@Test
	public void test5() {
		Assert.assertEquals(0, maxSpecialProduct(Arrays.asList(7, 5, 7, 9, 8, 7)));
	}

	public ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
// WRITE YOUR CODE HERE
		List<FeatureRequestCount> featureRequestCountList = new ArrayList<>();
		for (int i = 0; i < numFeatureRequests; i++) {
			String featureRequest = featureRequests.get(i);
			// String[] featureRequestArr = featureRequest.split(" ");
			// List<String> featureRequestList = Arrays.asList(featureRequestArr);

			for (int j = 0; j < numFeatures; j++) {
				String feature = possibleFeatures.get(j);

				if (featureRequest.contains(feature)) {
					int count = 0;
					int index = featureRequestCountList.indexOf(new FeatureRequestCount(feature, 0));
					if (-1 != index) {
						count = featureRequestCountList.get(index).getCount();
						count++;

						featureRequestCountList.set(index, new FeatureRequestCount(feature, count));
					} else {
						featureRequestCountList.add(new FeatureRequestCount(feature, 1));
					}
				}

			}

		}
		Collections.sort(featureRequestCountList, (a, b) -> b.getCount().compareTo(a.getCount()));
		ArrayList<String> finalResult = new ArrayList<>();
		for (int i = 0; i < topFeatures; i++) {
			finalResult.add(featureRequestCountList.get(i).getFeature());
		}
		// featureRequestCountList.subList(0, toIndex);
		return finalResult;
	}

	class FeatureRequestCount {
		String feature;
		Integer count;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((feature == null) ? 0 : feature.hashCode());
			return result;
		}

		public FeatureRequestCount(String feature, int count) {
			super();
			this.feature = feature;
			this.count = count;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FeatureRequestCount other = (FeatureRequestCount) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (feature == null) {
				if (other.feature != null)
					return false;
			} else if (!feature.equalsIgnoreCase(other.feature))
				return false;
			return true;
		}

		private MaxSpecialProduct getEnclosingInstance() {
			return MaxSpecialProduct.this;
		}

		public String getFeature() {
			return feature;
		}

		public void setFeature(String feature) {
			this.feature = feature;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	// @Test
	public void test1() {
		Assert.assertEquals(Arrays.asList("waterproof", "battery"), popularNFeatures(6, 2,
				Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar"), 7,
				Arrays.asList("aa ss hh waterproof", "bbaashj  jhhf akhs battery", " waterproof", "", "", "", "")));
	}

	int minimumDays(int rows, int columns, List<List<Integer>> grid) {
		int days = 0;
		while (!allSetToOne(grid)) {
			for (int i = 0; i < rows; i++) {
				List<Integer> currList = grid.get(i);
				for (int j = 0; j < columns; j++) {

					if (currList.get(j) == 1) {
						// set in lef
						if (j > 0 && currList.get(j - 1) == 0) {
							currList.set(j - 1, 1);
						}
						// set in right
						if (j > 0 && j < columns - 1 && currList.get(j + 1) == 0) {
							currList.set(j + 1, 1);
						}
						// set up
						if (i > 0 && grid.get(i - 1).get(j) == 0) {
							grid.get(i - 1).set(j, 1);
						}

						// set down
						if (i > 0 && i < rows - 1 && grid.get(i + 1).get(j) == 0) {
							grid.get(i + 1).set(j, 1);
						}

					}

				}

			}
			days++;
		}
		return days;
	}

	private boolean allSetToOne(List<List<Integer>> grid) {
		for (List<Integer> eachGrid : grid) {
			if (eachGrid.contains(0)) {
				return false;
			}
		}
		return true;
	}

	// @Test
	public void test2() {
		List<Integer> l1 = Arrays.asList(0, 1, 1, 0, 1);
		List<Integer> l2 = Arrays.asList(0, 1, 0, 1, 0);
		List<Integer> l3 = Arrays.asList(0, 0, 0, 0, 1);
		List<Integer> l4 = Arrays.asList(0, 1, 0, 0, 0);
		List<List<Integer>> ll = new ArrayList<>();
		ll.add(l1);
		ll.add(l2);
		ll.add(l3);
		ll.add(l4);
		Assert.assertEquals(2, minimumDays(4, 5, ll));
	}

}
