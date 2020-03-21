package com.interviewbit.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MinStepsToInfiniteGrid {

	public int coverPoints(List<Integer> A, List<Integer> B) {
		int totalSteps = 0;
		for (int i = 0; i < A.size() - 1; i++) {
			int currPosX = A.get(i);
			int currPosY = B.get(i);
			int nextX = A.get(i + 1);
			int nextY = B.get(i + 1);
			while (currPosX != nextX || currPosY != nextY) {

				if (currPosX < nextX && currPosY < nextY) {
					currPosX++;
					currPosY++;
				} else if (currPosX >nextX && currPosY > nextY) {
					currPosX--;
					currPosY--;
				} else if (currPosX >nextX && currPosY <nextY) {
					currPosX--;
					currPosY++;
				} else if (currPosX <nextX && currPosY >nextY) {
					currPosX++;
					currPosY--;
				} else if (currPosX <nextX) {
					currPosX++;
				} else if (currPosX >nextX) {
					currPosX--;
				} else if (currPosY <nextY) {
					currPosY++;

				} else if (currPosY >nextY) {
					currPosY--;
				} else {
				}
				//System.out.println("next X step:"+currPosX+", next step Y:"+currPosY);
				totalSteps++;

			}


		}

		return totalSteps;

	}

	@Test
	public void test() {
		Assert.assertEquals(0, coverPoints(Arrays.asList(-7, -13), Arrays.asList(1, -5)));
		Assert.assertEquals(2, coverPoints(Arrays.asList(0, 1, 1), Arrays.asList(0, 1, 2)));

	}

}
