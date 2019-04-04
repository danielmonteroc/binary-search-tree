package com.example.test;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class BinarySearchTreeTest {

	@Test
	void testSearchNotFound() {
		int[] array = {23,36,98,333,24,12,15,16,39,45,23,98};
		BinarySearchTree tree = new BinarySearchTree(array);
		List<Integer> result = tree.search(235);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(-1, result.get(0).intValue());
		
	}
	
	@Test
	void testSearchFound() {
		int[] array = {23,36,98,333,24,12,15,16,39,45,23,98};
		BinarySearchTree tree = new BinarySearchTree(array);
		List<Integer> result = tree.search(333);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(3, result.get(0).intValue());
	}
	@Test
	void testSearchFound24() {
		int[] array = {23,36,98,333,24,12,15,16,39,45,23,98};
		BinarySearchTree tree = new BinarySearchTree(array);
		List<Integer> result = tree.search(24);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(4, result.get(0).intValue());
	}
	@Test
	void testSearchDuplicated() {
		int[] array = {23,36,98,333,24,12,15,16,39,45,23,98};
		BinarySearchTree tree = new BinarySearchTree(array);
		List<Integer> result = tree.search(23);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals(0, result.get(0).intValue());
		Assert.assertEquals(10, result.get(1).intValue());

	}

}
