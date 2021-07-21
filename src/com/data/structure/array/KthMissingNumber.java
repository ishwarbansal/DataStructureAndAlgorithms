package com.data.structure.array;

public class KthMissingNumber {

	public int findKthPositive1(int[] arr, int k) {
		//simple binary search
		int n = arr.length;
		int left = 0, right = n-1;
		int missing  = compute(arr[n-1], n);
		while(left <= right) {
			int mid = left + (right-left)/2;
			missing = compute(arr[mid], mid+1);

			if(missing >= k) right = mid-1;
			else left = mid+1;
		}

		// Right -> -1;
		if(right == -1) return k;
		return arr[right] + k-compute(arr[right], right+1);

	}
	int compute(int actual, int expected){
		return actual - expected;
	}
	public int findKthPositive(int[] arr, int k) {
		//another binary search. diff need to be discussed in both binary searches
		int low = 0;
		int high = arr.length;
		while(low<high){
			int mid = (high -low)/2 + low;

 			if(arr[mid] -(mid +1) >= k){
				high = mid;
			} else{
				low =mid+1;
			}
		}
		//low is the index of smallest element index in the array in which adding k            
		//will give us the kth missing element.
		return low +k;
	}
	public static void main(String[] args) {
		KthMissingNumber obj=new KthMissingNumber();
		int[] arr=new int[] {2,3,4,7,11};
		int k=5;
		obj.findKthPositive(arr, k);

	}
}
