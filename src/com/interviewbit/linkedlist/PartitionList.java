package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.interviewbit.linkedlist.PalindromeList.ListNode;

public class PartitionList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode A, int B) {
		ListNode smaller = null;
		ListNode greater = null;

		ListNode start = null;

		ListNode greaterStart = null;

		while (A != null) {

			if (A.val < B) {
				if (smaller == null) {
					smaller = new ListNode(A.val);
					start = smaller;
				} else {
					smaller.next = new ListNode(A.val);
					smaller = smaller.next;
				}

			} else {
				if (greater == null) {
					greater = new ListNode(A.val);
					greaterStart = greater;
				} else {
					greater.next = new ListNode(A.val);
					greater = greater.next;
				}
			}
			A = A.next;
		}
		if (smaller != null) {
			smaller.next = greaterStart;
		}else {
			start=greaterStart;
		}
		return start;
	}

	@Test
	public void test() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode res = partition(head, 3);

		int[] exp = { 1, 2, 2, 4, 3, 5 };

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

	@Test
	public void test1() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode res = partition(head, 1);

		int[] exp = { 1, 4, 3, 2, 5, 2 };

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

}
