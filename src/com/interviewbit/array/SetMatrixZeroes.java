package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroes {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {

		boolean isFirstRowZero = false;
		boolean isFirstColumnZero = false;

		int noOfRows = a.size();
		int noOfCols = a.get(0).size();

		for (int i = 0; i < noOfCols; i++) {
			if (a.get(0).get(i) == 0) {
				isFirstRowZero = true;
			}
		}

		for (int i = 0; i < noOfRows; i++) {
			if (a.get(i).get(0) == 0) {
				isFirstColumnZero = true;
			}
		}

		// mark the starting row and col as 0
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfCols; j++) {
				if (a.get(i).get(j) == 0) {
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);
				}

			}
		}

		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfCols; j++) {
				if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
					a.get(i).set(j, 0);
				}
			}
		}

		if (isFirstRowZero) {
			for (int i = 0; i < noOfCols; i++) {
				a.get(0).set(i, 0);
			}
		}
		
		if(isFirstColumnZero) {
			for (int i = 0; i < noOfRows; i++) {
				a.get(i).set(0, 0);
			}
			
		}

	}
	
	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList(Arrays.asList(1, 0, 1)));
		a.add(new ArrayList(Arrays.asList(1, 1, 1)));
		a.add(new ArrayList(Arrays.asList(1, 1, 1)));

		setZeroes(a);
		Assert.assertEquals(Arrays.asList(0, 0, 0), a.get(0));
		Assert.assertEquals(Arrays.asList(1, 0, 1), a.get(1));
		Assert.assertEquals(Arrays.asList(1, 0, 1), a.get(2));
	}

	@Test
	public void test2() {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList(Arrays.asList(0, 0)));
		a.add(new ArrayList(Arrays.asList(1, 1)));

		setZeroes(a);
		Assert.assertEquals(Arrays.asList(0, 0), a.get(0));
		Assert.assertEquals(Arrays.asList(0, 0), a.get(1));
	}

}
