package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NoOfPathsInMatrix {

	int count = 0;
	int endX = 0;
	int endY = 0;

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
		int startX = 0;
		int startY = 0;
		endX = A.size() - 1;
		endY = A.get(endX).size() - 1;

		uniquePathsWithObstacles(startX, startY, A);

		return count;
	}

	private void uniquePathsWithObstacles(int startX, int startY, ArrayList<ArrayList<Integer>> a) {
		if (isDestination(startX, startY, a)) {
			count++;
		} else {
			int nextIncreasedX = startX + 1;
			int nextIncreasedY = startY + 1;
			if (nextIncreasedX <= endX && startY <= endY && a.get(nextIncreasedX).get(startY) != 1 ) {
				uniquePathsWithObstacles(startX + 1, startY, a);
			}
			if (startX <= endX && nextIncreasedY <= endY && a.get(startX).get(nextIncreasedY) != 1 ) {
				uniquePathsWithObstacles(startX, startY + 1, a);

			}
		}

	}

	private boolean isDestination(int startX, int startY, ArrayList<ArrayList<Integer>> a) {

		if (startX == endX && startY == endY) {
			return true;
		}
		return false;
	}

	@Test
	public void test() {

		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		A.add(new ArrayList(Arrays.asList(0, 0, 0)));
		A.add(new ArrayList(Arrays.asList(0, 1, 0)));
		A.add(new ArrayList(Arrays.asList(0, 0, 0)));

		Assert.assertEquals(2, uniquePathsWithObstacles(A));
	}

}
