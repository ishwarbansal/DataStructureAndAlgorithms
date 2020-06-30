package com.leetcode.challenge.june2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import com.patterns.tree.breadth.first.search.TreeNode;

public class Solution {

	//Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
	//write a function to compute the researcher's h-index.
	public int hIndex(int[] citations) {
		int n = citations.length;
		//O(n)
		//		int i = n-1;
		//		while(i>=0) {
		//			System.out.println(citations[i] + "  " + i);
		//			if(citations[i]<n-i)
		//				break;
		//			i--;
		//		}
		//		return n-i-1;
		System.out.println("---------------"+ 7/2);
		//Log(n)
		int start = 0;
		int end = citations.length-1;
		int mid = 0;

		while(start<=end) {
			mid = start + (end-start)/2;
			if(citations[mid] < n - mid) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		return n - start;
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[row-1].length;

		int[][] matrix = new int[row][col];

		matrix[row-1][col-1] = dungeon [row-1][col-1] > 0 ? 1 :  1 - dungeon[row-1][col-1];

		for(int i=row-2; i>=0; i--) {
			matrix[i][col-1] = Math.max(matrix [i+1][col-1] - dungeon[i][col-1],1); 
		}

		for(int j=col-2; j>=0; j--) {
			matrix[row-1][j] = Math.max(matrix [row-1][j+1] - dungeon[row-1][j],1); 
		}

		for(int i=row-2; i>=0; i--) {
			for(int j=col-2; j>=0; j--) {
				matrix[i][j] = Math.max(Math.min(matrix[i+1][j],matrix[i][j+1]) - dungeon[i][j],1);
			}
		}
		return matrix[0][0];
	}


	public String getPermutation(int n, int k) {
		ArrayList<Integer> fact = new ArrayList<>();
		fact.add(1);

		ArrayList<Integer> digits = new ArrayList<>();
		digits.add(1);

		int factorial = 1;
		for(int i=2; i<=n; i++) {
			factorial*=i;
			fact.add(factorial);
			digits.add(i);
		}

		String result = "";

		while(result.length()<n-1) {
			int repeat = fact.get(fact.size()-2);
			int nextDigit = (k-1)/repeat;
			result+= digits.get(nextDigit);
			digits.remove(nextDigit);
			fact.remove(fact.size()-1);
			k=k%repeat;
			if(k==0) {
				for(int i=digits.size()-1; i>=0; i--) {
					result+=digits.get(i);
				}
			}
		}

		if(result.length() < n) {
			result+= digits.get(0);
		}
		return result;
	}

	public String validIPAddress(String IP) {
		String result = "Neither";

		if(IP.length()<=0)
			return result;

		String str[] = null;
		if(IP.contains(".")) {
			str = IP.split(".");
		}else if (IP.contains(":")) {
			str = IP.split(":");
		}
		if(str.length==4) {
			for(String st: str) {
				if(st.startsWith("0")) {
					return result;
				}else if (Integer.parseInt(st)<=0 || Integer.parseInt(st)>255) {
					return result;
				}
			}
			result = "IPv4";
		}else if(str.length==8) {
			for(String st: str) {
				if(st.startsWith("0")) {
					return result;
				}
			}
			result = "IPv6";
		}
		return result;
	}

	public int countNodes(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root==null)
			return 0;

		queue.add(root);

		int countNode = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if(node!=null) {
				countNode++;
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		return countNode;
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n : nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}

		int returnValue = -1;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				returnValue =  entry.getKey();
				break;
			}
		}
		return returnValue;        
	}

	public int findDuplicate(int[] nums) {
		//		int returnValue = -1;
		//		for(int i=0; i<nums.length; i++) {
		//			for(int j=i+1; j<nums.length; j++) {
		//				if(nums[i]==nums[j])
		//					returnValue = nums[i];
		//			}
		//		}
		//		return returnValue;

		int rabbit = 0, turtle = 0;
		do {
			rabbit = nums[nums[rabbit]];
			turtle = nums[turtle];
		} while (rabbit != turtle);
		rabbit = 0;
		while (rabbit != turtle) {
			rabbit = nums[rabbit];
			turtle = nums[turtle];
		}
		return turtle;
	}


	public String getPermutation2(int n, int k) {
		int []nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = i+1;
		}
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackPermute(list, new ArrayList<>(), nums, 0, k);
		List<Integer> result = list.get(list.size()-1);
		String val = "";
		for(int num: result) {
			val+=num;
		}
		return val;
	}

	private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start, int k){
		if(tempList.size()==nums.length)
			list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			if(tempList.contains(nums[i]))
				continue;
			tempList.add(nums[i]);
			backtrackPermute(list, tempList, nums, 0,k); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
			if(list.size()==k)
				break;
		}
	}


	public int sumNumbers(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root==null)
			return 0;

		queue.add(root);

		int sum = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if(node!=null) {
				if(node.left==null && node.right==null) {
					sum += node.val;
				}else {
					if(node.left!=null) {
						node.left.val = (node.val * 10) + node.left.val;
					}
					queue.add(node.left);

					if(node.right!=null) {
						node.right.val = (node.val * 10) + node.right.val;
					}
					queue.add(node.right);
				}
			}
		}
		return sum; 
	}


	public int numSquares(int n) {
		int dp[] = new int[n+1];
		for(int x=1; x<=n; ++x) {
			int minVal = x;
			int y =1, sq =1;
			while(sq <= x) {
				minVal = Math.min(minVal, 1+dp[x-sq]);
				y++;
				sq = y*y;
			}
			dp[x] = minVal;
		}
		return dp[n];
	}


	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(List<String> list : tickets) {
			if(map.get(list.get(0))!=null) {
				List<String> l = map.get(list.get(0));
				int addIndex = l.size();
				for(int i=0; i<l.size(); i++) {
					if(l.get(i).compareTo(list.get(1))<=0) {
						continue;
					}else {
						addIndex = i;
						break;
					}
				}
				l.add(addIndex, list.get(1));
			}else {
				List<String> st = new ArrayList<String>();
				st.add(list.get(1));
				map.put(list.get(0), st);
			}
		}

		List<String> result = new ArrayList<>();

		int n =tickets.size();

		result.add("JFK");
		String key = "JFK";

		while(n>0) {
			List<String> ls = map.get(key);
			key = ls.get(0);
			if(map.get(key)!=null)
				result.add(key);
			
			if(ls.size()>1) {
				ls.remove(0);
			}
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		//		System.out.println(solution.hIndex(new int[] {0,1,3,5,6}));
		//		System.out.println(solution.hIndex(new int[] {}));
		//		System.out.println(solution.hIndex(new int[] {100}));

		//		System.out.println(solution.calculateMinimumHP(new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}}));

		//		System.out.println(solution.getPermutation(4, 9));

		//		System.out.println(solution.validIPAddress("172.16.254.1"));
		//		String s = "172.16.254.1";
		//		for(String st : s.split("."))
		//			System.out.println(st);

		//		TreeNode root = new TreeNode(1);
		//		root.left = new TreeNode(2);
		//		root.right = new TreeNode(3);
		//		root.left.left =  new TreeNode(4);
		//		root.left.right =  new TreeNode(5);
		//		root.right.left =  new TreeNode(6);
		//		System.out.println(solution.sumNumbers(root));

		//		System.out.println(solution.singleNumber(new int[] {2,2,2,3}));

		//		System.out.println(solution.findDuplicate(new int[] {1,3,4,2,5,2}));

		//		System.out.println(solution.getPermutation2(3, 3));

		//		System.out.println(solution.numSquares(0));
		//		System.out.println(solution.numSquares(1));
		//		System.out.println(solution.numSquares(2));
		//		System.out.println(solution.numSquares(3));
		//		System.out.println(solution.numSquares(4));
		//		System.out.println(solution.numSquares(13));
		//		System.out.println(solution.numSquares(16));

				List<List<String>> valList = new ArrayList<>();
		
				List<String> strList = new ArrayList<>();
				strList.add("JFK");
				strList.add("SFO");
		
				valList.add(strList);
		
				strList = new ArrayList<>();
				strList.add("JFK");
				strList.add("ATL");
		
				valList.add(strList);
		
				strList = new ArrayList<>();
				strList.add("SFO");
				strList.add("ATL");
		
				valList.add(strList);
		
		
				strList = new ArrayList<>();
				strList.add("ATL");
				strList.add("JFK");
		
				valList.add(strList);
		
				strList = new ArrayList<>();
				strList.add("ATL");
				strList.add("SFO");
		
				valList.add(strList);
		
				List<String> list = solution.findItinerary(valList);
				for(String st : list) {
					System.out.println(st);
				}

//		System.out.println(solution.numTrees(5));
//		System.out.println(solution.uniquePaths(3, 3));
	}


	public int numTrees(int n) {
		if(n<2)
			return 1;

		int[] t = new int[n+1];
		t[0] = 1;
		t[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				t[i] += t[j] * t[i-j-1];
			}
		}
		return t[n];
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 || j==0) {
					dp[i][j]=1;
				}
			}
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
					dp[i][j]= dp[i][j-1] + dp[i-1][j];
			}
		}
		
		return dp[m-1][n-1];
	}
}
