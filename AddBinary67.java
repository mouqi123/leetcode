/**
 * File Name: AddBinary67.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年10月08日 星期六 22时29分41秒
 */
public class AddBinary67 {
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0 || carry == 1) {
			carry += i >= 0 ? a.charAt(i--) - '0' : 0;
			carry += j >= 0 ? b.charAt(j--) - '0' : 0;
			sb.append(carry%2);
			carry /= 2;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(addBinary("11", "11"));
	}
}
