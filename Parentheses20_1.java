import java.util.*;
public class Parentheses20_1{
	public static boolean isValid(String s){
		LinkedList<Character> stack=new LinkedList<>();
		int n=s.length();
		for(int i=0;i<n;i++){
			char c=s.charAt(i);
			if(c=='{'||c=='('||c=='[')
				stack.push(c);
			else if(c==')'||c=='}'||c==']'){
				if(stack.isEmpty()) return false;
				if(c==')'&&stack.pop()!='('||c=='}'&&stack.pop()!='{'||c==']'&&stack.pop()!='[')
					return false;
			}
		}
		return stack.isEmpty()?true:false;
	}

	public static void main(String[] args){
		System.out.println(isValid("({asdfas})"));
	}
}
