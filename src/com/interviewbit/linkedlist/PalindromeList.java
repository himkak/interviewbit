package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PalindromeList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public int lPalin(ListNode A) {
		ListNode head = A;
		int len = getLen(A);
		ListNode tail = null;
		ListNode iterNode = A;
		int cnt = 0;
		ListNode prevNode = null;
		// ListNode next = null;
		while (null != iterNode) {

			tail = iterNode.next != null ? iterNode.next : iterNode;
			if (cnt >= (len / 2) + 1) {
				// if (iterNode.next != null)
				iterNode.next = prevNode;
				if (cnt >= (len / 2)) {
					prevNode = iterNode;
				}
				if (iterNode != tail) {
					iterNode = tail;
				} else {
					iterNode = null;
				}
			} else {
				if (cnt >= (len / 2)) {
					prevNode = iterNode;
				}
				iterNode = iterNode.next;
			}

			cnt++;
		}

		for (int i = 0; i < len / 2; i++) {
			if (head.val != tail.val) {
				return 0;
			}
			head=head.next;
			tail=tail.next;

		}
		return 1;
	}

	private int getLen(ListNode a) {
		int size = 0;
		while (a != null) {
			a = a.next;
			size++;

		}
		return size;
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		int res = lPalin(head);
		Assert.assertEquals(0, res);
	}

	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);

		int res = lPalin(head);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		// head.next.next.next.next.next = new ListNode(1);

		int res = lPalin(head);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);

		int res = lPalin(head);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test4() {
		ListNode head = new ListNode(8);
		head.next = new ListNode(1);

		int res = lPalin(head);
		Assert.assertEquals(0, res);
	}
	
	@Test
	public void test5() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(1);
		//head.next.next.next.next.next = new ListNode(1);

		int res = lPalin(head);
		Assert.assertEquals(0, res);
	}
}
