/**
 * File Name: Permutation47.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月19日 星期二 12时49分26秒
 */
import java.util.*;
public class Permutation47{
	public static List<List<Integer>> permuteUnique(int[] nums){
		Set<List<Integer>> result=new HashSet<>();
		if(nums.length==0) return new ArrayList<List<Integer>>();

		List<Integer> l0=new ArrayList<Integer>();
		l0.add(nums[0]);
		result.add(l0);

		for(int i=1;i<nums.length;i++){
			Set<List<Integer>> new_result=new HashSet<>();

			for(int j=0;j<=i;j++){
				for(List<Integer> l: result){
					List<Integer> new_l=new ArrayList<>(l);
					new_l.add(j,nums[i]);
					new_result.add(new_l);
				}
			}
			result=new_result;
		}
		return new ArrayList<List<Integer>>(result);
	}
}
