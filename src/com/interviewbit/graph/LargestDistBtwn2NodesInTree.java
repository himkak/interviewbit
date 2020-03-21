package com.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LargestDistBtwn2NodesInTree {

	class TreeNode {
		int val;
		List<TreeNode> nodes;

		TreeNode(int val) {
			this.val = val;
		}
	}

	private int maxDiam;
	private Map<Integer, Integer> elemsPresentAtDepth = new HashMap<>();

	public int solve(int[] A) {
		// index , connectingIndexes
		Map<Integer, List<TreeNode>> connections = new HashMap<>();
		TreeNode root = null;

		for (int i = 0; i < A.length; i++) {

			if (A[i] == -1) {
				root = new TreeNode(i);
			} else {
				if (connections.get(A[i]) != null) {
					connections.get(A[i]).add(new TreeNode(i));
				} else {
					connections.put(A[i], new ArrayList<>(Arrays.asList(new TreeNode(i))));
				}
			}

		}
		connectNodes(root, connections);

		getDiameter(root, 0, 0);

		return maxDiam;

	}

	private void getDiameter(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		elemsPresentAtDepth.computeIfAbsent(depth);
		maxDiam = Math.max(maxDiam, position - elemsPresentAtDepth.get(depth) - 1);
		if (root.nodes != null) {
			for (int i = 0; i < root.nodes.size(); i++) {
				getDiameter(root.nodes.get(i), depth + 1, position + 1);
			}
		}
	}

	private void connectNodes(TreeNode curr, Map<Integer, List<TreeNode>> connections) {
		curr.nodes = connections.get(curr.val);
		if (curr.nodes != null) {
			for (int i = 0; i < curr.nodes.size(); i++) {
				connectNodes(curr.nodes.get(i), connections);
			}
		}

	}

	@Test
	public void test() {
		int[] A = { -1, 0, 0, 0, 3 };
		Assert.assertEquals(3, solve(A));
	}

}
