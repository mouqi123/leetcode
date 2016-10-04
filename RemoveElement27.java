public class RemoveElement27{
    public static int removeElement(int[] nums,int val){
	int i=0;
	for(int x:nums){
	    if(x!=val)
	        nums[i++]=x;
	}
	return i;
    }
}
