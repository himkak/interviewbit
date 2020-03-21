package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ZigZagLevelOrderTraversalBT {
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

	public int[][] zigzagLevelOrder(TreeNode A) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(A);
		List<List<Integer>> result = new ArrayList<>();
		zigZagLevelOrder(A, 0, queue, result);

		int[][] finalRes = new int[result.size()][];

		for (int i = 0; i < result.size(); i++) {
			finalRes[i] = result.get(i).stream().mapToInt(Integer::intValue).toArray();
		}

		return finalRes;
	}

	private void zigZagLevelOrder(TreeNode a, int i, Queue<TreeNode> queue, List<List<Integer>> result) {
		List<Integer> currList = new ArrayList<>();
		currList.add(queue.peek().val);
		result.add(currList);
		while (!queue.isEmpty()) {
			Queue<TreeNode> tempQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode n = queue.poll();
				if (n != null) {
					if (n.left != null)
						tempQueue.add(n.left);
					if (n.right != null)
						tempQueue.add(n.right);

				}
			}
			currList = new ArrayList<>();
			Stack<Integer> stack = new Stack<>();
			while (!tempQueue.isEmpty()) {
				TreeNode n = tempQueue.poll();
				if (i % 2 == 0) {
					stack.add(n.val);
				} else {
					currList.add(n.val);
				}
				queue.add(n);
			}
			if (i % 2 == 0) {
				while (!stack.isEmpty()) {
					currList.add(stack.pop());
				}
			}

			if (currList.size() > 0) {
				result.add(currList);
			}
			i++;
		}

	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		int[][] expected = { { 3 }, { 20, 9 }, { 15, 7 } };

		Assert.assertArrayEquals(expected, zigzagLevelOrder(root));

	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);

		int[][] expected = { { 3 }, { 20, 9 }, { 2, 1, 15, 7 } };

		Assert.assertArrayEquals(expected, zigzagLevelOrder(root));

	}
}
