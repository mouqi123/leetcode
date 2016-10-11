/**
 * File Name: Palindrome5_1.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年04月03日 星期日 12时10分55秒
 */
public class Palindrome5_1{
	private static int lo=0, maxLen=0;
	public static String longestPalindrome(String s){
		int len =s.length();
		if(len<2)
			return s;
		for(int i=0;i<len-1;i++){
			extendPalindrome(s,i,i);
			extendPalindrome(s,i,i+1);
		}
		return s.substring(lo,lo+maxLen);
	}

	public static void extendPalindrome(String s,int i,int j){
		int len=s.length();
		while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){
			i--;   j++;
		}
		if(maxLen<j-i-1){
			lo=i+1;
			maxLen=j-i-1;
		}
	}

	public static void main(String[] args){
		Palindrome5_1 p=new Palindrome5_1();
		System.out.println(p.longestPalindrome("aaabaaaab"));
		System.out.println(p.longestPalindrome("aaabaaaabaaaaaaaaaaaaa"));

	}
}
