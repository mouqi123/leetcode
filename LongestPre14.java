public class LongestPre14{
	public static String longestCommonPrefix(String[] strs){
		int n=strs.length;
		if(n==0||strs==null)   return "";

		String s0=strs[0];
		for(int i=1;i<n;i++){
			int j=0;
			while(j<strs[i].length()&&j<s0.length()){
				if(strs[i].charAt(j)!=s0.charAt(j))   break;
				j++;
			}
			s0=s0.substring(0,j);
		}
		return s0;
	}
	public static void main(String[] args){
		String[] strs={"abc","abcd","abcdef"};
		System.out.println(longestCommonPrefix(strs));
	}
}
