package com.interviewbit.tree;

public class MaxDepthOfBinaryTree {

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

	public int maxDepth(TreeNode A) {
		if (A == null) {
			return 0;
		}

		int lDepth = maxDepth(A.left);
		int rDepth = maxDepth(A.right);

		return Math.max(lDepth, rDepth) + 1;
	}

}
