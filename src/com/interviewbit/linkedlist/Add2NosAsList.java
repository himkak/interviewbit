package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class Add2NosAsList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		int carry = 0;
		ListNode head = null;
		ListNode res = null;
		while (A != null || B!=null || carry>0) {
			int aVal = 0;
			int bVal = 0;
			if (A != null)
				aVal = A.val;
			if (B != null)
				bVal = B.val;
			int sum = aVal + bVal + carry;
			if (sum > 9) {
				carry = 1;
				sum = sum % 10;
			}else {
				carry=0;
			}
			if (res == null) {
				res = new ListNode(sum);
				head = res;
			} else {
				res.next = new ListNode(sum);
				res = res.next;
			}

			A = A!=null ? A.next : null;
			B = B!=null ? B.next : null;;
		}
		return head;

	}

	

	@Test
	public void test() {

		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);

		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);

		ListNode res = addTwoNumbers(a, b);

		int[] exp = { 7, 0, 8 };

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

	@Test
	public void test1() {

		ListNode a = new ListNode(9);
		a.next = new ListNode(9);
		a.next.next = new ListNode(1);

		ListNode b = new ListNode(1);

		ListNode res = addTwoNumbers(a, b);

		int[] exp = { 0, 0, 2 };

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}
	
	@Test
	public void test2() {

		ListNode a = new ListNode(0);

		ListNode b = new ListNode(1);
		b.next = new ListNode(0);
		b.next.next = new ListNode(1);

		ListNode res = addTwoNumbers(a, b);

		int[] exp = {1,0,1};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

	
	@Test
	public void test3() {

		ListNode a = new ListNode(1);

		ListNode b = new ListNode(9);
		b.next = new ListNode(9);
		b.next.next = new ListNode(9);

		ListNode res = addTwoNumbers(a, b);

		int[] exp = {0,0,0,1};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

}
