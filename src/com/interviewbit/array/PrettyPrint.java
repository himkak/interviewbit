package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PrettyPrint {

	public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		int size=A*2-1;
		int[][] list = new int[size][size];
		for (int i = A; i > 0; i--) {
			int diff=A-i;
			
			fillRowTop(i,diff,list,size);
			fillRowBottom(i,diff,list,size);
			fillColLeft(i,diff, list,size);
			fillColRight(i,diff, list,size);
			
		}
		//System.out.println(list);
		ArrayList<ArrayList<Integer>> al=new ArrayList<>(); 
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> row=new ArrayList<>();
			for (int j = 0; j < size; j++) {
				row.add(list[i][j]);
			}
			al.add(row);
		}
		
		return al ;
	}

	private void fillColLeft(int i, int col, int[][] list,int size) {
		for (int j = col; j < size-col; j++) {
			list[j][col]=i;
		}
		
	}
	
	private void fillColRight(int i, int col, int[][] list,int size) {
		for (int j = col; j < size-col; j++) {
			list[j][size-col-1]=i;
		}
		
	}

	private void fillRowTop(int i, int row, int[][] list, int size) {
		for (int j = row; j < size-row; j++) {
			list[row][j]=i;
		}
		
	}
	
	private void fillRowBottom(int i, int row, int[][] list, int size) {
		for (int j = row; j < size-row; j++) {
			list[size-row-1][j]=i;
		}
		
	}

	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> resultList = prettyPrint(3);

		Assert.assertEquals(5, resultList.size());
		Assert.assertEquals(Arrays.asList(3, 3, 3, 3, 3), resultList.get(0));
		Assert.assertEquals(Arrays.asList(3, 3, 3, 3, 3), resultList.get(4));
		Assert.assertEquals(Arrays.asList(3, 2, 2, 2, 3), resultList.get(1));
		Assert.assertEquals(Arrays.asList(3, 2, 1, 2, 3), resultList.get(2));
		Assert.assertEquals(Arrays.asList(3, 2, 2, 2, 3), resultList.get(3));
	}

}
