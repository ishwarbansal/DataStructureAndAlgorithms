package com.leetcode.challenge.april2020.week4;

import java.util.HashMap;
import java.util.Map;

class DbNode{

	int key;
	int freq;

	DbNode pre;
	DbNode post;

	DbNode(){
	}

	DbNode(int key,int freq){
		this.key=key;
		this.freq=freq;
	}
}

class DbLinkedList{
	DbNode start;
	DbNode tail;

	DbLinkedList(){
		start=new DbNode();
		tail= new DbNode();
		start.post=tail;
		start.pre=null;
		tail.pre=start;
		tail.post=null;
	}

	void add(DbNode node) {
		//add to the end
		tail.pre.post=node;
		node.pre=tail.pre;
		node.post=tail;
		tail.pre=node;
	}

	void remove(DbNode node) {
		node.pre.post=node.post;
		node.post.pre=node.pre;
	}

	void display() {  
		DbNode current = this.start;      
		while(current != null) {          
			System.out.print(current.key + " ");  
			current = current.post;  
		}  
	}
}

class FirstUnique {
	Map<Integer,DbNode> freqMap= new HashMap<Integer,DbNode>();
	DbLinkedList dbList= new DbLinkedList();    


	public FirstUnique(int[] nums) {
		for(int i=0;i<nums.length;i++)   {
			DbNode node=freqMap.get(nums[i]);
			if(node==null) {
				node=new DbNode(nums[i],1);
				freqMap.put(nums[i],node);
				dbList.add(node);
			}else {
				node.freq=--node.freq;
				freqMap.put(nums[i],node);
				if(node.freq==0) {
					dbList.remove(node);
					node.post = null;
					node.pre = null;
				}
			}
		}
	}

	public int showFirstUnique() {  
		Integer uniqeNbr=dbList.start.post.key;
		return uniqeNbr > 0 ? uniqeNbr : -1;
	}

	public void add(int key) {
		DbNode node=freqMap.get(key);
		if(node==null) {
			node=new DbNode(key,1);
			freqMap.put(key,node);
			dbList.add(node);
		}else {
			node.freq=--node.freq;
			freqMap.put(key,node);

			if(node.freq==0)
				dbList.remove(node);
		}
	}
	public static void main(String[] args) {
		FirstUnique obj = new FirstUnique(new int[] {2,3,2,3,5 });
		obj.dbList.display();
		System.out.println(obj.showFirstUnique());
		obj.add(5);
		obj.dbList.display();
		System.out.println(obj.showFirstUnique());
		obj.add(2);
		obj.dbList.display();
		System.out.println(obj.showFirstUnique());
		obj.add(3);
		obj.dbList.display();
		System.out.println(obj.showFirstUnique());
	}
}