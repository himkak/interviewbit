package com.interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NearestSmallestElement {

	class Stack {

		Node head;

		class Node {
			int val;
			Node next;

			public Node(int x) {
				this.val = x;
			}
		}

		public void push(int x) {

			Node n = new Node(x);
			if (head == null) {
				head = n;
			} else {
				n.next = head;
				head = n;
			}

		}

		public int pop() {
			int x = -1;
			if (head != null) {
				x = head.val;
				head = head.next;
			}
			return x;

		}

		public int peek() {
			return head.val;
		}
	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack nearestSmallest= new Stack();
		
		ArrayList<Integer> nearestSmallerList=new ArrayList<>();
		
		for (int i = 0; i < A.size(); i++) {
			
			while(nearestSmallest.head!=null && nearestSmallest.peek()>=A.get(i) ) {
				nearestSmallest.pop();
			}
			if(nearestSmallest.head==null) {
				nearestSmallerList.add(-1);
			}else {
				nearestSmallerList.add(nearestSmallest.peek());
			}
			nearestSmallest.push(A.get(i));
		}
		return nearestSmallerList;
	}
	
	/*
	 * public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) { Stack
	 * nearestSmaller = new Stack();
	 * 
	 * int prevSmallerVal = Integer.MAX_VALUE; int prev; for (int i = 0; i <
	 * A.size(); i++) { if (i == 0) { nearestSmaller.push(-1); } else { if (A.get(i)
	 * < prevSmallerVal) { nearestSmaller.push(-1); } else {
	 * nearestSmaller.push(prevSmallerVal); } } prevSmallerVal = A.get(i) <
	 * prevSmallerVal ? A.get(i) : prevSmallerVal; prev= A.get(i); }
	 * 
	 * Integer[] prevSmaller = new Integer[A.size()]; int i = A.size() - 1; while
	 * (nearestSmaller.head != null) { prevSmaller[i] = nearestSmaller.pop(); i--; }
	 * return new ArrayList<Integer>(Arrays.asList(prevSmaller)); }
	 */

	@Test
	public void test() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
		ArrayList<Integer> res = prevSmaller(al);

		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1, 4, -1, 2, 2));

		Assert.assertEquals(expected, res);
	}

	@Test
	public void test1() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3, 2, 1));
		ArrayList<Integer> res = prevSmaller(al);

		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1, -1, -1));

		Assert.assertEquals(expected, res);
	}

	
	@Test
	public void test2() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28 ));
		ArrayList<Integer> res = prevSmaller(al);

		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1, 34, -1, 27, -1, 5, 28, 5, 20 ));

		Assert.assertEquals(expected, res);
	}

}
