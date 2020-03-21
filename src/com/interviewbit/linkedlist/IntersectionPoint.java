package com.interviewbit.linkedlist;

public class IntersectionPoint {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int listASize = getSize(a);
		int listBSize = getSize(b);
		ListNode biggerList = null;
		ListNode smallerList = null;
		int diff = Math.abs(listASize) - listBSize;
		if (listASize > listBSize) {
			biggerList = a;
			smallerList = b;
		} else {
			biggerList = b;
			smallerList = a;
		}
		for (int i = 0; i < diff; i++) {
			biggerList = biggerList.next;

		}

		while (smallerList.next != null) {
			if (biggerList.val == smallerList.val) {
				return biggerList;
			}
			biggerList = biggerList.next;
			smallerList = smallerList.next;
		}
		return null;
	}

	private int getSize(ListNode b) {
		int size = 0;
		while (b.next != null) {
			size++;
		}
		return size;
	}

}
