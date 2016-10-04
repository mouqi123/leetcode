import java.util.*;
public class FourSum18_1{
    public static List<List<Integer>> fourSum(int[] nums,int target){
	Arrays.sort(nums);
	List<List<Integer>> results=new LinkedList<List<Integer>>();
	
	for(int i=0;i<nums.length-3;i++){
	    if(i>0&&nums[i]==nums[i-1])  continue;

	    int newTarget=target-nums[i];
	    for(int j=i+1;j<nums.length-2;j++){
		if(j>i+1&&nums[j]==nums[j-1]) continue;

		int n=j+1,m=nums.length-1;
		while(n<m){
		    if(n>j+1&&nums[n]==nums[n-1]){
			n++;
			continue;
		    }
		    if(m<nums.length-1&&nums[m]==nums[m+1]){
			m--;
			continue;
		    }
		    int sum=nums[j]+nums[n]+nums[m];
		    if(sum==newTarget){
			results.add(Arrays.asList(nums[i],nums[j],nums[n],nums[m]));
			n++;
			m--;
		    }else if(sum<newTarget)  n++;
		    else m--;
		}
	    }
	}
	return results;
    }
    public static void main(String[] args){
	int[] a={-494,-487,-471,-470,-465,-462,-447,-445,-441,-432,-429,-422,-406,-398,-397,-364,-344,-333,-328,-307,-302,-293,-291,-279,-269,-269,-268,-254,-198,-181,-134,-127,-115,-112,-96,-94,-89,-58,-58,-58,-44,-2,-1,43,89,92,100,101,106,106,110,116,143,156,168,173,192,231,248,256,281,316,321,327,346,352,353,355,358,365,371,410,413,414,447,473,473,475,476,481,491,498};
	List<List<Integer>> l=fourSum(a,0);
 	for(List list:l){
	    System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2)+" "+list.get(3));
	}
    }
}
