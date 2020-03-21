package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class ListCycle {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode a) {
		ListNode start = a;
		ListNode slow = a.next;
		ListNode fast = a.next.next;
		ListNode insideLoopPt = null;
		while (a != null) {
			if (slow == fast) {
				insideLoopPt = slow;
				break;
			} else {
				slow = slow.next;
				if (fast.next == null || fast.next.next == null) {
					return null;
				}
				fast = fast.next.next;
			}
			a = a.next;
		}
		if (null != insideLoopPt) {
			slow = start;
			while (slow != null) {
				if (slow == fast) {
					return slow;
				} else {
					slow = slow.next;
					fast = fast.next;
				}
			}
		}
		return null;
		
	}
//			a = start;
//			while (a != null) {
//				if (isReachableFrom(insideLoopPt, a)) {
//					return a;
//				}
//				a = a.next;
//			}

	private boolean isReachableFrom(ListNode insideLoopPt, ListNode a) {
		ListNode browse = insideLoopPt;
		boolean unchecked = true;
		while (browse != insideLoopPt || unchecked) {
			if (a == browse) {
				return true;
			}
			browse = browse.next;
			unchecked = false;
		}
		return false;
	}

	@Test
	public void test() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode cyclePt = new ListNode(3);

		head.next.next = cyclePt;
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = cyclePt;

		ListNode res = detectCycle(head);
		Assert.assertEquals(3, res.val);

	}

	@Test
	public void test1() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode cyclePt = new ListNode(3);

		head.next.next = cyclePt;
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = cyclePt;

		ListNode res = detectCycle(head);
		Assert.assertEquals(3, res.val);

	}

	@Test
	public void test2() {
//87797 23219 41441 58396 48953 94603 2721 95832 49029 98448 65450
		ListNode head = new ListNode(87797);
		head.next = new ListNode(23219);
		ListNode cyclePt = new ListNode(41441);

		head.next.next = cyclePt;
		head.next.next.next = new ListNode(58396);
		head.next.next.next.next = new ListNode(48953);
		head.next.next.next.next.next = new ListNode(94603);
		head.next.next.next.next.next.next = new ListNode(2721);
		head.next.next.next.next.next.next.next = new ListNode(95832);
		head.next.next.next.next.next.next.next.next = new ListNode(49029);
		head.next.next.next.next.next.next.next.next.next = new ListNode(98448);
		head.next.next.next.next.next.next.next.next.next.next = new ListNode(65450);

		ListNode res = detectCycle(head);
		Assert.assertNull(res);

	}

}
