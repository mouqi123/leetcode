public class Median4_1{
	public static double findMedian(int[] nums1,int[] nums2){
		int total = nums1.length+nums2.length;
		if (total%2 == 0) 
			return (findKey(nums1, 0, nums2, 0, (total-1)/2)+findKey(nums1, 0, nums2, 0, (total-1)/2+1))/2.0;
		else
			return findKey(nums1, 0, nums2, 0, (total-1)/2);
	}

	public static double findKey(int[] nums1, int s1, int[] nums2, int s2, int index) {
		if (s1 >= nums1.length) return nums2[s2+index];
		if (s2 >= nums2.length) return nums1[s1+index];

		if (index == 0) return Math.min(nums1[s1], nums2[s2]);

		int mid1 = s1+(index-1)/2 < nums1.length ? nums1[s1+(index-1)/2] : Integer.MAX_VALUE;
		int mid2 = s2+(index-1)/2 < nums2.length ? nums2[s2+(index-1)/2] : Integer.MAX_VALUE;

		if (mid1 > mid2) return findKey(nums1, s1, nums2, s2+(index+1)/2, index-(index+1)/2);
		else			 return findKey(nums1, s1+(index+1)/2, nums2, s2, index-(index+1)/2);
	}  

	public static void main(String[] args){
		int nums1[]={};
		int nums2[]={1,2,3,4,7};
		int nums3[]={1,2,3,5,7,8,10};
		int nums4[]={4,6};
		System.out.println(findMedian(nums1,nums2));
		System.out.println(findKey(nums1,0,nums2,0,2));
		System.out.println(findMedian(nums3,nums4));
		System.out.println(findKey(nums3,0,nums4,0,6));
		System.out.println(findKey(nums3,0,nums4,0,7));
	}
}


