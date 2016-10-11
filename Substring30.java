import java.util.*;
public class Substring30{
    public static List<Integer> findSubstring(String s,String[] words){
	List<Integer> ret=new ArrayList<>();
	if(words.length==0) return ret;
	
	int wlen=words[0].length();
	int slen=s.length();
	
	Map<String,Integer> map=new HashMap<>();
	for(String word:words){
	    if(map.containsKey(word))
		map.put(word,map.get(word)+1);
	    else
		map.put(word,1);
	}

	String[] sword=new String[slen-wlen+1];
	for(int i=0;i<sword.length;i++){
	    String sub=s.substring(i,i+wlen);
	    if(map.containsKey(sub))
		sword[i]=sub;
	    else
		sword[i]="";
	}

	for(int i=0;i<wlen;i++){
	    int start=i;
	    int found=0;
	    Map<String,Integer> temp=new HashMap<>();
	    for(int j=i;j<sword.length;j+=wlen){
		String word=sword[j];
		if(word.equals("")){
		    start=j+wlen;
		    temp=new HashMap<>();
		    found=0;
		    continue;
		}else{
		    if(temp.containsKey(word)){
			temp.put(word,temp.get(word)+1);
		    }else
			temp.put(word,1);
		}
		found++;
	
		if(temp.get(word)>map.get(word)){
		    while(!sword[start].equals(word)){
			temp.put(sword[start],temp.get(sword[start])-1);
			start+=wlen;
			found--;
		    }
		    temp.put(word,temp.get(word)-1);
		    start+=wlen;
		    found--;
		}
		if(found==words.length)
		    ret.add(start);
	    }
	}
	return ret;
    }
}
