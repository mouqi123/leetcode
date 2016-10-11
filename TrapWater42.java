public class TrapWater42{
    public static int trap(int[] height){
	int high=0;
	int left=0;
	int right=height.length-1;
	int water=0;

	while(left<right){
	    if(height[left]<height[right]){
		high=Math.max(high,height[left]);
		water+=high-height[left];
		left++;
	    }else{
		high=Math.max(high,height[right]);
		water+=high-height[right];
		right--;
	    }
	}
	return water;
    }

    public static void main(String[] args){
	int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
	System.out.println(trap(a));
    }
}
	 
