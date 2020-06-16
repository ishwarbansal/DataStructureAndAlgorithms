package com.data.structure.leet.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if (map.containsKey(count)) {
				maxlen = Math.max(maxlen, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxlen;	
	}

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0) return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[] left = new int[n];
		int[] right= new int[n];
		int[] height = new int[n];

		int maxA = 0;
		for(int i=0; i<m; i++) {
			int cur_left=0, cur_right=n; 
			for(int j=0; j<n; j++) { // compute height (can do this from either side)
				if(matrix[i][j]=='1') height[j]++; 
				else height[j]=0;
			}
			for(int j=0; j<n; j++) { // compute left (from left to right)
				if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
				else {left[j]=0; cur_left=j+1;}
			}
			// compute right (from right to left)
			for(int j=n-1; j>=0; j--) {
				if(matrix[i][j]=='1') right[j]=Math.min(right[j],cur_right);
				else {right[j]=n; cur_right=j;}    
			}
			// compute the area of rectangle (can do this from either side)
			for(int j=0; j<n; j++)
				maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
		}
		return maxA;
	}

	//	public static void main(String[] args) {
	//		Test test = new Test();
	////		System.out.println(test.findMaxLength(new int[] {0,0,0,1,1,1,0}));
	////		System.out.println(test.maximalRectangle(new char[][] {{'0','0','0','1','0','0','0'},{'0','0','1','1','1','0','0'},{'0','1','1','1','1','1','0'}}));
	//		int[] list = {5, 3, 4, 8, 6, 7};
	//		System.out.println(test.lisDP(list, list.length));
	//		System.out.println(test.lisBruteForce(list, list.length));
	//		System.out.println(test.lisRecurssion(list, list.length-1));
	//		System.out.println("Count "+ test.a);
	//	}

	public int lisDP(int[] arr, int n) {
		int[] list = new int[n];
		Arrays.fill(list, 1);
		int max = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && list[i]<list[j]+1) {
					list[i] = list[j]+1;
				}
			}
			max = Math.max(list[i], max);
		}
		return max;
	}

	static int getMaxZigZag(int[] arr) {
		int n =arr.length;
		int[] list = new int[n];

		if(arr.length==1)
			return 1;

		Arrays.fill(list, 1);
		int max = 0;
		boolean flag = arr.length > 1 && arr[1] > arr[0];
		int temp = 0;
		for(int i=1; i<n; i++) {
			if(flag && arr[i] > arr[temp]) {
				list[i] = list[temp]+1;
				temp = i;
				flag = !flag;
			}else if(!flag && arr[i] < arr[temp]){
				list[i] = list[temp]+1;
				temp = i;
				flag = !flag;
			}
			max = Math.max(max, list[i]);
		}
		return max;	
	}

	static int zigzag(int arr[],int n)
	{
		int zigzag[] = new int[n];
		char signs[] = new char[n];

		int i,j,max = 0;

		/* Initialize LIS values for all indexes */
		for ( i = 0; i < n; i++ ) {
			zigzag[i] = 1;
			signs[i] ='+';
		}
		if(n>=2) {
			if(arr[1]<arr[0]) {
				signs[1]='-';
			}
			zigzag[1] = 2;
		}

		/* Compute optimized LIS values in  
		           bottom up manner */
		for ( i = 2; i < n; i++ )
			for ( j = 0; j < i; j++ ) {
				if(signs[j]=='+') {
					if ( arr[i] < arr[j] &&  
							zigzag[i] < zigzag[j] + 1) {
						zigzag[i] = zigzag[j] + 1;
						signs[i]='-';

					}
				}else if(signs[j]=='-') {
					if ( arr[i] > arr[j] &&  
							zigzag[i] < zigzag[j] + 1) {
						zigzag[i] = zigzag[j] + 1;
						signs[i]='+';          
					}  
				}

			}



		/* Pick maximum of all LIS values */
		for ( i = 0; i < n; i++ ) {
			System.out.print(zigzag[i]+" ");
			if ( max < zigzag[i] )
				max = zigzag[i];
		}
		return max;
	}

	//	public static void main(String args[]) {
	//		int arr[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//		arr = new int[]{ 1, 7, 4, 9, 2, 5 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//		arr = new int[]{ 44 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//		arr = new int[]{  1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//		arr = new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//		arr = new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
	//				600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
	//				67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
	//				477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
	//				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
	//		System.out.println("Length of zigzag sequence with DP is " + zigzag(arr, arr.length) + "\n");
	//	}


	//	public static void main(String[] args) 
	//	{ 
	//		System.out.println(getMaxZigZag(new int[] {1, 7, 4, 9, 2, 5}));
	//		System.out.println(getMaxZigZag(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
	//		System.out.println(getMaxZigZag(new int[] {77}));
	//		System.out.println(getMaxZigZag(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
	//		System.out.println(getMaxZigZag(new int[] {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }));
	//		System.out.println(getMaxZigZag(new int[] {374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
	//				600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
	//				67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
	//				477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
	//				249, 22, 176, 279, 23, 22, 617, 462, 459, 244}));
	//	} 


	static int badNeighbours(int[] a, int size) {
		if(size == 2) {
			int sum = Math.max(a[0], a[1]);
			return sum;
		}

		int i, j;
		int[] s = new int[size];
		int[] b = new int[size];
		s[0]=a[0];
		s[1]=a[1];
		b[0]=1;
		b[1]=0;

		for(i=2;i<size;i++) {
			for(j=0;j<i-1;j++) {
				if(s[i]<s[j]+a[i]) {
					s[i]=s[j]+a[i];
					b[i]=b[j];
				}
			}
		}

		if(b[size-1]==0) {
			return s[size-1];
		} else {
			int min = Math.min(a[0], a[size-1]);
			int sum = Math.max(s[size-2], s[size-1]-min);
			return sum;
		}
	}

	static int getMaxPath(int row, int col) {
		int[][] matrix = new int[row][col];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++){
				matrix[i][j] = 1;
			}
		}

		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[i].length; j++){
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}
		}

		return matrix[row-1][col-1];
	}
	static int rowMove[] = {-2,-2,-1,-1, 1,1, 2,2,-1,-1,-1,0,0,1,1,1};
	static int colMove[] = {-1, 1,-2, 2,-2,2,-1,1,-1,0,1,-1,1,-1,0,1};

	static int[][] chess = null;
	static int moves = 0;

	public Test() {

	}
	public Test(int size) {
		chess = new int[size][size];
	}
	public static long howMany(int size, int[] start, int[] end, int numMoves) {
		knightMove(start[0], start[1], end[0], end[1], numMoves, 1);
		return moves;
	}

	public static void knightMove(int row, int col, int destRow, int destCol, int numMoves, int count) {
		//Add return condition
		if(count>numMoves)
			return ;

		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];
			if(newRow >=0 && newCol>=0 && newRow<chess.length && newCol<chess[newRow].length) {
				if(count<numMoves) {
					knightMove(newRow, newCol, destRow, destCol, numMoves, count+1);
				}
				if(newRow == destRow && newCol == destCol) {
					moves++;
				}
			}
		}
	}

	public int lengthOfLIS(int[] nums) {

		int n = nums.length;
		int ans = 0;
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
					ans = Math.max(ans, LIS[i]);
				}
			}
		}

		return ans;
	}

	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		int ans = 0;
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);
		Arrays.sort(envelopes, (a,b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < n; i++) {
			for (int j = i-1; j >=0; j--) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
				}
			}
		}

		for (int i = 0; i < LIS.length; i++) {
			ans = Math.max(ans, LIS[i]);
		}

		return ans;

	}

	public int findLongestChain(int[][] pairs) {
		int n = pairs.length;
		int ans = 0;
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);
		Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < n; i++) {
			for (int j = i-1; j >=0; j--) {
				if (pairs[i][0] > pairs[j][1]) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
				}
			}
		}

		for (int i = 0; i < LIS.length; i++) {
			ans = Math.max(ans, LIS[i]);
		}

		return ans;
	}

	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int max=0, ans = 0; 
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);
		for (int i = 0; i < n; i++) {
			int tempCount = 1;
			int tempMax = 1;
			int count = 0;
			for (int j = i-1; j >=0; j--) {
				if (nums[i] > nums[j]) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
					tempMax = Math.max(tempMax, LIS[i]);
					if(LIS[j]==LIS[j+1]) {
						tempCount++;
					}else {
						tempCount = 1;
					}
					count = Math.max(count,  tempCount);
				}else if(nums[i] == nums[j]){
					tempCount++;
					count = Math.max(count,  tempCount);
				}
			}
			if(max<tempMax) {
				ans = count;
				max = tempMax;
			}else if (max == tempMax && ans < count) {
				ans = count;
			}
		}
		return ans;
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int max = 0, index = -1;
		for (int i = 0; i < n; i++) {
			count[i] = 1;
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (1 + count[j] > count[i]) {
						count[i] = count[j] + 1;
						pre[i] = j;
					}
				}
			}
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}
		List<Integer> res = new ArrayList<>();
		while (index != -1) {
			res.add(nums[index]);
			index = pre[index];
		}
		return res;
	}


	public int deleteAndEarn(int[] nums) {
		int[] count = new int[10001];
		for (int x: nums) count[x]++;
		int avoid = 0, using = 0, prev = -1;

		for (int k = 0; k <= 10000; ++k)
			if (count[k] > 0) {
				int m = Math.max(avoid, using);
				if (k - 1 != prev) {
					using = k * count[k] + m;
					avoid = m;
				} else {
					using = k * count[k] + avoid;
					avoid = m;
				}
				prev = k;
			}
		return Math.max(avoid, using);
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		
		for(int num:nums)
			sum += num;
		
		if(k <= 0 || sum%k != 0)
			return false;
		
		int[] visited = new int[nums.length];
		
		return canPartition(nums, visited, 0, k, 0, 0, sum/k);
	}

	public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
		if(k==1)
			return true;
		
		if(cur_sum == target && cur_num>0)
			return canPartition(nums, visited, 0, k-1, 0, 0, target);
		
		for(int i = start_index; i<nums.length; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))
					return true;
				visited[i] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Test test = new Test(6);
		//		System.out.println(test.howMany(3, new int[] {0,0}, new int[] {1, 0}, 1));
		//		moves = 0;
		//		
		//		System.out.println(test.howMany(3, new int[] {0,0}, new int[] {1, 2}, 1));
		//		moves = 0;
		//		
		//		System.out.println(test.howMany(3, new int[] {0,0}, new int[] {2, 2}, 1));
		//		moves = 0;
		//		
		//		System.out.println(test.howMany(3, new int[] {0,0}, new int[] {0, 0}, 2));
		//		moves = 0;

		//		System.out.println(test.howMany(100, new int[] {0,0}, new int[] {0, 99}, 50));

		//		System.out.println(test.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));

		//		System.out.println(test.largestDivisibleSubset(new int[]{}));
		//		System.out.println(test.largestDivisibleSubset(new int[]{1}));
		//		System.out.println(test.largestDivisibleSubset(new int[]{1,3}));
		//		System.out.println(test.largestDivisibleSubset(new int[]{564, 679}));
		//		System.out.println(test.largestDivisibleSubset(new int[]{2,3,4,8}));
		//		System.out.println(test.largestDivisibleSubset(new int[]{4,8, 10, 240}));

		//		System.out.println(test.maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}}));
		//		System.out.println(test.maxEnvelopes(new int[][] {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}));

		//		System.out.println(test.findLongestChain(new int[][] {{1,2},{2,3},{3,4}}));
		//		System.out.println(test.findNumberOfLIS(new int[] {1,3,5,4,7}));
		//		System.out.println(test.findNumberOfLIS(new int[] {2,2,2,2,2}));
		//		System.out.println(test.findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}));
//		System.out.println(test.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
		System.out.println(test.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
	}

}

