public class Atoi8{
	public int myAtoi(String str){
		str=str.trim();
		if(str.equals("")) return 0;
		int sign=1,i=0;
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			sign=(str.charAt(0)=='-')?-1:1;
			i++;
		}

		int result=0;
		while(i<str.length()){
			if(Character.isDigit(str.charAt(i))){
				int d=str.charAt(i)-'0';
				if(result>(Integer.MAX_VALUE-d)/10){
					result=(sign==-1)?Integer.MIN_VALUE:Integer.MAX_VALUE;
					return result;
				}
				result=result*10+d;
			}else  break;
			i++;
		}
		return sign*result;
	}

	public static void main(String[] args){
		Atoi8 a=new Atoi8();
		System.out.println(a.myAtoi("-1234adsff"));
		System.out.println(a.myAtoi("+1234adsff"));
		System.out.println(a.myAtoi("asdf-1234adsff"));
		System.out.println(a.myAtoi("1"));
		System.out.println(a.myAtoi("   "));
		System.out.println(a.myAtoi("2147483648"));
		System.out.println(a.myAtoi("9223372036854775809"));
	}
}
