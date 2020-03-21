package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HotelReviews {

	class ScoreIndexMap {
		int score;
		int index;

		public ScoreIndexMap(int score, int index) {
			super();
			this.score = score;
			this.index = index;
		}

	}

	class BST {
		Node root;

		class Node {
			ScoreIndexMap value;
			Node left;
			Node right;

			Node(ScoreIndexMap value) {
				this.value = value;
			}
		}

		public void addNode(ScoreIndexMap val) {
			if (root == null) {
				root = new Node(val);
			} else {
				if (val.score <= root.value.score) {
					if (root.left == null) {
						root.left = new Node(val);
					} else {
						addNode(root.left, val);
					}
				} else {
					if (null == root.right) {
						root.right = new Node(val);
					} else {
						addNode(root.right, val);
					}
				}
			}
		}

		private void addNode(Node n, ScoreIndexMap val) {
			if (val.score < n.value.score) {
				if (n.left == null) {
					n.left = new Node(val);
				} else {
					addNode(n.left, val);
				}
			} else {
				if (null == n.right) {
					n.right = new Node(val);
				} else {
					addNode(n.right, val);
				}
			}

		}

		public ArrayList<Integer> sortDescending() {

			ArrayList<Integer> descendingSort = new ArrayList<>();
			sortDescending(descendingSort, root);
			return descendingSort;
		}

		private void sortDescending(ArrayList<Integer> descendingSort, Node node) {
			if (node != null) {
				sortDescending(descendingSort, node.right);
				System.out.print(node.value.score+":"+node.value.index+",");
				descendingSort.add(node.value.index);
				sortDescending(descendingSort, node.left);

			}
		}

	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		String[] goodWords = A.split("_");
		//Set<String> goodUniqueWords=new HashSet<>(Arrays.asList(goodWords));
		// List<ScoreIndexMap> socreIdxMap = new ArrayList<>();
		BST bst = new BST();
		for (int i = 0; i < B.size(); i++) {
			String review = B.get(i);

			List<String> reviewWords = new LinkedList<>(Arrays.asList(review.split("_")));
			int score = 0;

			for (String goodWord : goodWords) {
				if (reviewWords.contains(goodWord)) {
					int sizeb4= reviewWords.size();
					reviewWords.removeAll(Arrays.asList(goodWord));
					int diff= sizeb4-reviewWords.size();
					score= score+diff;
				}
			}
			bst.addNode(new ScoreIndexMap(score, i));
		}

		return bst.sortDescending();

	}

	@Test
	public void test() {

		ArrayList<String> reviews = new ArrayList<>(
				Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));

		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 0, 1));

		Assert.assertEquals(expected, solve("cool_ice_wifi", reviews));
	}

}
