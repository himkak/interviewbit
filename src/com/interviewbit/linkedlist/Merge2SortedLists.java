package com.interviewbit.linkedlist;

import org.junit.Test;

public class Merge2SortedLists {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode root = null;
		ListNode curr = null;
		while (A != null || B != null) {
			ListNode tmp = null;
			if ((A != null && B != null && A.val <= B.val) || (A != null && B == null)) {
				tmp = new ListNode(A.val);
				A = A.next;
			} else {
				tmp = new ListNode(B.val);
				B = B.next;
			}

			if (curr == null) {
				curr = tmp;
			} else {
				curr.next = tmp;
				curr = curr.next;
			}

			if (root == null) {
				root = curr;
			}

		}
		return root;
	}

	@Test
	public void test() {
		ListNode A = new ListNode(4);
		A.next = new ListNode(5);
		A.next.next = new ListNode(6);

		ListNode B = new ListNode(1);
		B.next = new ListNode(2);
		B.next.next = new ListNode(3);

		mergeTwoLists(A, B);
	}

}
