import java.util.*;
public class ThreeSum16{
	public static int threeSumClosest(int[] nums,int target){
		Arrays.sort(nums);
		int closest=nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length-2;i++){
			int j=i+1,k=nums.length-1;
			while(j<k){
				int curSum=nums[i]+nums[j]+nums[k];
				if(curSum==target) return curSum;
				if(Math.abs(curSum-target)<Math.abs(closest-target)){
					closest=curSum;
				}
				if(curSum>target)  k--;
				else j++;

			}
		}
		return closest;
	}
	public static void main(String[] args){
		int[] a={1,1,1,0};
		System.out.println(threeSumClosest(a,100));
	}
}
