package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementInBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int kthsmallest(TreeNode A, int B) {
		List<Integer> result = new ArrayList<>();
		iterateInOrder(A, B, result);
		return result.get(B-1);
	}

	private void iterateInOrder(TreeNode a, int b, List<Integer> readVals) {

		if (a != null && readVals.size() < b) {
			iterateInOrder(a.left, b, readVals);
			readVals.add(a.val);
			iterateInOrder(a.right, b, readVals);
		}

	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		Assert.assertEquals(2, kthsmallest(root, 2));
	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(4);
		TreeNode left1 = new TreeNode(2);

		root.left = left1;
		left1.left = new TreeNode(1);
		left1.right = new TreeNode(3);

		TreeNode right1 = new TreeNode(6);

		root.right = right1;
		right1.left = new TreeNode(5);
		right1.right = new TreeNode(7);

		// root.right = new TreeNode(1);
		for (int i = 1; i <= 7; i++) {
			System.out.println("i:" + i);
			Assert.assertEquals(i, kthsmallest(root, i));
		}
	}

}
