package com.interviewbit.graph;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class SumOfFibNumbers {

	public int fibsum(int A) {
		Stack<Integer> stack = new Stack<>();
		int curr = 1;
		int prev = 1;
		stack.add(prev);
		while (curr <= A) {
			stack.add(curr);
			int tmp = curr;
			curr = curr + prev;
			prev = tmp;
		}

		int pending = A;
		int i = 0;
		while (pending > 0) {
			int currElem = stack.pop();
			if (currElem <= pending) {
				i++;
				pending = pending - currElem;
			}

		}

		return i;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, fibsum(4));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(2, fibsum(7));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, fibsum(2));
	}

}
