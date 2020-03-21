package com.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class LevelOrdertRaversal {

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

	public int[][] levelOrder(TreeNode A) {
		List<List<Integer>> levelOrderList = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, Integer> nodeDepthMap = new HashMap<>();

		queue.add(A);
		levelOrderList.add(new ArrayList<>(Arrays.asList(A.val)));
		nodeDepthMap.put(A.val, 0);

		while (!queue.isEmpty()) {
			TreeNode elem = queue.poll();
			int depth = nodeDepthMap.get(elem.val) + 1;
			if (elem.left != null) {
				queue.add(elem.left);
				if (levelOrderList.size() > depth) {
					levelOrderList.get(depth).add(elem.left.val);
				} else {
					levelOrderList.add(new ArrayList<>(Arrays.asList(elem.left.val)));
				}
				nodeDepthMap.put(elem.left.val, depth);
			}

			if (elem.right != null) {
				queue.add(elem.right);
				if (levelOrderList.size() > depth) {
					levelOrderList.get(depth).add(elem.right.val);
				} else {
					levelOrderList.add(new ArrayList<>(Arrays.asList(elem.right.val)));
				}
				nodeDepthMap.put(elem.right.val, depth);
			}
		}

		int[][] result = new int[levelOrderList.size()][];
		for (int i = 0; i < levelOrderList.size(); i++) {
			result[i] = new int[levelOrderList.get(i).size()];
			for (int j = 0; j < levelOrderList.get(i).size(); j++) {
				result[i][j] = levelOrderList.get(i).get(j);
			}

		}
		return result;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int[][] expecteds = { { 3 }, { 9, 20 }, { 15, 7 } };

		Assert.assertArrayEquals(expecteds, levelOrder(root));

	}

}
