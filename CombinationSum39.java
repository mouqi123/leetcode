import java.util.*;
public class CombinationSum39{

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> results=new ArrayList<>();
	Arrays.sort(candidates);
	combination(new ArrayList<Integer>(),results,candidates,0,target);
	return results;
    }

    private void combination(List<Integer> list,List<List<Integer>> results,int[] candidates,int start,int target){

	if(target==0){
	    results.add(list);
	    return;
	}
		
	int n=candidates.length;
	for(int i=start;i<n;i++){
	    if(target>=candidates[i]){
	        List<Integer> temp=new ArrayList<>(list);
		temp.add(candidates[i]);
	        combination(temp,results,candidates,i,target-candidates[i]);
	    }else break;
	}
    }

    public static void main(String[] args){
	CombinationSum39 cs=new CombinationSum39();
	int[] a={2,3,6,7};
	List<List<Integer>> list=cs.combinationSum(a,7);
	System.out.println(list);
	for(int i=0;i<list.size();i++){
	    for(int j=0;j<list.get(i).size();j++){
		System.out.print(list.get(i).get(j)+" ");
	    }
	    System.out.println();
	}
    }
}
        
	
