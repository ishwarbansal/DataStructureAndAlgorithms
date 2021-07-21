package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

	/*Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

		perm[i] is divisible by i.
		i is divisible by perm[i].
		Given an integer n, return the number of the beautiful arrangements that you can construct.
	 */

	private int count = 0;

	private List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	public int countArrangement(int n) {
		boolean[] visited = new boolean[n+1];
		calculate(n, 1, visited);
		subset(n, 1, visited, new ArrayList<Integer>());
		return count;
	}

	private void calculate(int n, int pos, boolean[] visited){
		if(pos>n)
			count++;

		for(int i=1; i<=n; i++){
			if(!visited[i] && (i%pos==0 || pos%i==0)){
				visited[i]=true;
				calculate(n, pos+1, visited);
				visited[i] = false;
			}
		}
	}
	
	private void subset(int n, int pos, boolean[] visited, List<Integer> list){
		if(list.size()==n) {
			result.add(new ArrayList<Integer>(list));
		}

		for(int i=1; i<=n; i++){
			if(!visited[i]){
				visited[i]=true;
				list.add(i);
				subset(n, pos+1, visited, list);
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		BeautifulArrangement arrangement = new BeautifulArrangement();
		System.out.println(arrangement.countArrangement(3));
		for(ArrayList<Integer> list : arrangement.result) {
			for(Integer val : list) {
				System.out.print(val + "  ");
			}
			System.out.println("");
		}
	}

}
