import java.util.*;
public class PhoneNumber17{
    public static List<String> letterCombinations(String digits){
	List<String> results=new ArrayList<String>();
	results.add("");
	String[] map={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxzy"};
	for(int i=0;i<digits.length();i++){
	    List<String> temp=new ArrayList<String>();
	    String charmap=map[digits.charAt(i)-'0'];
	    int n=results.size();
	    for(int j=0;j<charmap.length();j++){
		for(int k=0;k<n;k++){
		   temp.add(results.get(k)+charmap.charAt(j));
	   	}
	    }
	    results=temp;
	}
 	return results;
    }
}
