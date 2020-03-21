package com.interviewbit.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedList2 {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode A, int B, int C) {

		int cnt = 0;
		ListNode start = A;

		ListNode beforeBPtr = null;
		ListNode afterCPtr = null;
		ListNode bPtr = null;
		ListNode prev = null;

		while (A != null && cnt <= C) {
			cnt++;
			if (cnt >= B) {
				if (null == beforeBPtr) {
					beforeBPtr = B>1 ? prev : null;
					bPtr= null==bPtr ? A : bPtr;
				}
				if(cnt==C) {
					afterCPtr= A.next;
					A.next=null;
					ListNode reversedListStart=	reverseLinkedList(bPtr);
					if(beforeBPtr!=null) {
					beforeBPtr.next= reversedListStart;
					}else {
						start= reversedListStart;
					}
					
					ListNode reversedListend= getReverseEnd(bPtr);
					reversedListend.next=afterCPtr;
				}

			}
			prev = A;
			A = A.next;

		}

		return start;
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

		ListNode res = reverseBetween(head, 2,4);

		int[] exp = {1,4,3,2,5};

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

		ListNode res = reverseBetween(head, 1,5);

		int[] exp = {5,4,3,2,1};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}

	
	@Test
	public void test3() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode res = reverseBetween(head, 1,3);

		int[] exp = {3,2,1,4,5};

		for (int i = 0; i < exp.length; i++) {

			Assert.assertEquals(exp[i], res.val);
			res = res.next;
		}

	}


}
