public class Regex10_1{
    public static boolean isMatch(String s,String p){
	if(p.equals("")) return s.equals("");
	
	if(p.length()==1||p.charAt(1)!='*'){
	    if(!matchFirst(s,p)) return false;
	    return isMatch(s.substring(1),p.substring(1));
	}
	else{
	    if(isMatch(s,p.substring(2))) return true;
	    while(matchFirst(s,p)){
		s=s.substring(1);
		if(isMatch(s,p.substring(2))) return true;
	    }
	}
	return false;
    }
    public static boolean matchFirst(String s,String p){
	char b=p.charAt(0);
	return !s.isEmpty() && ((s.charAt(0)==b)||b=='.');
    }

    public static void main(String[] args){
	String s="asdssssssssssssssssssssssssssssssssssssssssdaaaaaaaaaaaaaaaaaaaaaaaaa";
	String p="asds*da*e*m*";
	/*long t1=System.nanoTime();
	System.out.println(isMatch(s,p));
 	System.out.println(System.nanoTime()-t1);
	long t2=System.nanoTime();
	System.out.println(s.matches(p));
 	System.out.println(System.nanoTime()-t2);*/
	System.out.println(isMatch("aa","a"));
	System.out.println(isMatch("aa","a*"));
	System.out.println(isMatch("aa","aa"));
	System.out.println(isMatch("ab",".*"));
	System.out.println(isMatch("",""));
	System.out.println(isMatch("ab",".*c"));
    }
}
