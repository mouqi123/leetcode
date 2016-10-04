public class MultiplyStr43{
    public static String multiply(String num1,String num2){
	int len1=num1.length();
	int len2=num2.length();
	int len=len1+len2;
	int[] mul=new int[len];
	for(int i=len1-1;i>=0;i--){
	    int a=num1.charAt(i)-'0';
	    int k=len2+i;
	    for(int j=len2-1;j>=0;j--){
		int b=num2.charAt(j)-'0';
		int c=mul[k]+a*b;
		mul[k]=c%10;
	 	mul[k-1]=mul[k-1]+c/10;
		k--;
	    }
	}
	int i=0;
	while(i<len&&mul[i]==0) i++;
	StringBuilder sb=new StringBuilder();
	for(;i<len;i++)
	    sb.append(mul[i]);
	return sb.length()==0?"0":sb.toString();
    }
    public static void main(String[] args){
	System.out.println(multiply("123","123"));
    }
}
