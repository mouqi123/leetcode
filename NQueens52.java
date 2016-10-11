import java.util.*;
public class NQueens52{
	private int[] column;
	private int[] rup;
	private int[] lup;
	private int[] queen;
	private int count;

	public int totalNQueens(int n) {
		if (n > 1 && n < 4) return 0;
		column = new int[n+1];
		rup = new int[2*n+1];
		lup = new int[2*n+1];
		queen = new int[n+1];
		backtrack(1, n);
		return count;
	}

	private void backtrack(int i, int n){
		if (i > n)
			count++;
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
	public static void main(String[] args){
		NQueens52 q = new NQueens52();
		System.out.println(q.totalNQueens(4));
		NQueens52 q1 = new NQueens52();
		System.out.println(q1.totalNQueens(8));
		NQueens52 q2 = new NQueens52();
		System.out.println(q2.totalNQueens(5));
	}
}
