package com.interviewbit.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class EvaluateExpression {

	class Stack<T> {
		Node<T> head;

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

		public T peek() {
			return head.value;
		}

	}

	class Node<T> {
		T value;
		Node<T> next;

		public Node(T val) {
			this.value = val;
		}
	}

	public int evalRPN(ArrayList<String> A) {
		Stack<String> stack = new Stack<>();
		if(A.size()==1) {
			return Integer.parseInt(A.get(0));
		}

		for (String elem : A) {
			stack.push(elem);
		}
		String operator = null;
		String oper1 = null;
		String oper2 = null;

		Stack<String> stack2 = new Stack<>();
		String res = null;
		while (stack.head != null) {
			String elem = stack.pop();
			if (isOperator(elem)) {
				if (operator == null && oper1 == null && oper2 == null) {
					if (isOperator(stack.peek())) {
						stack2.push(elem);
					} else {
						operator = elem;
					}
				} else {
					stack2.push(operator);
					if(oper1!=null)
					stack2.push(oper1);
					operator = elem;
					oper1 = null;
				}
			} else {
				if (oper1 == null || oper1.isEmpty()) {
					oper1 = elem;
				} else if (oper2 == null || oper2.isEmpty()) {
					oper2 = elem;

				}
			}
			if (operator != null && oper1 != null && oper2 != null) {
				res = performOp(operator, oper1, oper2);
				if (stack.head != null || stack2.head != null) {
					stack.push(res);
				}
				while (stack2.head != null) {
					stack.push(stack2.pop());
				}
				operator = null;
				oper1 = null;
				oper2 = null;
			}

		}
		return Integer.parseInt(res);

	}

	private String performOp(String operator, String oper1, String oper2) {
		int res = 0;
		switch (operator) {
		case "+":
			res = Integer.parseInt(oper1) + Integer.parseInt(oper2);
			break;
		case "-":
			res = Integer.parseInt(oper2) - Integer.parseInt(oper1);
			break;
		case "*":
			res = Integer.parseInt(oper1) * Integer.parseInt(oper2);
			break;
		case "/":
			res = Integer.parseInt(oper2) / Integer.parseInt(oper1);
			break;

		default:
			break;
		}
		return Integer.toString(res);
	}

	private boolean isOperator(String elem) {
		if (elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
			return true;
		}
		return false;
	}

	@Test
	public void test() {
		ArrayList<String> a = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
		Assert.assertEquals(9, evalRPN(a));

	}
	
	@Test
	public void test2() {
		ArrayList<String> a = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
		Assert.assertEquals(6, evalRPN(a));

	}
	
	@Test
	public void test3() {
		ArrayList<String> a = new ArrayList<>(Arrays.asList("5", "1", "2", "+", "4", "*", "+", "3", "-"));
		Assert.assertEquals(14, evalRPN(a));

	}
	
	@Test
	public void test4() {
		ArrayList<String> a = new ArrayList<>(Arrays.asList("5"));
		Assert.assertEquals(5, evalRPN(a));

	}
}
