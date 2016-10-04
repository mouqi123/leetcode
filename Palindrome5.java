public class Palindrome5{
    public String longestPalindrome(String s){
	String sub="";
	int len=0;
	for(int i=0;i<s.length();i++){
	    if(isPalindrome(s,i-len,i)){
		sub=s.substring(i-len,i+1);
		len+=1;
	    }else if(isPalindrome(s,i-len-1,i)){
		sub=s.substring(i-len-1,i+1);
		len+=2;
	    }
	}
	return sub;

    }

    public boolean isPalindrome(String s,int start,int end){
	if(start<0)  return false;
	while(start<end){
	    if(s.charAt(start++)!=s.charAt(end--))  return false;
	}
	return true;
    }
	
    public static void main(String[] args){
	Palindrome5 p=new Palindrome5();
	System.out.println(p.longestPalindrome("abedcdmx12321"));
    }
}
