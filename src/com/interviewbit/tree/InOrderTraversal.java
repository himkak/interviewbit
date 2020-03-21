package com.interviewbit.tree;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class InOrderTraversal {

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

	public int[] inorderTraversal(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<>();
		inOrderTraversal(res, A);
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;

	}

	private void inOrderTraversal(ArrayList<Integer> arr, TreeNode A) {
		if (A != null) {
			inOrderTraversal(arr,A.left);
			arr.add(A.val);
			inOrderTraversal(arr,A.right);
		}
	}
	
	@Test
	public void test() {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		
		int[] expected= {1,3,2};
		Assert.assertArrayEquals(expected, inorderTraversal(root));
		
	}
	
	@Test
	public void test1() {
		TreeNode root=new TreeNode(1);
		
		int[] expected= {1};
		Assert.assertArrayEquals(expected, inorderTraversal(root));
		
	}

}
