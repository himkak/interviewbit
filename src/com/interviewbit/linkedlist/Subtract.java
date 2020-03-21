package com.interviewbit.linkedlist;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Subtract {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListNode other = (ListNode) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (val != other.val)
				return false;
			return true;
		}

		private Subtract getEnclosingInstance() {
			return Subtract.this;
		}
		
		
	}

	public ListNode subtract(ListNode A) {
		ArrayList<Integer> al = new ArrayList<>();
		ListNode head = A;
		int cnt = 0;
		while (A != null) {
			cnt++;
			al.add(A.val);
			A = A.next;
		}

		ListNode B = head;
		for (int i = 0; i < cnt / 2; i++) {

			B.val = al.get(cnt - i-1) - B.val;
			B = B.next;
		}

		return head;

	}

	@Test
	public void test() {
		ListNode head = convertArrayToLinkedList(new int[] { 1, 2, 3, 4, 5 });
		ListNode resHead = subtract(head);
		ListNode expectedHead = convertArrayToLinkedList(new int[] { 4, 2, 3, 4, 5 });
		Assert.assertEquals(expectedHead, resHead);

	}

	private ListNode convertArrayToLinkedList(int[] arr) {
		ListNode li = null;
		ListNode head = null;
		for (int inp : arr) {
			if (li != null && li.next!=null) {
				li = li.next;
			}
			ListNode elem = new ListNode(inp);
			if (li == null) {
				li = elem;
				head = li;
			} else {
				li.next = elem;
			}

		}
		return head;
	}

}
