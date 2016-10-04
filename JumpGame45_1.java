//可以将这个问题转化为一个BFS问题，如[2,3,1,1,4] 可以分成三组，2||3 1||1 4||
//第i层节点能够在i-1步跳跃中到达的。
public class JumpGame45_1{
	public static int jump(int[] nums){
		int n=nums.length;
		if(n<2) return 0;
		//currentMax是每一层能够达到的最大索引值,内层循环的每次都迭都不能超过这个值
		int level=0,currentMax=0,nextMax=0,i=0;

		//这个循环条件确保了如下情况的发生：
		//若nums为[1,1,0,1] currentMax的值必须大于i-1(i为currentPosition),在这个例子中表示最后一项不可达，循环终止，返回0
		while(currentMax-i+1>0){
			level++; 
			//内层循环，找出这一层中能够达到的最大索引值，存放在nextMax中用于下一层的迭代。
			for(;i<=currentMax;i++){
				nextMax=nextMax>nums[i]+i? nextMax: nums[i]+i;
				if(nextMax>=n-1)
					//如果下一层可以达到尾部，则返回层级.
					return level;
			}
			currentMax=nextMax;
		}
		return 0;
	}
	public static void main(String[] args){
		int[] nums={2,3,1,1,4};
		System.out.println(JumpGame45_1.jump(nums));
	}
}
