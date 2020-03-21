package com.interviewbit.tree;

import org.junit.Test;

public class BalancedBST {

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

	public TreeNode sortedArrayToBST(final int[] A) {
		if (A.length == 1) {
			TreeNode res = new TreeNode(A[0]);
			return res;
		}
		TreeNode res = getBst(0, A.length - 1, A);
		return res;

	}

	private TreeNode getBst(int startIdx, int endIdx, int[] a) {
		if (startIdx > endIdx) {
			return null;
		}
		if (startIdx == endIdx) {
			return new TreeNode(a[startIdx]);
		}

		int rootIndex = (startIdx + endIdx) / 2;
		TreeNode root = new TreeNode(a[rootIndex]);
		root.left = getBst(startIdx, rootIndex - 1, a);
		root.right = getBst(rootIndex + 1, endIdx, a);

		return root;
	}

	@Test
	public void test() {
		int[] A = { 1, 2, 3, 4, 5, 6, 7 };
		sortedArrayToBST(A);
	}

	@Test
	public void test1() {
		int[] A = { 1, 2 };
		sortedArrayToBST(A);
	}

	@Test
	public void test2() {
		int[] A = { 1 };
		sortedArrayToBST(A);
	}

}
