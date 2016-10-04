import java.util.*;
public class Parentheses20{
    public static boolean isValid(String s){
	char m=s.charAt(0);
        if(m==')'||m=='}'||m==']') return false;
	LinkedList<Character> stack=new LinkedList<Character>();
	int n=s.length();
	for(int i=0;i<n;i++){
	    char c=s.charAt(i);
	    if(c=='('||c=='{'||c=='[')
		stack.push(c);
	    else if(c==')'||c=='}'||c==']'){
		if(stack.size()==0)  return false;
		if(c==')'&&stack.pop()!='(' || c=='}'&&stack.pop()!='{' || c==']'&&stack.pop()!='[')
		    return false;
	    }
	}
	if(stack.size()==0) return true;
	else  return false;
    }
  
    public static void main(String[] args){
	System.out.println(isValid("({asdfas})"));
    }
}
