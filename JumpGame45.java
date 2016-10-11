/**
 * File Name: JumpGame45.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月16日 星期六 12时42分02秒
 */
public class JumpGame45{
	public static int jump(int[] nums){
		if(nums.length<=1) return 0;
		//s用来记录到每个位置的最大步数。
		int[] s=new int[nums.length];
		s[0]=0; s[1]=1;

		for(int i=2;i<nums.length;i++){
			for(int j=0;j<i;j++){
				if(j+nums[j]>=i){
					s[i]=s[j]+1;
					break;
				}
			}
		}
		return s[nums.length-1];
	}
	public static void main(String[] args){
		int[] nums={1,1,2,3,1,1,4};
		System.out.println(JumpGame45.jump(nums));
	}
}
