import java.util.*;
public class TowSum1{
    public int[] twoSum1(int[] nums,int target){
	for(int i=0;i<nums.length;i++){
	    for(int j=i+1;j<nums.length;j++){
		if(nums[i]+nums[j]==target){
		    return new int[]{i+1,j+1};
		}
	    }
	}
	return null;
    }
    public static void main(String[] args){
	TowSum1 t=new TowSum1();
	int[] a={2,7,11,15};
	int[] r=t.twoSum2(a,9);
	System.out.println(r[0]+"    "+r[1]);
    }

    public int[] twoSum2(int[] nums,int target){
	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	for(int i=0;i<nums.length;i++){
	    if(map.containsKey(target-nums[i]))
		return new int[] {map.get(target-nums[i]),i};
	    else
		map.put(nums[i],i);
	}
	return null;
    }
}
