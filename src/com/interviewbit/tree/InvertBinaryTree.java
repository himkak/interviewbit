package com.interviewbit.tree;

import org.junit.Test;

public class InvertBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}

	}

	public TreeNode invertTree(TreeNode A) {
		if (A == null) {
			return null;

		}
		TreeNode tmp = A.left;
		A.left = A.right;
		A.right = tmp;

		if (A.left != null) {
			invertTree(A.left);
		}
		if (A.right != null) {
			invertTree(A.right);
		}
		return A;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);

		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root.left = left1;
		root.right = right1;

		left1.left = new TreeNode(4);
		left1.right = new TreeNode(5);
		right1.left = new TreeNode(6);
		right1.right = new TreeNode(7);
		TreeNode result = invertTree(root);
		System.out.println();
	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(1);
		TreeNode result = invertTree(root);
		System.out.println();

	}

}
