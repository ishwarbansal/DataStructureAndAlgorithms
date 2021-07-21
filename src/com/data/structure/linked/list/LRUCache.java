package com.data.structure.linked.list;

import java.util.HashMap;

class DoubleNode {
    DoubleNode prev = null;
    DoubleNode next = null;
    int key;
    int value;
    
    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, DoubleNode> map;
    DoubleNode least;
    DoubleNode most;
    int capacity;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.least = new DoubleNode(0, 0);
        this.most = new DoubleNode(0, 0);
        this.capacity = capacity;
        least.next = most;
        most.prev = least;
    }
    
    public void remove(DoubleNode node) {
        DoubleNode prevNode = node.prev;
        DoubleNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void insert(DoubleNode node) {
        DoubleNode prevNode = most.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = most;
        most.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        DoubleNode node = new DoubleNode(key, value);
        map.put(key, node);
        insert(node);
        if (map.size() > capacity) {
            int removeKey = least.next.key;
            remove(least.next);
            map.remove(removeKey);
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */