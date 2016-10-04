public class SearchPosition35{
    public static int searchInsert(int[] nums,int target){
	int s=0,e=nums.length-1;
	int q=-1;
	while(s<=e){
	    q=(s+e)/2;
	    if(nums[q]>target) e=q-1;
	    else if(nums[q]<target) s=q+1;
	    else return q;
	}
	return s;
    }
    public static void main(String[] args){
	int[] a={1,3,5,8};
	System.out.println(searchInsert(a,2));
	System.out.println(searchInsert(a,3));
	System.out.println(searchInsert(a,6));
    }
}
