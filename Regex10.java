public class Regex10{
    public static boolean isMatch(String s,String p){
	int n=s.length();
	int m=p.length();
	boolean[][] f=new boolean[n+1][m+1];
	f[0][0]=true;

	for(int i=1;i<=m;i++)
	    f[0][i]= i>1 && p.charAt(i-1)=='*' && f[0][i-2];
	
	for(int i=1;i<=n;i++)
	    for(int j=1;j<=m;j++)
		if(p.charAt(j-1)!='*')
		    f[i][j]= f[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
		else
		    f[i][j]= f[i][j-2] ||( (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')&& f[i-1][j] );
	return f[n][m];
    }
    
    public static void main(String[] args){
	String s="asdssssssssssssssssssssssssssssssssssssssssdaaaaaaaaaaaaaaaaaaaaaaaaa";
	String p="asds*da*e*m*";
	long t1=System.nanoTime();
	System.out.println(isMatch(s,p));
 	System.out.println(System.nanoTime()-t1);
	long t2=System.nanoTime();
	System.out.println(s.matches(p));
 	System.out.println(System.nanoTime()-t2);
    }
}
