package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class KReverseLinkedList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// public ListNode reverseList(ListNode A, int B) {

	/*
	 * public ListNode reverseList(ListNode A, int B) { int cnt = 0; ListNode prev =
	 * null; ListNode head = null; ListNode logicalStart=null; ListNode
	 * logicalTail=null; ListNode next = null; while (A != null) { cnt++;
	 * 
	 * 
	 * 
	 * next = A.next; if (cnt % B==0) { if (prev != null) { prev.next = next; A.next
	 * = prev; if(head!=null ) { logicalTail.next=logicalStart; } if (head == null)
	 * { head = A; } logicalStart=A; } prev = null; } else {
	 * 
	 * prev = A; } if(cnt%B==1) { logicalTail=A; }
	 * 
	 * A = next;
	 * 
	 * }
	 */

	public ListNode reverseList(ListNode A, int B) {

		int cnt = 0;
		ListNode head = null;
		ListNode start = null;
		ListNode reversedStart = null;
		ListNode reverseEnd = null;
		ListNode prevReverseEnd = null;
		ListNode next = A;
		if(B==1) {
			return A;
		}
		while (A != null) {
			cnt++;
			if (cnt % B == 1) {
				start = next;
			}
			if (cnt % B == 0) {
				next = A.next;
				A.next = null;

				ListNode n = reverseLinkedList(start);
				if (reversedStart == null) {
					reversedStart = n;
					reverseEnd = getReverseEnd(reversedStart);
					if (head == null) {
						head = reversedStart;
					}
					if (prevReverseEnd == null) {
						prevReverseEnd = reverseEnd;
					} else {
						prevReverseEnd.next = reversedStart;
						prevReverseEnd=reverseEnd;
					}
					reversedStart = null;
				} else {
					reverseEnd = getReverseEnd(reversedStart);
					reverseEnd.next = n;
				}
				A = next;

			} else {
				A = A.next;
			}

		}
		return head;
	}

	private ListNode getReverseEnd(ListNode reversedStart) {
		ListNode a = reversedStart;
		while (null != a.next) {
			a = a.next;
		}
		return a;
	}

	private ListNode reverseLinkedList(ListNode A) {
		ListNode prev = null;
		ListNode next = null;
		while (A != null) {
			next = A.next;
			A.next = prev;
			prev = A;
			A = next;

		}

		return prev;
	}

	@Test
	public void test() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode res = reverseList(head, 3);

		int[] exp = {3,2,1,6,5,4};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}
	
	@Test
	public void test2() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode res = reverseList(head, 2);

		int[] exp = {2,1,4,3,6,5};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

	
	@Test
	public void test1() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode res = reverseList(head, 6);

		int[] exp = {6,5,4,3,2,1};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}
	
	@Test
	public void test3() {

		ListNode head = new ListNode(8);
		head.next = new ListNode(11);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(12);
		head.next.next.next.next = new ListNode(0);

		ListNode res = reverseList(head, 1);

		int[] exp = {8,11,4,12,0};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

}
