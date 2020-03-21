package com.interviewbit.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class IdenticalBinaryTrees {

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

	public int isSameTree(TreeNode A, TreeNode B) {
		boolean isSame = iterateBFS(A, B);

		return isSame ? 1 : 0;
	}

	private boolean iterateBFS(TreeNode a, TreeNode b) {
		Queue<TreeNode> queueA = new LinkedList<>();
		Queue<TreeNode> queueB = new LinkedList<>();
		queueA.add(a);
		queueB.add(b);

		while (!queueA.isEmpty() || !queueB.isEmpty()) {
			TreeNode nodeA = queueA.poll();
			TreeNode nodeB = queueB.poll();
			if (nodeA == null && nodeB == null) {
				return true;
			}

			if ((nodeA != null && nodeB == null) || (nodeA == null && nodeB != null) || nodeA.val != nodeB.val) {
				return false;
			}
			queueA.add(nodeA.left);
			queueA.add(nodeA.right);

			queueB.add(nodeB.left);
			queueB.add(nodeB.right);

		}

		return true;
	}

	@Test
	public void test() {
		TreeNode A = createTreeBFS(Arrays.asList(1, 2, 3));
		TreeNode B = createTreeBFS(Arrays.asList(1, 2, 3));
		Assert.assertEquals(1, isSameTree(A, B));

	}

	@Test
	public void test1() {
		TreeNode A = createTreeBFS(Arrays.asList(1, 2, 3, 4, -1));
		TreeNode B = createTreeBFS(Arrays.asList(1, 2, 3));
		Assert.assertEquals(0, isSameTree(A, B));

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

}
