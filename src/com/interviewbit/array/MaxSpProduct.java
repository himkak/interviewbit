package com.interviewbit.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class MaxSpProduct {
	
	public int maxSpecialProduct(List<Integer> A) {
		int n=A.size();
		int[] leftMaxIndex= new int[n];
		int[] rightMaxIndex=new int[n];
		
		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(0);
		//iterate from left, and populate the max left
		for (int i = 1; i < n; i++) {
			while(!q.isEmpty()) {
				if(A.get(q.getLast())>A.get(i)) {
					break;
				}
				q.removeLast();
			}
			leftMaxIndex[i]= q.isEmpty() ? 0 : q.getLast();
			q.addLast(i);
		}
		q=new LinkedList<>();
		q.addLast(n-1);
		
		for (int i = n-2; i >= 0; i--) {
			while(!q.isEmpty()) {
				if(A.get(q.getLast())>A.get(i)) {
					break;
				}
				q.removeLast();
			}
			rightMaxIndex[i]= q.isEmpty() ? 0 : q.getLast();
			q.addLast(i);
		}
		
		long max=-1;
		for (int i = 0; i < n; i++) {
			long val=1L*leftMaxIndex[i] * rightMaxIndex[i];
			max= val>max?val:max;
		}
		
		return (int)(max%1000000007);
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

}
