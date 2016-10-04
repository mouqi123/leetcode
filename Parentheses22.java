import java.util.*;
public class Parentheses22{
    public static List<String> generateParenthesis(int n){
	List<String> list=new ArrayList<>();
	generateOneByOne("",list,n,n);
	return list;
    }

    public static void generateOneByOne(String s,List<String> list,int left,int right){
	if(left>right) return;

	if(left>0)
	    generateOneByOne(s+"(",list,left-1,right);
	if(right>0)
	    generateOneByOne(s+")",list,left,right-1);
	if(left==0&&right==0)
	    list.add(s);
    }
    public static void main(String[] args){
	List<String> list=generateParenthesis(10);
	int i=0;
	for(String str:list){
	    if(i%5==0)
		System.out.println();
	    i++;
	    System.out.printf("%-25s",str);
	}
	System.out.println();
    }
}
