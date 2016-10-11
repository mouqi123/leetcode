//可以将这个问题转化为一个BFS问题，如[2,3,1,1,4] 可以分成三组，2||3 1||1 4||
//第i层节点能够在i-1步跳跃中到达的。
public class JumpGame45_2{
	public static int jump(int[] nums) {
		if (nums.length <2) return 0;

		//curMax为当前组的最大索引值，nextMax为下一组可达的最大索引值,
		//level为层级
		int curMax = 0, nextMax = 0;
		int curPos = 0, level = 0;

		//只有curPos(当前位置)小于等于curMax(当前可达的最大位置)时，循环才能继续.
		while (curMax >= curPos) {

			for (;curPos <= curMax; curPos++) {
				nextMax = nums[curPos]+curPos > nextMax ? nums[curPos]+curPos : nextMax;
				if (nextMax >= nums.length-1)
					return level+1;
			}
			level++;
			curMax = nextMax;
		}
		return 0;
	}
	public static void main(String[] args){
		int[] nums={2,3,1,1,4};
		System.out.println(JumpGame45_2.jump(nums));
	}
}
