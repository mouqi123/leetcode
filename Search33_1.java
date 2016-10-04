public class Search33_1{
	public static int search(int[] nums,int target){
		int n=nums.length;
		int lo=0,hi=n-1,q=0;
		while(lo<hi){
			q=(lo+hi)/2;
			if(nums[hi]>nums[q]) 
				hi=q;
			else
				lo=q+1;
		}
		int rot=lo;
		q=0;  lo=0; hi=n-1;
		while(lo<=hi){
			q=(lo+hi)/2;
			int realmid=(q+rot)%n;
			if(nums[realmid]>target) 
				hi=q-1;
			else if(nums[realmid]<target)
				lo=q+1;
			else return realmid;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a={9,10,1,2,3,4,5,6};
		System.out.println(search(a,10));
	}
}
