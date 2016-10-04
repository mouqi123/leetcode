/**
 * File Name: Permutation46.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月17日 星期日 12时56分08秒
 */
import java.util.*;
public class Permutation46{
	public static List<List<Integer>> permute(int[] nums){
		List<Integer> origin=new LinkedList<Integer>();
		Collections.addAll(origin,nums);
		List<List<Integer>> result=new LinkedList<List<Integer>>();

		List<Integer> element=new LinkedList<Integer>();
		
		select(result,origin,element);
		return result;
	}

	public static void select(List<List<Integer>> result,List<Integer> origin,List<Integer> element){
		if(origin.isEmpty()) return;

		for(Integer i:origin){
			
		}
	}
}
