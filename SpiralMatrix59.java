public class SpiralMatrix59 {
	public static int[][] generateMatrix(int n) {
		int[][] results = new int[n][n];
		int rowBegin = 0;
		int rowEnd = n-1;
		int colBegin = 0;
		int colEnd = n-1;
		int x = 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int i = colBegin; i <= colEnd; i++) 
				results[rowBegin][i] = x++;
			rowBegin++;

			for (int i = rowBegin; i<= rowEnd; i++)
				results[i][colEnd] = x++;
			colEnd--;

			if (rowBegin <= rowEnd) {
				for (int i = colEnd; i >= colBegin; i--)
					results[rowEnd][i] = x++;
				rowEnd--;
			}

			if (colBegin <= colEnd) {
				for (int i= rowEnd; i >= rowBegin; i--)
					results[i][colBegin] = x++;
				colBegin++;
			}
		}
		return results;
	}
}
