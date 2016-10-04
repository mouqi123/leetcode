public class SearchRange34{
    public static int[] searchRange(int[] nums,int target){
	int s=0,e=nums.length-1;
	int q=0;
	boolean find=false;
	while(s<=e){
	    q=(s+e)/2;
	    if(nums[q]>target) e=q-1;
	    else if(nums[q]<target) s=q+1;
	    else{
		find=true;
		break;
	    }
	}
	if(!find)
	    return new int[]{-1,-1};
	int i=q,j=q;
	while(i>0){
	    if(nums[i]==nums[i-1])
		i--;
	    else break;
	}
	while(j<nums.length-1){
	    if(nums[j]==nums[j+1])
	        j++;
	    else break;
	}
	return new int[]{i,j};
    }
    public static void main(String[] args){
	int[] a={5,7,7,8,8,10};
	int[] r=searchRange(a,8);
	System.out.println(r[0]+"  "+r[1]);
    }
}
