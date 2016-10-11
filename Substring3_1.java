public class Substring3_1{
    /**
     * find out the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s){
	int occurs[]=new int[65535];
	int maxL=0;
	for(int i=0,j=0;i<s.length();i++){
	    char c=s.charAt(i);
	    occurs[c]++;
	    while(occurs[c]>1)
		occurs[s.charAt(j++)]--;
	    maxL=Math.max(maxL,i-j+1);
	   
	}
	return maxL;
    }
    public static void main(String[] args){
	Substring3_1 sub=new Substring3_1();
	System.out.println(sub.lengthOfLongestSubstring("abcabcdef"));
	System.out.println(sub.lengthOfLongestSubstring("牟奇"));
	System.out.println(sub.lengthOfLongestSubstring("11111"));
    }k
