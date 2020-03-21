package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class InorderTraversalOfCartesianTree {

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

	public TreeNode buildTree(ArrayList<Integer> A) {

		TreeNode prevNode = null;
		TreeNode root = null;
		boolean maxFound = false;
		for (int i = 0; i < A.size(); i++) {
			TreeNode node = new TreeNode(A.get(i));
			if (prevNode != null && root == null && node.val < prevNode.val) {
				maxFound = true;
				root = prevNode;
			} else if (root != null && root.val < node.val) {
				root = node;
			}

			if (!maxFound) {
				if (prevNode != null) {
					if (node.val > prevNode.val) {
						node.left = prevNode;
					} else {
						node.right = prevNode;
					}
				}

				prevNode = node;
			} else {
				prevNode.right = node;

			}
			if (i == A.size() - 1 && root == null) {
				root = node;
			}

		}
		return root;
	}

	@Test
	public void test() {
		buildTree(new ArrayList<Integer>(Arrays.asList(2, 1, 3)));
	}

}
