public class CountSay38{
    public static String countAndSay(int n){
	String result="1";
	
	for(int i=2;i<=n;i++){
	    StringBuilder sb=new StringBuilder();
	    int j=0;
	    int len=result.length();
	    while(j<len){
		char c=result.charAt(j);
		int cnt=1;
		j++;
		while(j<len){
		    if(result.charAt(j)!=c)  break;
		    cnt++;
		    j++;
		}
		sb.append(cnt);	
		sb.append(c);
	    }
	    result=sb.toString();
	 //   System.out.println(result);
	}
	return result;
    }
    public static void main(String[] args){
	countAndSay(7);
    }
}
