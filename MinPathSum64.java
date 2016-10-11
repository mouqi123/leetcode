public class MinPathSum64 {
	public int minPathSum(int[][] grid) {
		int columnLen = grid[0].length;
		int[] cur = new int[columnLen];

		cur[0] = grid[0][0];
		for (int k = 1; k < cur.length; k++) 
			cur[k] += cur[k-1] + grid[0][k];

		for (int i = 0; i < grid.length; i++) {
			cur[0] += grid[i][0];
			for (int j = 1; j < cur.length; j++) {
				cur[j] = Math.min(cur[j], cur[j-1]) + grid[i][j];

			}
		}
		return cur[columnLen-1];
	}
}
