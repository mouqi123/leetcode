public class Substring3{

	//找到最长的不重复的子串
	public int lengthOfLongestSubstring(String s){
		int occurs[]=new int occurs[128];
		int maxL=0;
		for(int i=0,j=0;i<s.length();i++){
			char c=s.charAt(i);
			occurs[c]++;
			while(occurs[c]>1){
				occurs[s.charAt(j++)]--;
				maxL=Math.max(maxL,i-j+1);
			}
			return maxL;
		}
