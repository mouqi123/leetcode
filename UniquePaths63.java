public class UniquePaths63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] cur = new int[obstacleGrid[0].length];
		cur[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int i = 0; i < cur.length; i++) {
				if (row[i] == 1) 
					cur[i] = 0;
				else if (i > 0)
					cur[i] += cur[i-1];
			}
		}

		return cur[obstacleGrid[0].length];
	}
}
