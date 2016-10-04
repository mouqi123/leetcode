public class Regex10_2{
    public static boolean isMatch(String s,String p){
	if(p.equals("")) return s.equals("");
	p+=" ";
	int slen=s.length();
	int plen=p.length();

	int star=-1;
	int pos=-1;

	int i=0,j=0;
	while(j<plen && i<slen){
	    char sc=s.charAt(i);
	    char pc=p.charAt(j);
	    char pc1=p.charAt(j+1);

	    if(pc1!='*' && star==-1){
		if(!isMatchFirst(sc,pc))
		    return false;
	        else{
		    i++; j++;
		    continue;
		}
	    }

	    if(pc1!='*' && star!=-1){
		if(!isMatchFirst(sc,pc)){
		    i=pos;
		    j=star-1;
		    if(!isMatchFirst(s.charAt(i),p.charAt(j)))
			return false;
		    else{
			i++;
			j=star+1;
			continue;
		    }
		}else{
		    i++; j++;
		}
	    }
	   
	    if(pc1=='*'){
		star=j+1;
		pos=i;
		j=j+2;
		continue;
	    }	
	}

	if(i==slen) return true;
	else return false;
    }

    public static boolean isMatchFirst(char a,char b){
	return a==b|| b=='.';
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
	System.out.println(isMatch("aa","a")); //false
	System.out.println(isMatch("aa","a*"));//true
	System.out.println(isMatch("aa","aa"));//true
	System.out.println(isMatch("ab",".*"));//true
	System.out.println(isMatch("",""));    //true
	System.out.println(isMatch("ab",".*c")); //false
    }
}







