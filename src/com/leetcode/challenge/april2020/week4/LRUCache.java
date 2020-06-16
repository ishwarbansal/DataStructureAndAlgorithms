package com.leetcode.challenge.april2020.week4;

import java.util.Hashtable;

public class LRUCache {


	class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;

		tail = new DLinkedNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {

		DLinkedNode node = cache.get(key);
		if(node == null){
			return -1; // should raise exception here.
		}

		// move the accessed node to the head;
		this.moveToHead(node);

		return node.value;
	}


	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);

		if(node == null){

			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			this.cache.put(key, newNode);
			this.addNode(newNode);

			++count;

			if(count > capacity){
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		}else{
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail. 
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}


	public static void main(String[] args) {
		//		LRUCache cache = new LRUCache(2);
		//		cache.put(1, 1);
		//		cache.put(2, 2);
		//		System.out.println(cache.get(1));       // returns 1
		//		cache.put(3, 3);    // evicts key 2
		//		System.out.println(cache.get(2));       // returns -1 (not found)
		//		cache.put(4, 4);    // evicts key 1
		//		System.out.println(cache.get(1));       // returns -1 (not found)
		//		System.out.println(cache.get(3));       // returns 3
		//		System.out.println(cache.get(4));       // returns 4

		//		LRUCache cache = new LRUCache(1);
		//		System.out.println(cache.get(2));
		//		cache.put(2, 6);
		//		System.out.println(cache.get(1));
		//		cache.put(1,5);
		//		cache.put(1,2);
		//		System.out.println(cache.get(1));
		//		System.out.println(cache.get(2));

		LRUCache cache = new LRUCache(2);
		cache.put(1,1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

	}
}


























