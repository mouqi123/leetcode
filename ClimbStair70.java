/**
 * File Name: ClimbStair70.java
 * Author: mackie
 * Mail: mouqi562315905@qq.com 
 * Created Time: 2016年10月20日 星期四 17时16分51秒
 */
public class ClimbStair70 {
	public int climbStairs(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;

		int one_step_before = 2;
		int two_step_before = 1;
		int all_ways = 0;

		for (int i = 3; i <=n; i++) {
			all_ways = one_step_before + two_step_before;
			two_step_before = one_step_before;
			one_step_before = all_ways;
		}

		return all_ways;
	}
}
