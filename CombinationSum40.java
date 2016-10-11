import java.util.*;
public class CombinationSum40{

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> results=new ArrayList<>();
	Arrays.sort(candidates);
	combination(new ArrayList<Integer>(),results,candidates,0,target);
	return results;
    }

    private void combination(List<Integer> list,List<List<Integer>> results,int[] candidates,int start,int target){

	int n=candidates.length;
	for(int i=start;i<n;i++){

	    if(i>start&&candidates[i]==candidates[i-1])
		continue;

	    if(target==candidates[i]){
	        List<Integer> temp=new ArrayList<>(list);
		temp.add(candidates[i]);
		results.add(temp);
	    }else if(candidates[i]<target){
	        List<Integer> temp=new ArrayList<>(list);
		temp.add(candidates[i]);
		combination(temp,results,candidates,i+1,target-candidates[i]);
	    }else break;
	}
    }

    public static void main(String[] args){
	CombinationSum40 cs=new CombinationSum40();
	int[] a={10,1,2,7,6,1,5};
	List<List<Integer>> list=cs.combinationSum(a,8);
	System.out.println(list);
	for(int i=0;i<list.size();i++){
	    for(int j=0;j<list.get(i).size();j++){
		System.out.print(list.get(i).get(j)+" ");
	    }
	    System.out.println();
	}
    }
}
        
	
