public class JumpGame55{
	public static boolean canJump(int[] nums) {
		if (nums.length < 2) return true;

		int curMax = 0, nextMax = 0;
		int curPos =0;

		while (curMax >= curPos) {
			for (; curPos <= curMax; curPos++) {
				nextMax = Math.max(nextMax,nums[curPos]+curPos);
				if (nextMax >= nums.length-1)
					return true;
			}
			curMax = nextMax;
		}
		return false;
	}
}
