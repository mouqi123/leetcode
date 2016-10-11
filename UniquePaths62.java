//这是一个动态规划问题
public class UniquePaths62 {
	public int uniquePaths(int m, int n) {
		if (m > n) return uniquePaths(n, m);
		int[] a = new int[m];
		for (int i = 0; i < m; i++) 
			a[i] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				a[j] += a[j-1];
			}
		}

		return a[m-1];
	}
}

/* class Solution {
    int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m); 
        vector<int> pre(m, 1);
        vector<int> cur(m, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++)
                cur[i] = cur[i - 1] + pre[i];
            swap(pre, cur);
        }
        return pre[m - 1];
    }
}; */

/*
class Solution {
    public:
        int uniquePaths(int m, int n) {
            int N = n + m - 2;// how much steps we need to do
            int k = m - 1; // number of steps that need to go down
            double res = 1;
            // here we calculate the total possible path number 
            // Combination(N, k) = n! / (k!(n - k)!)
            // reduce the numerator and denominator and get
            // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
            for (int i = 1; i <= k; i++)
				res = res * (N - k + i) / i;
			return (int)res;
	    }
}; */
