package com.interviewbit.tree;

import org.junit.Assert;
import org.junit.Test;

public class ValidBST {

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

	public boolean isValidBst(int max, int min, TreeNode A) {
		if (A == null) {
			return true;
		}
		if ((A.left != null && A.left.val > A.val) || (A.right != null && A.right.val < A.val)) {
			return false;
		}

		if (A.val >= max || A.val <= min) {
			return false;
		}

		return isValidBst(A.val, min, A.left) && isValidBst(max, A.val, A.right);

	}

	public int isValidBST(TreeNode A) {
		return isValidBst(Integer.MAX_VALUE, Integer.MIN_VALUE, A) ? 1 : 0;
	}
	
	
	@Test
	public void test5() {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		Assert.assertEquals(0, isValidBST(root));

	}

	@Test
	public void test4() {

		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);

		Assert.assertEquals(0, isValidBST(root));

	}

	@Test
	public void test3() {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);

		Assert.assertEquals(0, isValidBST(root));

	}

	@Test
	public void test() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		Assert.assertEquals(0, isValidBST(root));

	}

	@Test
	public void test1() {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		Assert.assertEquals(1, isValidBST(root));

	}

	@Test
	public void test2() {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);

		Assert.assertEquals(1, isValidBST(root));

	}

}
