package com.interviewbit.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBinaryTree {

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

	public int isBalanced(TreeNode A) {

		int ht = getHeight(A);

		return ht > -1 ? 1 : 0;
	}

	private int getHeight(TreeNode a) {

		if (a == null) {
			return 0;
		}

		int leftHt = getHeight(a.left);
		int rightHt = getHeight(a.right);
		if (leftHt == -1 || rightHt == -1) {
			return -1;
		}
		leftHt = leftHt + 1;
		rightHt = rightHt + 1;
		int diff = leftHt - rightHt;
		if (Math.abs(diff) > 1) {
			return -1;
		}
		return Math.max(leftHt, rightHt);
	}

	@Test
	public void test6() {
		TreeNode root = createTreeBFS(Arrays.asList(167, 3, 62, 31, 73, 52, 16, 2, 23, 66, 71, 11, 18, 76, 43, 19, 47,
				53, 42, -1, 12, 4, -1, 34, 7, -1, -1, 13, 25, 51, 44, 80, 50, -1, 83, 46, 48, -1, -1, -1, 35, 75, -1,
				65, 28, 59, 30, 20, -1, -1, -1, -1, -1, 37, 8, 21, 77, 1, -1, 79, 58, -1, -1, -1, -1, -1, -1, -1, -1,
				82, -1, -1, -1, -1, 61, -1, 67, 26, 9, 70, -1, 38, 22, -1, 55, 24, 27, -1, -1, -1, 54, 56, -1, 32, -1,
				-1, -1, -1, -1, 57, -1, -1, -1, -1, -1, 69, -1, -1, 64, 29, -1, -1, 63, 81, -1, 15, 17, 72, 41, -1, -1,
				-1, -1, -1, -1, 14, -1, -1, -1, 49, -1, -1, 60, 45, 68, 74, 36, 6, -1, -1, 10, -1, -1, -1, 5, -1, -1,
				39, -1, -1, -1, -1, 40, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1));
		Assert.assertEquals(0, isBalanced(root));
	}

	@Test
	public void test5() {
		TreeNode root = createTreeBFS(Arrays.asList(1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1));
		Assert.assertEquals(0, isBalanced(root));
	}

	@Test
	public void test4() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root.right = right1;
		TreeNode right1left1 = new TreeNode(4);
		right1.left = right1left1;
		right1left1.right = new TreeNode(5);
		Assert.assertEquals(0, isBalanced(root));
	}

	private TreeNode createTreeBFS(List<Integer> list) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(list.get(0));
		queue.add(root);

		for (int i = 1; i < list.size() - 1; i = i + 2) {
			TreeNode node = queue.poll();
			int leftVal = list.get(i);
			int rightVal = list.get(i + 1);
			if (leftVal != -1) {
				TreeNode left = new TreeNode(leftVal);
				node.left = left;
				queue.add(left);
			}
			if (rightVal != -1) {
				TreeNode right = new TreeNode(rightVal);
				node.right = right;
				queue.add(right);
			}
		}
		return root;

	}

	@Test
	public void test3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		Assert.assertEquals(1, isBalanced(root));
	}

	@Test
	public void test2() {
		TreeNode root = new TreeNode(1);
		Assert.assertEquals(1, isBalanced(root));
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Assert.assertEquals(1, isBalanced(root));

	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		root.left = left1;
		left1.right = new TreeNode(3);
		Assert.assertEquals(0, isBalanced(root));

	}

}
