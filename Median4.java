public class Median4{
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
	int total=nums1.length+nums2.length;
	if(total%2==0)
	    return (findKey(nums1,0,nums2,0,total/2)+findKey(nums1,0,nums2,0,total/2+1))/2.0;
	else
	    return findKey(nums1,0,nums2,0,total/2+1);
    }

	//k为要寻找的索引
    public static double findKey(int[] nums1,int s1,int[] nums2,int s2,int k){
	if(s1>=nums1.length)    return nums2[s2+k-1];
	if(s2>=nums2.length)    return nums1[s1+k-1];

	if(k==1)    return Math.min(nums1[s1],nums2[s2]);
	
	int midA=s1+k/2-1<nums1.length? nums1[s1+k/2-1]:Integer.MAX_VALUE;
	int midB=s2+k/2-1<nums2.length? nums2[s2+k/2-1]:Integer.MAX_VALUE;

	if(midA>midB)   return findKey(nums1,s1,nums2,s2+k/2,k-k/2);
	else 		  return findKey(nums1,s1+k/2,nums2,s2,k-k/2);
    }
    
    public static void main(String[] args){
	Median4 m=new Median4();
	int nums1[]={};
	int nums2[]={1,2,3,4,7};
	int nums3[]={1,3,7,9};
	int nums4[]={1,2,4,7,12};
	System.out.println(m.findMedianSortedArrays(nums1,nums2));
	System.out.println(findKey(nums1,0,nums2,0,5));
	System.out.println(m.findMedianSortedArrays(nums3,nums4));
	System.out.println(findKey(nums3,0,nums4,0,5));
    }
}
