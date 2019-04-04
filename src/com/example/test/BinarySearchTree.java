package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BinarySearchTree {

	private Node root;

	public class Node {
		List<Integer> indexes = new ArrayList<>();
		int value;
		Node left;
		Node right;

		Node(int index, int value) {
			this.value = value;
			addIndex(index);
		}

		public void addIndex(int index) {
			indexes.add(index);
		}
	}

	public BinarySearchTree(int[] array) {
		IntStream.range(0, array.length).forEach(i -> insert(i, array[i]));
	}

	public List<Integer> search(int value) {
		List<Integer> list = search(root, value);
		if (list.isEmpty())
			list.add(-1);
		return list;
	}

	public List<Integer> search(Node node, int value) {
		if (node == null) {
			return Arrays.asList(-1);
		} else if (node.value == value) {
			return node.indexes;
		} else if (value < node.value) {
			return search(node.left, value);
		} else {
			// value > node.value
			return search(node.right, value);
		}
	}

	private void insert(int index, int value) {
		if (root == null) {
			root = new Node(index, value);
		} else {
			insert(root, index, value);
		}
	}

	private void insert(Node rootNode, int index, int value) {
		if (rootNode.value == value) {
			rootNode.addIndex(index);
		} else if (value < rootNode.value) {
			if (rootNode.left == null) {
				rootNode.left = new Node(index, value);
			} else {
				insert(rootNode.left, index, value);
			}
		} else {
			if (rootNode.right == null) {
				rootNode.right = new Node(index, value);
			} else {
				insert(rootNode.right, index, value);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 23, 36, 98, 333, 24, 12, 15, 16, 39, 45, 23, 98 };
		BinarySearchTree tree = new BinarySearchTree(array);
		tree.search(23).forEach(i -> System.out.print(i + " "));
		System.out.println();
		tree.search(24).forEach(i -> System.out.print(i + " "));
		System.out.println();
		tree.search(235).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
