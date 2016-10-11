import java.util.*;
public class LongestParentheses32{
    public static int longestValidParentheses(String s){
	int n=s.length();
	LinkedList<Integer> stack=new LinkedList<>();
	int max=0;
	int start=-1;

	for(int i=0;i<n;i++){
	    char c=s.charAt(i);
	    if(c=='(')
		stack.push(i);
	    else{
		if(stack.isEmpty())
		    start=i;
		else{
		    stack.pop();
		    //Here should check the size of stack because if stack is empty,then
		    //we can't get index from it,instead we use the start index.
		    if(stack.isEmpty())
			max=Math.max(max,i-start);
		    else
			max=Math.max(max,i-stack.peek());
		}
	    }
	}
	return max;
    }
}
