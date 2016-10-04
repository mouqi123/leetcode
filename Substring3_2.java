/**
 * File Name: Substring3_2.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年03月28日 星期一 12时48分08秒
 */
public class Substring3_2{
	public static int lengthOfLongestSubstring(String s){
		int[] occurs=new int[128];
		int maxL=0;
		int len=s.length();
		for(int i=0,j=0;i<len;i++){
			char c=s.charAt(i);
			occurs[c]++;
			while(occurs[c]>1){
				occurs[s.charAt(j++)]--;
				maxL=Math.max(maxL,i-j+1);
			}
		}
		return maxL;
	}
}
