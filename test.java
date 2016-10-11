import java.util.*;
public class test{
    public static void main(String[] args){
	String s=" 1 2 3 4 ";
	s=s.trim();
	String[] str=s.split("\\s");
	for(String t:str)
	    System.out.println(t);
    }
}
