/**
 * File Name: Pow50.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年06月06日 星期一 20时57分07秒
 */
public class Pow50{
	public static double myPow(double x, int n) {
		return pow(x, (long) n);
	}
	public static double pow(double x, long n) {
		if (n == 0)
			return 1;
		if (n < 0){
			n = -n;
			x = 1/x;
		}
		return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
	}

	public static void main(String[] args){
		System.out.println(myPow(2, 4));
	}
}
