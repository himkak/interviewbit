package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeros {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		
		ArrayList<ArrayList<Integer>> copy = new ArrayList<>();
		a.stream().forEach(list->copy.add(new ArrayList<>(list)));
		for (int row = 0; row < a.size(); row++) {
			for (int col = 0; col < a.get(row).size(); col++) {

				if (copy.get(row).get(col) == 0) {
					setRow(a, row, 0);
					setCol(a, col, 0);
				}
			}
		}
	}

	private void setCol(ArrayList<ArrayList<Integer>> a, int col, int i) {
		for (int j = 0; j < a.size(); j++) {
			//if (a.get(j).get(col) != 0) {
				a.get(j).set(col, i);
			//}
		}

	}

	private void setRow(ArrayList<ArrayList<Integer>> a, int row, int i) {
		ArrayList<Integer> rowList=a.get(row);
		for (int j = 0; j < rowList.size(); j++) {
			//if(rowList.get(j)!=0) {
				rowList.set(j, i);
			//}
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
