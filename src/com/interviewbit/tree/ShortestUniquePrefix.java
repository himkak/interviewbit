package com.interviewbit.tree;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ShortestUniquePrefix {

	class Trie {
		Node root;

		public void addWord(String word, int index) {

			char[] chars = word.toCharArray();
			Node n = root;

			for (int i = 0; i < chars.length; i++) {
				char ch = chars[i];
				if (n.contains(ch)) {
					n = n.getNode(ch);
				} else {
					n = n.addNode(ch, index);

				}
			}

		}

		Trie() {
			root = new Node();
		}
	}

	class Node {
		char ch;
		List<Node> nodes;
		int count;
		int index;

		public boolean contains(char ch2) {
			if (nodes != null) {
				for (Node n : nodes) {
					if (n.ch == ch2) {
						n.count = n.count + 1;
						return true;
					}
				}
			}
			return false;
		}

		public Node addNode(char ch2, int index) {
			if (nodes == null) {
				nodes = new LinkedList<>();
			}
			Node n = new Node();
			n.ch = ch2;
			n.count = 1;
			n.index = index;
			nodes.add(n);
			return n;
		}

		public Node getNode(char ch2) {
			for (Node n : nodes) {
				if (n.ch == ch2) {
					return n;
				}
			}

			return null;
		}

	}

	public String[] prefix(String[] words) {
		Trie trie = new Trie();
		for (int i = 0; i < words.length; i++) {
			trie.addWord(words[i], i);

		}
		String[] result = new String[words.length];
		iterateTrie(trie.root, result, "");
		return result;
	}

	private void iterateTrie(Node node, String[] result, String word) {

		if (node.count == 1) {
			result[node.index] = word;
			return;
		}
		for (Node n : node.nodes) {
			iterateTrie(n, result, word + n.ch);

		}

	}

	@Test
	public void test() {
		String[] words = { "zebra", "dog", "duck", "dot" };
		prefix(words);
	}

}
