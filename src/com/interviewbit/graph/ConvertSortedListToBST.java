package com.interviewbit.graph;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.interviewbit.tree.TreeNode;

public class ConvertSortedListToBST {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public TreeNode sortedListToBST(ListNode a) {
		ArrayList<Integer> al = new ArrayList<>();
		ListNode curr = a;
		while (curr != null) {
			al.add(curr.val);
			curr = curr.next;
		}
		return convertToBST(0, al.size() - 1, al);

	}

	private TreeNode convertToBST(int start, int end, ArrayList<Integer> al) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode currNode = new TreeNode(al.get(mid));
		currNode.left = convertToBST(start, mid - 1, al);
		currNode.right = convertToBST(mid + 1, end, al);
		return currNode;

	}

	@Test
	public void test() {
		ListNode l =new ListNode(1);
		l.next=new ListNode(2);
		l.next.next= new ListNode(3);
		
		TreeNode expected= new TreeNode(2);
		expected.left=new TreeNode(1);
		expected.right=new TreeNode(3);
		
		Assert.assertEquals(expected, sortedListToBST(l));
	}
}
