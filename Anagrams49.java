import java.util.*;
public class Anagrams49{
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) 
			return new ArrayList<List<String>>();
		Map<String,List<String>> map = new HashMap<>();
		for (String s : strs){
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
