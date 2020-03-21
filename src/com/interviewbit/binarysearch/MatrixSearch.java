package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MatrixSearch {

	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

		int rows = A.size();
		int cols = A.get(0).size();

		return searchMatrix(A, B, 0, (rows * cols) - 1);

	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B, int start, int end) {
		int startCol=getCol(A.get(0).size(), start);
		int startRow = getRow(A.get(0).size(), start);
		int endCol=getCol(A.get(0).size(), end);
		int endRow = getRow(A.get(0).size(), end);
		if(B<A.get(startRow).get(startCol) || B>A.get(endRow).get(endCol)) {
			return 0;
		}else if(end-start==1 && (B==A.get(startRow).get(startCol) || B==A.get(endRow).get(endCol))) {
			return 1;
		}else if (start==end && B==A.get(startRow).get(startCol) ) {
			return 1;
		}
		
		int total = start + end;
		int mid = total / 2;
		int midRow = getRow(A.get(0).size(), mid);
		int midCol = getCol(A.get(0).size(), mid);
		if (start < end) {
			if (A.get(midRow).get(midCol) > B) {
				end = mid-1;
				return searchMatrix(A, B, start, end);
			} else if (A.get(midRow).get(midCol) < B) {
				start = mid+1;
				return searchMatrix(A, B, start, end);
			} else {
				return 1;
			}
		} else {
			if(A.get(start).get(start)==B) {
				return 1;
			}
			return 0;
		}
		//return 0;
	}

	private int getCol(int size, int mid) {
		//mid++;
		return mid % size;
	}

	private int getRow(int cols, int mid) {
		if(mid==0) {
			return 0;
		}
		return (mid / cols)  ;
	}
	
	@Test
	public void test() {
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		
		A.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
		A.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
		A.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
		
		Assert.assertEquals(1, searchMatrix(A, 3));
		
	}
	
	@Test
	public void test1() {
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		
		A.add(new ArrayList<>(Arrays.asList(5, 17, 100, 111)));
		A.add(new ArrayList<>(Arrays.asList(119, 120,  127,   131)));
		
		Assert.assertEquals(0, searchMatrix(A, 3));
		
	}
	
	@Test
	public void test2() {
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		
		A.add(new ArrayList<>(Arrays.asList(1)));
		
		Assert.assertEquals(1, searchMatrix(A, 1));
		
	}
	
	@Test
	public void test3() {
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		
		A.add(new ArrayList<>(Arrays.asList(3)));
		
		A.add(new ArrayList<>(Arrays.asList(29)));
		A.add(new ArrayList<>(Arrays.asList(36)));
		A.add(new ArrayList<>(Arrays.asList(63)));
		A.add(new ArrayList<>(Arrays.asList(67)));
		A.add(new ArrayList<>(Arrays.asList(72)));
		A.add(new ArrayList<>(Arrays.asList(74)));
		A.add(new ArrayList<>(Arrays.asList(78)));
		A.add(new ArrayList<>(Arrays.asList(85)));
		
		Assert.assertEquals(0, searchMatrix(A, 41));
		
	}
	
	@Test
	public void test4() {
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		
		A.add(new ArrayList<>(Arrays.asList(1)));
		
		A.add(new ArrayList<>(Arrays.asList(11)));
		A.add(new ArrayList<>(Arrays.asList(49)));
		A.add(new ArrayList<>(Arrays.asList(74)));
		A.add(new ArrayList<>(Arrays.asList(77)));
		A.add(new ArrayList<>(Arrays.asList(78)));
		A.add(new ArrayList<>(Arrays.asList(93)));
		A.add(new ArrayList<>(Arrays.asList(94)));
		
		Assert.assertEquals(1, searchMatrix(A, 49));
		
	}
}
