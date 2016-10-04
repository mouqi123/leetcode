public class Wildcard44{
    //此算法为字符'?'和'*'的通配实现。
    //用到了两个索引记录，si用来记录遇到'*'时s的索引，
    //star用来记录p中'*'的索引。
    public static boolean isMatch(String s,String p){
        //加个空格字符作为sentinel(哨兵).
        p=p+" ";
    	int star=-1;
	int si=-1;
	int len=s.length();
	int lenP=p.length();

	int i=0,j=0;
	while(i<len&&j<lenP){
	    char ss=s.charAt(i);
	    char pp=p.charAt(j);

	    //如果开头的字符都匹配，则都前进1.
	    if(ss==pp||pp=='?'){
	        i++;j++; continue;
	    }

	    //如果遇到'*'则记录此时s和p的索引,以便后面出现不匹配时可以恢复
	    if(pp=='*'){
	    	star=j;
		si=i;
		j++;
		continue;
	    }
	    //上面两个条件都不成立，此时若前面出现过'*',则恢复以前记录的索引.si在以前的基础上要再前进1.
	    if(star!=-1){
	        j=star+1;
		i=++si;
		continue;
	    }
	    return false;
	}
	
	while(j<lenP && p.charAt(j)=='*') j++;
	return j==lenP-1;
    }

    public static void main(String[] args){
    	System.out.println(isMatch("aa","a"));
    	System.out.println(isMatch("aa","aa"));
    	System.out.println(isMatch("aaa","aa"));
    	System.out.println(isMatch("aa","*"));
    	System.out.println(isMatch("aa","a*"));
    	System.out.println(isMatch("ab","?*"));
    	System.out.println(isMatch("aab","c*a*b"));
    }
}
