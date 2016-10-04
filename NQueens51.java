import java.util.*;
public class NQueens51{
	private static int[] column;
	private static int[] rup;
	private static int[] lup;
	private static int[] queen;
	private static List<List<String>> result;

	public static List<List<String>> solveNQueens(int n) {
		column = new int[n+1];
		rup = new int[2*n+1];
		lup = new int[2*n+1];
		queen = new int[n+1];
		result = new ArrayList<>();
		backtrack(1, n);
		return result;
	}

	private static void backtrack(int i, int n){
		if (i > n)
			addResult(n);
		else {
			for (int j = 1; j <= n; j++){
				if (column[j] == 0 && rup[i+j] == 0 && lup[i+n-j] ==0){
					queen[i] = j;
					column[j] = rup[i+j] = lup[i+n-j] =1;
					backtrack(i+1,n);
					column[j] = rup[i+j] = lup[i+n-j] =0;
				}
			}

		}
	}

	private static void addResult(int n){
		List<String> list = new ArrayList<>();
		for (int i = 1; i<=n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= n; j++){
				if (queen[i] == j)
					sb.append("Q");
				else
					sb.append(".");
			}
			list.add(sb.toString());
		}
		result.add(list);
	}
}
