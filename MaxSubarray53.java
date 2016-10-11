public class MaxSubarray53{
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		return max(nums, 0, nums.length-1);
	}
	
	public static int max(int[] nums, int s, int e) {
		if (s == e) return nums[s];
		int q = s + (e - s) / 2;
		int left = max(nums, s, q);
		int right = max(nums, q+1, e);
		int mid = maxCross(nums, s, q, e);
		return Math.max(Math.max(left, right), mid);
	}

	public static int maxCross(int[] nums, int s, int q, int e) {
		int left_max = Integer.MIN_VALUE;
		int right_max = Integer.MIN_VALUE;
		int left_sum = 0;
		int right_sum = 0;
		for (int i = q; i >= s; i--) {
			left_sum += nums[i];
			if (left_sum > left_max) left_max = left_sum; 
		}
		for (int j = q+1; j <= e; j++) {
			right_sum += nums[j];
			if (right_sum > right_max) right_max = right_sum;
		}
		return left_max + right_max;
	}

	public static void main(String[] args){
		int[] a ={
			-2,1,-3,4,-1,2,1,-5,4
		};
		System.out.println(maxSubArray(a));
	}
}
