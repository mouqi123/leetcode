public class Palindrome9{
    public boolean isPalindrome(int x){
	if(x<0) return false;
	String s=String.valueOf(x);

	int i=0,k=s.length()-1;
	while(i<k){
	    if(s.charAt(i++)!=s.charAt(k--)) return false;
	}
	return true;
    }
    public static void main(String[] args){
	Palindrome9 p=new Palindrome9();
	System.out.println(p.isPalindrome(0));
    }
}
