public class Median4_2{
	public double findMedianSortedArrays(int[] nums1,int[] nums2){
		int total=nums1.length+nums2.length;
		if(total%2==0)
			return (findKey(nums1,nums2,total/2)+findKey(nums1,nums2,total/2+1))/2.0;
		else
			return findKey(nums1,nums2,total/2+1);
	}

	public double findKey(int[] nums1,int[] nums2,int k){
		int index1=0,index2=0;
		int start1=0;start2=0;
		int len1=nums1.length,len2=nums2.length;
		while(true){
			index1=start1+n1/2;
			index2=start2+n2/2;

			if(index1+index2==k-1){
				if(nums1[index1]<=nums2[index2]&&nums1[index1]>=nums2[index2-1])
					return nums1[index1];
				else if(nums2[index2]<=nums1[index1]&&nums2[index2]>=nums1[index1-1])
					return nums2[index2];
				else
			}else if(index1+index2==k-2){
				if(nums1[index1]>=nums2[index2]&&nums1[index1]<=nums2[index2+1])
					return nums1[index1];
				else if(nums2[index2]>=nums1[index1]&&nums2[index2]<=nums1[index1+1])
					return nums2[index2];
			}
