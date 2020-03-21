package com.interviewbit.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class SimplifyDirectoryPath {

	class Stack<T> {
		Node<T> head;
		// Node<T> tail;

		public void push(T elem) {
			Node<T> node = new Node<>(elem);
			if (head == null) {
				head = node;
				// tail= node;
			} else {
				node.next = head;
				head = node;
			}

		}

		public T pop() {
			Node<T> node = head;
			if (head != null) {
				head = head.next;
				return node.value;
			}
			return null;
		}


	}

	class Node<T> {
		T value;
		Node<T> next;

		public Node(T val) {
			this.value = val;
		}
	}

	public String simplifyPath(String A) {

		String[] dirs = A.split("/");
		Stack<String> stack = new Stack<>();

		for (String dir : dirs) {
			if (dir.equals("..")) {
				stack.pop();
			} else if (!dir.trim().isEmpty() && !dir.equals(".")) {
				stack.push(dir);
			}

		}

		Stack<String> stack2 = new Stack<>();
		while (stack.head != null) {
			stack2.push(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (stack2.head != null) {
			sb.append("/" + stack2.pop());
		}

		return sb.toString().isEmpty() ? "/" : sb.toString();

	}

	@Test
	public void test() {

		String A = "/a/./b/../../c/";
		String res = simplifyPath(A);
		Assert.assertEquals("/c", res);

	}

	@Test
	public void test1() {

		String A = "/home/";
		String res = simplifyPath(A);
		Assert.assertEquals("/home", res);

	}

	@Test
	public void test2() {

		String A = "/../";
		String res = simplifyPath(A);
		Assert.assertEquals("/", res);

	}

	@Test
	public void test3() {

		String A = "/home//foo/";
		String res = simplifyPath(A);
		Assert.assertEquals("/home/foo", res);

	}
}
