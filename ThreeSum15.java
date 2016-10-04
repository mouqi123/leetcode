import java.util.*;
    /**
     * caculate a+b+c=0? in an array.
     */
public class ThreeSum15{
    public List<List<Integer>> threeSum(int[] nums){
	List<List<Integer>> results=new ArrayList<List<Integer>>();
	Arrays.sort(nums);
	for(int i=0;i<nums.length-2;i++){
	    //remove duplicate items.
	    if(i>0&&nums[i]==nums[i-1])
		continue;
	
	    int j=i+1, k=nums.length-1;
	    while(j<k){
		int sum=nums[i]+nums[j]+nums[k];
		if(sum<=0){
		    if(sum==0)
		        results.add(Arrays.asList(nums[i],nums[j],nums[k]));
		    j++;
		    //remove duplicate items.
		    while(j<k&&nums[j]==nums[j-1])  j++;
		}else{
		    k--;
		    //remove duplicate items.
		    while(j<k&&nums[k]==nums[k+1])  k--;
		}
	    }
	}

	return results;
    }
}
