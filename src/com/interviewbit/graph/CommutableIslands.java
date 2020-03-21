package com.interviewbit.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class CommutableIslands {

	class NodeDist implements Comparable<NodeDist> {
		int node;
		int dist;

		NodeDist(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(NodeDist o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	int[] distanceFromSrc;
	PriorityQueue<NodeDist> pq;
	List<Integer> processedNodes;

	public int solve(int A, int[][] B) {
		int src = 1;
		distanceFromSrc = new int[A];
		processedNodes = new ArrayList<>();
		pq = new PriorityQueue<>();
		pq.add(new NodeDist(src, 0));
		// fetch the srcNode and populate its distance
		for (int i = 0; i < B.length; i++) {
			int dest = B[i][1];
			int dist = B[i][2];
			int currNode = B[i][0];
			if (currNode == src) {
				distanceFromSrc[dest-1] = dist;

			} else {
				distanceFromSrc[dest-1] = Integer.MAX_VALUE;
			}

		}

		while (processedNodes.size() < A) {
			NodeDist node = pq.poll();
			if (null!=node && !processedNodes.contains(node.node)) {
				processedNodes.add(node.node);
				List<Integer> nextNodesIndex = getNextNodes(node.node, B);

				for (int i = 0; i < nextNodesIndex.size(); i++) {
					int nextNode = B[i][1];
					int nextNodeDist = B[i][2];

					int totalDist = node.dist + nextNodeDist;
					if (distanceFromSrc[nextNode-1] > totalDist) {
						distanceFromSrc[nextNode-1] = totalDist;
					}
					pq.add(new NodeDist(nextNode, nextNodeDist));
				}
			}
		}
		return distanceFromSrc[A];
	}

	private List<Integer> getNextNodes(int node, int[][] b) {
		List<Integer> nextNodes = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
			int currNode = b[i][0];
			if (currNode == node) {
				nextNodes.add(i);
			}
		}
		return nextNodes;
	}

	@Test
	public void test() {
		int noOfNodes = 4;
		int[][] B = { { 1, 2, 1 }, { 2, 3, 4 }, { 1, 4, 3 }, { 4, 3, 2 }, { 1, 3, 10 } };

		Assert.assertEquals(6, solve(noOfNodes, B));
	}

}
